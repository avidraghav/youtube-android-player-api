package com.google.android.youtube.player;

import android.util.Log;

public final class y {
    public static void a(String var0, Object... var1) {
        Log.w("YouTubeAndroidPlayerAPI", String.format(var0, var1));
    }

    public static void a(String var0, Throwable var1) {
        Log.e("YouTubeAndroidPlayerAPI", var0, var1);
    }
}
