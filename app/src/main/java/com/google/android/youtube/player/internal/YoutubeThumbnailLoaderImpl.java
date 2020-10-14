package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

import com.google.android.youtube.player.YouTubeThumbnailView;

public final class YoutubeThumbnailLoaderImpl extends AbstractYouTubeThumbnailLoader {
    private final Handler handler;
    private ConnectionClient connectionClient;
    private IThumbnailLoaderService thumbnailLoaderService;
    private boolean d;
    private boolean e;

    public YoutubeThumbnailLoaderImpl(ConnectionClient connectionClient, YouTubeThumbnailView thumbnail) {
        super(thumbnail);
        this.connectionClient = Validators.notNull(connectionClient, "connectionClient cannot be null");
        this.thumbnailLoaderService = connectionClient.ss(new IThumbnailLoaderClient.Stub() {
            @Override
            public void cc(final Bitmap var1, final String var2, final boolean var3, final boolean var4) throws RemoteException {
                handler.post(new Runnable() {
                    public final void run() {
                        d = var3;
                        e = var4;
                        YoutubeThumbnailLoaderImpl.this.loadThumbnail(var1, var2);
                    }
                });
            }

            @Override
            public void bb(final String var1, final boolean var2, final boolean var3) throws RemoteException {
                handler.post(new Runnable() {
                    public final void run() {
                        d = var2;
                        e = var3;
                        YoutubeThumbnailLoaderImpl.this.b(var1);
                    }
                });
            }
        });
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected final boolean isConnected() {
        return super.isConnected() && this.thumbnailLoaderService != null;
    }

    @Override
    public final void a(String videoId) {
        try {
            this.thumbnailLoaderService.setVideo(videoId);
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void a(String playlistId, int skipTo) {
        try {
            this.thumbnailLoaderService.setPlaylist(playlistId, skipTo);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    @Override
    public final void c() {
        try {
            this.thumbnailLoaderService.next();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void d() {
        try {
            this.thumbnailLoaderService.previous();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void e() {
        try {
            this.thumbnailLoaderService.first();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final boolean f() {
        return this.e;
    }

    @Override
    public final boolean g() {
        return this.d;
    }

    @Override
    public final void h() {
        try {
            this.thumbnailLoaderService.release();
        } catch (RemoteException var1) {
        }

        this.connectionClient.disconnect();
        this.thumbnailLoaderService = null;
        this.connectionClient = null;
    }
}
