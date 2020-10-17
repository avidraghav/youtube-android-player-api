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
import com.google.android.youtube.player.YouTubePlayer;

import java.util.ArrayList;

public abstract class YouTubeClient<T extends IInterface> implements Client {

    private final Context context;
    final Handler handler;
    public final ArrayList<B<?>> f102i = new ArrayList<>();
    private final ArrayList<Client.Connection> connections = new ArrayList<>();
    public T connection;
    public ArrayList<Client.Connection> f97d;
    public boolean isConnected = false;
    private boolean h = false;
    private boolean isProcessing = false;
    private ServiceConnection serviceConnection;
    private ArrayList<Client.OnInitializationResult> initResultListeners;

    protected YouTubeClient(Context context, Client.Connection aVar, Client.OnInitializationResult bVar) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        }
        this.context = (Context) Validators.notNull(context);
        this.f97d = new ArrayList<>();
        this.f97d.add(Validators.notNull(aVar));
        this.initResultListeners = new ArrayList<>();
        this.initResultListeners.add(Validators.notNull(bVar));
        this.handler = new InternalHandler();
    }

    public static YouTubeInitializationResult getYouTubeInitializationResult(String str) {
        try {
            return YouTubeInitializationResult.valueOf(str);
        } catch (IllegalArgumentException e) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException e2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }

    public abstract T a(IBinder iBinder);

    protected abstract void a(IServiceBroker iVar, OnConnectionCompletedListener dVar) throws RemoteException;

    protected abstract String getConnectionDescriptor();

    protected abstract String getIntentService();

    public void unbindService() {
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

    public final void a(YouTubeInitializationResult youTubeInitializationResult) {
        this.handler.removeMessages(4);
        synchronized (this.initResultListeners) {
            this.h = true;
            ArrayList<Client.OnInitializationResult> arrayList = this.initResultListeners;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.isConnected) {
                    if (this.initResultListeners.contains(arrayList.get(i))) {
                        arrayList.get(i).onResult(youTubeInitializationResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.h = false;
        }
    }

    public final void b(IBinder iBinder) {
        try {
            a(IServiceBroker.Stub.asInterface(iBinder), new OnConnectionCompletedListener());
        } catch (RemoteException e) {
            Log.w("YouTubeClient", "service died");
        }
    }

    @Override
    public final void connect() {
        this.isConnected = true;
        YouTubeInitializationResult isYouTubeApiServiceAvailable = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this.context);
        if (isYouTubeApiServiceAvailable != YouTubeInitializationResult.SUCCESS) {
            this.handler.sendMessage(this.handler.obtainMessage(3, isYouTubeApiServiceAvailable));
            return;
        }
        Intent intent = new Intent(getIntentService()).setPackage(ApplicationUtils.getPackageName(this.context));
        if (this.serviceConnection != null) {
            Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
            unbindService();
        }
        this.serviceConnection = new YouTubeServiceConnection();
        if (!this.context.bindService(intent, this.serviceConnection, Context.BIND_AUTO_CREATE | Context.BIND_ADJUST_WITH_ACTIVITY)) {
            this.handler.sendMessage(this.handler.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
        }
    }

    @Override
    public void disconnect() {
        releaseAll();
        this.isConnected = false;
        synchronized (this.f102i) {
            int size = this.f102i.size();
            for (int i = 0; i < size; i++) {
                this.f102i.get(i).b();
            }
            this.f102i.clear();
        }
        unbindService();
    }

    public final boolean connectionExists() {
        return this.connection != null;
    }

    public final void bindAll() {
        boolean z = true;
        synchronized (this.f97d) {
            Validators.validateState(!this.isProcessing);
            this.handler.removeMessages(4);
            this.isProcessing = true;
            if (this.connections.size() != 0) {
                z = false;
            }
            Validators.validateState(z);
            ArrayList<Client.Connection> arrayList = this.f97d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.isConnected && connectionExists(); i++) {
                if (!this.connections.contains(arrayList.get(i))) {
                    arrayList.get(i).bind();
                }
            }
            this.connections.clear();
            this.isProcessing = false;
        }
    }

    public final void releaseAll() {
        this.handler.removeMessages(4);
        synchronized (this.f97d) {
            this.isProcessing = true;
            ArrayList<Client.Connection> arrayList = this.f97d;
            int size = arrayList.size();
            for (int i = 0; i < size && this.isConnected; i++) {
                if (this.f97d.contains(arrayList.get(i))) {
                    arrayList.get(i).release();
                }
            }
            this.isProcessing = false;
        }
    }

    public final void checkConnection() {
        if (!connectionExists()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T getService() {
        checkConnection();
        return this.connection;
    }

    static /* synthetic */ class C00541 {

        static final /* synthetic */ int[] f105a = new int[YouTubeInitializationResult.values().length];

        static {
            try {
                f105a[YouTubeInitializationResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    final class InternalHandler extends Handler {
        InternalHandler() {
        }

        @Override
        public final void handleMessage(Message message) {
            if (message.what == 3) {
                YouTubeClient.this.a((YouTubeInitializationResult) message.obj);
            } else if (message.what == 4) {
                synchronized (YouTubeClient.this.f97d) {
                    if (isConnected && connectionExists() && f97d.contains(message.obj)) {
                        ((Client.Connection) message.obj).bind();
                    }
                }
            } else if (message.what == 2 && !YouTubeClient.this.connectionExists()) {
            } else {
                if (message.what == 2 || message.what == 1) {
                    ((B) message.obj).a();
                }
            }
        }
    }

    protected abstract class B<TListener> {

        private TListener tListener;

        public B(TListener tlistener) {
            this.tListener = tlistener;
            synchronized (f102i) {
                f102i.add(this);
            }
        }

        public final void a() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.tListener;
            }
            a(tlistener);
        }

        public abstract void a(TListener tlistener);

        public final void b() {
            synchronized (this) {
                this.tListener = null;
            }
        }
    }

    protected final class D extends B<Boolean> {

        public final YouTubeInitializationResult f109b;
        public final IBinder f110c;

        public D(String str, IBinder iBinder) {
            super(true);
            this.f109b = YouTubeClient.getYouTubeInitializationResult(str);
            this.f110c = iBinder;
        }

        @Override
        public final /* synthetic */ void a(Boolean obj) {
            if (obj != null) {
                switch (C00541.f105a[this.f109b.ordinal()]) {
                    case YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION:
                        try {
                            if (getConnectionDescriptor().equals(this.f110c.getInterfaceDescriptor())) {
                                connection = YouTubeClient.this.a(this.f110c);
                                if (connection != null) {
                                    bindAll();
                                    return;
                                }
                            }
                        } catch (RemoteException e) {
                        }
                        YouTubeClient.this.unbindService();
                        YouTubeClient.this.a(YouTubeInitializationResult.INTERNAL_ERROR);
                        return;
                    default:
                        YouTubeClient.this.a(this.f109b);
                }
            }
        }
    }

    protected final class OnConnectionCompletedListener extends IConnectionCallbacks.Stub {
        protected OnConnectionCompletedListener() {
        }

        @Override
        public final void onConnectionCompleted(String str, IBinder iBinder) {
            YouTubeClient.this.handler.sendMessage(YouTubeClient.this.handler.obtainMessage(1, new D(str, iBinder)));
        }
    }

    final class YouTubeServiceConnection implements ServiceConnection {
        YouTubeServiceConnection() {
        }

        @Override
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b(iBinder);
        }

        @Override
        public final void onServiceDisconnected(ComponentName componentName) {
            connection = null;
            releaseAll();
        }
    }
}
