package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;

import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

public abstract class AbstractYouTubeThumbnailLoader implements YouTubeThumbnailLoader {
    private final WeakReference<YouTubeThumbnailView> thumbnailViewWeakReference;
    private OnThumbnailLoadedListener onThumbnailLoadedListener;
    private boolean hasPlaylist;
    private boolean isReleased;

    public AbstractYouTubeThumbnailLoader(YouTubeThumbnailView thumbnailView) {
        this.thumbnailViewWeakReference = new WeakReference<>(Validators.notNull(thumbnailView));
    }

    // TODO hasResources / holdsResources
    protected boolean hasResources() {
        return !this.isReleased;
    }

    private void checkResources() {
        if (!this.hasResources()) {
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
        this.a(playlistId, skipTo);
    }

    @Override
    public final void setVideo(String videoId) {
        this.checkResources();
        this.hasPlaylist = false;
        this.a(videoId);
    }

    @Override
    public final void next() {
        this.checkResources();
        if (!this.hasPlaylist) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (!this.f()) {
            throw new NoSuchElementException("Called next at end of playlist");
        } else {
            this.c();
        }
    }

    @Override
    public final void previous() {
        this.checkResources();
        if (!this.hasPlaylist) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (!this.g()) {
            throw new NoSuchElementException("Called previous at start of playlist");
        } else {
            this.d();
        }
    }

    @Override
    public final void first() {
        this.checkResources();
        if (!this.hasPlaylist) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else {
            this.e();
        }
    }

    @Override
    public final boolean hasNext() {
        this.checkResources();
        return this.f();
    }

    @Override
    public final boolean hasPrevious() {
        this.checkResources();
        return this.g();
    }

    @Override
    public final void release() {
        if (this.hasResources()) {
            this.isReleased = true;
            this.onThumbnailLoadedListener = null;
            this.h();
        }
    }

    // TODO finalize
    public final void b() {
        if (this.hasResources()) {
            Logging.warn("The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().");
            this.release();
        }
    }

    // TODO setVideo
    public abstract void a(String videoId);

    // TODO setPlaylist
    public abstract void a(String playlistId, int skipTo);

    // TODO next
    public abstract void c();

    // TODO previous
    public abstract void d();

    // TODO first
    public abstract void e();

    // TODO hasNext
    public abstract boolean f();

    // TODO hasPrevious
    public abstract boolean g();

    // TODO release
    public abstract void h();

    // TODO loadThumbnail might also be setThumbnail
    public final void loadThumbnail(Bitmap thumbnailBitmap, String videoId) {
        YouTubeThumbnailView thumbnail = this.thumbnailViewWeakReference.get();
        if (this.hasResources() && thumbnail != null) {
            thumbnail.setImageBitmap(thumbnailBitmap);
            if (this.onThumbnailLoadedListener != null) {
                this.onThumbnailLoadedListener.onThumbnailLoaded(thumbnail, videoId);
            }
        }

    }

    public final void b(String errorReasonString) {
        YouTubeThumbnailView thumbnailView = this.thumbnailViewWeakReference.get();
        if (this.hasResources() && this.onThumbnailLoadedListener != null && thumbnailView != null) {
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
