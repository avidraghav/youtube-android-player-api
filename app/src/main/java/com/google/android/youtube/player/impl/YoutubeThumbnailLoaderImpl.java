package com.google.android.youtube.player.impl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;

import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.IThumbnailLoaderClient;
import com.google.android.youtube.player.internal.IThumbnailLoaderService;
import com.google.android.youtube.player.network.ConnectionClient;
import com.google.android.youtube.player.utils.Validators;

public final class YoutubeThumbnailLoaderImpl extends AbstractYouTubeThumbnailLoader {
    private final Handler handler;
    private ConnectionClient connectionClient;
    private IThumbnailLoaderService thumbnailLoaderService;
    private boolean hasPrevious;
    private boolean hasNext;

    public YoutubeThumbnailLoaderImpl(ConnectionClient connectionClient, YouTubeThumbnailView thumbnail) {
        super(thumbnail);
        this.connectionClient = Validators.notNull(connectionClient, "connectionClient cannot be null");
        this.thumbnailLoaderService = connectionClient.getThumbnailLoaderService(new IThumbnailLoaderClient.Stub() {
            @Override
            public void loadThumbnail(final Bitmap thumbnail, final String videoId, final boolean hasPrevious, final boolean hasNext) throws RemoteException {
                handler.post(new Runnable() {
                    public final void run() {
                        YoutubeThumbnailLoaderImpl.this.hasPrevious = hasPrevious;
                        YoutubeThumbnailLoaderImpl.this.hasNext = hasNext;
                        YoutubeThumbnailLoaderImpl.this.loadThumbnail(thumbnail, videoId);
                    }
                });
            }

            @Override
            public void onLoadingError(final String reason, final boolean hasPrevious, final boolean hasNext) throws RemoteException {
                handler.post(new Runnable() {
                    public final void run() {
                        YoutubeThumbnailLoaderImpl.this.hasPrevious = hasPrevious;
                        YoutubeThumbnailLoaderImpl.this.hasNext = hasNext;
                        YoutubeThumbnailLoaderImpl.this.onThumbnailError(reason);
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
    public final void loadThumbnail(String videoId) {
        try {
            this.thumbnailLoaderService.setVideo(videoId);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public final void loadThumbnail(String playlistId, int skipTo) {
        try {
            this.thumbnailLoaderService.setPlaylist(playlistId, skipTo);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public final void loadNext() {
        try {
            this.thumbnailLoaderService.next();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public final void loadPrevious() {
        try {
            this.thumbnailLoaderService.previous();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public final void loadFirst() {
        try {
            this.thumbnailLoaderService.first();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public final boolean hasNextThumbnail() {
        return this.hasNext;
    }

    @Override
    public final boolean hasPreviousThumbnail() {
        return this.hasPrevious;
    }

    @Override
    public final void h() {
        try {
            this.thumbnailLoaderService.release();
        } catch (RemoteException e) {
        }

        this.connectionClient.disconnect();
        this.thumbnailLoaderService = null;
        this.connectionClient = null;
    }
}
