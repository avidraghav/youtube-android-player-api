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

    private static final String TAG = "YouTubeBaseActivity";

    private static final int IS_STOPPING = 0;
    private static final int IS_STARTING = 1;
    private static final int IS_RESUMING = 2;
    private static final int IS_PAUSING = 1;

    private B b;
    private YouTubePlayerView playerView;
    private int lifecycleState;
    private Bundle bundle;

    final B getB() {
        Log.d(TAG, "getB: B interface requested.");
        return this.b;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "onCreate: Create BBB()...");
        this.b = new BBB();

        Log.d(TAG, "onCreate: Set bundle...");
        this.bundle = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: playerView=" + this.playerView);
        this.lifecycleState = IS_STARTING;
        if (this.playerView != null) {
            Log.d(TAG, "onStart: [a] playerView...");
            this.playerView.a();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: playerView=" + this.playerView);
        this.lifecycleState = IS_RESUMING;
        if (this.playerView != null) {
            Log.d(TAG, "onResume: bind playerView...");
            this.playerView.bind();
        }
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: playerView=" + this.playerView);
        this.lifecycleState = IS_PAUSING;
        if (this.playerView != null) {
            Log.d(TAG, "onPause: [c] playerView...");
            this.playerView.c();
        }
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Log.d(TAG, "onSaveInstanceState: bundle=" + bundle);
        Log.d(TAG, "onSaveInstanceState: Merge bundles...");
        Bundle actualBundle = this.playerView != null ? this.playerView.getBundle() : this.bundle;
        bundle.putBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE", actualBundle);
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: playerView=" + this.playerView);
        this.lifecycleState = IS_STOPPING;
        if (this.playerView != null) {
            this.playerView.d();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: playerView=" + this.playerView);
        if (this.playerView != null) {
            Log.d(TAG, "onDestroy: Release playerView (" + this.isFinishing() + ")...");
            this.playerView.release(this.isFinishing());
        }
        super.onDestroy();
    }

    private class BBB implements B {
        @Override
        public final void initialize(YouTubePlayerView view, String developerKey, OnInitializedListener listener) {
            Log.d(TAG, "(B) initialize: [a with params] playerView...");
            view.a(YouTubeBaseActivity.this, view, developerKey, listener, YouTubeBaseActivity.this.bundle);
            Log.d(TAG, "initialize: Set playerView of activity to null...");
            playerView = null;
        }

        @Override
        public final void onFocusChanged(YouTubePlayerView view) {
            Log.d(TAG, "onFocusChanged: view=" + view);
            Log.d(TAG, "onFocusChanged: playerView(activity)=" + playerView);
            if (playerView != null && playerView != view) {
                Log.d(TAG, "onFocusChanged: Stop (self) playerView (activity) with true...");
                playerView.stopSelf(true);
            }

            Log.d(TAG, "onFocusChanged: playerView (activity) = view");
            playerView = view;
            Log.d(TAG, "onFocusChanged: lifecycleState=" + lifecycleState);
            if (lifecycleState > IS_STOPPING) {
                Log.d(TAG, "onFocusChanged: [a without params] view...");
                view.a();
            }

            if (lifecycleState >= IS_RESUMING) {
                Log.d(TAG, "onFocusChanged: Bind view...");
                view.bind();
            }
        }
    }
}
