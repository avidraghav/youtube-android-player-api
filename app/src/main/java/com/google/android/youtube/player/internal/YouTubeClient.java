package com.google.android.youtube.player.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import com.google.android.youtube.player.YouTubeApiServiceUtil;
import com.google.android.youtube.player.YouTubeInitializationResult;

import java.util.ArrayList;

public abstract class YouTubeClient<T extends IInterface> implements Client {
    private final Context context;
    final Handler handler;
    private T connection;
    private final ArrayList<Connection> connections = new ArrayList<>();
    private final ArrayList<Connection> activeConnections = new ArrayList<>();
    // TODO Instantiate here, make final and clear only in constructor for thread safety
    private final ArrayList<OnInitializationResult> initResultListeners = new ArrayList<>();
    private boolean isProcessingConnections = false;
    private boolean h = false;
    private final ArrayList<B<?>> i = new ArrayList<>();
    private ServiceConnection serviceConnection;
    private boolean isConnected = false;

    protected YouTubeClient(Context context, Connection connection, OnInitializationResult onInitResult) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        } else {
            this.context = Validators.notNull(context);
            this.connections.add(Validators.notNull(connection));
            this.initResultListeners.add(Validators.notNull(onInitResult));
            this.handler = new InternalHandler();
        }
    }

    protected abstract String c();

    protected abstract String getConnectionDescriptor();

    protected abstract T a(IBinder var1);

    private static YouTubeInitializationResult getYouTubeInitializationResult(String initResult) {
        try {
            return YouTubeInitializationResult.valueOf(initResult);
        } catch (IllegalArgumentException var1) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException var2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }

    @Override
    public final void connect() {
        this.isConnected = true;
        YouTubeInitializationResult result = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this.context);
        if (result != YouTubeInitializationResult.SUCCESS) {
            this.handler.sendMessage(this.handler.obtainMessage(3, result));
        } else {
            Intent intent = (new Intent(this.c())).setPackage(z.getPackageName(this.context));
            if (this.serviceConnection != null) {
                Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
                this.unbindService();
            }

            this.serviceConnection = new YouTubeServiceConnection();
            if (!this.context.bindService(intent, this.serviceConnection, Context.BIND_AUTO_CREATE | Context.BIND_ADJUST_WITH_ACTIVITY)) {
                this.handler.sendMessage(this.handler.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
            }
        }
    }

    public final boolean isConnected() {
        return this.connection != null;
    }


    @Override
    public void disconnect() {
        this.releaseAll();
        this.isConnected = false;
        synchronized (this.i) {
            int length = this.i.size();
            int i = 0;

            while (true) {
                if (i >= length) {
                    this.i.clear();
                    break;
                }

                this.i.get(i).b();
                ++i;
            }
        }

        this.unbindService();
    }

    private void unbindService() {
        if (this.serviceConnection != null) {
            try {
                this.context.unbindService(this.serviceConnection);
            } catch (IllegalArgumentException e) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", e);
            }
        }

        this.connection = null;
        this.serviceConnection = null;
    }

    // TODO bind?
    protected final void getConnectionDescriptor(IBinder var1) {
        try {
            IServiceBroker broker = IServiceBroker.Stub.asInterface(var1);
            this.a(broker, new OnConnectionCompletedListener());
        } catch (RemoteException var2) {
            Log.w("YouTubeClient", "service died");
        }
    }

    protected abstract void a(IServiceBroker broker, OnConnectionCompletedListener onCompletedListener) throws RemoteException;

    protected final void bindAll() {
        synchronized (this.connections) {
            Validators.validateState(!this.isProcessingConnections);
            this.handler.removeMessages(4);
            this.isProcessingConnections = true;

            // TODO See if this is thread safe
            for (Connection connection : connections) {
                if (this.isConnected && this.isConnected()) break;
                connection.bind();
            }

            this.isProcessingConnections = false;
        }
    }

    protected final void releaseAll() {
        this.handler.removeMessages(4);
        synchronized (this.connections) {
            this.isProcessingConnections = true;
            ArrayList<Connection> list = this.connections;

            for (int i = 0; i < list.size() && this.isConnected; ++i) {
                if (this.connections.contains(list.get(i))) {
                    list.get(i).release();
                }
            }

            this.isProcessingConnections = false;
        }
    }

    protected final void a(YouTubeInitializationResult result) {
        this.handler.removeMessages(4);
        synchronized (this.initResultListeners) {
            this.h = true;

            // TODO Check if this loop is thread safe
            for (OnInitializationResult listener : this.initResultListeners) {
                if (!this.isConnected) {
                    return;
                }
                listener.onResult(result);
            }

            this.h = false;
        }
    }

    protected final void checkConnection() {
        if (!this.isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected final T j() {
        this.checkConnection();
        return this.connection;
    }

    protected final class OnConnectionCompletedListener extends IConnectionCallbacks.Stub {

        public final void onConnectionCompleted(String initResult, IBinder binder) {
            handler.sendMessage(handler.obtainMessage(1, new D(initResult, binder)));
        }
    }

    protected final class D extends B<Boolean> {
        public final YouTubeInitializationResult result;
        public final IBinder binder;

        public D(String initResult, IBinder binder) {
            super(true);
            this.result = YouTubeClient.getYouTubeInitializationResult(initResult);
            this.binder = binder;
        }

        // TODO was not implemented before
        @Override
        protected void a(Boolean var1) {

        }
    }

    protected abstract class B<TListener> {
        private TListener tListener;

        public B(final TListener tListener) {
            this.tListener = tListener;
            synchronized (i) {
                i.add(this);
            }
        }

        protected abstract void a(final TListener tListener);

        public final void a() {
            TListener tListener;
            synchronized (this) {
                tListener = this.tListener;
            }

            this.a(tListener);
        }

        public final void b() {
            synchronized (this) {
                this.tListener = null;
            }
        }
    }

    private final class InternalHandler extends Handler {

        @Override
        public final void handleMessage(final Message message) {
            if (message.what == 3) {
                a((YouTubeInitializationResult) message.obj);
            } else if (message.what == 4) {
                synchronized (connections) {
                    if (isConnected && isConnected() && connections.contains(message.obj)) {
                        ((Connection) message.obj).bind();
                    }

                }
            } else if (message.what != 2 || isConnected()) {
                if (message.what == 2 || message.what == 1) {
                    ((B) message.obj).a();
                }
            }
        }
    }

    final class YouTubeServiceConnection implements ServiceConnection {

        public final void onServiceConnected(ComponentName component, IBinder binder) {
            getConnectionDescriptor(binder);
        }

        public final void onServiceDisconnected(ComponentName component) {
            connection = null;
            releaseAll();
        }
    }
}
