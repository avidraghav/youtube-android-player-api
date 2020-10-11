package com.google.android.youtube.player.internal;

import android.os.RemoteException;

public final class YouTubePlayerException extends RuntimeException {
    public YouTubePlayerException(RemoteException e) {
        super(e);
    }
}
