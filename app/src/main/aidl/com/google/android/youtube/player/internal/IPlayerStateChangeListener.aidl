package com.google.android.youtube.player.internal;

interface IPlayerStateChangeListener {
    void onLoading();
    void onLoaded(String videoId);
    void onAdStarted();
    void onVideoStarted();
    void onVideoEnded();
    void onError(String reason);
}
