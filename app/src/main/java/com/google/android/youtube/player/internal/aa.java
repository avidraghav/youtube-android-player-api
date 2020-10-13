package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;

import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.t.C;

public abstract class aa {
    private static final aa INSTANCE = getInstance();

    public aa() {
    }

    private static aa getInstance() {
        try {
            Class clazz = Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(aa.class);

            try {
                return (aa)clazz.newInstance();
            } catch (InstantiationException e) {
                throw new IllegalStateException(e);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        } catch (ClassNotFoundException e) {
            return new ac();
        }
    }

    public static aa a() {
        return INSTANCE;
    }

    public abstract ConnectionClient a(Context context, String developerKey, C var3, t.OnInitializationResult result);

    public abstract IEmbeddedPlayer a(Activity activity, ConnectionClient connectionClient, boolean var3) throws RemoteEmbeddedPlayer.RemotePlayerException;

    public abstract AbstractYouTubeThumbnailLoader a(ConnectionClient connectionClient, YouTubeThumbnailView thumbnail);
}
