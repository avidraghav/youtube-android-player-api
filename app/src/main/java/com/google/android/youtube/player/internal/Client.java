package com.google.android.youtube.player.internal;

import com.google.android.youtube.player.YouTubeInitializationResult;

public interface Client {
    void connect();

    void disconnect();

    interface OnInitializationResult {
        void onResult(YouTubeInitializationResult result);
    }

    interface Connection {
        void bind();

        void release();
    }
}
