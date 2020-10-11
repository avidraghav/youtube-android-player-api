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
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_1, var1);
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
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_33);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void c() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_34);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void d() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_35);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void e() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_36);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void b(boolean var1) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_37, var1);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void a(Configuration conf) {
        try {
            this.embeddedPlayer.a(conf);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void f() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_38);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void g() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_31);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean a(int var1, KeyEvent event) {
        try {
            return this.embeddedPlayer.a(var1, event);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean b(int var1, KeyEvent event) {
        try {
            return this.embeddedPlayer.b(var1, event);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final Bundle h() {
        try {
            return this.embeddedPlayer.r();
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
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_2, videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new YouTubePlayerException(var3);
        }
    }

    @Override
    public final void loadVideo(String videoId, int timeMillis) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_3, videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new YouTubePlayerException(var3);
        }
    }

    @Override
    public final void cuePlaylist(String playlistId, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_4, playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    @Override
    public final void loadPlaylist(String playlistId, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_5, playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    public final void cueVideos(List<String> videoIds, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_6, videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    public final void loadVideos(List<String> videoIds, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_7, videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new YouTubePlayerException(var4);
        }
    }

    public final void play() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.PLAY);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final void pause() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.PAUSE);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    @Override
    public final boolean isPlaying() {
        try {
            return this.embeddedPlayer.performActionWithResponse(IEmbeddedPlayer.IS_PLAYING);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean hasNext() {
        try {
            return this.embeddedPlayer.performActionWithResponse(IEmbeddedPlayer.HAS_NEXT);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final boolean hasPrevious() {
        try {
            return this.embeddedPlayer.performActionWithResponse(IEmbeddedPlayer.HAS_PREVIOUS);
        } catch (RemoteException e) {
            throw new YouTubePlayerException(e);
        }
    }

    public final void next() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.NEXT);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void previous() {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.PREVIOUS);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final int getCurrentTimeMillis() {
        try {
            return this.embeddedPlayer.performActionWithNumberResponse(IEmbeddedPlayer.Action.CODE_15);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final int getDurationMillis() {
        try {
            return this.embeddedPlayer.performActionWithNumberResponse(IEmbeddedPlayer.Action.CODE_16);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void seekToMillis(int milliSeconds) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_17, milliSeconds);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void seekRelativeMillis(int milliSeconds) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_18, milliSeconds);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setFullscreen(boolean fullscreen) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_19, fullscreen);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void setFullscreenControlFlags(int flags) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_20, flags);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final int getFullscreenControlFlags() {
        try {
            return this.embeddedPlayer.performActionWithNumberResponse(IEmbeddedPlayer.Action.CODE_21);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    @Override
    public final void addFullscreenControlFlag(int controlFlag) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_22, controlFlag);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setPlayerStyle(PlayerStyle style) {
        try {
            this.embeddedPlayer.a(style.name());
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setShowFullscreenButton(boolean show) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_24, show);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setManageAudioFocus(boolean manageAudioFocus) {
        try {
            this.embeddedPlayer.performAction(IEmbeddedPlayer.Action.CODE_25, manageAudioFocus);
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setOnFullscreenListener(final OnFullscreenListener onFullscreenListener) {
        try {
            this.embeddedPlayer.a(new IOnFullscreenListener.OnFullscreenListener() {
                public final void a(boolean var1x) {
                    onFullscreenListener.onFullscreen(var1x);
                }
            });
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setPlaylistEventListener(final PlaylistEventListener playlistEventListener) {
        try {
            this.embeddedPlayer.setPlaylistEventListener(new IPlaylistEventListener.PlaylistEventListener() {
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
            this.embeddedPlayer.a(new IPlayerStateChangeListener.PlayerStateChangeListener() {
                public final void c() {
                    playerStateChangeListener.onVideoStarted();
                }

                public final void d() {
                    playerStateChangeListener.onVideoEnded();
                }

                public final void a() {
                    playerStateChangeListener.onLoading();
                }

                public final void a(String var1x) {
                    playerStateChangeListener.onLoaded(var1x);
                }

                public final void b(String var1x) {
                    ErrorReason var4;
                    try {
                        var4 = ErrorReason.valueOf(var1x);
                    } catch (IllegalArgumentException var2) {
                        var4 = ErrorReason.UNKNOWN;
                    } catch (NullPointerException var3) {
                        var4 = ErrorReason.UNKNOWN;
                    }

                    playerStateChangeListener.onError(var4);
                }

                public final void b() {
                    playerStateChangeListener.onAdStarted();
                }
            });
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }

    public final void setPlaybackEventListener(final PlaybackEventListener playbackEventListener) {
        try {
            this.embeddedPlayer.a(new IPlaybackEventListener.PlaybackEventListener() {
                public final void c() {
                    playbackEventListener.onStopped();
                }

                public final void a(int var1x) {
                    playbackEventListener.onSeekTo(var1x);
                }

                public final void a() {
                    playbackEventListener.onPlaying();
                }

                public final void b() {
                    playbackEventListener.onPaused();
                }

                public final void a(boolean var1x) {
                    playbackEventListener.onBuffering(var1x);
                }
            });
        } catch (RemoteException var2) {
            throw new YouTubePlayerException(var2);
        }
    }
}
