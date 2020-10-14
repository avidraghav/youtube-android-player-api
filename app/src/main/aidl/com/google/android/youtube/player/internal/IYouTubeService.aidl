package com.google.android.youtube.player.internal;

import com.google.android.youtube.player.internal.IThumbnailLoaderService;
import com.google.android.youtube.player.internal.IThumbnailLoaderClient;

interface IYouTubeService {
     IBinder ff();
     IThumbnailLoaderService ee(in IThumbnailLoaderClient var1);
     void dd(boolean var1);
}
