package com.google.android.youtube.player.internal;

interface IConnectionCallbacks {
    void onConnectionCompleted(String initializationResult, IBinder binder);
}
