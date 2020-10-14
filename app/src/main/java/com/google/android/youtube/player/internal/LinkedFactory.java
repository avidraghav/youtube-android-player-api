package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;

import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.Client.Connection;

public abstract class LinkedFactory {

    private static final LinkedFactory INSTANCE = instantiate();

    private static LinkedFactory instantiate() {
        if (INSTANCE != null) return INSTANCE;
        try {
            final Class<? extends LinkedFactory> clazz = Class.forName("com.google.android.youtube.player.internal.LocallyLinkedFactory").asSubclass(LinkedFactory.class);

            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                throw new IllegalStateException(e);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        } catch (ClassNotFoundException e) {
            return new LocallyLinkedFactory();
        }
    }

    public static LinkedFactory getInstance() {
        return INSTANCE;
    }

    public abstract ConnectionClient getClient(Context context, String developerKey, Connection var3, Client.OnInitializationResult result);

    public abstract IEmbeddedPlayer getPlayer(Activity activity, ConnectionClient connectionClient, boolean var3) throws RemoteEmbeddedPlayer.RemotePlayerException;

    public abstract AbstractYouTubeThumbnailLoader getThumbnailLoader(ConnectionClient connectionClient, YouTubeThumbnailView thumbnail);
}
