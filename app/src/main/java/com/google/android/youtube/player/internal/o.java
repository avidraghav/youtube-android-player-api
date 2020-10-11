package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public final class o extends r<l> implements ConnectionClient {
    private final String b;
    private final String c;
    private final String d;
    private boolean e;

    public o(Context var1, String var2, String var3, String var4, a var5, com.google.android.youtube.player.internal.t.b var6) {
        super(var1, var5, var6);
        this.b = (String) Validators.notNull(var2);
        this.c = Validators.notEmpty(var3, "callingPackage cannot be null or empty");
        this.d = Validators.notEmpty(var4, "callingAppVersion cannot be null or empty");
    }

    protected final String b() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    protected final String c() {
        return "com.google.android.youtube.api.service.START";
    }

    private final void k() {
        this.i();
        if (this.e) {
            throw new IllegalStateException("Connection client has been released");
        }
    }

    protected final void a(i var1, d var2) throws RemoteException {
        var1.a(var2, 1202, this.c, this.d, this.b, (Bundle)null);
    }

    public final k a(j var1) {
        this.k();

        try {
            return ((l)this.j()).a(var1);
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    public final IBinder a() {
        this.k();

        try {
            return ((l)this.j()).a();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    public final void a(boolean var1) {
        if (this.f()) {
            try {
                ((l)this.j()).a(var1);
            } catch (RemoteException var2) {
            }

            this.e = true;
        }

    }

    public final void d() {
        if (!this.e) {
            this.a(true);
        }

        super.d();
    }
}
