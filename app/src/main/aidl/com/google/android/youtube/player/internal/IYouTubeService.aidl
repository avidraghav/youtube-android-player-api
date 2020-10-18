package com.google.android.youtube.player.internal;

import com.google.android.youtube.player.internal.IThumbnailLoaderService;
import com.google.android.youtube.player.internal.IThumbnailLoaderClient;

interface IYouTubeService {
     IBinder toBinder();
     IThumbnailLoaderService getThumbnailLoaderService(IThumbnailLoaderClient var1);
     void release(boolean isFinishing);
}
