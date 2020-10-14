package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;

import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.t.C;

public final class LocallyLinkedFactory extends aa {
    public LocallyLinkedFactory() {
    }

    public final ConnectionClient a(Context context, String developerKey, C var3, t.OnInitializationResult result) {
        return new O(context, developerKey, context.getPackageName(), z.getPackageVersionName(context), var3, result);
    }

    public final IEmbeddedPlayer a(Activity activity, ConnectionClient client, boolean var3) throws RemoteEmbeddedPlayer.RemotePlayerException {
        return RemoteEmbeddedPlayer.a(activity, client.getBinder(), var3);
    }

    public final AbstractYouTubeThumbnailLoader a(ConnectionClient client, YouTubeThumbnailView thumbnail) {
        return new YoutubeThumbnailLoaderImpl(client, thumbnail);
    }
}
