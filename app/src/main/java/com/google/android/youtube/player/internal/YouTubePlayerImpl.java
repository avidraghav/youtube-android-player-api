package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.youtube.player.YouTubePlayer;

import java.util.List;

public final class YouTubePlayerImpl implements YouTubePlayer {

    private static final String TAG = "YouTubePlayerImpl";

    private ConnectionClient connectionClient;
    private IEmbeddedPlayer embeddedPlayer;

    public YouTubePlayerImpl(ConnectionClient connectionClient, IEmbeddedPlayer embeddedPlayer) {
        Log.d(TAG, "YouTubePlayerImpl: Constructor called.");
        this.connectionClient = Validators.notNull(connectionClient, "connectionClient cannot be null");
        this.embeddedPlayer = Validators.notNull(embeddedPlayer, "embeddedPlayer cannot be null");
    }

    // TODO release / disconnect / setDisconnected / setReleased
    public final void release(boolean isFinishing) {
        Log.d(TAG, "release: called with isFinishing=" + isFinishing);
        try {
            this.embeddedPlayer.release(isFinishing);
            this.connectionClient.release(isFinishing);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }

        this.connectionClient.disconnect();
    }

    @Override
    public final void cueVideo(String videoId) {
        Log.d(TAG, "cueVideo: called with videoId=" + videoId);
        this.cueVideo(videoId, 0);
    }

    @Override
    public final void loadVideo(String videoId) {
        Log.d(TAG, "loadVideo: called with videoId=" + videoId);
        this.loadVideo(videoId, 0);
    }

    @Override
    public final void cuePlaylist(String playlistId) {
        Log.d(TAG, "cuePlaylist: called with playlistId=" + playlistId);
        this.cuePlaylist(playlistId, 0, 0);
    }

    @Override
    public final void loadPlaylist(String playlistId) {
        Log.d(TAG, "loadPlaylist: called with playlistId=" + playlistId);
        this.loadPlaylist(playlistId, 0, 0);
    }

    @Override
    public final void cueVideos(List<String> videoIds) {
        Log.d(TAG, "cueVideos: called with videoIds=" + videoIds);
        this.cueVideos(videoIds, 0, 0);
    }

    @Override
    public final void loadVideos(List<String> videoIds) {
        Log.d(TAG, "loadVideos: called with videoIds=" + videoIds);
        this.loadVideos(videoIds, 0, 0);
    }

    public final View a() {
        Log.d(TAG, "a: called.");
        try {
            return (View) ObjectWrapper.a(this.embeddedPlayer.qq());
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    // TODO start
    public final void b() {
        Log.d(TAG, "b: called.");
        try {
            this.embeddedPlayer.ll();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    // TODO resume
    public final void bind() {
        Log.d(TAG, "bind: called.");
        try {
            this.embeddedPlayer.bind();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    // TODO pause
    public final void d() {
        Log.d(TAG, "d: called.");
        try {
            this.embeddedPlayer.nn();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    // TODO stop / disconnect
    public final void e() {
        Log.d(TAG, "e: called.");
        try {
            this.embeddedPlayer.oo();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    // TODO See if destroy is the right name
    public final void stop(boolean isFinishing) {
        Log.d(TAG, "stop: called with isFinishing=" + isFinishing);
        try {
            this.embeddedPlayer.stopSelf(isFinishing);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void onConfigurationChanged(Configuration conf) {
        Log.d(TAG, "onConfigurationChanged: called.");
        try {
            this.embeddedPlayer.onConfigurationChanged(conf);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    // TODO Called from Connection.release()
    public final void stop() {
        Log.d(TAG, "stop: called.");
        try {
            this.embeddedPlayer.stop();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    // TODO Called when focus changed
    public final void g() {
        Log.d(TAG, "g: called.");
        try {
            this.embeddedPlayer.kk();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean dispatchKeyEventDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "dispatchKeyEventDown: called with keyCode=" + keyCode);
        try {
            return this.embeddedPlayer.dispatchKeyEventDown(keyCode, event);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean dispatchKeyEventUp(int keyCode, KeyEvent event) {
        Log.d(TAG, "dispatchKeyEventUp: called with keyCode=" + keyCode);
        try {
            return this.embeddedPlayer.dispatchKeyEventUp(keyCode, event);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final Bundle getBundle() {
        Log.d(TAG, "getBundle: called.");
        try {
            return this.embeddedPlayer.getBundle();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean setBundle(Bundle bundle) {
        Log.d(TAG, "setBundle: called.");
        try {
            return this.embeddedPlayer.setBundle(bundle);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final void release() {
        Log.d(TAG, "release: called.");
        this.release(true);
    }

    @Override
    public final void cueVideo(String videoId, int timeMillis) {
        Log.d(TAG, "cueVideo: called with videoId=" + videoId);
        try {
            this.embeddedPlayer.cueVideo(videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new YouTubePlayerException(var3);
        }
    }

    @Override
    public final void loadVideo(String videoId, int timeMillis) {
        Log.d(TAG, "loadVideo: called with videoId=" + videoId);
        try {
            this.embeddedPlayer.loadVideo(videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new YouTubePlayerException(var3);
        }
    }

    @Override
    public final void cuePlaylist(String playlistId, int startIndex, int timeMillis) {
        Log.d(TAG, "cuePlaylist: called with playlistId=" + playlistId);
        try {
            this.embeddedPlayer.cuePlaylist(playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    @Override
    public final void loadPlaylist(String playlistId, int startIndex, int timeMillis) {
        Log.d(TAG, "loadPlaylist: called with playlistId=" + playlistId);
        try {
            this.embeddedPlayer.loadPlaylist(playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    @Override
    public final void cueVideos(List<String> videoIds, int startIndex, int timeMillis) {
        Log.d(TAG, "cueVideos: called with videoIds=" + videoIds);
        try {
            this.embeddedPlayer.cueVideos(videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    @Override
    public final void loadVideos(List<String> videoIds, int startIndex, int timeMillis) {
        Log.d(TAG, "loadVideos: called with videoIds=" + videoIds);
        try {
            this.embeddedPlayer.loadVideos(videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    @Override
    public final void play() {
        Log.d(TAG, "play: called.");
        try {
            this.embeddedPlayer.play();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final void pause() {
        Log.d(TAG, "pause: called.");
        try {
            this.embeddedPlayer.pause();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final boolean isPlaying() {
        Log.d(TAG, "isPlaying: called.");
        try {
            return this.embeddedPlayer.isPlaying();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final boolean hasNext() {
        Log.d(TAG, "hasNext: called.");
        try {
            return this.embeddedPlayer.hasNext();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final boolean hasPrevious() {
        Log.d(TAG, "hasPrevious: called.");
        try {
            return this.embeddedPlayer.hasPrevious();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final void next() {
        Log.d(TAG, "next: called.");
        try {
            this.embeddedPlayer.next();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void previous() {
        Log.d(TAG, "previous: called.");
        try {
            this.embeddedPlayer.previous();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final int getCurrentTimeMillis() {
        Log.d(TAG, "getCurrentTimeMillis: called.");
        try {
            return this.embeddedPlayer.getCurrentTimeMillis();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final int getDurationMillis() {
        Log.d(TAG, "getDurationMillis: called.");
        try {
            return this.embeddedPlayer.getDurationMillis();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void seekToMillis(int milliSeconds) {
        Log.d(TAG, "seekToMillis: called.");
        try {
            this.embeddedPlayer.seekToMillis(milliSeconds);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void seekRelativeMillis(int milliSeconds) {
        Log.d(TAG, "seekRelativeMillis: called.");
        try {
            this.embeddedPlayer.seekRelativeMillis(milliSeconds);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setFullscreen(boolean fullscreen) {
        Log.d(TAG, "setFullscreen: called.");
        try {
            this.embeddedPlayer.setFullscreen(fullscreen);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final int getFullscreenControlFlags() {
        Log.d(TAG, "getFullscreenControlFlags: called.");
        try {
            return this.embeddedPlayer.getFullscreenControlFlags();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setFullscreenControlFlags(int flags) {
        Log.d(TAG, "setFullscreenControlFlags: called.");
        try {
            this.embeddedPlayer.setFullscreenControlFlags(flags);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void addFullscreenControlFlag(int controlFlag) {
        Log.d(TAG, "addFullscreenControlFlag: called.");
        try {
            this.embeddedPlayer.addFullscreenControlFlag(controlFlag);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setPlayerStyle(PlayerStyle style) {
        Log.d(TAG, "setPlayerStyle: called.");
        try {
            this.embeddedPlayer.setPlayerStyle(style.name());
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setShowFullscreenButton(boolean show) {
        Log.d(TAG, "setShowFullscreenButton: called.");
        try {
            this.embeddedPlayer.setShowFullscreenButton(show);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setManageAudioFocus(boolean manageAudioFocus) {
        Log.d(TAG, "setManageAudioFocus: called.");
        try {
            this.embeddedPlayer.setManageAudioFocus(manageAudioFocus);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setOnFullscreenListener(final OnFullscreenListener onFullscreenListener) {
        Log.d(TAG, "setOnFullscreenListener: called.");
        try {
            this.embeddedPlayer.setOnFullscreenListener(new IOnFullscreenListener.Stub() {
                public final void onFullscreen(boolean fullscreen) {
                    onFullscreenListener.onFullscreen(fullscreen);
                }
            });
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setPlaylistEventListener(final PlaylistEventListener playlistEventListener) {
        Log.d(TAG, "setPlaylistEventListener: called.");
        try {
            this.embeddedPlayer.setPlaylistEventListener(new IPlaylistEventListener.Stub() {
                public final void onPrevious() {
                    playlistEventListener.onPrevious();
                }

                public final void onPlaylistEnded() {
                    playlistEventListener.onPlaylistEnded();
                }

                public final void onNext() {
                    playlistEventListener.onNext();
                }
            });
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setPlayerStateChangeListener(final PlayerStateChangeListener playerStateChangeListener) {
        Log.d(TAG, "setPlayerStateChangeListener: called.");
        try {
            this.embeddedPlayer.setPlayerStateChangeListener(new IPlayerStateChangeListener.Stub() {
                public final void onVideoStarted() {
                    playerStateChangeListener.onVideoStarted();
                }

                public final void onVideoEnded() {
                    playerStateChangeListener.onVideoEnded();
                }

                public final void onLoading() {
                    playerStateChangeListener.onLoading();
                }

                public final void onLoaded(String videoId) {
                    playerStateChangeListener.onLoaded(videoId);
                }

                public final void onError(String reason) {
                    ErrorReason error;
                    try {
                        error = ErrorReason.valueOf(reason);
                    } catch (IllegalArgumentException var2) {
                        error = ErrorReason.UNKNOWN;
                    } catch (NullPointerException var3) {
                        error = ErrorReason.UNKNOWN;
                    }

                    playerStateChangeListener.onError(error);
                }

                public final void onAdStarted() {
                    playerStateChangeListener.onAdStarted();
                }
            });
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final void setPlaybackEventListener(final PlaybackEventListener playbackEventListener) {
        Log.d(TAG, "setPlaybackEventListener: called.");
        try {
            this.embeddedPlayer.setPlaybackEventListener(new IPlaybackEventListener.Stub() {
                public final void onStopped() {
                    playbackEventListener.onStopped();
                }

                public final void onSeekTo(int newPositionMillis) {
                    playbackEventListener.onSeekTo(newPositionMillis);
                }

                public final void onPlaying() {
                    playbackEventListener.onPlaying();
                }

                public final void onPaused() {
                    playbackEventListener.onPaused();
                }

                public final void onBuffering(boolean isBuffering) {
                    playbackEventListener.onBuffering(isBuffering);
                }
            });
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }
}
