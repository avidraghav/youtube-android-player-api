package com.google.android.youtube.player.internal;

interface IThumbnailLoaderService {
       void setVideo(String videoId);
       void setPlaylist(String playlistId, int skipTo);
       void next();
       void previous();
       void first();
       void release();
}
