package com.google.android.youtube.player.internal;

import android.os.IBinder;

public interface ConnectionClient extends t {
    IBinder getBinder();

    IThumbnailLoaderService a(IThumbnailLoaderClient var1);

    // TODO Called from YouTubePlayer release(boolean var1) / disconnect /
    // TODO
    void a(boolean var1);
}
