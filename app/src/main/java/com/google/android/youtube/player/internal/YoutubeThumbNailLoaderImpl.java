package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

import com.google.android.youtube.player.YouTubeThumbnailView;

public final class YoutubeThumbNailLoaderImpl extends AbstractYouTubeThumbnailLoader {
    private final Handler handler;
    private ConnectionClient connectionClient;
    private IThumbnailLoaderService thumbnailLoaderService;
    private boolean d;
    private boolean e;

    public YoutubeThumbNailLoaderImpl(ConnectionClient connectionClient, YouTubeThumbnailView thumbnail) {
        super(thumbnail);
        this.connectionClient = Validators.notNull(connectionClient, "connectionClient cannot be null");
        this.thumbnailLoaderService = connectionClient.a(new IThumbnailLoaderClient.ThumbnailLoaderClient() {
            @Override
            public void a(final Bitmap var1, final String var2, final boolean var3, final boolean var4) throws RemoteException {
                handler.post(new Runnable() {
                    public final void run() {
                        d = var3;
                        e = var4;
                        YoutubeThumbNailLoaderImpl.this.a(var1, var2);
                    }
                });
            }

            @Override
            public void a(final String var1, final boolean var2, final boolean var3) throws RemoteException {
                handler.post(new Runnable() {
                    public final void run() {
                        d = var2;
                        e = var3;
                        YoutubeThumbNailLoaderImpl.this.b(var1);
                    }
                });
            }
        });
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected final boolean a() {
        return super.a() && this.thumbnailLoaderService != null;
    }

    @Override
    public final void a(String var1) {
        try {
            this.thumbnailLoaderService.a(var1);
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void a(String var1, int var2) {
        try {
            this.thumbnailLoaderService.a(var1, var2);
        } catch (RemoteException var3) {
            throw new IllegalStateException(var3);
        }
    }

    @Override
    public final void c() {
        try {
            this.thumbnailLoaderService.a();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void d() {
        try {
            this.thumbnailLoaderService.b();
        } catch (RemoteException var2) {
            throw new IllegalStateException(var2);
        }
    }

    @Override
    public final void e() {
        try {
            this.thumbnailLoaderService.c();
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
            this.thumbnailLoaderService.d();
        } catch (RemoteException var1) {
        }

        this.connectionClient.d();
        this.thumbnailLoaderService = null;
        this.connectionClient = null;
    }
}
