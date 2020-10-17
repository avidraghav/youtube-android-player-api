package com.google.android.youtube.player.internal;

import android.os.IBinder;

public interface ConnectionClient extends Client {
    IBinder getBinder();

    IThumbnailLoaderService getThumbnailLoaderService(IThumbnailLoaderClient client);

    // TODO Called from YouTubePlayer release(boolean var1) / disconnect /
    void release(final boolean var1);
}
