package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.youtube.player.internal.AbstractYouTubeThumbnailLoader;
import com.google.android.youtube.player.internal.aa;
import com.google.android.youtube.player.internal.Validators;
import com.google.android.youtube.player.internal.ConnectionClient;
import com.google.android.youtube.player.internal.t;

public final class YouTubeThumbnailView extends AppCompatImageView {
    private ConnectionClient a;
    private AbstractYouTubeThumbnailLoader b;

    public YouTubeThumbnailView(Context var1) {
        this(var1, (AttributeSet)null);
    }

    public YouTubeThumbnailView(Context var1, AttributeSet var2) {
        this(var1, var2, 0);
    }

    public YouTubeThumbnailView(Context var1, AttributeSet var2, int var3) {
        super(var1, var2, var3);
    }

    public final void initialize(String var1, YouTubeThumbnailView.OnInitializedListener var2) {
        YouTubeThumbnailView.a var3 = new YouTubeThumbnailView.a(this, var2);
        this.a = aa.a().a(this.getContext(), var1, var3, var3);
        this.a.connect();
    }

    @Override
    protected final void finalize() throws Throwable {
        if (this.b != null) {
            this.b.b();
            this.b = null;
        }

        super.finalize();
    }

    private static final class a implements t.C, t.OnInitializationResult {
        private YouTubeThumbnailView a;
        private YouTubeThumbnailView.OnInitializedListener b;

        public a(YouTubeThumbnailView var1, YouTubeThumbnailView.OnInitializedListener var2) {
            this.a = (YouTubeThumbnailView) Validators.notNull(var1, "thumbnailView cannot be null");
            this.b = (YouTubeThumbnailView.OnInitializedListener) Validators.notNull(var2, "onInitializedlistener cannot be null");
        }

        public final void a() {
            if (this.a != null && this.a.a != null) {
                this.a.b = aa.a().a(this.a.a, this.a);
                this.b.onInitializationSuccess(this.a, this.a.b);
                this.c();
            }

        }

        public final void b() {
            this.c();
        }

        public final void onResult(YouTubeInitializationResult result) {
            this.b.onInitializationFailure(this.a, result);
            this.c();
        }

        private void c() {
            if (this.a != null) {
                YouTubeThumbnailView.c(this.a);
                this.a = null;
                this.b = null;
            }

        }
    }

    public interface OnInitializedListener {
        void onInitializationSuccess(YouTubeThumbnailView var1, YouTubeThumbnailLoader var2);

        void onInitializationFailure(YouTubeThumbnailView var1, YouTubeInitializationResult var2);
    }
}
