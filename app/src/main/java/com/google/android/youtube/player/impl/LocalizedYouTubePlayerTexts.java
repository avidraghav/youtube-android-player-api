package com.google.android.youtube.player.impl;

import android.content.Context;
import android.content.res.Resources;

import java.util.Locale;
import java.util.Map;

// TODO Replace this with localized resource files
public final class LocalizedYouTubePlayerTexts {
    public final String errorInitializingPlayer;
    public final String getYouTubeAppTitle;
    public final String getYouTubeAppText;
    public final String getYouTubeAppAction;
    public final String enableYouTubeAppTitle;
    public final String enableYouTubeAppText;
    public final String enableYouTubeAppAction;
    public final String updateYouTubeAppTitle;
    public final String updateYouTubeAppText;
    public final String updateYouTubeAppAction;

    public LocalizedYouTubePlayerTexts(Context context) {
        Resources res;
        Locale locale;
        if ((res = context.getResources()) != null && res.getConfiguration() != null && res.getConfiguration().locale != null) {
            locale = res.getConfiguration().locale;
        } else {
            locale = Locale.getDefault();
        }

        Map<String, String> var4 = LocalizedYouTubeTexts.a(locale);
        this.errorInitializingPlayer = var4.get("error_initializing_player");
        this.getYouTubeAppTitle = var4.get("get_youtube_app_title");
        this.getYouTubeAppText = var4.get("get_youtube_app_text");
        this.getYouTubeAppAction = var4.get("get_youtube_app_action");
        this.enableYouTubeAppTitle = var4.get("enable_youtube_app_title");
        this.enableYouTubeAppText = var4.get("enable_youtube_app_text");
        this.enableYouTubeAppAction = var4.get("enable_youtube_app_action");
        this.updateYouTubeAppTitle = var4.get("update_youtube_app_title");
        this.updateYouTubeAppText = var4.get("update_youtube_app_text");
        this.updateYouTubeAppAction = var4.get("update_youtube_app_action");
    }
}
