package com.google.android.youtube.player;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;

public final class z {
    private static final Uri a = Uri.parse("http://play.google.com/store/apps/details");
    private static final String[] b = new String[]{"com.google.android.youtube", "com.google.android.youtube.tv", "com.google.android.youtube.googletv", "com.google.android.gms", null};

    public static String a(Context var0) {
        PackageManager var5 = var0.getPackageManager();
        String[] var1;
        int var2 = (var1 = b).length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String var4 = var1[var3];
            Intent var6 = (new Intent("com.google.android.youtube.api.service.START")).setPackage(var4);
            ResolveInfo var7;
            if ((var7 = var5.resolveService(var6, 0)) != null && var7.serviceInfo != null && var7.serviceInfo.packageName != null) {
                return var7.serviceInfo.packageName;
            }
        }

        if (var5.hasSystemFeature("android.software.leanback")) {
            return "com.google.android.youtube.tv";
        } else if (var5.hasSystemFeature("com.google.android.tv")) {
            return "com.google.android.youtube.googletv";
        } else {
            return "com.google.android.youtube";
        }
    }

    public static boolean a(Context var0, String var1) {
        Resources var4;
        try {
            var4 = var0.getPackageManager().getResourcesForApplication(var1);
        } catch (NameNotFoundException var3) {
            return true;
        }

        String var2 = var1;
        if (var1.equals("com.google.android.youtube.googletvdev")) {
            var2 = "com.google.android.youtube.googletv";
        }

        int var6;
        if ((var6 = var4.getIdentifier("youtube_api_version_code", "integer", var2)) == 0) {
            return true;
        } else {
            int var5 = var4.getInteger(var6);
            return 12 > var5 / 100;
        }
    }

    public static Context b(Context var0) {
        try {
            return var0.createPackageContext(a(var0), 3);
        } catch (NameNotFoundException var1) {
            return null;
        }
    }

    public static int c(Context var0) {
        Context var1 = b(var0);
        int var2 = 0;
        if (var1 != null) {
            var2 = var1.getResources().getIdentifier("clientTheme", "style", a(var0));
        }

        if (var2 == 0) {
            if (VERSION.SDK_INT >= 14) {
                var2 = 16974120;
            } else if (VERSION.SDK_INT >= 11) {
                var2 = 16973931;
            } else {
                var2 = 16973829;
            }
        }

        return var2;
    }

    // TODO Document: returns app version
    public static String d(Context var0) {
        try {
            return var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionName;
        } catch (NameNotFoundException var1) {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", var1);
        }
    }

    // TODO Document: returns client library version
    public static String a() {
        return (new StringBuilder(35)).append(1).append(".2.2").toString();
    }

    public static Intent a(String var0) {
        Uri var2 = Uri.fromParts("package", var0, (String)null);
        Intent var1;
        (var1 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS")).setData(var2);
        return var1;
    }

    public static Intent b(String var0) {
        Intent var1 = new Intent("android.intent.action.VIEW");
        Uri var2 = a.buildUpon().appendQueryParameter("id", var0).build();
        var1.setData(var2);
        var1.setPackage("com.android.vending");
        var1.addFlags(524288);
        return var1;
    }

    public static boolean a(PackageManager var0) {
        return var0.hasSystemFeature("com.google.android.tv");
    }

    public static boolean b(PackageManager var0) {
        return var0.hasSystemFeature("android.software.leanback");
    }
}
