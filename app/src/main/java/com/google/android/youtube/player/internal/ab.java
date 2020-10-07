package com.google.android.youtube.player.internal;

import android.text.TextUtils;

public final class ab {
    public static <T> T a(T var0) {
        if (var0 == null) {
            throw new NullPointerException("null reference");
        } else {
            return var0;
        }
    }

    public static <T> T a(T var0, Object var1) {
        if (var0 == null) {
            throw new NullPointerException(String.valueOf(var1));
        } else {
            return var0;
        }
    }

    public static String a(String var0, Object var1) {
        if (TextUtils.isEmpty(var0)) {
            throw new IllegalArgumentException(String.valueOf(var1));
        } else {
            return var0;
        }
    }

    public static void a(boolean var0) {
        if (!var0) {
            throw new IllegalStateException();
        }
    }
}
