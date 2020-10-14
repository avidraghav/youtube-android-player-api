package com.google.android.youtube.player;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerView.B;

/**
 * Any activity that wants to directly incorporate {@link YouTubePlayerView} views in its UI must
 * extend this activity.
 */
public class YouTubeBaseActivity extends AppCompatActivity {

    private static final int IS_STOPPING = 0;
    private static final int IS_STARTING = 1;
    private static final int IS_RESUMING = 2;
    private static final int IS_PAUSING = 1;

    private B b;
    private YouTubePlayerView playerView;
    private int lifecycleState;
    private Bundle bundle;

    public YouTubeBaseActivity() {
    }

    final B getB() {
        return this.b;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = new BBB();

        this.bundle = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.lifecycleState = IS_STARTING;
        if (this.playerView != null) {
            this.playerView.a();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.lifecycleState = IS_RESUMING;
        if (this.playerView != null) {
            this.playerView.b();
        }
    }

    @Override
    protected void onPause() {
        this.lifecycleState = IS_PAUSING;
        if (this.playerView != null) {
            this.playerView.c();
        }
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle actualBundle = this.playerView != null ? this.playerView.getBundle() : this.bundle;
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", actualBundle);
    }

    @Override
    protected void onStop() {
        this.lifecycleState = IS_STOPPING;
        if (this.playerView != null) {
            this.playerView.d();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (this.playerView != null) {
            this.playerView.b(this.isFinishing());
        }
        super.onDestroy();
    }

    private class BBB implements B {
        @Override
        public final void initialize(YouTubePlayerView view, String developerKey, OnInitializedListener listener) {
            Log.d("YouTubeBaseActivity", "initialize called.");
            view.a(YouTubeBaseActivity.this, view, developerKey, listener, YouTubeBaseActivity.this.bundle);
            playerView = null;
        }

        @Override
        public final void a(YouTubePlayerView view) {
            if (playerView != null && playerView != view) {
                playerView.c(true);
            }

            playerView = view;
            if (lifecycleState > IS_STOPPING) {
                view.a();
            }

            if (lifecycleState >= IS_RESUMING) {
                view.b();
            }
        }
    }
}
