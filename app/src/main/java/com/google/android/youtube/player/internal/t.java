package com.google.android.youtube.player.internal;

import com.google.android.youtube.player.YouTubeInitializationResult;

/**
 * TODO Connection / Initializer / Client
 */
public interface t {
    void connect();

    void disconnect();

    interface OnInitializationResult {
        void onResult(YouTubeInitializationResult result);
    }

    interface C {
        void a();

        void b();
    }
}
