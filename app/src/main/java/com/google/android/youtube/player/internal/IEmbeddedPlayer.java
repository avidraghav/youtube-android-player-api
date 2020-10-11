package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.KeyEvent;

import androidx.annotation.NonNull;

import com.google.android.youtube.player.internal.dynamic.IObjectWrapper;

import java.util.ArrayList;
import java.util.List;

public interface IEmbeddedPlayer extends IInterface {

    int UNKNOWN_1 = 1;
    int CUE_VIDEO = 2;
    int LOAD_VIDEO = 3;
    int CUE_PLAYLIST = 4;
    int LOAD_PLAYLIST = 5;
    int CUE_VIDEOS = 6;
    int LOAD_VIDEOS = 7;
    int PLAY = 8;
    int PAUSE = 9;
    int IS_PLAYING = 10;
    int HAS_NEXT = 11;
    int HAS_PREVIOUS = 12;
    int NEXT = 13;
    int PREVIOUS = 14;
    int GET_CURRENT_TIME_MILLIS = 15;
    int GET_DURATION_MILLIS = 16;
    int SEEK_TO_MILLIS = 17;
    int SEEK_RELATIVE_MILLIS = 18;
    int SET_FULLSCREEN = 19;
    int SET_FULLSCREEN_CONTROL_FLAGS = 20;
    int GET_FULLSCREEN_CONTROL_FLAGS = 21;
    int ADD_FULLSCREEN_CONTROL_FLAG = 22;
    int SET_PLAYER_STYLE = 23;
    int SET_SHOW_FULLSCREEN_BUTTON = 24;
    int SET_MANAGE_AUDIO_FOCUS = 25;
    int SET_ON_FULLSCREEN_LISTENER = 26;
    int SET_PLAYLIST_EVENT_LISTENER = 27;
    int SET_PLAYER_STATE_CHANGE_LISTENER = 28;
    int SET_PLAYBACK_EVENT_LISTENER = 29;
    int UNKNOWN_30 = 30;

    void a(boolean var1) throws RemoteException;

    void a(String var1, int var2) throws RemoteException;

    void b(String var1, int var2) throws RemoteException;

    void a(String var1, int var2, int var3) throws RemoteException;

    void b(String var1, int var2, int var3) throws RemoteException;

    void a(List<String> var1, int var2, int var3) throws RemoteException;

    void b(List<String> var1, int var2, int var3) throws RemoteException;

    void a() throws RemoteException;

    void b() throws RemoteException;

    boolean c() throws RemoteException;

    boolean d() throws RemoteException;

    boolean e() throws RemoteException;

    void f() throws RemoteException;

    void g() throws RemoteException;

    int h() throws RemoteException;

    int i() throws RemoteException;

    void a(int var1) throws RemoteException;

    void b(int var1) throws RemoteException;

    void b(boolean var1) throws RemoteException;

    void c(int var1) throws RemoteException;

    int j() throws RemoteException;

    void d(int var1) throws RemoteException;

    void a(String var1) throws RemoteException;

    void c(boolean var1) throws RemoteException;

    void d(boolean var1) throws RemoteException;

    void a(IOnFullscreenListener var1) throws RemoteException;

    void a(IPlaylistEventListener var1) throws RemoteException;

    void a(IPlayerStateChangeListener var1) throws RemoteException;

    void a(IPlaybackEventListener var1) throws RemoteException;

    void k() throws RemoteException;

    void l() throws RemoteException;

    /**
     * TODO: Maybe configure?
     * @param config
     * @throws RemoteException
     */
    void a(Configuration config) throws RemoteException;

    void m() throws RemoteException;

    void n() throws RemoteException;

    void o() throws RemoteException;

    void p() throws RemoteException;

    void e(boolean var1) throws RemoteException;

    void q() throws RemoteException;

    Bundle r() throws RemoteException;

    boolean a(Bundle bundle) throws RemoteException;

    boolean a(int var1, KeyEvent keyEvent) throws RemoteException;

    boolean b(int var1, KeyEvent keyEvent) throws RemoteException;

    IObjectWrapper s() throws RemoteException;

    abstract class EmbeddedPlayer extends Binder implements IEmbeddedPlayer {

        public static IEmbeddedPlayer getInstance(IBinder binder) {
            if (binder == null) {
                return null;
            } else {
                IInterface instance = binder.queryLocalInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                return instance instanceof IEmbeddedPlayer ? (IEmbeddedPlayer) instance : new EmbeddedPlayerImpl(binder);
            }
        }

        public boolean onTransact(int code, @NonNull Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle var6;
            boolean var7;
            IInterface var8;
            boolean var9;
            int var11;
            KeyEvent var12;
            IBinder var13;
            Object var14;
            String var16;
            ArrayList<String> var17;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != data.readInt();
                    this.a(var9);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = data.readString();
                    flags = data.readInt();
                    this.a(var16, flags);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = data.readString();
                    flags = data.readInt();
                    this.b(var16, flags);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = data.readString();
                    flags = data.readInt();
                    var11 = data.readInt();
                    this.a(var16, flags, var11);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = data.readString();
                    flags = data.readInt();
                    var11 = data.readInt();
                    this.b(var16, flags, var11);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var17 = data.createStringArrayList();
                    flags = data.readInt();
                    var11 = data.readInt();
                    this.a(var17, flags, var11);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var17 = data.createStringArrayList();
                    flags = data.readInt();
                    var11 = data.readInt();
                    this.b(var17, flags, var11);
                    reply.writeNoException();
                    return true;
                case PLAY:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a();
                    reply.writeNoException();
                    return true;
                case PAUSE:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.b();
                    reply.writeNoException();
                    return true;
                case IS_PLAYING:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = this.c();
                    reply.writeNoException();
                    reply.writeInt(var9 ? 1 : 0);
                    return true;
                case HAS_NEXT:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = this.d();
                    reply.writeNoException();
                    reply.writeInt(var9 ? 1 : 0);
                    return true;
                case HAS_PREVIOUS:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = this.e();
                    reply.writeNoException();
                    reply.writeInt(var9 ? 1 : 0);
                    return true;
                case NEXT:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f();
                    reply.writeNoException();
                    return true;
                case PREVIOUS:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.g();
                    reply.writeNoException();
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = this.h();
                    reply.writeNoException();
                    reply.writeInt(code);
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = this.i();
                    reply.writeNoException();
                    reply.writeInt(code);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = data.readInt();
                    this.a(code);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = data.readInt();
                    this.b(code);
                    reply.writeNoException();
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != data.readInt();
                    this.b(var9);
                    reply.writeNoException();
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = data.readInt();
                    this.c(code);
                    reply.writeNoException();
                    return true;
                case 21:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = this.j();
                    reply.writeNoException();
                    reply.writeInt(code);
                    return true;
                case 22:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = data.readInt();
                    this.d(code);
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = data.readString();
                    this.a(var16);
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != data.readInt();
                    this.c(var9);
                    reply.writeNoException();
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != data.readInt();
                    this.d(var9);
                    reply.writeNoException();
                    return true;
                case 26:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var14 = (var13 = data.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IOnFullscreenListener")) != null && var8 instanceof IOnFullscreenListener ? (IOnFullscreenListener) var8 : new IOnFullscreenListener.OnFullscreenListener.OnFullscreenListenerImpl(var13));
                    this.a((IOnFullscreenListener) var14);
                    reply.writeNoException();
                    return true;
                case 27:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var14 = (var13 = data.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlaylistEventListener")) != null && var8 instanceof IPlaylistEventListener ? (IPlaylistEventListener) var8 : new IPlaylistEventListener.PlaylistEventListener.PlaylistEventListenerImpl(var13));
                    this.a((IPlaylistEventListener) var14);
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var14 = (var13 = data.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener")) != null && var8 instanceof IPlayerStateChangeListener ? (IPlayerStateChangeListener) var8 : new IPlayerStateChangeListener.PlayerStateChangeListener.PlayerStateChangeListenerImpl(var13));
                    this.a((IPlayerStateChangeListener) var14);
                    reply.writeNoException();
                    return true;
                case 29:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var14 = (var13 = data.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlaybackEventListener")) != null && var8 instanceof IPlaybackEventListener ? (IPlaybackEventListener) var8 : new IPlaybackEventListener.PlaybackEventListener.PlaybackEventListenerImpl(var13));
                    this.a((IPlaybackEventListener) var14);
                    reply.writeNoException();
                    return true;
                case 30:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.k();
                    reply.writeNoException();
                    return true;
                case 31:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.l();
                    reply.writeNoException();
                    return true;
                case 32:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    Configuration var10;
                    if (0 != data.readInt()) {
                        var10 = Configuration.CREATOR.createFromParcel(data);
                    } else {
                        var10 = null;
                    }

                    this.a(var10);
                    reply.writeNoException();
                    return true;
                case 33:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.m();
                    reply.writeNoException();
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.n();
                    reply.writeNoException();
                    return true;
                case 35:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.o();
                    reply.writeNoException();
                    return true;
                case 36:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.p();
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != data.readInt();
                    this.e(var9);
                    reply.writeNoException();
                    return true;
                case 38:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.q();
                    reply.writeNoException();
                    return true;
                case 39:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var6 = this.r();
                    reply.writeNoException();
                    if (var6 != null) {
                        reply.writeInt(1);
                        var6.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }

                    return true;
                case 40:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (0 != data.readInt()) {
                        var6 = Bundle.CREATOR.createFromParcel(data);
                    } else {
                        var6 = null;
                    }

                    boolean var15 = this.a(var6);
                    reply.writeNoException();
                    reply.writeInt(var15 ? 1 : 0);
                    return true;
                case 41:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = data.readInt();
                    if (0 != data.readInt()) {
                        var12 = KeyEvent.CREATOR.createFromParcel(data);
                    } else {
                        var12 = null;
                    }

                    var7 = this.a(code, var12);
                    reply.writeNoException();
                    reply.writeInt(var7 ? 1 : 0);
                    return true;
                case 42:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    code = data.readInt();
                    if (0 != data.readInt()) {
                        var12 = KeyEvent.CREATOR.createFromParcel(data);
                    } else {
                        var12 = null;
                    }

                    var7 = this.b(code, var12);
                    reply.writeNoException();
                    reply.writeInt(var7 ? 1 : 0);
                    return true;
                case 43:
                    data.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    IObjectWrapper var5 = this.s();
                    reply.writeNoException();
                    reply.writeStrongBinder(var5 != null ? var5.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        // was private before
        public static class EmbeddedPlayerImpl implements IEmbeddedPlayer {
            private IBinder binder;

            EmbeddedPlayerImpl(IBinder binder) {
                this.binder = binder;
            }

            public final IBinder asBinder() {
                return this.binder;
            }

            public final void a(boolean var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1 ? 1 : 0);
                    this.binder.transact(1, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void a(String var1, int var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                try {
                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var3.writeString(var1);
                    var3.writeInt(var2);
                    this.binder.transact(2, var3, var4, 0);
                    var4.readException();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

            }

            public final void b(String var1, int var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                try {
                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var3.writeString(var1);
                    var3.writeInt(var2);
                    this.binder.transact(3, var3, var4, 0);
                    var4.readException();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

            }

            public final void a(String var1, int var2, int var3) throws RemoteException {
                Parcel var4 = Parcel.obtain();
                Parcel var5 = Parcel.obtain();

                try {
                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var4.writeString(var1);
                    var4.writeInt(var2);
                    var4.writeInt(var3);
                    this.binder.transact(4, var4, var5, 0);
                    var5.readException();
                } finally {
                    var5.recycle();
                    var4.recycle();
                }

            }

            public final void b(String var1, int var2, int var3) throws RemoteException {
                Parcel var4 = Parcel.obtain();
                Parcel var5 = Parcel.obtain();

                try {
                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var4.writeString(var1);
                    var4.writeInt(var2);
                    var4.writeInt(var3);
                    this.binder.transact(5, var4, var5, 0);
                    var5.readException();
                } finally {
                    var5.recycle();
                    var4.recycle();
                }

            }

            public final void a(List<String> var1, int var2, int var3) throws RemoteException {
                Parcel var4 = Parcel.obtain();
                Parcel var5 = Parcel.obtain();

                try {
                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var4.writeStringList(var1);
                    var4.writeInt(var2);
                    var4.writeInt(var3);
                    this.binder.transact(6, var4, var5, 0);
                    var5.readException();
                } finally {
                    var5.recycle();
                    var4.recycle();
                }

            }

            public final void b(List<String> var1, int var2, int var3) throws RemoteException {
                Parcel var4 = Parcel.obtain();
                Parcel var5 = Parcel.obtain();

                try {
                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var4.writeStringList(var1);
                    var4.writeInt(var2);
                    var4.writeInt(var3);
                    this.binder.transact(7, var4, var5, 0);
                    var5.readException();
                } finally {
                    var5.recycle();
                    var4.recycle();
                }

            }

            public final void a() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(8, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void b() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(9, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final boolean c() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                boolean var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(10, var1, var2, 0);
                    var2.readException();
                    var3 = 0 != var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public final boolean d() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                boolean var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(11, var1, var2, 0);
                    var2.readException();
                    var3 = 0 != var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public final boolean e() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                boolean var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(12, var1, var2, 0);
                    var2.readException();
                    var3 = 0 != var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public final void f() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(13, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void g() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(14, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final int h() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                int var3;
                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(15, data, reply, 0);
                    reply.readException();
                    var3 = reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

                return var3;
            }

            public final int i() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                int var3;
                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(16, data, reply, 0);
                    reply.readException();
                    var3 = reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

                return var3;
            }

            public final void a(int var1) throws RemoteException {
                Parcel Data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    Data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    Data.writeInt(var1);
                    this.binder.transact(17, Data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    Data.recycle();
                }

            }

            public final void b(int var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeInt(var1);
                    this.binder.transact(18, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void b(boolean var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeInt(var1 ? 1 : 0);
                    this.binder.transact(19, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void c(int var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeInt(var1);
                    this.binder.transact(20, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final int j() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                int var3;
                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(21, data, reply, 0);
                    reply.readException();
                    var3 = reply.readInt();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

                return var3;
            }

            public final void d(int var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeInt(var1);
                    this.binder.transact(22, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void a(String var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeString(var1);
                    this.binder.transact(23, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void c(boolean var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeInt(var1 ? 1 : 0);
                    this.binder.transact(24, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void d(boolean var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeInt(var1 ? 1 : 0);
                    this.binder.transact(25, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void a(IOnFullscreenListener var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.binder.transact(26, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void a(IPlaylistEventListener var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.binder.transact(27, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void a(IPlayerStateChangeListener var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.binder.transact(28, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void a(IPlaybackEventListener var1) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    data.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.binder.transact(29, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void k() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(30, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void l() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(31, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void a(Configuration config) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (config != null) {
                        data.writeInt(1);
                        config.writeToParcel(data, 0);
                    } else {
                        data.writeInt(0);
                    }

                    this.binder.transact(32, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void m() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();

                try {
                    data.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(33, data, reply, 0);
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }

            }

            public final void n() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(34, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void o() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(35, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void p() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(36, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void e(boolean var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1 ? 1 : 0);
                    this.binder.transact(37, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void q() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(38, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final Bundle r() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                Bundle var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(39, var1, var2, 0);
                    var2.readException();
                    if (0 != var2.readInt()) {
                        var3 = Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var3 = null;
                    }
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public final boolean a(Bundle var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                boolean var6;
                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.binder.transact(40, var2, var3, 0);
                    var3.readException();
                    var6 = 0 != var3.readInt();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var6;
            }

            public final boolean a(int var1, KeyEvent var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                boolean var7;
                try {
                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var3.writeInt(var1);
                    if (var2 != null) {
                        var3.writeInt(1);
                        var2.writeToParcel(var3, 0);
                    } else {
                        var3.writeInt(0);
                    }

                    this.binder.transact(41, var3, var4, 0);
                    var4.readException();
                    var7 = 0 != var4.readInt();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

                return var7;
            }

            public final boolean b(int var1, KeyEvent var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                boolean var7;
                try {
                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var3.writeInt(var1);
                    if (var2 != null) {
                        var3.writeInt(1);
                        var2.writeToParcel(var3, 0);
                    } else {
                        var3.writeInt(0);
                    }

                    this.binder.transact(42, var3, var4, 0);
                    var4.readException();
                    var7 = 0 != var4.readInt();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

                return var7;
            }

            public final IObjectWrapper s() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                IObjectWrapper var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.binder.transact(43, var1, var2, 0);
                    var2.readException();
                    var3 = IObjectWrapper.ObjectWrapperImpl.a(var2.readStrongBinder());
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }
        }
    }
}
