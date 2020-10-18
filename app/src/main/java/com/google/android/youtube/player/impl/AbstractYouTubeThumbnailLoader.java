package com.google.android.youtube.player.impl;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.utils.Validators;

import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

public abstract class AbstractYouTubeThumbnailLoader implements YouTubeThumbnailLoader {
    private final WeakReference<YouTubeThumbnailView> thumbnailViewWeakReference;
    private OnThumbnailLoadedListener onThumbnailLoadedListener;
    private boolean hasPlaylist;
    // TODO isDisconnected
    private boolean isReleased;

    public AbstractYouTubeThumbnailLoader(YouTubeThumbnailView thumbnailView) {
        this.thumbnailViewWeakReference = new WeakReference<>(Validators.notNull(thumbnailView));
    }

    // TODO hasResources / holdsResources / isConnected
    protected boolean isConnected() {
        return !this.isReleased;
    }

    private void checkResources() {
        if (!this.isConnected()) {
            throw new IllegalStateException("This YouTubeThumbnailLoader has been released");
        }
    }

    @Override
    public final void setOnThumbnailLoadedListener(OnThumbnailLoadedListener listener) {
        this.checkResources();
        this.onThumbnailLoadedListener = listener;
    }

    @Override
    public final void setPlaylist(String playlistId) {
        this.setPlaylist(playlistId, 0);
    }

    @Override
    public final void setPlaylist(String playlistId, int skipTo) {
        this.checkResources();
        this.hasPlaylist = true;
        this.loadThumbnail(playlistId, skipTo);
    }

    @Override
    public final void setVideo(String videoId) {
        this.checkResources();
        this.hasPlaylist = false;
        this.loadThumbnail(videoId);
    }

    @Override
    public final void next() {
        this.checkResources();
        if (!this.hasPlaylist) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (!this.hasNextThumbnail()) {
            throw new NoSuchElementException("Called next at end of playlist");
        } else {
            this.loadNext();
        }
    }

    @Override
    public final void previous() {
        this.checkResources();
        if (!this.hasPlaylist) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (!this.hasPreviousThumbnail()) {
            throw new NoSuchElementException("Called previous at start of playlist");
        } else {
            this.loadPrevious();
        }
    }

    @Override
    public final void first() {
        this.checkResources();
        if (!this.hasPlaylist) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else {
            this.loadFirst();
        }
    }

    @Override
    public final boolean hasNext() {
        this.checkResources();
        return this.hasNextThumbnail();
    }

    @Override
    public final boolean hasPrevious() {
        this.checkResources();
        return this.hasPreviousThumbnail();
    }

    @Override
    public final void release() {
        if (this.isConnected()) {
            this.isReleased = true;
            this.onThumbnailLoadedListener = null;
            this.h();
        }
    }

    @Override
    public final void finalize() {
        if (this.isConnected()) {
            Log.w("YouTubeAndroidPlayerAPI", "The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().");
            this.release();
        }
    }

    // TODO setVideo / loadThumbnail
    public abstract void loadThumbnail(String videoId);

    // TODO setPlaylist / loadThumbnail
    public abstract void loadThumbnail(String playlistId, int skipTo);

    // TODO next
    public abstract void loadNext();

    // TODO previous
    public abstract void loadPrevious();

    // TODO first
    public abstract void loadFirst();

    // TODO hasNext
    public abstract boolean hasNextThumbnail();

    // TODO hasPrevious
    public abstract boolean hasPreviousThumbnail();

    // TODO disconnect / release
    public abstract void h();

    // TODO loadThumbnail might also be setThumbnail
    public final void loadThumbnail(Bitmap thumbnailBitmap, String videoId) {
        YouTubeThumbnailView thumbnail = this.thumbnailViewWeakReference.get();
        if (this.isConnected() && thumbnail != null) {
            thumbnail.setImageBitmap(thumbnailBitmap);
            if (this.onThumbnailLoadedListener != null) {
                this.onThumbnailLoadedListener.onThumbnailLoaded(thumbnail, videoId);
            }
        }

    }

    public final void onThumbnailError(String errorReasonString) {
        YouTubeThumbnailView thumbnailView = this.thumbnailViewWeakReference.get();
        if (this.isConnected() && this.onThumbnailLoadedListener != null && thumbnailView != null) {
            ErrorReason reason;
            try {
                reason = ErrorReason.valueOf(errorReasonString);
            } catch (IllegalArgumentException | NullPointerException e) {
                reason = ErrorReason.UNKNOWN;
            }

            this.onThumbnailLoadedListener.onThumbnailError(thumbnailView, reason);
        }
    }
}
