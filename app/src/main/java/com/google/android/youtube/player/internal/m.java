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

    public m(Context var1) {
        Resources var2;
        Locale var3;
        if ((var2 = var1.getResources()) != null && var2.getConfiguration() != null && var2.getConfiguration().locale != null) {
            var3 = var2.getConfiguration().locale;
        } else {
            var3 = Locale.getDefault();
        }

        Map var4 = x.a(var3);
        this.a = (String)var4.get("error_initializing_player");
        this.b = (String)var4.get("get_youtube_app_title");
        this.c = (String)var4.get("get_youtube_app_text");
        this.d = (String)var4.get("get_youtube_app_action");
        this.e = (String)var4.get("enable_youtube_app_title");
        this.f = (String)var4.get("enable_youtube_app_text");
        this.g = (String)var4.get("enable_youtube_app_action");
        this.h = (String)var4.get("update_youtube_app_title");
        this.i = (String)var4.get("update_youtube_app_text");
        this.j = (String)var4.get("update_youtube_app_action");
    }
}
