package com.google.android.youtube.player;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerView.YouTubePlayerViewInitializer;

/**
 * Any activity that wants to directly incorporate {@link YouTubePlayerView} views in its UI must
 * extend this activity.
 */
public class YouTubeBaseActivity extends AppCompatActivity {

    public static final String KEY_PLAYER_VIEW_STATE = "YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE";

    private static final int IS_STOPPING = 0;
    private static final int IS_STARTING = 1;
    private static final int IS_RESUMING = 2;
    private static final int IS_PAUSING = 1;

    private YouTubePlayerViewInitializer playerViewInitializer;
    private YouTubePlayerView playerView;
    private int lifecycleState;
    private Bundle bundle;

    final YouTubePlayerViewInitializer getViewInitializer() {
        return this.playerViewInitializer;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.playerViewInitializer = new ActivityPlayerViewInitializer();
        this.bundle = bundle != null ? bundle.getBundle(KEY_PLAYER_VIEW_STATE) : null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.lifecycleState = IS_STARTING;
        if (this.playerView != null) {
            this.playerView.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.lifecycleState = IS_RESUMING;
        if (this.playerView != null) {
            this.playerView.onResume();
        }
    }

    @Override
    protected void onPause() {
        this.lifecycleState = IS_PAUSING;
        if (this.playerView != null) {
            this.playerView.onPause();
        }
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle actualBundle = this.playerView != null ? this.playerView.getBundle() : this.bundle;
        outState.putBundle(KEY_PLAYER_VIEW_STATE, actualBundle);
    }

    @Override
    protected void onStop() {
        this.lifecycleState = IS_STOPPING;
        if (this.playerView != null) {
            this.playerView.onStop();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (this.playerView != null) {
            this.playerView.release(this.isFinishing());
        }
        super.onDestroy();
    }

    private class ActivityPlayerViewInitializer implements YouTubePlayerViewInitializer {

        @Override
        public final void initializeView(YouTubePlayerView view, String developerKey, OnInitializedListener listener) {
            view.initialize(YouTubeBaseActivity.this, view, developerKey, listener, bundle);
            playerView = null;
        }

        @Override
        public final void onViewInitialized(YouTubePlayerView view) {
            if (playerView != null && playerView != view) {
                playerView.stopSelf(true);
            }

            playerView = view;
            if (lifecycleState > IS_STOPPING) {
                view.onStart();
            }

            if (lifecycleState >= IS_RESUMING) {
                view.onResume();
            }
        }
    }
}
