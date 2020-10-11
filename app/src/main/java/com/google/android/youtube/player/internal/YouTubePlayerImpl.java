package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.internal.e.a;

import java.util.List;

public final class YouTubePlayerImpl implements YouTubePlayer {
    private ConnectionClient connectionClient;
    private EmbeddedPlayer embeddedPlayer;

    public YouTubePlayerImpl(ConnectionClient connectionClient, EmbeddedPlayer embeddedPlayer) {
        this.connectionClient = Validators.notNull(connectionClient, "connectionClient cannot be null");
        this.embeddedPlayer = Validators.notNull(embeddedPlayer, "embeddedPlayer cannot be null");
    }

    public final void a(boolean var1) {
        try {
            this.embeddedPlayer.a(var1);
            this.connectionClient.a(var1);
        } catch (RemoteException e) {
            throw new q(e);
        }

        this.connectionClient.d();
    }

    public final void cueVideo(String videoId) {
        this.cueVideo(videoId, 0);
    }

    public final void loadVideo(String videoId) {
        this.loadVideo(videoId, 0);
    }

    public final void cuePlaylist(String playlistId) {
        this.cuePlaylist(playlistId, 0, 0);
    }

    public final void loadPlaylist(String playlistId) {
        this.loadPlaylist(playlistId, 0, 0);
    }

    public final void cueVideos(List<String> videoIds) {
        this.cueVideos(videoIds, 0, 0);
    }

    public final void loadVideos(List<String> videoIds) {
        this.loadVideos(videoIds, 0, 0);
    }

    public final View a() {
        try {
            return (View) v.a(this.embeddedPlayer.s());
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void b() {
        try {
            this.embeddedPlayer.m();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void c() {
        try {
            this.embeddedPlayer.n();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void d() {
        try {
            this.embeddedPlayer.o();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void e() {
        try {
            this.embeddedPlayer.p();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void b(boolean var1) {
        try {
            this.embeddedPlayer.e(var1);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void a(Configuration conf) {
        try {
            this.embeddedPlayer.a(conf);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void f() {
        try {
            this.embeddedPlayer.q();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void g() {
        try {
            this.embeddedPlayer.l();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean a(int var1, KeyEvent event) {
        try {
            return this.embeddedPlayer.a(var1, event);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean b(int var1, KeyEvent event) {
        try {
            return this.embeddedPlayer.b(var1, event);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final Bundle h() {
        try {
            return this.embeddedPlayer.r();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean a(Bundle var1) {
        try {
            return this.embeddedPlayer.a(var1);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void release() {
        this.a(true);
    }

    public final void cueVideo(String videoId, int timeMillis) {
        try {
            this.embeddedPlayer.a(videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new q(var3);
        }
    }

    public final void loadVideo(String videoId, int timeMillis) {
        try {
            this.embeddedPlayer.b(videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new q(var3);
        }
    }

    public final void cuePlaylist(String playlistId, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.a(playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new q(var4);
        }
    }

    public final void loadPlaylist(String playlistId, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.b(playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new q(var4);
        }
    }

    public final void cueVideos(List<String> videoIds, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.a(videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new q(var4);
        }
    }

    public final void loadVideos(List<String> videoIds, int startIndex, int timeMillis) {
        try {
            this.embeddedPlayer.b(videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new q(var4);
        }
    }

    public final void play() {
        try {
            this.embeddedPlayer.a();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void pause() {
        try {
            this.embeddedPlayer.b();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final boolean isPlaying() {
        try {
            return this.embeddedPlayer.c();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final boolean hasNext() {
        try {
            return this.embeddedPlayer.d();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final boolean hasPrevious() {
        try {
            return this.embeddedPlayer.e();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void next() {
        try {
            this.embeddedPlayer.f();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void previous() {
        try {
            this.embeddedPlayer.g();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final int getCurrentTimeMillis() {
        try {
            return this.embeddedPlayer.h();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final int getDurationMillis() {
        try {
            return this.embeddedPlayer.i();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void seekToMillis(int milliSeconds) {
        try {
            this.embeddedPlayer.a(milliSeconds);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void seekRelativeMillis(int milliSeconds) {
        try {
            this.embeddedPlayer.b(milliSeconds);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setFullscreen(boolean fullscreen) {
        try {
            this.embeddedPlayer.b(fullscreen);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setFullscreenControlFlags(int flags) {
        try {
            this.embeddedPlayer.c(flags);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final int getFullscreenControlFlags() {
        try {
            return this.embeddedPlayer.j();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void addFullscreenControlFlag(int controlFlag) {
        try {
            this.embeddedPlayer.d(controlFlag);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setPlayerStyle(PlayerStyle style) {
        try {
            this.embeddedPlayer.a(style.name());
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setShowFullscreenButton(boolean show) {
        try {
            this.embeddedPlayer.c(show);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setManageAudioFocus(boolean manageAudioFocus) {
        try {
            this.embeddedPlayer.d(manageAudioFocus);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setOnFullscreenListener(final OnFullscreenListener onFullscreenListener) {
        try {
            this.embeddedPlayer.a(new a() {
                public final void a(boolean var1x) {
                    onFullscreenListener.onFullscreen(var1x);
                }
            });
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setPlaylistEventListener(final PlaylistEventListener playlistEventListener) {
        try {
            this.embeddedPlayer.a(new BinderInterface.a() {
                public final void a() {
                    playlistEventListener.onPrevious();
                }

                public final void c() {
                    playlistEventListener.onPlaylistEnded();
                }

                public final void b() {
                    playlistEventListener.onNext();
                }
            });
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setPlayerStateChangeListener(final PlayerStateChangeListener playerStateChangeListener) {
        try {
            this.embeddedPlayer.a(new com.google.android.youtube.player.internal.g.a() {
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
            throw new q(var2);
        }
    }

    public final void setPlaybackEventListener(final PlaybackEventListener playbackEventListener) {
        try {
            this.embeddedPlayer.a(new com.google.android.youtube.player.internal.f.a() {
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
            throw new q(var2);
        }
    }
}
