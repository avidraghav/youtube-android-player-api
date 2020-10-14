package com.google.android.youtube.player;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayerView.B;

/**
 * Any activity that wants to directly incorporate {@link YouTubePlayerView} views in its UI must
 * extend this activity.
 */
public class YouTubeBaseActivity extends AppCompatActivity {
    private B a;
    private YouTubePlayerView playerView;
    private int lifecycleState;
    private Bundle bundle;

    public YouTubeBaseActivity() {
    }

    final B getA() {
        return this.a;
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new B() {
            @Override
            public final void initialize(YouTubePlayerView view, String developerKey, OnInitializedListener listener) {
                view.a(YouTubeBaseActivity.this, view, developerKey, listener, YouTubeBaseActivity.this.bundle);
                playerView = null;
            }

            @Override
            public final void a(YouTubePlayerView view) {
                if (playerView != null && playerView != view) {
                    playerView.c(true);
                }

                playerView = view;
                if (lifecycleState > 0) {
                    view.a();
                }

                if (lifecycleState >= 2) {
                    view.b();
                }
            }
        };

        this.bundle = bundle != null ? bundle.getBundle("YouTubeBaseActivity.KEY_PLAYER_VIEW_STATE") : null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.lifecycleState = 1;
        if (this.playerView != null) {
            this.playerView.a();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.lifecycleState = 2;
        if (this.playerView != null) {
            this.playerView.b();
        }
    }

    @Override
    protected void onPause() {
        this.lifecycleState = 1;
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
        this.lifecycleState = 0;
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
}
