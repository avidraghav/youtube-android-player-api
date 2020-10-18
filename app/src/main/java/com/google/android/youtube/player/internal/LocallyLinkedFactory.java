package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;

import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.Client.Connection;

public final class LocallyLinkedFactory extends LinkedFactory {
    public LocallyLinkedFactory() {
    }

    public final ConnectionClient getClient(Context context, String developerKey, Connection connection, Client.OnInitializationResult result) {
        return new YouTubePlayerConnectionClient(context, developerKey, context.getPackageName(), ApplicationUtils.getPackageVersionName(context), connection, result);
    }

    public final IEmbeddedPlayer getPlayer(Activity activity, ConnectionClient client, boolean var3) throws RemoteEmbeddedPlayer.RemotePlayerException {
        return RemoteEmbeddedPlayer.a(activity, client.getSomeBinder(), var3);
    }

    public final AbstractYouTubeThumbnailLoader getThumbnailLoader(ConnectionClient client, YouTubeThumbnailView thumbnail) {
        return new YoutubeThumbnailLoaderImpl(client, thumbnail);
    }
}
