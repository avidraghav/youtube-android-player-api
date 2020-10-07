package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public final class YouTubeStandalonePlayer {
    private YouTubeStandalonePlayer() {
    }

    public static Intent createVideoIntent(Activity var0, String var1, String var2) {
        return createVideoIntent(var0, var1, var2, 0, false, false);
    }

    public static Intent createVideoIntent(Activity var0, String var1, String var2, int var3, boolean var4, boolean var5) {
        if (var2 == null) {
            throw new NullPointerException("The videoId cannot be null");
        } else if (var1 == null) {
            throw new NullPointerException("The developerKey cannot be null");
        } else {
            return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START")).putExtra("video_id", var2), var0, var1, var3, var4, var5);
        }
    }

    public static Intent createPlaylistIntent(Activity var0, String var1, String var2) {
        return createPlaylistIntent(var0, var1, var2, 0, 0, false, false);
    }

    public static Intent createPlaylistIntent(Activity var0, String var1, String var2, int var3, int var4, boolean var5, boolean var6) {
        if (var2 == null) {
            throw new NullPointerException("The playlistId cannot be null");
        } else if (var1 == null) {
            throw new NullPointerException("The developerKey cannot be null");
        } else {
            return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START")).putExtra("playlist_id", var2).putExtra("current_index", var3), var0, var1, var4, var5, var6);
        }
    }

    public static Intent createVideosIntent(Activity var0, String var1, List<String> var2) {
        return createVideosIntent(var0, var1, var2, 0, 0, false, false);
    }

    public static Intent createVideosIntent(Activity var0, String var1, List<String> var2, int var3, int var4, boolean var5, boolean var6) {
        if (var2 == null) {
            throw new NullPointerException("The list of videoIds cannot be null");
        } else if (var2.isEmpty()) {
            throw new IllegalStateException("The list of videoIds cannot be empty");
        } else if (var1 == null) {
            throw new NullPointerException("The developerKey cannot be null");
        } else {
            return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START")).putStringArrayListExtra("video_ids", new ArrayList(var2)).putExtra("current_index", var3), var0, var1, var4, var5, var6);
        }
    }

    private static Intent a(Intent var0, Activity var1, String var2, int var3, boolean var4, boolean var5) {
        YouTubeIntents.addIntentExtras(var0, var1).putExtra("developer_key", var2).putExtra("autoplay", var4).putExtra("lightbox_mode", var5).putExtra("start_time_millis", var3).putExtra("window_has_status_bar", (var1.getWindow().getAttributes().flags & 1024) == 0);
        return var0;
    }

    public static YouTubeInitializationResult getReturnedInitializationResult(Intent var0) {
        String var3 = var0.getExtras().getString("initialization_result");

        try {
            return YouTubeInitializationResult.valueOf(var3);
        } catch (IllegalArgumentException var1) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        } catch (NullPointerException var2) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }
}
