package com.google.android.youtube.player.internal;

import android.os.IBinder;

public interface ConnectionClient extends t {
    IBinder a();

    IThumbnailLoaderService a(IThumbnailLoaderClient var1);

    void a(boolean var1);
}
