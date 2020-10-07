package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;

import com.google.android.youtube.player.YouTubeThumbnailView;
import com.google.android.youtube.player.internal.t.a;

public abstract class aa {
    private static final aa a = b();

    public aa() {
    }

    private static aa b() {
        try {
            Class var0 = Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(aa.class);

            try {
                return (aa)var0.newInstance();
            } catch (InstantiationException var1) {
                throw new IllegalStateException(var1);
            } catch (IllegalAccessException var2) {
                throw new IllegalStateException(var2);
            }
        } catch (ClassNotFoundException var3) {
            return new ac();
        }
    }

    public static aa a() {
        return a;
    }

    public abstract b a(Context var1, String var2, a var3, com.google.android.youtube.player.internal.t.b var4);

    public abstract d a(Activity var1, b var2, boolean var3) throws com.google.android.youtube.player.internal.w.a;

    public abstract com.google.android.youtube.player.internal.a a(b var1, YouTubeThumbnailView var2);
}
