package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

public final class o extends r<IYouTubeService> implements ConnectionClient {
    private final String b;
    private final String callingPackage;
    private final String callingAppVersion;
    private boolean e;

    public o(Context context, String var2, String callingPackage, String callingAppVersion, t.a var5, OnInitializationResult onInitializationResult) {
        super(context, var5, onInitializationResult);
        this.b = Validators.notNull(var2);
        this.callingPackage = Validators.notEmpty(callingPackage, "callingPackage cannot be null or empty");
        this.callingAppVersion = Validators.notEmpty(callingAppVersion, "callingAppVersion cannot be null or empty");
    }

    @Override
    protected final String b() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    @Override
    protected final String c() {
        return "com.google.android.youtube.api.service.START";
    }

    private void k() {
        this.i();
        if (this.e) {
            throw new IllegalStateException("Connection client has been released");
        }
    }

    @Override
    protected final void a(IServiceBroker var1, d var2) throws RemoteException {
        var1.a(var2, 1202, this.callingPackage, this.callingAppVersion, this.b, null);
    }

    @Override
    public final IThumbnailLoaderService a(IThumbnailLoaderClient var1) {
        this.k();

        try {
            return this.j().a(var1);
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final IBinder a() {
        this.k();

        try {
            return this.j().a();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void a(boolean var1) {
        if (this.f()) {
            try {
                this.j().a(var1);
            } catch (RemoteException var2) {
            }

            this.e = true;
        }

    }

    @Override
    public final void d() {
        if (!this.e) {
            this.a(true);
        }

        super.d();
    }
}
