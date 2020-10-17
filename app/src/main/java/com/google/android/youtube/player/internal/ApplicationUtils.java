package com.google.android.youtube.player.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;

public final class ApplicationUtils {
    private static final Uri a = Uri.parse("http://play.google.com/store/apps/details");
    private static final String[] packageList = new String[]{"com.google.android.youtube", "com.google.android.youtube.tv", "com.google.android.youtube.googletv", "com.google.android.gms", null};

    public static String getPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();

        for (String packageName : packageList) {
            Intent intent = (new Intent("com.google.android.youtube.api.service.START")).setPackage(packageName);
            ResolveInfo resolveInfo = packageManager.resolveService(intent, 0);
            if (resolveInfo != null && resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.packageName != null) {
                return resolveInfo.serviceInfo.packageName;
            }
        }

        if (packageManager.hasSystemFeature("android.software.leanback")) {
            return "com.google.android.youtube.tv";
        } else if (packageManager.hasSystemFeature("com.google.android.tv")) {
            return "com.google.android.youtube.googletv";
        } else {
            return "com.google.android.youtube";
        }
    }

    public static boolean a(Context context, String resource) {
        Resources res;
        try {
            res = context.getPackageManager().getResourcesForApplication(resource);
        } catch (NameNotFoundException e) {
            return true;
        }

        if (resource.equals("com.google.android.youtube.googletvdev")) {
            resource = "com.google.android.youtube.googletv";
        }

        int resNameId = res.getIdentifier("youtube_api_version_code", "integer", resource);
        if (resNameId == 0) {
            return true;
        } else {
            int resValue = res.getInteger(resNameId);
            return 12 > resValue / 100;
        }
    }

    public static Context createContext(Context context) {
        try {
            return context.createPackageContext(getPackageName(context), Context.CONTEXT_INCLUDE_CODE | Context.CONTEXT_IGNORE_SECURITY);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static int getDefaultStyleAttribute(Context context) {
        Context c = createContext(context);
        int defStyleAttr = 0;
        if (c != null) {
            defStyleAttr = c.getResources().getIdentifier("clientTheme", "style", getPackageName(context));
        }

        if (defStyleAttr == 0) {
            if (VERSION.SDK_INT >= 14) {
                defStyleAttr = android.R.style.Theme_DeviceDefault;
            } else if (VERSION.SDK_INT >= 11) {
                defStyleAttr = android.R.style.Theme_Holo;
            } else {
                defStyleAttr = android.R.style.Theme;
            }
        }

        return defStyleAttr;
    }

    public static String getPackageVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Cannot retrieve calling Context's PackageInfo", e);
        }
    }

    // TODO Document: returns client library version
    public static String a() {
        return (new StringBuilder(35)).append(1).append(".2.2").toString();
    }

    /**
     * Provides an intent that opens the application in the device's application details settings.
     *
     * @param packageName The application to open in the details settings
     * @return The intent that redirects to the application's details settings
     */
    public static Intent getAppDetailsSettingsIntent(String packageName) {
        Uri uri = Uri.fromParts("package", packageName, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(uri);
        return intent;
    }

    /**
     * Provides an intent that redirects the user to the Google Play Store page of the application
     * passed as {@param packageName}.
     *
     * @param packageName The application to link with the intent and open in Google Play Store.
     * @return An intent that opens the specified application in Google Play Store
     */
    public static Intent getPlayStoreIntent(String packageName) {
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri uri = a.buildUpon().appendQueryParameter("id", packageName).build();
        intent.setData(uri);
        intent.setPackage("com.android.vending");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        return intent;
    }

    public static boolean isGoogleTV(PackageManager packageManager) {
        return packageManager.hasSystemFeature("com.google.android.tv");
    }

    public static boolean supportsLeanBackUI(PackageManager packageManager) {
        return packageManager.hasSystemFeature("android.software.leanback");
    }
}
