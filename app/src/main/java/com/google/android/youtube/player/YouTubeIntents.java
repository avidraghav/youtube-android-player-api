package com.google.android.youtube.player;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import com.google.android.youtube.player.internal.z;

import java.util.List;

/**
 * A selection of static methods that create intents which navigate to specific activities within
 * the main YouTube application.
 * <p>
 * Video and playlist IDs required by methods such as {@link #createPlayVideoIntent(Context, String)}
 * or {@link #createOpenPlaylistIntent(Context, String)} are provided by the YouTube Data API. To
 * learn more about this API, visit https://developers.google.com/youtube/v3/.
 * <p>
 * Use the {@code canResolve} methods before sending an intent to make sure that the user's device
 * has a version of the YouTube application that supports the given intent.
 */
public final class YouTubeIntents {
    private YouTubeIntents() {
    }

    /**
     * Checks if the YouTube application is installed on the user's device.
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application is installed on the user's device,
     * {@code false} otherwise.
     */
    public static boolean isYouTubeInstalled(Context context) {
        try {
            context.getPackageManager().getApplicationInfo(getPackage(context), 0);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /**
     * Retrieves the version name of the YouTube application installed on the user's device.
     *
     * @param context The current Context.
     * @return A string representation of the version of YouTube installed on this device or
     * {@code null} if YouTube is not installed.
     */
    public static String getInstalledYouTubeVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(getPackage(context), 0).versionName;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    /**
     * Retrieves the version code of the YouTube application installed on the user's device.
     *
     * @param context The current Context.
     * @return A string representation of the version of YouTube installed on this device or
     * {@code -1} if YouTube is not installed.
     */
    public static int getInstalledYouTubeVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(getPackage(context), 0).versionCode;
        } catch (NameNotFoundException var1) {
            return -1;
        }
    }

    /**
     * Checks if the YouTube application installed on the user's device supports the play video
     * intent.
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application installed on the user's device allows
     * external apps to play a video in the YouTube application, {@code false} otherwise.
     * @see #createPlayVideoIntent(Context, String)
     */
    public static boolean canResolvePlayVideoIntent(Context context) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=");
        return canResolveUriIntent(context, uri);
    }

    /**
     * Creates an Intent that, when resolved, will start playing the video specified by
     * {@param videoId}, within the YouTube application.
     *
     * @param context The current Context.
     * @param videoId The ID of the video to be played, as returned from the
     *                <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @return An Intent which will start playing the video in the YouTube application.
     * @see #canResolvePlayVideoIntent(Context)
     */
    public static Intent createPlayVideoIntent(Context context, String videoId) {
        return createPlayVideoIntentWithOptions(context, videoId, false, false);
    }

    /**
     * Checks if the YouTube application installed on the user's device supports the {@code fullscreen}
     * and {@code finishedOnEnd} optional parameters when resolving a play video intent.
     * <ul>
     * <li>If this method returns {@code true}, then your application can call the
     * {@link #createPlayVideoIntentWithOptions(Context, String, boolean, boolean)} method.</li>
     * <li>If this method returns {@code true}, then your application should call the
     * {@link #createPlayVideoIntent(Context, String)} method instead.</li>
     * </ul>
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application installed on the user's device supports the
     * {@code false} otherwise.
     * @see #createPlayVideoIntentWithOptions(Context, String, boolean, boolean)
     */
    public static boolean canResolvePlayVideoIntentWithOptions(Context context) {
        int versionCode = getInstalledYouTubeVersionCode(context);
        PackageManager packageManager;
        return (z.b(packageManager = context.getPackageManager()) || (z.a(packageManager) ? versionCode >= 2147483647 : versionCode >= 3300)) && canResolvePlayVideoIntent(context);
    }

    /**
     * Creates an Intent that, when resolved, will start playing the video specified by
     * {@param videoId}, within the YouTube application.
     *
     * @param context     The current Context.
     * @param videoId     The ID of the video to be played, as returned from the
     *                    <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @param fullscreen  If {@code true} the video will be played fullscreen, if {@code false} the
     *                    video will be played according to the orientation of the device.
     * @param finishOnEnd If {@code true} will finish the YouTube application activity and return
     *                    to the calling activity once the video has finished, if {@code false}
     *                    will only return when the user clicks the <b>back</b> button.
     * @return An Intent which will start playing the video.
     * @see #canResolvePlayVideoIntentWithOptions(Context)
     */
    public static Intent createPlayVideoIntentWithOptions(Context context, String videoId, boolean fullscreen, boolean finishOnEnd) {
        String videoUrl = "https://www.youtube.com/watch?v=";

        if (videoId != null) {
            videoUrl = videoUrl.concat(videoId);
        }

        Uri uri = Uri.parse(videoUrl);
        return createUriIntent(context, uri)
                .putExtra("force_fullscreen", fullscreen)
                .putExtra("finish_on_ended", finishOnEnd);
    }

    /**
     * Checks if the YouTube application installed on the user's device supports the open search
     * results intent.
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application installed on the user's device allows
     * external apps to perform a search, {@code false} otherwise.
     * @see #createSearchIntent(Context, String)
     */
    public static boolean canResolveSearchIntent(Context context) {
        if (z.a(context.getPackageManager()) && getInstalledYouTubeVersionCode(context) < 4700) {
            return false;
        } else {
            Intent intent = (new Intent(Intent.ACTION_SEARCH)).setPackage(getPackage(context));
            return canResolveIntent(context, intent);
        }
    }

    /**
     * Creates an Intent that, when resolved, will open the search results for the given query in
     * the YouTube application.
     *
     * @param context The current Context.
     * @param query   The search query to request search results for.
     * @return An Intent that will open the search results page in the YouTube app with the results
     * for the given query.
     * @see #canResolveSearchIntent(Context)
     */
    public static Intent createSearchIntent(Context context, String query) {
        return addIntentExtras((new Intent(Intent.ACTION_SEARCH))
                .setPackage(getPackage(context))
                .putExtra("query", query), context);
    }

    /**
     * Checks if the YouTube application installed on the user's device supports the open playlist
     * intent.
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application installed on the user's device allows
     * external apps to navigate to the Playlist page, {@code false} otherwise.
     * @see #createOpenPlaylistIntent(Context, String)
     */
    public static boolean canResolveOpenPlaylistIntent(Context context) {
        Uri uri = Uri.parse("https://www.youtube.com/playlist?list=");
        return canResolveUriIntent(context, uri);
    }

    /**
     * Creates an Intent that, when resolved, will open the given playlist in the YouTube application.
     *
     * @param context    The current Context.
     * @param playlistId The ID of the playlist to be opened, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @return An intent that will open the Playlist page in the YouTube app with the given playlist.
     * @see #canResolveOpenPlaylistIntent(Context)
     */
    public static Intent createOpenPlaylistIntent(Context context, String playlistId) {
        Uri uri = createPlaylistUri(playlistId);
        return addIntentExtras(createUriIntent(context, uri), context);
    }

    /**
     * Checks if the YouTube application installed on the user's device supports the play playlist
     * intent.
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application installed on the user's device allows
     * external apps to start playing a playlist, {@code false} otherwise.
     * @see #createPlayPlaylistIntent(Context, String)
     */
    public static boolean canResolvePlayPlaylistIntent(Context context) {
        int versionCode = getInstalledYouTubeVersionCode(context);
        return (z.a(context.getPackageManager()) ? versionCode >= 4700 : versionCode >= 4000) && canResolveOpenPlaylistIntent(context);
    }

    /**
     * Creates an Intent that, when resolved, will start playing the given playlist in the YouTube
     * application from its first video.
     *
     * @param context    The current Context.
     * @param playlistId The ID of the playlist to be played, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @return An intent that will play the given playlist in the YouTube app.
     * @see #canResolvePlayPlaylistIntent(Context)
     */
    public static Intent createPlayPlaylistIntent(Context context, String playlistId) {
        Uri uri = createPlaylistUri(playlistId).buildUpon()
                .appendQueryParameter("playnext", "1")
                .build();

        return addIntentExtras(createUriIntent(context, uri), context);
    }

    /**
     * Checks if the YouTube application installed on the user's device supports the open user
     * intent.
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application installed on the user's device allows
     * external apps to navigate to the User page, {@code false} otherwise.
     * @see #createUserIntent(Context, String)
     */
    public static boolean canResolveUserIntent(Context context) {
        Uri uri = Uri.parse("https://www.youtube.com/user/");
        return canResolveUriIntent(context, uri);
    }

    /**
     * Creates an Intent that, when resolved, will open the user page for the given user ID in the
     * YouTube application.
     *
     * @param context  The current Context.
     * @param username The name of the channel that you want to retrieve information about.
     * @return An Intent that will open the given users' page in the YouTube app.
     * @see #canResolveUserIntent(Context)
     */
    public static Intent createUserIntent(Context context, String username) {
        String userUrl = "https://www.youtube.com/user/";
        if (username != null) {
            userUrl = userUrl.concat(username);
        }

        Uri uri = Uri.parse(userUrl);
        return createUriIntent(context, uri);
    }

    /**
     * Checks if the YouTube application installed on the user's device supports the open channel
     * intent.
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application installed on the user's device allows
     * external apps to navigate to the Channel page, {@code false} otherwise.
     * @see #createChannelIntent(Context, String)
     */
    public static boolean canResolveChannelIntent(Context context) {
        Uri uri = Uri.parse("https://www.youtube.com/channel/");
        return canResolveUriIntent(context, uri);
    }

    /**
     * Creates an Intent that, when resolved, will open the channel page for the given channel ID
     * in the YouTube application.
     *
     * @param context   The current Context.
     * @param channelId The ID of the channel to be displayed, as returned from the
     *                  <a href="https://developers.google.com/youtube/v3/docs/channels#resource">YouTube Data API</a>.
     * @return An Intent that will open the given channel page in the YouTube app.
     * @see #canResolveChannelIntent(Context)
     */
    public static Intent createChannelIntent(Context context, String channelId) {
        String channelUrl = "https://www.youtube.com/channel/";
        if (channelId != null) {
            channelUrl = channelUrl.concat(channelId);
        }

        Uri uri = Uri.parse(channelUrl);
        return createUriIntent(context, uri);
    }

    /**
     * Checks if the YouTube application installed on the user's device supports the upload video
     * intent.
     *
     * @param context The current Context.
     * @return {@code true} if the YouTube application installed on the user's device allows
     * external apps to upload videos to YouTube, {@code false} otherwise.
     * @see #createUploadIntent(Context, Uri)
     */
    public static boolean canResolveUploadIntent(Context context) {
        Intent intent = (new Intent("com.google.android.youtube.intent.action.UPLOAD")).setPackage(getPackage(context)).setType("video/*");
        return canResolveIntent(context, intent);
    }

    /**
     * Creates an Intent that, when resolved, will open the upload activity in the YouTube
     * application for the video specified by the {@param videoUri}. An exception will be thrown if
     * {@param videoUri} does not exist or is invalid. If the video specified by {@param videoUri}
     * does not exist, the resulting Activity will end immediately after starting.
     *
     * @param context  The current Context.
     * @param videoUri A Uri that points to the video on your device you wish to upload.
     * @return An Intent that will open the upload page in the YouTube app, with the specified
     * video already selected for loaded.
     * @throws IllegalArgumentException will be thrown if the video specified by the Uri is invalid.
     * @see #canResolveUploadIntent(Context)
     */
    public static Intent createUploadIntent(Context context, Uri videoUri) throws IllegalArgumentException {
        if (videoUri == null) {
            throw new IllegalArgumentException("videoUri parameter cannot be null.");
        } else if (!videoUri.toString().startsWith("content://media/")) {
            throw new IllegalArgumentException("videoUri parameter must be a URI pointing to a " +
                    "valid video file. It must begin with \"content://media/\"");
        } else {
            return addIntentExtras((new Intent("com.google.android.youtube.intent.action.UPLOAD"))
                    .setPackage(getPackage(context))
                    .setDataAndType(videoUri, "video/*"), context);
        }
    }

    private static boolean canResolveUriIntent(Context context, Uri uri) {
        Intent intent = (new Intent(Intent.ACTION_VIEW, uri)).setPackage(getPackage(context));
        return canResolveIntent(context, intent);
    }

    private static Intent createUriIntent(Context context, Uri uri) {
        return addIntentExtras((new Intent(Intent.ACTION_VIEW, uri)).setPackage(getPackage(context)), context);
    }

    /**
     * Adds to the {@param intent} the app's package name and version, and the client's library
     * version.
     *
     * @param intent  The intent to add the information
     * @param context The current Context.
     * @return the {@param intent} with the data added as extras.
     */
    static Intent addIntentExtras(Intent intent, Context context) {
        intent.putExtra("app_package", context.getPackageName())
                .putExtra("app_version", z.d(context))
                .putExtra("client_library_version", z.a());
        return intent;
    }

    /**
     * Checks if there is any activity that can be performed for the given intent.
     *
     * @param context The current Context.
     * @param intent  The intent the activity has to perform for.
     * @return {@code true} if there were found any activities that can be performed for the given
     * intent, {@code false} otherwise.
     */
    private static boolean canResolveIntent(Context context, Intent intent) {
        List<ResolveInfo> list = context.getPackageManager()
                .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return !list.isEmpty();
    }

    /**
     * TODO Add documentation
     * @param context The current Context.
     * @return TODO Add return value documentation
     */
    private static String getPackage(Context context) {
        PackageManager packageManager;
        if (z.b(packageManager = context.getPackageManager())) {
            return "com.google.android.youtube.tv";
        } else {
            return z.a(packageManager) ? "com.google.android.youtube.googletv" : "com.google.android.youtube";
        }
    }

    private static Uri createPlaylistUri(String playlistId) {
        String playlistUrl = "https://www.youtube.com/playlist?list=";
        if (playlistId != null) {
            playlistUrl = playlistUrl.concat(playlistId);
        }

        return Uri.parse(playlistUrl);
    }
}
