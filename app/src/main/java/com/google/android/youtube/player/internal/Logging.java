package com.google.android.youtube.player.internal;

import android.util.Log;

// TODO This class can be directly implemented / replaced
public final class Logging {
    // TODO Create warning message / writeWarning / logWarning
    public static void warn(String message, Object... var1) {
        Log.w("YouTubeAndroidPlayerAPI", String.format(message, var1));
    }

    // TODO Create error message / writeError / logError
    public static void error(String message, Throwable error) {
        Log.e("YouTubeAndroidPlayerAPI", message, error);
    }
}
