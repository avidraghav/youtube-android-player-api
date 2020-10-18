package com.google.android.youtube.player;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        YouTubePlayerView view = findViewById(R.id.ypv_first);
        view.initialize("AIzaSyC8Ch6FpgVHr3Kxq3xsqcfJ7iS-wTvgf8k", this);
    }

    YouTubePlayer.Provider getYouTubePlayerProvider() {
        return findViewById(R.id.ypv_first);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            getYouTubePlayerProvider().initialize("AIzaSyC8Ch6FpgVHr3Kxq3xsqcfJ7iS-wTvgf8k", this);
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.loadVideo("wKJ9KzGQq0w");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
        // TODO Handle initialization failures
    }
}
