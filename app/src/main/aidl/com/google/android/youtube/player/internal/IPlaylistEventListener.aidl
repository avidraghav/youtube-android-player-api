package com.google.android.youtube.player.internal;

interface IPlaylistEventListener {
    void onPrevious() = 1;
    void onNext() = 2;
    void onPlaylistEnded() = 3;
}
