package com.google.android.youtube.player.internal;

//
//public interface IEmbeddedPlayer extends IInterface {
//
//    int UNKNOWN_1 = 1;
//    int CUE_VIDEO = 2;
//    int LOAD_VIDEO = 3;
//    int CUE_PLAYLIST = 4;
//    int LOAD_PLAYLIST = 5;
//    int CUE_VIDEOS = 6;
//    int LOAD_VIDEOS = 7;
//    int PLAY = 8;
//    int PAUSE = 9;
//    int IS_PLAYING = 10;
//    int HAS_NEXT = 11;
//    int HAS_PREVIOUS = 12;
//    int NEXT = 13;
//    int PREVIOUS = 14;
//    int GET_CURRENT_TIME_MILLIS = 15;
//    int GET_DURATION_MILLIS = 16;
//    int SEEK_TO_MILLIS = 17;
//    int SEEK_RELATIVE_MILLIS = 18;
//    int SET_FULLSCREEN = 19;
//    int SET_FULLSCREEN_CONTROL_FLAGS = 20;
//    int GET_FULLSCREEN_CONTROL_FLAGS = 21;
//    int ADD_FULLSCREEN_CONTROL_FLAG = 22;
//    int SET_PLAYER_STYLE = 23;
//    int SET_SHOW_FULLSCREEN_BUTTON = 24;
//    int SET_MANAGE_AUDIO_FOCUS = 25;
//    int SET_ON_FULLSCREEN_LISTENER = 26;
//    int SET_PLAYLIST_EVENT_LISTENER = 27;
//    int SET_PLAYER_STATE_CHANGE_LISTENER = 28;
//    int SET_PLAYBACK_EVENT_LISTENER = 29;
//    int UNKNOWN_30 = 30;
//
//    void ii(boolean var1) throws RemoteException;
//
//    void cueVideo(String videoId, int timeMillis) throws RemoteException;
//
//    void loadVideo(String videoId, int timeMillis) throws RemoteException;
//
//    void cuePlaylist(String playlistId, int startIndex, int timeMillis) throws RemoteException;
//
//    void loadPlaylist(String playlistId, int startIndex, int timeMillis) throws RemoteException;
//
//    void cueVideos(List<String> videoIds, int startIndex, int timeMillis) throws RemoteException;
//
//    void loadVideos(List<String> videoIds, int startIndex, int timeMillis) throws RemoteException;
//
//    void play() throws RemoteException;
//
//    void pause() throws RemoteException;
//
//    boolean isPlaying() throws RemoteException;
//
//    boolean hasNext() throws RemoteException;
//
//    boolean hasPrevious() throws RemoteException;
//
//    void next() throws RemoteException;
//
//    void previous() throws RemoteException;
//
//    int getCurrentTimeMillis() throws RemoteException;
//
//    int getDurationMillis() throws RemoteException;
//
//    void seekToMillis(int milliSeconds) throws RemoteException;
//
//    void seekRelativeMillis(int milliSeconds) throws RemoteException;
//
//    void setFullscreen(boolean fullscreen) throws RemoteException;
//
//    void setFullscreenControlFlags(int controlFlag) throws RemoteException;
//
//    int getFullscreenControlFlags() throws RemoteException;
//
//    void addFullscreenControlFlag(int controlFlag) throws RemoteException;
//
//    void setPlayerStyle(String style) throws RemoteException;
//
//    void setShowFullscreenButton(boolean show) throws RemoteException;
//
//    void setManageAudioFocus(boolean manageAudioFocus) throws RemoteException;
//
//    void setOnFullscreenListener(IOnFullscreenListener onFullscreenListener) throws RemoteException;
//
//    void setPlaylistEventListener(IPlaylistEventListener playlistEventListener) throws RemoteException;
//
//    void setPlayerStateChangeListener(IPlayerStateChangeListener playerStateChangeListener) throws RemoteException;
//
//    void setPlaybackEventListener(IPlaybackEventListener playbackEventListener) throws RemoteException;
//
//    void jj() throws RemoteException;
//
//    void kk() throws RemoteException;
//
//    void onConfigurationChanged(Configuration config) throws RemoteException;
//
//    void ll() throws RemoteException;
//
//    void mm() throws RemoteException;
//
//    void nn() throws RemoteException;
//
//    void oo() throws RemoteException;
//
//    // TODO Check if destroy is the right action
//    void destroy(boolean isFinishing) throws RemoteException;
//
//    void pp() throws RemoteException;
//
//    Bundle getBundle() throws RemoteException;
//
//    boolean setBundle(Bundle bundle) throws RemoteException;
//
//    boolean dispatchKeyEventDown(int keyCode, KeyEvent keyEvent) throws RemoteException;
//
//    boolean dispatchKeyEventUp(int keyCode, KeyEvent keyEvent) throws RemoteException;
//
//    IObjectWrapper qq() throws RemoteException;
//
//    abstract class Stub extends Binder implements IEmbeddedPlayer {
//
//        public static IEmbeddedPlayer asInterface(IBinder binder) {
//            if (binder == null) {
//                return null;
//            } else {
//                IInterface instance = binder.queryLocalInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                return instance instanceof IEmbeddedPlayer ? (IEmbeddedPlayer) instance : new EmbeddedPlayer(binder);
//            }
//        }
//
//        public boolean onTransact(int code, @NonNull Parcel data, Parcel reply, int flags) throws RemoteException {
//            Bundle var6;
//            boolean var7;
//            IInterface var8;
//            boolean var9;
//            int var11;
//            KeyEvent var12;
//            IBinder var13;
//            Object var14;
//            String var16;
//            ArrayList<String> var17;
//            switch (code) {
//                case 1:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var9 = 0 != data.readInt();
//                    this.ii(var9);
//                    reply.writeNoException();
//                    return true;
//                case 2:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var16 = data.readString();
//                    flags = data.readInt();
//                    this.cueVideo(var16, flags);
//                    reply.writeNoException();
//                    return true;
//                case 3:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var16 = data.readString();
//                    flags = data.readInt();
//                    this.loadVideo(var16, flags);
//                    reply.writeNoException();
//                    return true;
//                case 4:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var16 = data.readString();
//                    flags = data.readInt();
//                    var11 = data.readInt();
//                    this.cuePlaylist(var16, flags, var11);
//                    reply.writeNoException();
//                    return true;
//                case 5:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var16 = data.readString();
//                    flags = data.readInt();
//                    var11 = data.readInt();
//                    this.loadPlaylist(var16, flags, var11);
//                    reply.writeNoException();
//                    return true;
//                case 6:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var17 = data.createStringArrayList();
//                    flags = data.readInt();
//                    var11 = data.readInt();
//                    this.cueVideos(var17, flags, var11);
//                    reply.writeNoException();
//                    return true;
//                case 7:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var17 = data.createStringArrayList();
//                    flags = data.readInt();
//                    var11 = data.readInt();
//                    this.loadVideos(var17, flags, var11);
//                    reply.writeNoException();
//                    return true;
//                case PLAY:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.play();
//                    reply.writeNoException();
//                    return true;
//                case PAUSE:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.pause();
//                    reply.writeNoException();
//                    return true;
//                case IS_PLAYING:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var9 = this.isPlaying();
//                    reply.writeNoException();
//                    reply.writeInt(var9 ? 1 : 0);
//                    return true;
//                case HAS_NEXT:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var9 = this.hasNext();
//                    reply.writeNoException();
//                    reply.writeInt(var9 ? 1 : 0);
//                    return true;
//                case HAS_PREVIOUS:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var9 = this.hasPrevious();
//                    reply.writeNoException();
//                    reply.writeInt(var9 ? 1 : 0);
//                    return true;
//                case NEXT:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.next();
//                    reply.writeNoException();
//                    return true;
//                case PREVIOUS:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.previous();
//                    reply.writeNoException();
//                    return true;
//                case 15:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = this.getCurrentTimeMillis();
//                    reply.writeNoException();
//                    reply.writeInt(code);
//                    return true;
//                case 16:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = this.getDurationMillis();
//                    reply.writeNoException();
//                    reply.writeInt(code);
//                    return true;
//                case 17:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = data.readInt();
//                    this.seekToMillis(code);
//                    reply.writeNoException();
//                    return true;
//                case 18:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = data.readInt();
//                    this.seekRelativeMillis(code);
//                    reply.writeNoException();
//                    return true;
//                case 19:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var9 = 0 != data.readInt();
//                    this.setFullscreen(var9);
//                    reply.writeNoException();
//                    return true;
//                case 20:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = data.readInt();
//                    this.setFullscreenControlFlags(code);
//                    reply.writeNoException();
//                    return true;
//                case 21:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = this.getFullscreenControlFlags();
//                    reply.writeNoException();
//                    reply.writeInt(code);
//                    return true;
//                case 22:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = data.readInt();
//                    this.addFullscreenControlFlag(code);
//                    reply.writeNoException();
//                    return true;
//                case 23:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var16 = data.readString();
//                    this.setPlayerStyle(var16);
//                    reply.writeNoException();
//                    return true;
//                case 24:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var9 = 0 != data.readInt();
//                    this.setShowFullscreenButton(var9);
//                    reply.writeNoException();
//                    return true;
//                case 25:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var9 = 0 != data.readInt();
//                    this.setManageAudioFocus(var9);
//                    reply.writeNoException();
//                    return true;
//                case 26:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var14 = (var13 = data.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IOnFullscreenListener")) != null && var8 instanceof IOnFullscreenListener ? (IOnFullscreenListener) var8 : new IOnFullscreenListener.Stub.Proxy(var13));
//                    this.setOnFullscreenListener((IOnFullscreenListener) var14);
//                    reply.writeNoException();
//                    return true;
//                case 27:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var14 = (var13 = data.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlaylistEventListener")) != null && var8 instanceof IPlaylistEventListener ? (IPlaylistEventListener) var8 : new IPlaylistEventListener.Stub.Proxy(var13));
//                    this.setPlaylistEventListener((IPlaylistEventListener) var14);
//                    reply.writeNoException();
//                    return true;
//                case 28:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var14 = (var13 = data.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener")) != null && var8 instanceof IPlayerStateChangeListener ? (IPlayerStateChangeListener) var8 : new IPlayerStateChangeListener.Stub.Proxy(var13));
//                    this.setPlayerStateChangeListener((IPlayerStateChangeListener) var14);
//                    reply.writeNoException();
//                    return true;
//                case 29:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var14 = (var13 = data.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlaybackEventListener")) != null && var8 instanceof IPlaybackEventListener ? (IPlaybackEventListener) var8 : new IPlaybackEventListener.Stub.Proxy(var13));
//                    this.setPlaybackEventListener((IPlaybackEventListener) var14);
//                    reply.writeNoException();
//                    return true;
//                case 30:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.jj();
//                    reply.writeNoException();
//                    return true;
//                case 31:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.kk();
//                    reply.writeNoException();
//                    return true;
//                case 32:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    Configuration var10;
//                    if (0 != data.readInt()) {
//                        var10 = Configuration.CREATOR.createFromParcel(data);
//                    } else {
//                        var10 = null;
//                    }
//
//                    this.onConfigurationChanged(var10);
//                    reply.writeNoException();
//                    return true;
//                case 33:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.ll();
//                    reply.writeNoException();
//                    return true;
//                case 34:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.mm();
//                    reply.writeNoException();
//                    return true;
//                case 35:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.nn();
//                    reply.writeNoException();
//                    return true;
//                case 36:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.oo();
//                    reply.writeNoException();
//                    return true;
//                case 37:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var9 = 0 != data.readInt();
//                    this.destroy(var9);
//                    reply.writeNoException();
//                    return true;
//                case 38:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.pp();
//                    reply.writeNoException();
//                    return true;
//                case 39:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var6 = this.getBundle();
//                    reply.writeNoException();
//                    if (var6 != null) {
//                        reply.writeInt(1);
//                        var6.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
//                    } else {
//                        reply.writeInt(0);
//                    }
//
//                    return true;
//                case 40:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    if (0 != data.readInt()) {
//                        var6 = Bundle.CREATOR.createFromParcel(data);
//                    } else {
//                        var6 = null;
//                    }
//
//                    boolean var15 = this.setBundle(var6);
//                    reply.writeNoException();
//                    reply.writeInt(var15 ? 1 : 0);
//                    return true;
//                case 41:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = data.readInt();
//                    if (0 != data.readInt()) {
//                        var12 = KeyEvent.CREATOR.createFromParcel(data);
//                    } else {
//                        var12 = null;
//                    }
//
//                    var7 = this.dispatchKeyEventDown(code, var12);
//                    reply.writeNoException();
//                    reply.writeInt(var7 ? 1 : 0);
//                    return true;
//                case 42:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    code = data.readInt();
//                    if (0 != data.readInt()) {
//                        var12 = KeyEvent.CREATOR.createFromParcel(data);
//                    } else {
//                        var12 = null;
//                    }
//
//                    var7 = this.dispatchKeyEventUp(code, var12);
//                    reply.writeNoException();
//                    reply.writeInt(var7 ? 1 : 0);
//                    return true;
//                case 43:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    IObjectWrapper var5 = this.qq();
//                    reply.writeNoException();
//                    reply.writeStrongBinder(var5 != null ? var5.asBinder() : null);
//                    return true;
//                case 1598968902:
//                    reply.writeString("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    return true;
//                default:
//                    return super.onTransact(code, data, reply, flags);
//            }
//        }
//
//        // was private before
//        public static class EmbeddedPlayer implements IEmbeddedPlayer {
//            private IBinder binder;
//
//            EmbeddedPlayer(IBinder binder) {
//                this.binder = binder;
//            }
//
//            public final IBinder asBinder() {
//                return this.binder;
//            }
//
//            public final void ii(boolean var1) throws RemoteException {
//                Parcel var2 = Parcel.obtain();
//                Parcel var3 = Parcel.obtain();
//
//                try {
//                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var2.writeInt(var1 ? 1 : 0);
//                    this.binder.transact(1, var2, var3, 0);
//                    var3.readException();
//                } finally {
//                    var3.recycle();
//                    var2.recycle();
//                }
//
//            }
//
//            public final void cueVideo(String videoId, int timeMillis) throws RemoteException {
//                Parcel var3 = Parcel.obtain();
//                Parcel var4 = Parcel.obtain();
//
//                try {
//                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var3.writeString(videoId);
//                    var3.writeInt(timeMillis);
//                    this.binder.transact(2, var3, var4, 0);
//                    var4.readException();
//                } finally {
//                    var4.recycle();
//                    var3.recycle();
//                }
//
//            }
//
//            public final void loadVideo(String videoId, int timeMillis) throws RemoteException {
//                Parcel var3 = Parcel.obtain();
//                Parcel var4 = Parcel.obtain();
//
//                try {
//                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var3.writeString(videoId);
//                    var3.writeInt(timeMillis);
//                    this.binder.transact(3, var3, var4, 0);
//                    var4.readException();
//                } finally {
//                    var4.recycle();
//                    var3.recycle();
//                }
//
//            }
//
//            public final void cuePlaylist(String playlistId, int startIndex, int timeMillis) throws RemoteException {
//                Parcel var4 = Parcel.obtain();
//                Parcel var5 = Parcel.obtain();
//
//                try {
//                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var4.writeString(playlistId);
//                    var4.writeInt(startIndex);
//                    var4.writeInt(timeMillis);
//                    this.binder.transact(4, var4, var5, 0);
//                    var5.readException();
//                } finally {
//                    var5.recycle();
//                    var4.recycle();
//                }
//
//            }
//
//            public final void loadPlaylist(String playlistId, int startIndex, int timeMillis) throws RemoteException {
//                Parcel var4 = Parcel.obtain();
//                Parcel var5 = Parcel.obtain();
//
//                try {
//                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var4.writeString(playlistId);
//                    var4.writeInt(startIndex);
//                    var4.writeInt(timeMillis);
//                    this.binder.transact(5, var4, var5, 0);
//                    var5.readException();
//                } finally {
//                    var5.recycle();
//                    var4.recycle();
//                }
//
//            }
//
//            public final void cueVideos(List<String> videoIds, int startIndex, int timeMillis) throws RemoteException {
//                Parcel var4 = Parcel.obtain();
//                Parcel var5 = Parcel.obtain();
//
//                try {
//                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var4.writeStringList(videoIds);
//                    var4.writeInt(startIndex);
//                    var4.writeInt(timeMillis);
//                    this.binder.transact(6, var4, var5, 0);
//                    var5.readException();
//                } finally {
//                    var5.recycle();
//                    var4.recycle();
//                }
//
//            }
//
//            public final void loadVideos(List<String> videoIds, int startIndex, int timeMillis) throws RemoteException {
//                Parcel var4 = Parcel.obtain();
//                Parcel var5 = Parcel.obtain();
//
//                try {
//                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var4.writeStringList(videoIds);
//                    var4.writeInt(startIndex);
//                    var4.writeInt(timeMillis);
//                    this.binder.transact(7, var4, var5, 0);
//                    var5.readException();
//                } finally {
//                    var5.recycle();
//                    var4.recycle();
//                }
//
//            }
//
//            public final void play() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(8, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void pause() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(9, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final boolean isPlaying() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                boolean var3;
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(10, var1, var2, 0);
//                    var2.readException();
//                    var3 = 0 != var2.readInt();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//                return var3;
//            }
//
//            public final boolean hasNext() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                boolean var3;
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(11, var1, var2, 0);
//                    var2.readException();
//                    var3 = 0 != var2.readInt();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//                return var3;
//            }
//
//            public final boolean hasPrevious() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                boolean var3;
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(12, var1, var2, 0);
//                    var2.readException();
//                    var3 = 0 != var2.readInt();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//                return var3;
//            }
//
//            public final void next() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(13, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void previous() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(14, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final int getCurrentTimeMillis() throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                int var3;
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(15, data, reply, 0);
//                    reply.readException();
//                    var3 = reply.readInt();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//                return var3;
//            }
//
//            public final int getDurationMillis() throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                int var3;
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(16, data, reply, 0);
//                    reply.readException();
//                    var3 = reply.readInt();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//                return var3;
//            }
//
//            public final void seekToMillis(int milliSeconds) throws RemoteException {
//                Parcel Data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    Data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    Data.writeInt(milliSeconds);
//                    this.binder.transact(17, Data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    Data.recycle();
//                }
//
//            }
//
//            public final void seekRelativeMillis(int milliSeconds) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeInt(milliSeconds);
//                    this.binder.transact(18, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setFullscreen(boolean fullscreen) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeInt(fullscreen ? 1 : 0);
//                    this.binder.transact(19, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setFullscreenControlFlags(int controlFlag) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeInt(controlFlag);
//                    this.binder.transact(20, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final int getFullscreenControlFlags() throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                int var3;
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(21, data, reply, 0);
//                    reply.readException();
//                    var3 = reply.readInt();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//                return var3;
//            }
//
//            public final void addFullscreenControlFlag(int controlFlag) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeInt(controlFlag);
//                    this.binder.transact(22, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setPlayerStyle(String style) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeString(style);
//                    this.binder.transact(23, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setShowFullscreenButton(boolean show) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeInt(show ? 1 : 0);
//                    this.binder.transact(24, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setManageAudioFocus(boolean manageAudioFocus) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeInt(manageAudioFocus ? 1 : 0);
//                    this.binder.transact(25, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setOnFullscreenListener(IOnFullscreenListener onFullscreenListener) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeStrongBinder(onFullscreenListener != null ? onFullscreenListener.asBinder() : null);
//                    this.binder.transact(26, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setPlaylistEventListener(IPlaylistEventListener playlistEventListener) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeStrongBinder(playlistEventListener != null ? playlistEventListener.asBinder() : null);
//                    this.binder.transact(27, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setPlayerStateChangeListener(IPlayerStateChangeListener playerStateChangeListener) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeStrongBinder(playerStateChangeListener != null ? playerStateChangeListener.asBinder() : null);
//                    this.binder.transact(28, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void setPlaybackEventListener(IPlaybackEventListener playbackEventListener) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    data.writeStrongBinder(playbackEventListener != null ? playbackEventListener.asBinder() : null);
//                    this.binder.transact(29, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void jj() throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(30, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void kk() throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(31, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void onConfigurationChanged(Configuration config) throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    if (config != null) {
//                        data.writeInt(1);
//                        config.writeToParcel(data, 0);
//                    } else {
//                        data.writeInt(0);
//                    }
//
//                    this.binder.transact(32, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void ll() throws RemoteException {
//                Parcel data = Parcel.obtain();
//                Parcel reply = Parcel.obtain();
//
//                try {
//                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(33, data, reply, 0);
//                    reply.readException();
//                } finally {
//                    reply.recycle();
//                    data.recycle();
//                }
//
//            }
//
//            public final void mm() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(34, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void nn() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(35, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void oo() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(36, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void destroy(boolean isFinishing) throws RemoteException {
//                Parcel var2 = Parcel.obtain();
//                Parcel var3 = Parcel.obtain();
//
//                try {
//                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var2.writeInt(isFinishing ? 1 : 0);
//                    this.binder.transact(37, var2, var3, 0);
//                    var3.readException();
//                } finally {
//                    var3.recycle();
//                    var2.recycle();
//                }
//
//            }
//
//            public final void pp() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(38, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final Bundle getBundle() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                Bundle var3;
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(39, var1, var2, 0);
//                    var2.readException();
//                    if (0 != var2.readInt()) {
//                        var3 = Bundle.CREATOR.createFromParcel(var2);
//                    } else {
//                        var3 = null;
//                    }
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//                return var3;
//            }
//
//            public final boolean setBundle(Bundle var1) throws RemoteException {
//                Parcel var2 = Parcel.obtain();
//                Parcel var3 = Parcel.obtain();
//
//                boolean var6;
//                try {
//                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    if (var1 != null) {
//                        var2.writeInt(1);
//                        var1.writeToParcel(var2, 0);
//                    } else {
//                        var2.writeInt(0);
//                    }
//
//                    this.binder.transact(40, var2, var3, 0);
//                    var3.readException();
//                    var6 = 0 != var3.readInt();
//                } finally {
//                    var3.recycle();
//                    var2.recycle();
//                }
//
//                return var6;
//            }
//
//            public final boolean dispatchKeyEventDown(int keyCode, KeyEvent var2) throws RemoteException {
//                Parcel var3 = Parcel.obtain();
//                Parcel var4 = Parcel.obtain();
//
//                boolean var7;
//                try {
//                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var3.writeInt(keyCode);
//                    if (var2 != null) {
//                        var3.writeInt(1);
//                        var2.writeToParcel(var3, 0);
//                    } else {
//                        var3.writeInt(0);
//                    }
//
//                    this.binder.transact(41, var3, var4, 0);
//                    var4.readException();
//                    var7 = 0 != var4.readInt();
//                } finally {
//                    var4.recycle();
//                    var3.recycle();
//                }
//
//                return var7;
//            }
//
//            public final boolean dispatchKeyEventUp(int keyCode, KeyEvent var2) throws RemoteException {
//                Parcel var3 = Parcel.obtain();
//                Parcel var4 = Parcel.obtain();
//
//                boolean var7;
//                try {
//                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    var3.writeInt(keyCode);
//                    if (var2 != null) {
//                        var3.writeInt(1);
//                        var2.writeToParcel(var3, 0);
//                    } else {
//                        var3.writeInt(0);
//                    }
//
//                    this.binder.transact(42, var3, var4, 0);
//                    var4.readException();
//                    var7 = 0 != var4.readInt();
//                } finally {
//                    var4.recycle();
//                    var3.recycle();
//                }
//
//                return var7;
//            }
//
//            public final IObjectWrapper qq() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                IObjectWrapper var3;
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
//                    this.binder.transact(43, var1, var2, 0);
//                    var2.readException();
//                    var3 = IObjectWrapper.Stub.a(var2.readStrongBinder());
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//                return var3;
//            }
//        }
//    }
//}
