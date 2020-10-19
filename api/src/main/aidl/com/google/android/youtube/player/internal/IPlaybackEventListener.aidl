package com.google.android.youtube.player.internal;

interface IPlaybackEventListener {
    void onPlaying();
    void onPaused();
    void onStopped();
    void onBuffering(boolean isBuffering);
    void onSeekTo(int newPositionMillis);
}
