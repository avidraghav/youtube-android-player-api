package com.google.android.youtube.player.network;

import android.os.IBinder;

import com.google.android.youtube.player.internal.IThumbnailLoaderClient;
import com.google.android.youtube.player.internal.IThumbnailLoaderService;

public interface ConnectionClient extends Client {
    IBinder getSomeBinder();

    IThumbnailLoaderService getThumbnailLoaderService(IThumbnailLoaderClient client);

    // TODO Called from YouTubePlayer release(boolean var1) / disconnect /
    void release(final boolean var1);
}
