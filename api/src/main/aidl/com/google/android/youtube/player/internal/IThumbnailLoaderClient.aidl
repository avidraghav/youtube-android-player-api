package com.google.android.youtube.player.internal;

interface IThumbnailLoaderClient {
    void loadThumbnail(in Bitmap thumbnail, String videoId, boolean hasPrevious, boolean hasNext);
    void onError(String reason, boolean hasPrevious, boolean hasNext);
}
