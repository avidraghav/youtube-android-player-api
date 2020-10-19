package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.youtube.player.impl.AbstractYouTubeThumbnailLoader;
import com.google.android.youtube.player.network.Client;
import com.google.android.youtube.player.network.ConnectionClient;
import com.google.android.youtube.player.utils.Validators;

public final class YouTubeThumbnailView extends AppCompatImageView {

    private ConnectionClient client;
    private AbstractYouTubeThumbnailLoader thumbnailLoader;

    public YouTubeThumbnailView(Context var1) {
        this(var1, (AttributeSet) null);
    }

    public YouTubeThumbnailView(Context var1, AttributeSet var2) {
        this(var1, var2, 0);
    }

    public YouTubeThumbnailView(Context var1, AttributeSet var2, int var3) {
        super(var1, var2, var3);
    }

    public final void initialize(String developerKey, YouTubeThumbnailView.OnInitializedListener listener) {
        YouTubeThumbnailView.a var3 = new YouTubeThumbnailView.a(this, listener);
        this.client = LinkedFactory.getInstance().getClient(this.getContext(), developerKey, var3, var3);
        this.client.connect();
    }

    @Override
    protected final void finalize() throws Throwable {
        if (this.thumbnailLoader != null) {
            this.thumbnailLoader.finalize();
            this.thumbnailLoader = null;
        }
        super.finalize();
    }

    public interface OnInitializedListener {
        void onInitializationSuccess(YouTubeThumbnailView var1, YouTubeThumbnailLoader loader);

        void onInitializationFailure(YouTubeThumbnailView var1, YouTubeInitializationResult result);
    }

    private static final class a implements Client.Connection, Client.OnInitializationResult {

        private static final String TAG = "a[Cl.Conn,Cl.OnInitRes]";

        private YouTubeThumbnailView thumbnailView;
        private YouTubeThumbnailView.OnInitializedListener onInitializedListener;

        public a(YouTubeThumbnailView thumbnailView, YouTubeThumbnailView.OnInitializedListener onInitListener) {
            this.thumbnailView = Validators.notNull(thumbnailView, "thumbnailView cannot be null");
            this.onInitializedListener = Validators.notNull(onInitListener, "onInitializedlistener cannot be null");
        }

        @Override
        public final void bind() {
            Log.d(TAG, "bind: called.");
            if (this.thumbnailView != null && this.thumbnailView.client != null) {
                this.thumbnailView.thumbnailLoader = LinkedFactory.getInstance().getThumbnailLoader(this.thumbnailView.client, this.thumbnailView);
                this.onInitializedListener.onInitializationSuccess(this.thumbnailView, this.thumbnailView.thumbnailLoader);
                this.reset();
            }
        }

        @Override
        public final void release() {
            this.reset();
        }

        @Override
        public final void onResult(YouTubeInitializationResult result) {
            this.onInitializedListener.onInitializationFailure(this.thumbnailView, result);
            this.reset();
        }

        private void reset() {
            if (this.thumbnailView != null) {
                this.thumbnailView.client = null;
                this.thumbnailView = null;
                this.onInitializedListener = null;
            }
        }
    }
}
