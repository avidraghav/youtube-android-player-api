package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerView.b;

/**
 * Any activity that wants to directly incorporate {@link YouTubePlayerView} views in its UI must
 * extend this activity.
 */
public class YouTubeBaseActivity extends Activity {
    private YouTubeBaseActivity.a a;
    private YouTubePlayerView playerView;
    private int lifecycleState;
    private Bundle bundle;

    public YouTubeBaseActivity() {
    }

    final b a() {
        return this.a;
    }

    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.a = new YouTubeBaseActivity.a((byte)0);
        this.bundle = var1 != null ? var1.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    protected void onStart() {
        super.onStart();
        this.lifecycleState = 1;
        if (this.playerView != null) {
            this.playerView.a();
        }

    }

    protected void onResume() {
        super.onResume();
        this.lifecycleState = 2;
        if (this.playerView != null) {
            this.playerView.b();
        }

    }

    protected void onPause() {
        this.lifecycleState = 1;
        if (this.playerView != null) {
            this.playerView.c();
        }

        super.onPause();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle actualBundle = this.playerView != null ? this.playerView.getBundle() : this.bundle;
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", actualBundle);
    }

    protected void onStop() {
        this.lifecycleState = 0;
        if (this.playerView != null) {
            this.playerView.d();
        }

        super.onStop();
    }

    protected void onDestroy() {
        if (this.playerView != null) {
            this.playerView.b(this.isFinishing());
        }

        super.onDestroy();
    }

    private final class a implements b {
        private a() {
        }

        public final void a(YouTubePlayerView view, String var2, OnInitializedListener listener) {
            view.a(YouTubeBaseActivity.this, view, var2, listener, YouTubeBaseActivity.this.bundle);
            YouTubeBaseActivity.b(YouTubeBaseActivity.this);
        }

        public final void a(YouTubePlayerView playerView) {
            if (YouTubeBaseActivity.this.playerView != null && YouTubeBaseActivity.this.playerView != playerView) {
                YouTubeBaseActivity.this.playerView.c(true);
            }

            YouTubeBaseActivity.this.playerView = playerView;
            if (YouTubeBaseActivity.this.lifecycleState > 0) {
                playerView.a();
            }

            if (YouTubeBaseActivity.this.lifecycleState >= 2) {
                playerView.b();
            }

        }
    }
}
