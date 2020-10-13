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

public abstract class YouTubeClient<T extends IInterface> implements t {
    private final Context context;
    final Handler handler;
    private T connection;
    private ArrayList<C> d;
    private final ArrayList<C> e = new ArrayList<>();
    private boolean f = false;
    // TODO Instantiate here, make final and clear only in constructor for thread safety
    private ArrayList<OnInitializationResult> initResultListeners;
    private boolean h = false;
    private final ArrayList<B<?>> i = new ArrayList<>();
    private ServiceConnection serviceConnection;
    private boolean isConnected = false;

    protected YouTubeClient(Context context, C var2, OnInitializationResult onInitResult) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        } else {
            this.context = Validators.notNull(context);
            this.d = new ArrayList<>();
            this.d.add(Validators.notNull(var2));
            this.initResultListeners = new ArrayList<>();
            this.initResultListeners.add(Validators.notNull(onInitResult));
            this.handler = new A();
        }
    }

    protected abstract String c();

    protected abstract String b();

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

            this.serviceConnection = new e();
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
        this.h();
        this.isConnected = false;
        synchronized(this.i) {
            int length = this.i.size();
            int i = 0;

            while(true) {
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
    protected final void b(IBinder var1) {
        try {
            IServiceBroker var3 = IServiceBroker.Stub.asInterface(var1);
            this.a(var3, new d());
        } catch (RemoteException var2) {
            Log.w("YouTubeClient", "service died");
        }
    }

    protected abstract void a(IServiceBroker var1, d var2) throws RemoteException;

    protected final void g() {
        synchronized(this.d) {
            Validators.validateState(!this.f);
            this.handler.removeMessages(4);
            this.f = true;
            Validators.validateState(this.e.size() == 0);
            ArrayList<C> var2 = this.d;

            for(int i = 0; i < var2.size() && this.isConnected && this.isConnected(); ++i) {
                if (!this.e.contains(var2.get(i))) {
                    var2.get(i).a();
                }
            }

            this.e.clear();
            this.f = false;
        }
    }

    protected final void h() {
        this.handler.removeMessages(4);
        synchronized(this.d) {
            this.f = true;
            ArrayList<C> list = this.d;

            for(int i = 0; i < list.size() && this.isConnected; ++i) {
                if (this.d.contains(list.get(i))) {
                    list.get(i).b();
                }
            }

            this.f = false;
        }
    }

    protected final void a(YouTubeInitializationResult result) {
        this.handler.removeMessages(4);
        synchronized(this.initResultListeners) {
            this.h = true;
            ArrayList<OnInitializationResult> var3 = this.initResultListeners;

            for(int i = 0; i < var3.size(); ++i) {
                if (!this.isConnected) {
                    return;
                }

                if (this.initResultListeners.contains(var3.get(i))) {
                    ((OnInitializationResult)var3.get(i)).onResult(result);
                }
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

    protected final class d extends IConnectionCallbacks.Stub {
        protected d() {
        }

        public final void a(String initResult, IBinder binder) {
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
            super.b = var1;
        }
    }

    protected abstract class B<TListener> {
        private TListener b;

        public B(TListener var2) {
            this.b = var2;
            synchronized(YouTubeClient.this.i) {
                YouTubeClient.this.i.add(this);
            }
        }

        protected abstract void a(TListener var1);

        public final void a() {
            TListener var1;
            synchronized(this) {
                var1 = this.b;
            }

            this.a(var1);
        }

        public final void b() {
            synchronized(this) {
                this.b = null;
            }
        }
    }

    final class A extends Handler {
        A() {
        }

        @Override
        public final void handleMessage(Message message) {
            if (message.what == 3) {
                a((YouTubeInitializationResult)message.obj);
            } else if (message.what == 4) {
                synchronized(d) {
                    if (isConnected && isConnected() && d.contains(message.obj)) {
                        ((C)message.obj).a();
                    }

                }
            } else if (message.what != 2 || isConnected()) {
                if (message.what == 2 || message.what == 1) {
                    ((B)message.obj).a();
                }
            }
        }
    }

    final class e implements ServiceConnection {
        e() {
        }

        public final void onServiceConnected(ComponentName component, IBinder binder) {
            b(binder);
        }

        public final void onServiceDisconnected(ComponentName component) {
            connection = null;
            h();
        }
    }
}
