package com.google.android.youtube.player.network;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

import com.google.android.youtube.player.internal.IServiceBroker;
import com.google.android.youtube.player.internal.IThumbnailLoaderClient;
import com.google.android.youtube.player.internal.IThumbnailLoaderService;
import com.google.android.youtube.player.internal.IYouTubeService;
import com.google.android.youtube.player.utils.Validators;

public final class YouTubePlayerConnectionClient extends YouTubeClient<IYouTubeService> implements ConnectionClient {

    private final String developerKey;
    private final String callingPackage;
    private final String callingAppVersion;
    private boolean released;

    public YouTubePlayerConnectionClient(Context context, String developerKey, String callingPackage, String callingAppVersion, Connection var5, OnInitializationResult onInitializationResult) {
        super(context, var5, onInitializationResult);
        this.developerKey = Validators.notNull(developerKey);
        this.callingPackage = Validators.notEmpty(callingPackage, "callingPackage cannot be null or empty");
        this.callingAppVersion = Validators.notEmpty(callingAppVersion, "callingAppVersion cannot be null or empty");
    }

    @Override
    protected final String getConnectionDescriptor() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    @Override
    public final IYouTubeService a(IBinder iBinder) {
        return IYouTubeService.Stub.asInterface(iBinder);
    }

    @Override
    protected final String getAction() {
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
        serviceBroker.gg(callback, 1202, this.callingPackage, this.callingAppVersion, this.developerKey, null);
    }

    @Override
    public final IThumbnailLoaderService getThumbnailLoaderService(IThumbnailLoaderClient client) {
        this.isNotReleased();

        try {
            return this.getService().getThumbnailLoaderService(client);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public final IBinder getSomeBinder() {
        this.isNotReleased();

        try {
            return this.getService().toBinder();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void release(boolean isFinishing) {
        if (this.connectionExists()) {
            try {
                this.getService().release(isFinishing);
            } catch (RemoteException e) {
                // TODO Should error be ignored on stop / disconnect?
            }
            this.released = true;
        }
    }

    @Override
    public final void disconnect() {
        if (!this.released) {
            this.release(true);
        }
        super.disconnect();
    }
}
