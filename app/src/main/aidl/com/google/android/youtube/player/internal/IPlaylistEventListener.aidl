package com.google.android.youtube.player.internal;

interface IPlaylistEventListener {
    void onPrevious();
    void onNext();
    void onPlaylistEnded();
}
