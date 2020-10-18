package com.google.android.youtube.player.internal;

import com.google.android.youtube.player.internal.IOnFullscreenListener;
import com.google.android.youtube.player.internal.IPlaylistEventListener;
import com.google.android.youtube.player.internal.IPlayerStateChangeListener;
import com.google.android.youtube.player.internal.IPlaybackEventListener;
import com.google.android.youtube.player.internal.IObjectWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;

interface IEmbeddedPlayer {

    void release(boolean isFinishing);
    void cueVideo(String videoId, int timeMillis);
    void loadVideo(String videoId, int timeMillis);
    void cuePlaylist(String playlistId, int startIndex, int timeMillis);
    void loadPlaylist(String playlistId, int startIndex, int timeMillis);
    void cueVideos(inout List<String> videoIds, int startIndex, int timeMillis);
    void loadVideos(inout List<String> videoIds, int startIndex, int timeMillis);
    void play();
    void pause();
    boolean isPlaying();
    boolean hasNext();
    boolean hasPrevious();
    void next();
    void previous();
    int getCurrentTimeMillis();
    int getDurationMillis();
    void seekToMillis(int milliSeconds);
    void seekRelativeMillis(int milliSeconds);
    void setFullscreen(boolean fullscreen);
    void setFullscreenControlFlags(int flags);
    int getFullscreenControlFlags();
    void addFullscreenControlFlag(int controlFlag);
    void setPlayerStyle(String style);
    void setShowFullscreenButton(boolean show);
    void setManageAudioFocus(boolean manageAudioFocus);
    void setOnFullscreenListener(IOnFullscreenListener onFullscreenListener);
    void setPlaylistEventListener(IPlaylistEventListener playlistEventListener);
    void setPlayerStateChangeListener(IPlayerStateChangeListener playerStateChangeListener);
    void setPlaybackEventListener(IPlaybackEventListener playbackEventListener);

    void jj(); // TODO Find out
    void kk(); // TODO Find out
    void onConfigurationChanged(inout Configuration config);
    void ll(); // TODO onStart -> maybe calls PlaybackEventListener.onPlaying or .onBuffering
    void bind();
    void nn() ; // TODO onPause -> maybe calls PlaybackEventListener.onPaused after completion
    void oo(); // TODO onStop -> maybe calls PlaybackEventListener.onStopped after completion
    void stopSelf(boolean isFinishing);
    void stop();
    Bundle getBundle();
    boolean setBundle(inout Bundle bundle);
    boolean dispatchKeyEventDown(int keyCode, in KeyEvent keyEvent);
    boolean dispatchKeyEventUp(int keyCode, in KeyEvent keyEvent);
    IObjectWrapper qq(); // TODO Find out
}
