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

    void release(boolean isFinishing) = 1;
    void cueVideo(String videoId, int timeMillis) = 2;
    void loadVideo(String videoId, int timeMillis) = 3;
    void cuePlaylist(String playlistId, int startIndex, int timeMillis) = 4;
    void loadPlaylist(String playlistId, int startIndex, int timeMillis) = 5;
    void cueVideos(inout List<String> videoIds, int startIndex, int timeMillis) = 6;
    void loadVideos(inout List<String> videoIds, int startIndex, int timeMillis) = 7;
    void play() = 8;
    void pause() = 9;
    boolean isPlaying() = 10;
    boolean hasNext() = 11;
    boolean hasPrevious() = 12;
    void next() = 13;
    void previous() = 14;
    int getCurrentTimeMillis() = 15;
    int getDurationMillis() = 16;
    void seekToMillis(int milliSeconds) = 17;
    void seekRelativeMillis(int milliSeconds) = 18;
    void setFullscreen(boolean fullscreen) = 19;
    void setFullscreenControlFlags(int flags) = 20;
    int getFullscreenControlFlags() = 21;
    void addFullscreenControlFlag(int controlFlag) = 22;
    void setPlayerStyle(String style) = 23;
    void setShowFullscreenButton(boolean show) = 24;
    void setManageAudioFocus(boolean manageAudioFocus) = 25;
    void setOnFullscreenListener(IOnFullscreenListener onFullscreenListener) = 26;
    void setPlaylistEventListener(IPlaylistEventListener playlistEventListener) = 27;
    void setPlayerStateChangeListener(IPlayerStateChangeListener playerStateChangeListener) = 28;
    void setPlaybackEventListener(IPlaybackEventListener playbackEventListener) = 29;

    void jj() = 30; // TODO Find out
    void kk() = 31; // TODO Find out
    void onConfigurationChanged(inout Configuration config) = 32;
    void ll() = 33; // TODO onStart -> maybe calls PlaybackEventListener.onPlaying or .onBuffering
    void bind() = 34;
    void nn() = 35; // TODO onPause -> maybe calls PlaybackEventListener.onPaused after completion
    void oo() = 36; // TODO onStop -> maybe calls PlaybackEventListener.onStopped after completion
    void stopSelf(boolean isFinishing) = 37;
    void stop() = 38;
    Bundle getBundle() = 39;
    boolean setBundle(inout Bundle bundle) = 40;
    boolean dispatchKeyEventDown(int keyCode, in KeyEvent keyEvent) = 41;
    boolean dispatchKeyEventUp(int keyCode, in KeyEvent keyEvent) = 42;
    IObjectWrapper qq() = 43; // TODO Find out
}
