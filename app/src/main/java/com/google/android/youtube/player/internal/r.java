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

public abstract class r<T extends IInterface> implements t {
    private final Context context;
    final Handler handler;
    private T c;
    private ArrayList<t.a> d;
    private final ArrayList<t.a> e = new ArrayList<>();
    private boolean f = false;
    private ArrayList<OnInitializationResult> initResultListeners;
    private boolean h = false;
    private final ArrayList<r.b<?>> i = new ArrayList<>();
    private ServiceConnection serviceConnection;
    private boolean k = false;

    protected r(Context context, t.a var2, OnInitializationResult var3) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Clients must be created on the UI thread.");
        } else {
            this.context = Validators.notNull(context);
            this.d = new ArrayList<>();
            this.d.add(Validators.notNull(var2));
            this.initResultListeners = new ArrayList<>();
            this.initResultListeners.add(Validators.notNull(var3));
            this.handler = new a();
        }
    }

    protected abstract String c();

    protected abstract String b();

    protected abstract T a(IBinder var1);

    private static YouTubeInitializationResult b(String var0) {
        try {
            return YouTubeInitializationResult.valueOf(var0);
        } catch (IllegalArgumentException var1) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException var2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }

    public final void e() {
        this.k = true;
        YouTubeInitializationResult result = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(this.context);
        if (result != YouTubeInitializationResult.SUCCESS) {
            this.handler.sendMessage(this.handler.obtainMessage(3, result));
        } else {
            Intent intent = (new Intent(this.c())).setPackage(z.getPackageName(this.context));
            if (this.serviceConnection != null) {
                Log.e("YouTubeClient", "Calling connect() while still connected, missing disconnect().");
                this.a();
            }

            this.serviceConnection = new r.e();
            if (!this.context.bindService(intent, this.serviceConnection, Context.BIND_AUTO_CREATE | Context.BIND_ADJUST_WITH_ACTIVITY)) {
                this.handler.sendMessage(this.handler.obtainMessage(3, YouTubeInitializationResult.ERROR_CONNECTING_TO_SERVICE));
            }

        }
    }

    public final boolean f() {
        return this.c != null;
    }

    public void d() {
        this.h();
        this.k = false;
        synchronized(this.i) {
            int var2 = this.i.size();
            int var3 = 0;

            while(true) {
                if (var3 >= var2) {
                    this.i.clear();
                    break;
                }

                ((r.b)this.i.get(var3)).b();
                ++var3;
            }
        }

        this.a();
    }

    private void a() {
        if (this.serviceConnection != null) {
            try {
                this.context.unbindService(this.serviceConnection);
            } catch (IllegalArgumentException var2) {
                Log.w("YouTubeClient", "Unexpected error from unbindService()", var2);
            }
        }

        this.c = null;
        this.serviceConnection = null;
    }

    protected final void b(IBinder var1) {
        try {
            IServiceBroker var3 = IServiceBroker.Stub.a(var1);
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
            ArrayList var2 = this.d;
            int var3 = 0;

            for(int var4 = var2.size(); var3 < var4 && this.k && this.f(); ++var3) {
                if (!this.e.contains(var2.get(var3))) {
                    ((com.google.android.youtube.player.internal.t.a)var2.get(var3)).a();
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
            ArrayList var2 = this.d;
            int var3 = 0;

            for(int var4 = var2.size(); var3 < var4 && this.k; ++var3) {
                if (this.d.contains(var2.get(var3))) {
                    ((com.google.android.youtube.player.internal.t.a)var2.get(var3)).b();
                }
            }

            this.f = false;
        }
    }

    protected final void a(YouTubeInitializationResult var1) {
        this.handler.removeMessages(4);
        synchronized(this.initResultListeners) {
            this.h = true;
            ArrayList var3 = this.initResultListeners;
            int var4 = 0;

            for(int var5 = var3.size(); var4 < var5; ++var4) {
                if (!this.k) {
                    return;
                }

                if (this.initResultListeners.contains(var3.get(var4))) {
                    ((OnInitializationResult)var3.get(var4)).onResult(var1);
                }
            }

            this.h = false;
        }
    }

    protected final void i() {
        if (!this.f()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected final T j() {
        this.i();
        return this.c;
    }

    protected final class d extends IConnectionCallbacks.Stub {
        protected d() {
        }

        public final void a(String var1, IBinder var2) {
            r.this.handler.sendMessage(r.this.handler.obtainMessage(1, r.this.new c(var1, var2)));
        }
    }

    protected final class c extends b<Boolean> {
        public final YouTubeInitializationResult b;
        public final IBinder c;

        public c(String var2, IBinder var3) {
            super(true);
            this.b = r.b(var2);
            this.c = var3;
        }
    }

    protected abstract class b<TListener> {
        private TListener b;

        public b(TListener var2) {
            this.b = var2;
            synchronized(r.this.i) {
                r.this.i.add(this);
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

    final class a extends Handler {
        a() {
        }

        @Override
        public final void handleMessage(Message message) {
            if (message.what == 3) {
                r.this.a((YouTubeInitializationResult)message.obj);
            } else if (message.what == 4) {
                synchronized(r.this.d) {
                    if (r.this.k && r.this.f() && r.this.d.contains(message.obj)) {
                        ((com.google.android.youtube.player.internal.t.a)message.obj).a();
                    }

                }
            } else if (message.what != 2 || r.this.f()) {
                if (message.what == 2 || message.what == 1) {
                    ((r.b)message.obj).a();
                }
            }
        }
    }

    final class e implements ServiceConnection {
        e() {
        }

        public final void onServiceConnected(ComponentName var1, IBinder var2) {
            r.this.b(var2);
        }

        public final void onServiceDisconnected(ComponentName var1) {
            r.this.c = null;
            r.this.h();
        }
    }
}
