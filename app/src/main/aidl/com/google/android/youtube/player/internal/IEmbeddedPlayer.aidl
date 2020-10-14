package com.google.android.youtube.player.internal;

import com.google.android.youtube.player.internal.IOnFullscreenListener;
import com.google.android.youtube.player.internal.IPlaylistEventListener;
import com.google.android.youtube.player.internal.IPlayerStateChangeListener;
import com.google.android.youtube.player.internal.IPlaybackEventListener;
import com.google.android.youtube.player.internal.dynamic.IObjectWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;

interface IEmbeddedPlayer {

    void ii(boolean var1) = 1; // TODO Find out
    void cueVideo(String videoId, int timeMillis) = 2;
    void loadVideo(String videoId, int timeMillis) = 3;
    void cuePlaylist(String playlistId, int startIndex, int timeMillis) = 4;
    void loadPlaylist(String playlistId, int startIndex, int timeMillis) = 5;
    void cueVideos(in List<String> videoIds, int startIndex, int timeMillis) = 6;
    void loadVideos(in List<String> videoIds, int startIndex, int timeMillis) = 7;
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
    void onConfigurationChanged(in Configuration config) = 32;
    void ll() = 33; // TODO Find out
    void mm() = 34; // TODO Find out
    void nn() = 35; // TODO Find out
    void oo() = 36; // TODO Find out
    // TODO See if destroy is correct
    void destroy(boolean var1) = 37;
    void pp() = 38; // TODO Find out
    Bundle getBundle() = 39; // TODO Find out
    boolean setBundle(in Bundle bundle) = 40;
    boolean dispatchKeyEventDown(int keyCode, in KeyEvent keyEvent) = 41;
    boolean dispatchKeyEventUp(int var1, in KeyEvent keyEvent) = 42;
    IObjectWrapper qq() = 43; // TODO Find out
}
