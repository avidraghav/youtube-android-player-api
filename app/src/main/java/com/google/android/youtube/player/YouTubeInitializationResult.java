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
import android.util.Log;

import com.google.android.youtube.player.internal.Validators;
import com.google.android.youtube.player.internal.LocalizedYouTubePlayerTexts;
import com.google.android.youtube.player.internal.z;

/**
 * Provides the result of initializing the YouTube API Service. If initialization fails, the reason
 * for the failure is provided and, if this error is recoverable by user action, then a mechanism
 * to recover from the error is available via {@link #getErrorDialog(Activity, int)}.
 */
public enum YouTubeInitializationResult {

    /**
     * The initialization attempt was successful.
     */
    SUCCESS,

    /**
     * An internal error occurred.
     */
    INTERNAL_ERROR,

    /**
     * The reason for the error is not known.
     * <p>
     * This may be because the client library is older than the YouTube API service, and does not
     * know of the actual {@link YouTubeInitializationResult} that is being returned by the service.
     * Retrying may resolve the problem.
     */
    UNKNOWN_ERROR,

    /**
     * The YouTube API service is missing on this device.
     * <p>
     * The calling activity should pass this error reason to {@link #getErrorDialog(Activity, int)}
     * to get a localized error dialog that will enable the user to resolve the error when shown.
     */
    SERVICE_MISSING,

    /**
     * The installed version of YouTube API service is out of date.
     * <p>
     * The calling activity should pass this error reason to {@link #getErrorDialog(Activity, int)}
     * to get a localized error dialog that will enable the user to resolve the error when shown.
     */
    SERVICE_VERSION_UPDATE_REQUIRED,

    /**
     * The installed version of the YouTube API service has been disabled on this device.
     * <p>
     * The calling activity should pass this error reason to {@link #getErrorDialog(Activity, int)}
     * to get a localized error dialog that will enable the user to resolve the error when shown.
     */
    SERVICE_DISABLED,

    /**
     * The version of the YouTube API service installed on this device is not valid.
     * <p>
     * This may happen if there is a service on the device with the same name as the YouTube API
     * service, but which is not the official service provided by YouTube.
     */
    SERVICE_INVALID,

    /**
     * There was an error connecting to the YouTube API service.
     */
    ERROR_CONNECTING_TO_SERVICE,

    /**
     * The version of the client library used to connect to the YouTube API service is out of date.
     * <p>
     * The calling application must be rebuilt against a new version of the YouTube Android Player
     * API client library.
     */
    CLIENT_LIBRARY_UPDATE_REQUIRED,

    /**
     * There was an error connecting to the network which prevented the YouTube Player API service
     * initializing.
     */
    NETWORK_ERROR,

    /**
     * The developer key which was supplied to the initialization function is invalid.
     * <p>
     * To generate a new key, visit the
     * <a href="https://console.developers.google.com/">Google Developers Console</a>.
     */
    DEVELOPER_KEY_INVALID,

    /**
     * The application's APK has been incorrectly signed.
     * <p>
     * The application's APK must be signed with a single certificate. The YouTube Player API does
     * not support applications which have not been signed, or have been signed by more than one
     * certificate. For details on APK signing, please refer to this
     * <a href="http://developer.android.com/tools/publishing/app-signing.html">article</a>.
     */
    INVALID_APPLICATION_SIGNATURE;

    YouTubeInitializationResult() {
    }

    /**
     * Determines whether this error is user-recoverable.
     * <p>
     * If {@code true}, proceed by calling {@link #getErrorDialog(Activity, int)} and then show
     * this dialog to enable users to recover from this error.
     *
     * @return {@code true} if the error is recoverable with by calling
     * {@link #getErrorDialog(Activity, int)}, otherwise {@code false}.
     */
    public final boolean isUserRecoverableError() {
        switch (this) {
            case SERVICE_MISSING:
            case SERVICE_DISABLED:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return true;
            default:
                return false;
        }
    }

    /**
     * Returns a dialog to address this initialization error.
     * <p>
     * The returned dialog displays a localized message about the error and upon user confirmation
     * (by tapping on dialog) will direct them to the Play Store if the YouTube App is out of date
     * or missing, or to system settings if YouTube App is disabled on the device.
     *
     * @param activity    The parent activity for creating the dialog, also used for identifying
     *                    the language to display dialog in.
     * @param requestCode The {@code requestCode} given when calling {@link Activity#startActivityForResult}.
     * @return
     */
    public final Dialog getErrorDialog(Activity activity, int requestCode) {
        return this.getErrorDialog(activity, requestCode, (OnCancelListener) null);
    }

    /**
     * Returns a dialog to address this initialization error.
     * <p>
     * The returned dialog displays a localized message about the error and upon user confirmation
     * (by tapping on dialog) will direct them to the Play Store if the YouTube App is out of date
     * or missing, or to system settings if YouTube App is disabled on the device.
     *
     * @param activity       parent activity for creating the dialog, also used for identifying
     *                       language to display dialog in.
     * @param requestCode    The {@code requestCode} given when calling
     *                       {@link Activity#startActivityForResult}.
     * @param cancelListener The {@link DialogInterface.OnCancelListener} to invoke if the dialog
     *                       is canceled.
     * @return
     */
    public final Dialog getErrorDialog(Activity activity, int requestCode, OnCancelListener cancelListener) {
        Builder builder = new Builder(activity);
        if (cancelListener != null) {
            builder.setOnCancelListener(cancelListener);
        }

        Intent intent;
        switch (this) {
            case SERVICE_MISSING:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                intent = z.getPlayStoreIntent(z.getPackageName(activity));
                break;
            case SERVICE_DISABLED:
                intent = z.getAppDetailsSettingsIntent(z.getPackageName(activity));
                break;
            default:
                intent = null;
        }

        OnActionClickListener clickListener = new OnActionClickListener(activity, intent, requestCode);
        LocalizedYouTubePlayerTexts localizedTexts = new LocalizedYouTubePlayerTexts(activity);
        switch (this) {
            case SERVICE_MISSING:
                return builder
                        .setTitle(localizedTexts.getYouTubeAppTitle)
                        .setMessage(localizedTexts.getYouTubeAppText)
                        .setPositiveButton(localizedTexts.getYouTubeAppAction, clickListener)
                        .create();
            case SERVICE_DISABLED:
                return builder
                        .setTitle(localizedTexts.enableYouTubeAppTitle)
                        .setMessage(localizedTexts.enableYouTubeAppText)
                        .setPositiveButton(localizedTexts.enableYouTubeAppAction, clickListener)
                        .create();
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return builder
                        .setTitle(localizedTexts.updateYouTubeAppTitle)
                        .setMessage(localizedTexts.updateYouTubeAppText)
                        .setPositiveButton(localizedTexts.updateYouTubeAppAction, clickListener)
                        .create();
            default:
                throw new IllegalArgumentException("Unexpected errorReason: ".concat(this.name()));
        }
    }

    private static final class OnActionClickListener implements OnClickListener {
        private final Activity activity;
        private final Intent intent;
        private final int requestCode;

        public OnActionClickListener(Activity activity, Intent intent, int requestCode) {
            this.activity = (Activity) Validators.notNull(activity);
            this.intent = (Intent) Validators.notNull(intent);
            this.requestCode = Validators.notNull(requestCode);
        }

        public final void onClick(DialogInterface dialog, int var2) {
            try {
                this.activity.startActivityForResult(this.intent, this.requestCode);
                dialog.dismiss();
            } catch (ActivityNotFoundException e) {
                Log.e("YouTubeAndroidPlayerAPI", "Can't perform resolution for YouTubeInitializationError", e);
            }
        }
    }
}
