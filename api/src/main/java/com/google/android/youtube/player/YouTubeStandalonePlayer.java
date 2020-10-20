package com.google.android.youtube.player;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public final class YouTubeStandalonePlayer {
    private YouTubeStandalonePlayer() {
    }

    public static Intent createVideoIntent(Activity activity, String developerKey, String videoId) {
        return createVideoIntent(activity, developerKey, videoId, 0, false, false);
    }

    public static Intent createVideoIntent(Activity activity, String developerKey, String videoId, int startTimeMillis, boolean autoPlay, boolean lightBoxMode) {
        if (videoId == null) {
            throw new NullPointerException("The videoId cannot be null");
        } else if (developerKey == null) {
            throw new NullPointerException("The developerKey cannot be null");
        } else {
            return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START")).putExtra("video_id", videoId), activity, developerKey, startTimeMillis, autoPlay, lightBoxMode);
        }
    }

    public static Intent createPlaylistIntent(Activity activity, String developerKey, String playlistId) {
        return createPlaylistIntent(activity, developerKey, playlistId, 0, 0, false, false);
    }

    public static Intent createPlaylistIntent(Activity activity, String developerKey, String playlistId, int currentIndex, int startTimeMillis, boolean autoPlay, boolean lightBoxMode) {
        if (playlistId == null) {
            throw new NullPointerException("The playlistId cannot be null");
        } else if (developerKey == null) {
            throw new NullPointerException("The developerKey cannot be null");
        } else {
            return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START"))
                    .putExtra("playlist_id", playlistId)
                    .putExtra("current_index", currentIndex), activity, developerKey, startTimeMillis, autoPlay, lightBoxMode);
        }
    }

    public static Intent createVideosIntent(Activity activity, String developerKey, List<String> videoIds) {
        return createVideosIntent(activity, developerKey, videoIds, 0, 0, false, false);
    }

    public static Intent createVideosIntent(Activity activity, String developerKey, List<String> videoIds, int currentIndex, int startTimeMillis, boolean autoPlay, boolean lightBoxMode) {
        if (videoIds == null) {
            throw new NullPointerException("The list of videoIds cannot be null");
        } else if (videoIds.isEmpty()) {
            throw new IllegalStateException("The list of videoIds cannot be empty");
        } else if (developerKey == null) {
            throw new NullPointerException("The developerKey cannot be null");
        } else {
            return a((new Intent("com.google.android.youtube.api.StandalonePlayerActivity.START"))
                    .putStringArrayListExtra("video_ids", new ArrayList<>(videoIds))
                    .putExtra("current_index", currentIndex), activity, developerKey, startTimeMillis, autoPlay, lightBoxMode);
        }
    }

    private static Intent a(Intent intent, Activity activity, String developerKey, int startTimeMillis, boolean autoPlay, boolean lightBoxMode) {
        YouTubeIntents.addIntentExtras(intent, activity)
                .putExtra("developer_key", developerKey)
                .putExtra("autoplay", autoPlay)
                .putExtra("lightbox_mode", lightBoxMode)
                .putExtra("start_time_millis", startTimeMillis)
                .putExtra("window_has_status_bar", (activity.getWindow().getAttributes().flags & 1024) == 0);
        return intent;
    }

    public static YouTubeInitializationResult getReturnedInitializationResult(Intent intent) {
        try {
            return YouTubeInitializationResult.valueOf(intent.getExtras().getString("initialization_result"));
        } catch (IllegalArgumentException | NullPointerException e) {
            return YouTubeInitializationResult.UNKNOWN_ERROR;
        }
    }
}
