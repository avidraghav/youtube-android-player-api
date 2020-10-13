package com.google.android.youtube.player.internal;

import com.google.android.youtube.player.YouTubeInitializationResult;

/**
 * TODO Connection / Initializer /
 */
public interface t {
    void e();

    /*
    TODO: Connect or disconnect?
     */
    void d();

    interface OnInitializationResult {
        void onResult(YouTubeInitializationResult result);
    }

    interface a {
        void a();

        void b();
    }
}
