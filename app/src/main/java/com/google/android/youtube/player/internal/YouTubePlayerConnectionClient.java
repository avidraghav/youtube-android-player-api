package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

public final class YouTubePlayerConnectionClient extends YouTubeClient<IYouTubeService> implements ConnectionClient {
    private final String b;
    private final String callingPackage;
    private final String callingAppVersion;
    private boolean released;

    public YouTubePlayerConnectionClient(Context context, String developerKey, String callingPackage, String callingAppVersion, Connection var5, OnInitializationResult onInitializationResult) {
        super(context, var5, onInitializationResult);
        this.b = Validators.notNull(developerKey);
        this.callingPackage = Validators.notEmpty(callingPackage, "callingPackage cannot be null or empty");
        this.callingAppVersion = Validators.notEmpty(callingAppVersion, "callingAppVersion cannot be null or empty");
    }

    @Override
    protected final String getConnectionDescriptor() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    // TODO Was not implemented before
    @Override
    protected IYouTubeService a(IBinder var1) {
        return null;
    }

    @Override
    protected final String c() {
        return "com.google.android.youtube.api.service.START";
    }

    private void isNotReleased() {
        this.checkConnection();
        if (this.released) {
            throw new IllegalStateException("Connection client has been released");
        }
    }

    @Override
    protected final void a(IServiceBroker serviceBroker, OnConnectionCompletedListener callback) throws RemoteException {
        serviceBroker.gg(callback, 1202, this.callingPackage, this.callingAppVersion, this.b, null);
    }

    @Override
    public final IThumbnailLoaderService ss(IThumbnailLoaderClient var1) {
        this.isNotReleased();

        try {
            return this.j().ee(var1);
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final IBinder getBinder() {
        this.isNotReleased();

        try {
            return this.j().ff();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void rr(boolean var1) {
        if (this.isConnected()) {
            try {
                this.j().dd(var1);
            } catch (RemoteException var2) {
            }

            this.released = true;
        }
    }

    @Override
    public final void disconnect() {
        if (!this.released) {
            this.rr(true);
        }
        super.disconnect();
    }
}