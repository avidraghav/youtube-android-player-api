package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.youtube.player.YouTubePlayer;

import java.util.List;

public final class YouTubePlayerImpl implements YouTubePlayer {
    private ConnectionClient connectionClient;
    private IEmbeddedPlayer embeddedPlayer;

    public YouTubePlayerImpl(ConnectionClient connectionClient, IEmbeddedPlayer embeddedPlayer) {
        this.connectionClient = Validators.notNull(connectionClient, "connectionClient cannot be null");
        this.embeddedPlayer = Validators.notNull(embeddedPlayer, "embeddedPlayer cannot be null");
    }

    public final void a(boolean var1) {
        try {
            this.embeddedPlayer.a(var1);
            this.connectionClient.a(var1);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }

        this.connectionClient.d();
    }

    @Override
    public final void cueVideo(String videoId) {
        this.cueVideo(videoId, 0);
    }

    @Override
    public final void loadVideo(String videoId) {
        this.loadVideo(videoId, 0);
    }

    @Override
    public final void cuePlaylist(String playlistId) {
        this.cuePlaylist(playlistId, 0, 0);
    }

    @Override
    public final void loadPlaylist(String playlistId) {
        this.loadPlaylist(playlistId, 0, 0);
    }

    @Override
    public final void cueVideos(List<String> videoIds) {
        this.cueVideos(videoIds, 0, 0);
    }

    @Override
    public final void loadVideos(List<String> videoIds) {
        this.loadVideos(videoIds, 0, 0);
    }

    public final View a() {
        try {
            return (View) ObjectWrapper.a(this.embeddedPlayer.s());
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void b() {
        try {
            this.embeddedPlayer.m();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void c() {
        try {
            this.embeddedPlayer.n();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void d() {
        try {
            this.embeddedPlayer.o();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void e() {
        try {
            this.embeddedPlayer.p();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void b(boolean var1) {
        try {
            this.embeddedPlayer.e(var1);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void a(Configuration conf) {
        try {
            this.embeddedPlayer.onConfigurationChanged(conf);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void f() {
        try {
            this.embeddedPlayer.q();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void g() {
        try {
            this.embeddedPlayer.l();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean a(int var1, KeyEvent event) {
        try {
            return this.embeddedPlayer.dispatchKeyEventDown(var1, event);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean b(int var1, KeyEvent event) {
        try {
            return this.embeddedPlayer.dispatchKeyEventUp(var1, event);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final Bundle h() {
        try {
            return this.embeddedPlayer.getBundle();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean a(Bundle var1) {
        try {
            return this.embeddedPlayer.a(var1);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void release() {
        this.a(true);
    }

    @Override
    public final void cueVideo(String videoId, int timeMillis) {
        try {
            this.embeddedPlayer.cueVideo(videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new YouTubePlayerException(var3);
        }
    }

    @Override
    public final void loadVideo(String videoId, int timeMillis) {
        try {
            this.embeddedPlayer.loadVideo(videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new YouTubePlayerException(var3);
        }
    }

    @Override
    public final void cuePlaylist(String playlistId, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.cuePlaylist(playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    @Override
    public final void loadPlaylist(String playlistId, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.loadPlaylist(playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    public final void cueVideos(List<String> videoIds, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.cueVideos(videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    public final void loadVideos(List<String> videoIds, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.loadVideos(videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    public final void play() {
        try {
            this.embeddedPlayer.play();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final void pause() {
        try {
            this.embeddedPlayer.pause();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final boolean isPlaying() {
        try {
            return this.embeddedPlayer.isPlaying();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean hasNext() {
        try {
            return this.embeddedPlayer.hasNext();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean hasPrevious() {
        try {
            return this.embeddedPlayer.hasPrevious();
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void next() {
        try {
            this.embeddedPlayer.next();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void previous() {
        try {
            this.embeddedPlayer.previous();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final int getCurrentTimeMillis() {
        try {
            return this.embeddedPlayer.getCurrentTimeMillis();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final int getDurationMillis() {
        try {
            return this.embeddedPlayer.getDurationMillis();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void seekToMillis(int milliSeconds) {
        try {
            this.embeddedPlayer.seekToMillis(milliSeconds);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void seekRelativeMillis(int milliSeconds) {
        try {
            this.embeddedPlayer.seekRelativeMillis(milliSeconds);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setFullscreen(boolean fullscreen) {
        try {
            this.embeddedPlayer.setFullscreen(fullscreen);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setFullscreenControlFlags(int flags) {
        try {
            this.embeddedPlayer.setFullscreenControlFlags(flags);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final int getFullscreenControlFlags() {
        try {
            return this.embeddedPlayer.getFullscreenControlFlags();
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void addFullscreenControlFlag(int controlFlag) {
        try {
            this.embeddedPlayer.addFullscreenControlFlag(controlFlag);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setPlayerStyle(PlayerStyle style) {
        try {
            this.embeddedPlayer.setPlayerStyle(style.name());
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setShowFullscreenButton(boolean show) {
        try {
            this.embeddedPlayer.setShowFullscreenButton(show);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setManageAudioFocus(boolean manageAudioFocus) {
        try {
            this.embeddedPlayer.setManageAudioFocus(manageAudioFocus);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setOnFullscreenListener(final OnFullscreenListener onFullscreenListener) {
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

    public final void setPlaylistEventListener(final PlaylistEventListener playlistEventListener) {
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

    public final void setPlayerStateChangeListener(final PlayerStateChangeListener playerStateChangeListener) {
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
                    ErrorReason var4;
                    try {
                        var4 = ErrorReason.valueOf(reason);
                    } catch (IllegalArgumentException var2) {
                        var4 = ErrorReason.UNKNOWN;
                    } catch (NullPointerException var3) {
                        var4 = ErrorReason.UNKNOWN;
                    }

                    playerStateChangeListener.onError(var4);
                }

                public final void onAdStarted() {
                    playerStateChangeListener.onAdStarted();
                }
            });
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setPlaybackEventListener(final PlaybackEventListener playbackEventListener) {
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
