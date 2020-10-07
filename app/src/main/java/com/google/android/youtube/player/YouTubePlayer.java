package com.google.android.youtube.player;

import java.util.List;

/**
 * A YouTubePlayer provides methods for loading, playing and controlling YouTube video playback.
 * Get an instance of this class by calling {@link Provider#initialize(String, OnInitializedListener)}
 * on a {@link Provider} such as {@link YouTubePlayerFragment} or {@link YouTubePlayerView}.
 * <p>
 * Video and playlist IDs required by methods such as {@link #loadVideo(String)} or
 * {@link #cuePlaylist(String)} are provided by the YouTube Data API. To learn more
 * about this API, visit https://developers.google.com/youtube/.
 * <p>
 * The YouTubePlayer supports state saving, which is managed automatically by the {@link Provider}
 * of the player. The saved state includes the loaded videos, the current playback position and
 * player configurations such as the current YouTubePlayer.PlayerStyle or fullscreen control flags.
 * The state does not include any of the listeners that may be set on the player, so they need to
 * be set again after the player is recreated.
 * <p>
 * You should only call methods on a {@link YouTubePlayer} object from the UI thread.
 */
public interface YouTubePlayer {

    /**
     * Flag for {@link #setFullscreenControlFlags(int)} to enable automatic control
     * of the orientation.
     */
    int FULLSCREEN_FLAG_CONTROL_ORIENTATION = 1;

    /**
     * Flag for {@link #setFullscreenControlFlags(int)} to enable automatic control of system UI.
     */
    int FULLSCREEN_FLAG_CONTROL_SYSTEM_UI = 2;

    /**
     * Flag for {@link #setFullscreenControlFlags(int)} which causes the player to automatically
     * enter fullscreen whenever the device enters landscape orientation.
     */
    int FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE = 4;

    /**
     * Flag for {@link #setFullscreenControlFlags(int)} that disables the default fullscreen
     * layout handler, enabling you to control the transition to fullscreen layout manually.
     */
    int FULLSCREEN_FLAG_CUSTOM_LAYOUT = 8;

    /**
     * Stop any loading or video playback and release any system resources used by this
     * {@link YouTubePlayer}.
     * <p>
     * Note that after calling this method any further interaction with this {@link YouTubePlayer}
     * is forbidden. A new instance must be created to re-enable playback.
     */
    void release();

    /**
     * Loads the specified video's thumbnail and prepares the player to play the video, but does
     * not download any of the video stream until{@link #play()} is called.
     *
     * @param videoId The ID of the video to be cued, as returned from the
     *                <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     */
    void cueVideo(String videoId);

    /**
     * Loads the specified video's thumbnail and prepares the player to play the video, but does
     * not download any of the video stream until{@link #play()} is called.
     * <p>
     * When the user presses play or {@link #play()} is called, playback will start at the
     * specified time in the video.
     *
     * @param videoId    The ID of the video to be cued, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @param timeMillis The time, in milliseconds, where playback should start in the video.
     */
    void cueVideo(String videoId, int timeMillis);

    /**
     * Loads and plays the specified video.
     * <p>
     * Note: YouTube only counts playbacks that are initiated through the native play button.
     *
     * @param videoId The ID of the video to be played, as returned from the
     *                <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     */
    void loadVideo(String videoId);

    /**
     * Loads and plays the specified video.
     * <p>
     * Playback will start at the specified time in the video.
     * <p>
     * Note: YouTube only counts playbacks that are initiated through the native play button.
     *
     * @param videoId    The ID of the video to be played, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @param timeMillis The time, in milliseconds, where playback should start in the video.
     */
    void loadVideo(String videoId, int timeMillis);

    /**
     * Cues the specified playlist, but does not download any of the video streams or start playing
     * until {@link #play()} or {@link #seekToMillis(int)} is called.
     *
     * @param playlistId The ID for the playlist to be cued, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     */
    void cuePlaylist(String playlistId);

    /**
     * Cues the specified playlist, but does not download any of the video streams or start playing
     * until {@link #play()} or {@link #seekToMillis(int)} is called.
     * <p>
     * When the user presses play or {@link #play()} is called, playback will play the video with the
     * specified index in the playlist, starting at the specified time in the video.
     *
     * @param playlistId The ID for the playlist to be cued, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @param startIndex The index in the playlist of the first video to be cued.
     * @param timeMillis The time, in milliseconds, where playback should start in the first video cued.
     */
    void cuePlaylist(String playlistId, int startIndex, int timeMillis);

    /**
     * Loads and plays the specified playlist.
     * <p>
     * Note: YouTube only counts playbacks that are initiated through the native play button.
     *
     * @param playlistId The ID for the playlist to be played, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     */
    void loadPlaylist(String playlistId);

    /**
     * Loads and plays the specified playlist.
     * <p>
     * Playback will start at the video with the specified index and will start at the specified
     * time in the video.
     * <p>
     * Note: YouTube only counts playbacks that are initiated through the native play button.
     *
     * @param playlistId The ID for the playlist to be played, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @param startIndex The index in the playlist where playback will start.
     * @param timeMillis The time, in milliseconds, where playback should start in the first video played.
     */
    void loadPlaylist(String playlistId, int startIndex, int timeMillis);

    /**
     * Cues a list of videos, but does not download any of the video streams or start playing until
     * {@link #play()} or {@link #seekToMillis(int)} is called.
     *
     * @param videoIds A list of YouTube video IDs to be cued, as returned from the
     *                 <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     */
    void cueVideos(List<String> videoIds);

    /**
     * Cues a list of videos, but does not download any of the video streams or start playing until
     * {@link #play()} or {@link #seekToMillis(int)} is called.
     * <p>
     * When the user presses play or {@link #play()} is called, playback will play the video with
     * the specified index and playback will start at the specified time in the video.
     *
     * @param videoIds   A list of YouTube video IDs to be cued, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @param startIndex The index in the list of the first video to be cued.
     * @param timeMillis The time, in milliseconds, where playback should start in the first video cued.
     */
    void cueVideos(List<String> videoIds, int startIndex, int timeMillis);

    /**
     * Loads and plays a list of videos.
     * <p>
     * Note: YouTube only counts playbacks that are initiated through the native play button.
     *
     * @param videoIds A list of YouTube video IDs to be played, as returned from the
     *                 <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     */
    void loadVideos(List<String> videoIds);

    /**
     * Loads and plays a list of videos.
     * <p>
     * Playback will start at the video with the specified index and will start at the specified
     * time in the video
     * <p>
     * Note: YouTube only counts playbacks that are initiated through the native play button.
     *
     * @param videoIds   A list of YouTube video IDs to be played, as returned from the
     *                   <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @param startIndex The index in the list of the first video to be played.
     * @param timeMillis The time, in milliseconds, where playback should start in the first video played.
     */
    void loadVideos(List<String> videoIds, int startIndex, int timeMillis);

    /**
     * Starts video playback of the currently cued / loaded video.
     * <p>
     * Note: YouTube only counts playbacks that are initiated through the native play button.
     */
    void play();

    /**
     * Pauses the currently playing video.
     */
    void pause();

    /**
     * Determines whether the player is currently playing.
     *
     * @return {@code true} if the player is currently playing, or buffering while still in the
     * playing state, {@code false} otherwise.
     */
    boolean isPlaying();

    /**
     * Determines whether the currently loaded playlist has a next video.
     *
     * @return {@code true} if there is a next video in the loaded playlist, {@code false} otherwise.
     */
    boolean hasNext();

    /**
     * Determines whether the currently loaded playlist has a previous video.
     *
     * @return {@code true} if there is a previous video in the loaded playlist, {@code false}
     * otherwise.
     */
    boolean hasPrevious();

    /**
     * Plays the next video in the loaded playlist.
     * <p>
     * Note that a second call to {@link #next()} or {@link #previous()}, before the first call has
     * finished (as indicated by {@link PlayerStateChangeListener#onLoaded(String)}) might be ignored.
     *
     * @throws java.util.NoSuchElementException This exception is thrown if the method is called at
     *                                          the end of the playlist.
     */
    void next();

    /**
     * Plays the previous video in the loaded playlist.
     * <p>
     * Note that a second call to {@link #next()} or {@link #previous()}, before the first call has
     * finished (as indicated by {@link PlayerStateChangeListener#onLoaded(String)}) might be ignored.
     *
     * @throws java.util.NoSuchElementException This exception is thrown if the method is called at
     *                                          the start of the playlist.
     */
    void previous();

    /**
     * Gets the current elapsed time of the playing video relative to its start.
     *
     * @return The current elapsed time (a number of milliseconds) of the playing video relative
     * to its start. The result is only well-defined after the video has finished loading.
     * @see PlayerStateChangeListener#onLoaded(String)
     */
    int getCurrentTimeMillis();

    /**
     * Gets the duration of the currently loaded video.
     *
     * @return The currently loaded video's duration (in milliseconds). The result is only defined
     * after the video has finished loading, and may change to a more accurate value when the video
     * starts playing.
     * @see PlayerStateChangeListener#onLoaded(String)
     * @see PlayerStateChangeListener#onVideoStarted()
     */
    int getDurationMillis();

    /**
     * Seeks to the specified time in the video.
     * <p>
     * If the player is paused or stopped when this function is called, the player will remain in
     * the same state, but will start the video at the sought-to position when playback resumes.
     *
     * @param milliSeconds Time to seek to in milliseconds.
     */
    void seekToMillis(int milliSeconds);

    /**
     * Seeks forward or backward by the specified number of seconds.
     * <p>
     * If the player is paused or stopped when this function is called, the player will remain
     * in the same state, but will start the video at the sought-to position when playback resumes.
     *
     * @param milliSeconds Number of milliseconds to seek forward, if positive, or backward, if
     *                     negative.
     */
    void seekRelativeMillis(int milliSeconds);

    /**
     * Inform the player that it is being laid out fullscreen.
     * <p>
     * Calling this function may affect the looks of the player's controls, e.g. showing an option
     * to enter or exit fullscreen, changing the layout to better suit the current player size etc.
     * <p>
     * Note: Calling this function will cause any registered {@link OnFullscreenListener} to fire
     * an {@link OnFullscreenListener#onFullscreen(boolean)} event.
     *
     * @param fullscreen {code true} if the player is fullscreen, {@code false} otherwise.
     */
    void setFullscreen(boolean fullscreen);

    /**
     * Registers a {@link OnFullscreenListener}.
     *
     * @param onFullscreenListener The listener to be notified of fullscreen toggling.
     */
    void setOnFullscreenListener(OnFullscreenListener onFullscreenListener);

    /**
     * Controls the automatic behavior when fullscreen mode is toggled.
     * <p>
     * This method allows you to enable or disable different parts of fullscreen behavior that can
     * be automated by the library. Examples include control of screen orientation, showing/hiding
     * system UI on fullscreen events and a default fullscreen layout. The default flags set are
     * {@link #FULLSCREEN_FLAG_CONTROL_SYSTEM_UI} and {@link #FULLSCREEN_FLAG_CONTROL_ORIENTATION}.
     *
     * @param flags Bitwise-or of {@link #FULLSCREEN_FLAG_CONTROL_ORIENTATION},
     *              {@link #FULLSCREEN_FLAG_CONTROL_SYSTEM_UI},
     *              {@link #FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE} and
     *              {@link #FULLSCREEN_FLAG_CUSTOM_LAYOUT}. A value of 0 will disable any automatic
     *              behavior.
     */
    void setFullscreenControlFlags(int flags);

    /**
     * Gets the currently set fullscreen control flags.
     *
     * @return The currently set flags. The int is a bitwise-or of
     * {@link #FULLSCREEN_FLAG_CONTROL_ORIENTATION}, {@link #FULLSCREEN_FLAG_CONTROL_SYSTEM_UI},
     * {@link #FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE} and {@link #FULLSCREEN_FLAG_CUSTOM_LAYOUT}.
     */
    int getFullscreenControlFlags();

    /**
     * Variant of {@link #setFullscreenControlFlags(int)} that doesn't change the already set
     * flags, but just adds the provided flag to the currently set flags.
     * <p>
     * Variant of {@link #setFullscreenControlFlags(int)} that doesn't change the already set flags,
     * but just adds the provided flag to the currently set flags. Equivalent to
     * {@code setFullscreenControlFlags(getFullscreenControlFlags() | controlFlag)}.
     *
     * @param controlFlag The flag to set. One of {@link #FULLSCREEN_FLAG_CONTROL_ORIENTATION},
     *                    {@link #FULLSCREEN_FLAG_CONTROL_SYSTEM_UI},
     *                    {@link #FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE} and
     *                    {@link #FULLSCREEN_FLAG_CUSTOM_LAYOUT}.
     */
    void addFullscreenControlFlag(int controlFlag);

    /**
     * Sets the current style for the player, which impacts the level of control the user has over
     * the player.
     *
     * @param style The chosen {@link PlayerStyle}. The default style is {@link PlayerStyle#DEFAULT}.
     */
    void setPlayerStyle(YouTubePlayer.PlayerStyle style);

    /**
     * Shows or hides the fullscreen button on the player controls.
     * <p>
     * The default is to show a fullscreen button which enables the user to switch between
     * fullscreen and non-fullscreen modes. You can use this method to hide the fullscreen button
     * if required, e.g., if you only show videos in fullscreen.
     * <p>
     * Note: Only the {@link PlayerStyle#DEFAULT} player style supports this button, this method
     * will have no effect on other player styles.
     *
     * @param show {@code true} to show the fullscreen button, {@code false} to hide it.
     */
    void setShowFullscreenButton(boolean show);

    /**
     * Specifies whether or not the player will handle audio focus as part of its playback lifecycle.
     * <p>
     * When {@code true}, the player will request and abandon audio focus appropriately when
     * playback starts and ends, as well as pausing playback when losing audio focus. When ducking,
     * the player lowers its volume.
     * <p>
     * Handling the audio focus also includes pausing the player if necessary when the audio is
     * becoming noisy due to a change in audio outputs
     * (see {@link android.media.AudioManager#ACTION_AUDIO_BECOMING_NOISY}).
     * <p>
     * The default value is {@code true}.
     *
     * @param manageAudioFocus {@code true} to enable automatic handling of audio focus,
     *                         {@code false} to disable.
     */
    void setManageAudioFocus(boolean manageAudioFocus);

    /**
     * Registers a {@link PlaylistEventListener}.
     *
     * @param playlistEventListener The listener to register, or {@code null} to unregister the
     *                              previous listener.
     */
    void setPlaylistEventListener(YouTubePlayer.PlaylistEventListener playlistEventListener);

    /**
     * Registers a {@link PlayerStateChangeListener}.
     *
     * @param playerStateChangeListener The listener to register, or {@code null} to unregister the
     *                                  previous listener.
     */
    void setPlayerStateChangeListener(YouTubePlayer.PlayerStateChangeListener playerStateChangeListener);

    /**
     * Registers a {@link PlaybackEventListener}.
     *
     * @param playbackEventListener The listener to register, or {@code null} to unregister the
     *                              previous listener.
     */
    void setPlaybackEventListener(YouTubePlayer.PlaybackEventListener playbackEventListener);

    /**
     * Describes the reason for an error in a {@link YouTubePlayer}.
     *
     * @see PlayerStateChangeListener#onError(ErrorReason)
     */
    enum ErrorReason {
        /**
         * This field is deprecated. Replaced by {@link ErrorReason#NOT_PLAYABLE}.
         */
        EMBEDDING_DISABLED,

        /**
         * This field is deprecated. Replaced by {@link ErrorReason#NOT_PLAYABLE}.
         */
        BLOCKED_FOR_APP,

        /**
         * The current video could not be loaded because it is not in a playable state.
         */
        NOT_PLAYABLE,

        /**
         * An error occurred due to a network request failing.
         */
        NETWORK_ERROR,

        /**
         * Playback has been stopped due to a view overlaying the player.
         */
        UNAUTHORIZED_OVERLAY,

        /**
         * Playback has been stopped due to the player's View being too small.
         */
        PLAYER_VIEW_TOO_SMALL,

        /**
         * Playback has been stopped due to the player's View not being visible.
         */
        PLAYER_VIEW_NOT_VISIBLE,

        /**
         * Could not start playback because the loaded playlist did not contain any videos.
         */
        EMPTY_PLAYLIST,

        /**
         * The player has not automatically moved to the next video in the playlist because
         * of autoplay restrictions.
         */
        AUTOPLAY_DISABLED,

        /**
         * Playback was canceled because playback of restricted content was declined.
         */
        USER_DECLINED_RESTRICTED_CONTENT,

        /**
         * Playback was canceled because the user declined to allow playback of a
         * high-bandwidth stream.
         */
        USER_DECLINED_HIGH_BANDWIDTH,

        /**
         * Playback has been canceled and the player has been released due to an unexpected
         * disconnection from the YouTube API service.
         */
        UNEXPECTED_SERVICE_DISCONNECTION,

        /**
         * The current video could not be loaded due to an internal error.
         */
        INTERNAL_ERROR,

        /**
         * The reason for the error is not known.
         */
        UNKNOWN;
    }

    /**
     * The different styles available for the player.
     */
    enum PlayerStyle {
        /**
         * The default style, showing all interactive controls.
         */
        DEFAULT,

        /**
         * A minimal style, showing only a time bar and play/pause controls.
         */
        MINIMAL,

        /**
         * A style that shows no interactive player controls.
         */
        CHROMELESS
    }

    /**
     * Interface definition for callbacks that are invoked when the player toggles between
     * fullscreen on or off, either due to the user clicking the fullscreen button or a call
     * to {@link #setFullscreen(boolean)}.
     *
     * @see #setOnFullscreenListener(OnFullscreenListener)
     * @see #setFullscreen(boolean)
     * @see #FULLSCREEN_FLAG_CUSTOM_LAYOUT
     */
    interface OnFullscreenListener {

        /**
         * Called when fullscreen mode changes.
         *
         * @param isFullScreen {@code true} if the player should enter fullscreen, {@code false} otherwise.
         */
        void onFullscreen(boolean isFullScreen);
    }

    /**
     * Interface definition for callbacks that are invoked when video playback events occur.
     */
    interface PlaybackEventListener {

        /**
         * Called when playback starts, either due to {@link #play()} or user action.
         */
        void onPlaying();

        /**
         * Called when playback is paused, either due to {@link #pause()} or user
         * action.
         */
        void onPaused();

        /**
         * Called when playback stops for a reason other than being paused, such as the video
         * ending or a playback error.
         */
        void onStopped();

        /**
         * Called when buffering starts or ends.
         * <p>
         * Note, this may occur either before or after
         * {@link PlaybackEventListener#onPlaying()} when a video starts loading.
         *
         * @param isBuffering {@code true} if the player is buffering, {@code false} otherwise.
         */
        void onBuffering(boolean isBuffering);

        /**
         * Called when a jump in playback position occurs
         * <p>
         * Called when a jump in playback position occurs, either due to the user scrubbing or a
         * seek method being called (e.g. {@link #seekToMillis(int)}).
         *
         * @param newPositionMillis The time in milliseconds to which the player has seeked.
         */
        void onSeekTo(int newPositionMillis);
    }

    /**
     * Interface definition for callbacks that are invoked when the high-level player state changes.
     */
    interface PlayerStateChangeListener {

        /**
         * Called when the player begins loading a video and is not ready to accept commands
         * affecting playback (such as {@link #play()} or {@link #pause()}).
         */
        void onLoading();

        /**
         * Called when a video has finished loading.
         * <p>
         * Playback methods such as {@link #play()}, {@link #pause()} or
         * {@link #seekToMillis(int)} may be called after this callback.
         * <p>
         * If the video was loaded through one of the load functions such as
         * {@link #loadVideo(String)} this callback will typically be followed by a
         * call to either {@link PlayerStateChangeListener#onAdStarted()} or
         * {@link PlayerStateChangeListener#onVideoStarted()} ()}.
         *
         * @param videoId The YouTube video id of the loaded video.
         */
        void onLoaded(String videoId);

        /**
         * Called when playback of an advertisement starts.
         */
        void onAdStarted();

        /**
         * Called when playback of the video starts.
         */
        void onVideoStarted();

        /**
         * Called when the video reaches its end.
         */
        void onVideoEnded();

        /**
         * Called when an error occurs.
         * <p>
         * This can be called from any state.
         *
         * @param reason The reason for the error.
         */
        void onError(ErrorReason reason);
    }

    /**
     * Interface definition for callbacks that are invoked when events related to playlists occur.
     */
    interface PlaylistEventListener {
        /**
         * Called before the player starts loading the previous video in the playlist.
         */
        void onPrevious();

        /**
         * Called before the player starts loading the next video in the playlist.
         */
        void onNext();

        /**
         * Called when the last video in the playlist has ended.
         */
        void onPlaylistEnded();
    }

    /**
     * Interface definition for callbacks that are invoked when player initialization succeeds or
     * fails.
     */
    interface OnInitializedListener {
        /**
         * Called when initialization of the player succeeds.
         *
         * @param provider    The provider which was used to initialize the {@link YouTubePlayer}.
         * @param player      A {@link YouTubePlayer} which can be used to control video playback
         *                    in the provider.
         * @param wasRestored Whether the player was restored from a previously saved state, as
         *                    part of the {@link YouTubePlayerView} or {@link YouTubePlayerFragment}
         *                    restoring its state. {@code true} usually means playback is resuming
         *                    from where the user expects it would, and that a new video should not
         *                    be loaded.
         */
        void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored);

        /**
         * Called when initialization of the player fails.
         *
         * @param provider The provider which failed to initialize a {@link YouTubePlayer}.
         * @param error    The reason for this failure, along with potential resolutions to this failure.
         */
        void onInitializationFailure(Provider provider, YouTubeInitializationResult error);
    }

    /**
     * A class that implements this interface can provide a {@link YouTubePlayer} instance.
     */
    interface Provider {

        /**
         * Initialize a {@link YouTubePlayer}, which can be used to play videos and control video
         * playback.
         *
         * @param developerKey A valid API key that is enabled to use the YouTube Data API v3
         *                     service. To generate a new key, visit the
         *                     <a href="https://console.developers.google.com/">Google Developers Console</a>.
         * @param listener     The callbacks that will be invoked when the initialization succeeds
         *                     or fails.
         */
        void initialize(String developerKey, YouTubePlayer.OnInitializedListener listener);
    }
}
