//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.google.android.youtube.player;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

import com.google.android.youtube.player.internal.ab;
import com.google.android.youtube.player.internal.m;
import com.google.android.youtube.player.internal.y;
import com.google.android.youtube.player.internal.z;

public enum YouTubeInitializationResult {
    SUCCESS,
    INTERNAL_ERROR,
    UNKNOWN_ERROR,
    SERVICE_MISSING,
    SERVICE_VERSION_UPDATE_REQUIRED,
    SERVICE_DISABLED,
    SERVICE_INVALID,
    ERROR_CONNECTING_TO_SERVICE,
    CLIENT_LIBRARY_UPDATE_REQUIRED,
    NETWORK_ERROR,
    DEVELOPER_KEY_INVALID,
    INVALID_APPLICATION_SIGNATURE;

    private YouTubeInitializationResult() {
    }

    public final boolean isUserRecoverableError() {
        switch(this) {
            case SERVICE_MISSING:
            case SERVICE_DISABLED:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return true;
            default:
                return false;
        }
    }

    public final Dialog getErrorDialog(Activity var1, int var2) {
        return this.getErrorDialog(var1, var2, (OnCancelListener)null);
    }

    public final Dialog getErrorDialog(Activity var1, int var2, OnCancelListener var3) {
        Builder var4 = new Builder(var1);
        if (var3 != null) {
            var4.setOnCancelListener(var3);
        }

        Intent var10000;
        switch(this) {
            case SERVICE_MISSING:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                var10000 = z.b(z.a(var1));
                break;
            case SERVICE_DISABLED:
                var10000 = z.a(z.a(var1));
                break;
            default:
                var10000 = null;
        }

        Intent var8 = var10000;
        YouTubeInitializationResult.a var7 = new YouTubeInitializationResult.a(var1, var8, var2);
        m var6 = new m(var1);
        switch(this) {
            case SERVICE_MISSING:
                return var4.setTitle(var6.b).setMessage(var6.c).setPositiveButton(var6.d, var7).create();
            case SERVICE_DISABLED:
                return var4.setTitle(var6.e).setMessage(var6.f).setPositiveButton(var6.g, var7).create();
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return var4.setTitle(var6.h).setMessage(var6.i).setPositiveButton(var6.j, var7).create();
            default:
                IllegalArgumentException var9 = new IllegalArgumentException;
                String var10003 = String.valueOf(this.name());
                String var10002;
                if (var10003.length() != 0) {
                    var10002 = "Unexpected errorReason: ".concat(var10003);
                } else {
                    String var10004 = new String;
                    var10002 = var10004;
                    var10004.<init>("Unexpected errorReason: ");
                }

                var9.<init>(var10002);
                throw var9;
        }
    }

    private static final class a implements OnClickListener {
        private final Activity a;
        private final Intent b;
        private final int c;

        public a(Activity var1, Intent var2, int var3) {
            this.a = (Activity) ab.a(var1);
            this.b = (Intent)ab.a(var2);
            this.c = (Integer)ab.a(var3);
        }

        public final void onClick(DialogInterface var1, int var2) {
            try {
                this.a.startActivityForResult(this.b, this.c);
                var1.dismiss();
            } catch (ActivityNotFoundException var3) {
                y.a("Can't perform resolution for YouTubeInitalizationError", var3);
            }
        }
    }
}
