package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

import com.google.android.youtube.player.YouTubeThumbnailView;

public final class p extends com.google.android.youtube.player.internal.a {
    private final Handler a;
    private ConnectionClient b;
    private k c;
    private boolean d;
    private boolean e;

    public p(ConnectionClient var1, YouTubeThumbnailView var2) {
        super(var2);
        this.b = (ConnectionClient) Validators.notNull(var1, "connectionClient cannot be null");
        this.c = var1.a(new p.a((byte)0));
        this.a = new Handler(Looper.getMainLooper());
    }

    protected final boolean a() {
        return super.a() && this.c != null;
    }

    public final void a(String var1) {
        try {
            this.c.a(var1);
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    public final void a(String var1, int var2) {
        try {
            this.c.a(var1, var2);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    public final void c() {
        try {
            this.c.a();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    public final void d() {
        try {
            this.c.b();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    public final void e() {
        try {
            this.c.c();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    public final boolean f() {
        return this.e;
    }

    public final boolean g() {
        return this.d;
    }

    public final void h() {
        try {
            this.c.d();
        } catch (RemoteException var1) {
        }

        this.b.d();
        this.c = null;
        this.b = null;
    }

    private final class a extends com.google.android.youtube.player.internal.j.a {
        private a() {
        }

        public final void a(final Bitmap var1, final String var2, final boolean var3, final boolean var4) {
            p.this.a.post(new Runnable() {
                public final void run() {
                    p.this.d = var3;
                    p.this.e = var4;
                    p.this.a(var1, var2);
                }
            });
        }

        public final void a(final String var1, final boolean var2, final boolean var3) {
            p.this.a.post(new Runnable() {
                public final void run() {
                    p.this.d = var2;
                    p.this.e = var3;
                    p.this.b(var1);
                }
            });
        }
    }
}
