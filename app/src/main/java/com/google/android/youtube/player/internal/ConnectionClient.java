package com.google.android.youtube.player.internal;

import android.os.IBinder;

public interface ConnectionClient extends Client {
    IBinder getBinder();

    IThumbnailLoaderService ss(IThumbnailLoaderClient var1);

    // TODO Called from YouTubePlayer release(boolean var1) / disconnect /
    void rr(final boolean var1);
}
