package com.google.android.youtube.player;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String TAG = "MainActivity";

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: Set content view...");
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Content view set.");

        YouTubePlayerView view = findViewById(R.id.ypv_first);

        Log.d(TAG, "onCreate: Initialize YouTubePlayerView...");
        view.initialize("AIzaSyC8Ch6FpgVHr3Kxq3xsqcfJ7iS-wTvgf8k", this);
        Log.d(TAG, "onCreate: end.");
    }

    YouTubePlayer.Provider getYouTubePlayerProvider() {
        Log.d(TAG, "getYouTubePlayerProvider: Provider requested...");
        return findViewById(R.id.ypv_first);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult called.");
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            Log.d(TAG, "onActivityResult: Request code is RECOVERY_DIALOG_REQUEST.");
            Log.d(TAG, "onActivityResult: Initialize provider...");
            getYouTubePlayerProvider().initialize("AIzaSyC8Ch6FpgVHr3Kxq3xsqcfJ7iS-wTvgf8k", this);
            Log.d(TAG, "onActivityResult: end.");
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: wasRestored=" + wasRestored);
        if (!wasRestored) {
            Log.d(TAG, "onInitializationSuccess: Load video...");
            player.loadVideo("wKJ9KzGQq0w");
        }
        Log.d(TAG, "onInitializationSuccess: end.");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
        Log.e(TAG, "onInitializationFailure (" + error + ")");
    }
}
