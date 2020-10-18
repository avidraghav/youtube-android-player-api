package com.google.android.youtube.player.impl;

import android.app.Activity;
import android.content.Context;

import com.google.android.youtube.player.LinkedFactory;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.IEmbeddedPlayer;
import com.google.android.youtube.player.network.Client;
import com.google.android.youtube.player.network.Client.Connection;
import com.google.android.youtube.player.network.ConnectionClient;
import com.google.android.youtube.player.network.YouTubePlayerConnectionClient;
import com.google.android.youtube.player.utils.ApplicationUtils;

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
