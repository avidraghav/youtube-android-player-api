package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.res.Resources;

import java.util.Locale;
import java.util.Map;

public final class m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    public m(Context context) {
        Resources res;
        Locale locale;
        if ((res = context.getResources()) != null && res.getConfiguration() != null && res.getConfiguration().locale != null) {
            locale = res.getConfiguration().locale;
        } else {
            locale = Locale.getDefault();
        }

        Map<String, String> var4 = x.a(locale);
        this.a = var4.get("error_initializing_player");
        this.b = var4.get("get_youtube_app_title");
        this.c = var4.get("get_youtube_app_text");
        this.d = var4.get("get_youtube_app_action");
        this.e = var4.get("enable_youtube_app_title");
        this.f = var4.get("enable_youtube_app_text");
        this.g = var4.get("enable_youtube_app_action");
        this.h = var4.get("update_youtube_app_title");
        this.i = var4.get("update_youtube_app_text");
        this.j = var4.get("update_youtube_app_action");
    }
}
