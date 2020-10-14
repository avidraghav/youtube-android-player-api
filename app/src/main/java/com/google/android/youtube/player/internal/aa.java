package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;

import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.t.C;

public abstract class aa {

    private static final aa INSTANCE = instantiate();

    private static aa instantiate() {
        if (INSTANCE != null) return INSTANCE;
        try {
            final Class<? extends aa> clazz = Class.forName("com.google.android.youtube.player.internal.LocallyLinkedFactory").asSubclass(aa.class);

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

    public static aa getInstance() {
        return INSTANCE;
    }

    public abstract ConnectionClient a(Context context, String developerKey, C var3, t.OnInitializationResult result);

    public abstract IEmbeddedPlayer a(Activity activity, ConnectionClient connectionClient, boolean var3) throws RemoteEmbeddedPlayer.RemotePlayerException;

    public abstract AbstractYouTubeThumbnailLoader a(ConnectionClient connectionClient, YouTubeThumbnailView thumbnail);
}
