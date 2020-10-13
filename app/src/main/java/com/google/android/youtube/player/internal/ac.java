package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;

import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.t.a;

public final class ac extends aa {
    public ac() {
    }

    public final ConnectionClient a(Context context, String developerKey, a var3, t.OnInitializationResult result) {
        return new o(context, developerKey, context.getPackageName(), z.d(context), var3, result);
    }

    public final IEmbeddedPlayer a(Activity activity, ConnectionClient var2, boolean var3) throws RemoteEmbeddedPlayer.RemotePlayerException {
        return RemoteEmbeddedPlayer.a(activity, var2.a(), var3);
    }

    public final AbstractYouTubeThumbnailLoader a(ConnectionClient var1, YouTubeThumbnailView thumbnail) {
        return new YoutubeThumbnailLoaderImpl(var1, thumbnail);
    }
}
