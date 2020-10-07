package com.google.android.youtube.player;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.youtube.player.internal.e.a;

import java.util.List;

public final class YouTubePlayerImpl implements YouTubePlayer {
    private b a;
    private d b;

    public YouTubePlayerImpl(b var1, d var2) {
        this.a = (b)ab.a(var1, "connectionClient cannot be null");
        this.b = (d)ab.a(var2, "embeddedPlayer cannot be null");
    }

    public final void a(boolean var1) {
        try {
            this.b.a(var1);
            this.a.a(var1);
        } catch (RemoteException var2) {
            throw new q(var2);
        }

        this.a.d();
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
            return (View)v.a(this.b.s());
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void b() {
        try {
            this.b.m();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void c() {
        try {
            this.b.n();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void d() {
        try {
            this.b.o();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void e() {
        try {
            this.b.p();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void b(boolean var1) {
        try {
            this.b.e(var1);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void a(Configuration var1) {
        try {
            this.b.a(var1);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void f() {
        try {
            this.b.q();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void g() {
        try {
            this.b.l();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean a(int var1, KeyEvent event) {
        try {
            return this.b.a(var1, event);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean b(int var1, KeyEvent event) {
        try {
            return this.b.b(var1, event);
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final Bundle h() {
        try {
            return this.b.r();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final boolean a(Bundle var1) {
        try {
            return this.b.a(var1);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void release() {
        this.a(true);
    }

    public final void cueVideo(String videoId, int timeMillis) {
        try {
            this.b.a(videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new q(var3);
        }
    }

    public final void loadVideo(String videoId, int timeMillis) {
        try {
            this.b.b(videoId, timeMillis);
        } catch (RemoteException var3) {
            throw new q(var3);
        }
    }

    public final void cuePlaylist(String playlistId, int startIndex, int timeMillis) {
        try {
            this.b.a(playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new q(var4);
        }
    }

    public final void loadPlaylist(String playlistId, int startIndex, int timeMillis) {
        try {
            this.b.b(playlistId, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new q(var4);
        }
    }

    public final void cueVideos(List<String> videoIds, int startIndex, int timeMillis) {
        try {
            this.b.a(videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new q(var4);
        }
    }

    public final void loadVideos(List<String> videoIds, int startIndex, int timeMillis) {
        try {
            this.b.b(videoIds, startIndex, timeMillis);
        } catch (RemoteException var4) {
            throw new q(var4);
        }
    }

    public final void play() {
        try {
            this.b.a();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void pause() {
        try {
            this.b.b();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final boolean isPlaying() {
        try {
            return this.b.c();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final boolean hasNext() {
        try {
            return this.b.d();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final boolean hasPrevious() {
        try {
            return this.b.e();
        } catch (RemoteException e) {
            throw new q(e);
        }
    }

    public final void next() {
        try {
            this.b.f();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void previous() {
        try {
            this.b.g();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final int getCurrentTimeMillis() {
        try {
            return this.b.h();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final int getDurationMillis() {
        try {
            return this.b.i();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void seekToMillis(int milliSeconds) {
        try {
            this.b.a(milliSeconds);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void seekRelativeMillis(int milliSeconds) {
        try {
            this.b.b(milliSeconds);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setFullscreen(boolean fullscreen) {
        try {
            this.b.b(fullscreen);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setFullscreenControlFlags(int flags) {
        try {
            this.b.c(flags);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final int getFullscreenControlFlags() {
        try {
            return this.b.j();
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void addFullscreenControlFlag(int controlFlag) {
        try {
            this.b.d(controlFlag);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setPlayerStyle(PlayerStyle style) {
        try {
            this.b.a(style.name());
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setShowFullscreenButton(boolean show) {
        try {
            this.b.c(show);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setManageAudioFocus(boolean manageAudioFocus) {
        try {
            this.b.d(manageAudioFocus);
        } catch (RemoteException var2) {
            throw new q(var2);
        }
    }

    public final void setOnFullscreenListener(final OnFullscreenListener onFullscreenListener) {
        try {
            this.b.a(new a() {
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
            this.b.a(new com.google.android.youtube.player.internal.h.a() {
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
            this.b.a(new com.google.android.youtube.player.internal.g.a() {
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
            this.b.a(new com.google.android.youtube.player.internal.f.a() {
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
