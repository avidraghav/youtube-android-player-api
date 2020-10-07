package com.google.android.youtube.player;

import android.graphics.Bitmap;

import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

public abstract class a implements YouTubeThumbnailLoader {
    private final WeakReference<YouTubeThumbnailView> thumbnailViewWeakReference;
    private OnThumbnailLoadedListener onThumbnailLoadedListener;
    private boolean c;
    private boolean d;

    public a(YouTubeThumbnailView thumbnailView) {
        this.thumbnailViewWeakReference = new WeakReference(ab.a(thumbnailView));
    }

    protected boolean a() {
        return !this.d;
    }

    private void i() {
        if (!this.a()) {
            throw new IllegalStateException("This YouTubeThumbnailLoader has been released");
        }
    }

    public final void setOnThumbnailLoadedListener(OnThumbnailLoadedListener listener) {
        this.i();
        this.onThumbnailLoadedListener = listener;
    }

    public final void setPlaylist(String playlistId) {
        this.setPlaylist(playlistId, 0);
    }

    public final void setPlaylist(String playlistId, int skipTo) {
        this.i();
        this.c = true;
        this.a(playlistId, skipTo);
    }

    public final void setVideo(String videoId) {
        this.i();
        this.c = false;
        this.a(videoId);
    }

    public final void next() {
        this.i();
        if (!this.c) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (!this.f()) {
            throw new NoSuchElementException("Called next at end of playlist");
        } else {
            this.c();
        }
    }

    public final void previous() {
        this.i();
        if (!this.c) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else if (!this.g()) {
            throw new NoSuchElementException("Called previous at start of playlist");
        } else {
            this.d();
        }
    }

    public final void first() {
        this.i();
        if (!this.c) {
            throw new IllegalStateException("Must call setPlaylist first");
        } else {
            this.e();
        }
    }

    public final boolean hasNext() {
        this.i();
        return this.f();
    }

    public final boolean hasPrevious() {
        this.i();
        return this.g();
    }

    public final void release() {
        if (this.a()) {
            this.d = true;
            this.onThumbnailLoadedListener = null;
            this.h();
        }

    }

    public final void b() {
        if (this.a()) {
            y.a("The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().", new Object[0]);
            this.release();
        }

    }

    public abstract void a(String var1);

    public abstract void a(String var1, int var2);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract void h();

    public final void a(Bitmap var1, String var2) {
        YouTubeThumbnailView var3 = (YouTubeThumbnailView)this.thumbnailViewWeakReference.get();
        if (this.a() && var3 != null) {
            var3.setImageBitmap(var1);
            if (this.onThumbnailLoadedListener != null) {
                this.onThumbnailLoadedListener.onThumbnailLoaded(var3, var2);
            }
        }

    }

    public final void b(String errorReasonString) {
        YouTubeThumbnailView thumbnailView = (YouTubeThumbnailView)this.thumbnailViewWeakReference.get();
        if (this.a() && this.onThumbnailLoadedListener != null && thumbnailView != null) {
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
