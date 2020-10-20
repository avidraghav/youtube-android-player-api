package com.google.android.youtube.player;

/**
 * A {@link YouTubeThumbnailLoader} provides methods for loading YouTube thumbnails into a
 * {@link YouTubeThumbnailView}. Get an instance of this class by calling
 * {@link YouTubeThumbnailView#initialize(String, YouTubeThumbnailView.OnInitializedListener)}} on
 * a {@link YouTubeThumbnailView}.
 * <p>
 * Video and playlist IDs required by {@link #setVideo(String)} and {@link #setPlaylist(String)}
 * methods are provided by the YouTube Data API. To learn more about this API, visit
 * https://developers.google.com/youtube/v3/.
 * <p>
 * Note that you <b>must</b> call {@link #release()} when you are finished with the
 * {@link YouTubeThumbnailLoader}.
 */
public interface YouTubeThumbnailLoader {

    /**
     * Set a {@link OnThumbnailLoadedListener} which is invoked whenever a new thumbnail has
     * finished loading and has been displayed in this YouTube thumbnail view.
     *
     * @param listener The listener to register.
     */
    void setOnThumbnailLoadedListener(OnThumbnailLoadedListener listener);

    /**
     * Set this view to show the thumbnail image for the given YouTube video ID.
     *
     * @param videoId The ID of the video for which the thumbnail image is being shown, as returned
     *                from the <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     */
    void setVideo(String videoId);

    /**
     * Set this view to show thumbnail images for the given YouTube playlist ID, initially showing
     * the thumbnail for the first video in the playlist.
     *
     * @param playlistId The ID for the playlist to show thumbnail images from, as returned from
     *                   the <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     */
    void setPlaylist(String playlistId);

    /**
     * Set this view to show thumbnail images for the given YouTube playlist ID, initially showing
     * the thumbnail for the video at the index specified in the {@param skipTo} parameter.
     *
     * @param playlistId The ID for the playlist to show thumbnail images from, as returned from
     *                   the <a href="https://developers.google.com/youtube/v3/docs/playlists#resource">YouTube Data API</a>.
     * @param skipTo     The video in the playlist to skip to.
     */
    void setPlaylist(String playlistId, int skipTo);

    /**
     * Show the thumbnail of the next video in the playlist.
     * <p>
     * Note that a second call to {@link #next()} or {@link #previous()}, before the first call has
     * finished (as indicated by {@link OnThumbnailLoadedListener#onThumbnailLoaded(YouTubeThumbnailView, String)}),
     * might be ignored.
     *
     * @throws java.util.NoSuchElementException This exception is thrown if the method is called at
     *                                          the end of the playlist.
     */
    void next();

    /**
     * Show the thumbnail of the previous video in the playlist.
     * <p>
     * Note that a second call to {@link #next()} or {@link #previous()}, before the first call has
     * finished (as indicated by {@link OnThumbnailLoadedListener#onThumbnailLoaded(YouTubeThumbnailView, String)}),
     *
     * @throws java.util.NoSuchElementException This exception is thrown if the method is called at
     *                                          the end of the playlist.
     */
    void previous();

    /**
     * Show the thumbnail of the first video in the playlist.
     */
    void first();

    /**
     * Determines whether the currently loaded playlist has a next video.
     *
     * @return {@code true} if there is a next video in the playlist; otherwise returns
     * {@code false}.
     */
    boolean hasNext();

    /**
     * Determines whether the currently loaded playlist has a previous video.
     *
     * @return {@code true} if there is a previous video in the playlist; otherwise returns
     * {@code false}.
     */
    boolean hasPrevious();

    /**
     * Releases system resources used by this {@link YouTubeThumbnailLoader}.
     * <p>
     * Note that after calling this method any further interaction with this
     * {@link YouTubeThumbnailLoader} is forbidden. A new instance must be created to load
     * thumbnails into a {@link YouTubeThumbnailView}.
     */
    void release();

    /**
     * Describes the reasons for an error in a {@link YouTubeThumbnailView}.
     *
     * @see OnThumbnailLoadedListener#onThumbnailError(YouTubeThumbnailView, ErrorReason)
     */
    enum ErrorReason {
        /**
         * The thumbnail could not be loaded due a network request failing.
         * <p>
         * Check that the device is connected to the Internet.
         */
        NETWORK_ERROR,

        /**
         * An internal error prevented the thumbnail from being loaded.
         * <p>
         * Retrying may resolve the problem.
         */
        INTERNAL_ERROR,

        /**
         * The reason for the error is not known.
         * <p>
         * This may be because the client library is older than the YouTube API service and does
         * not know of the actual {@link ErrorReason} that the service is returning. Retrying may
         * resolve the problem.
         */
        UNKNOWN
    }

    /**
     * Interface definition for a listener that is invoked when a thumbnail has been loaded.
     */
    interface OnThumbnailLoadedListener {
        /**
         * Called when a YouTube thumbnail has been loaded into the view.
         * <p>
         * This will be called after the YouTubeThumbnailView has been updated to show the
         * thumbnail which was loaded.
         * <p>
         * Note that changing the current video or playlist by calling
         * {@link YouTubeThumbnailLoader#setVideo(String)} or {@link YouTubeThumbnailLoader#setPlaylist(String)})
         * will cancel the currently loading thumbnail and you will only get an
         * {@link #onThumbnailLoaded(YouTubeThumbnailView, String)} callback for the most recently
         * loaded thumbnail.
         * <p>
         * This will always be called on the UI thread.
         *
         * @param thumbnail The YouTube thumbnail view into which the thumbnail has been loaded.
         * @param videoId   The YouTube video ID of the loaded thumbnail.
         */
        void onThumbnailLoaded(YouTubeThumbnailView thumbnail, String videoId);

        /**
         * Called when there was an error loading a thumbnail.
         * <p>
         * The {@link YouTubeThumbnailView} will not be be modified when an error is encountered,
         * it will retain the same thumbnail previously loaded into the view (or none if no
         * thumbnail has been loaded).
         * <p>
         * This will always be called on the UI thread.
         *
         * @param thumbnail The YouTube thumbnail view which encountered the error.
         * @param reason    The reason for the error.
         */
        void onThumbnailError(YouTubeThumbnailView thumbnail, YouTubeThumbnailLoader.ErrorReason reason);
    }
}
