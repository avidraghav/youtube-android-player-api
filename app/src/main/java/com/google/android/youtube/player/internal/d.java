package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public interface d extends IInterface {
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

    void a(e var1) throws RemoteException;

    void a(h var1) throws RemoteException;

    void a(g var1) throws RemoteException;

    void a(f var1) throws RemoteException;

    void k() throws RemoteException;

    void l() throws RemoteException;

    void a(Configuration var1) throws RemoteException;

    void m() throws RemoteException;

    void n() throws RemoteException;

    void o() throws RemoteException;

    void p() throws RemoteException;

    void e(boolean var1) throws RemoteException;

    void q() throws RemoteException;

    Bundle r() throws RemoteException;

    boolean a(Bundle var1) throws RemoteException;

    boolean a(int var1, KeyEvent var2) throws RemoteException;

    boolean b(int var1, KeyEvent var2) throws RemoteException;

    u s() throws RemoteException;

    public abstract static class a extends Binder implements d {
        public static d a(IBinder var0) {
            if (var0 == null) {
                return null;
            } else {
                IInterface var1;
                return (d)((var1 = var0.queryLocalInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer")) != null && var1 instanceof d ? (d)var1 : new d.a.a(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            Bundle var6;
            boolean var7;
            IInterface var8;
            boolean var9;
            int var11;
            KeyEvent var12;
            IBinder var13;
            Object var14;
            String var16;
            ArrayList var17;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != var2.readInt();
                    this.a(var9);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = var2.readString();
                    var4 = var2.readInt();
                    this.a(var16, var4);
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = var2.readString();
                    var4 = var2.readInt();
                    this.b(var16, var4);
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = var2.readString();
                    var4 = var2.readInt();
                    var11 = var2.readInt();
                    this.a(var16, var4, var11);
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = var2.readString();
                    var4 = var2.readInt();
                    var11 = var2.readInt();
                    this.b(var16, var4, var11);
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var17 = var2.createStringArrayList();
                    var4 = var2.readInt();
                    var11 = var2.readInt();
                    this.a(var17, var4, var11);
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var17 = var2.createStringArrayList();
                    var4 = var2.readInt();
                    var11 = var2.readInt();
                    this.b(var17, var4, var11);
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a();
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.b();
                    var3.writeNoException();
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = this.c();
                    var3.writeNoException();
                    var3.writeInt(var9 ? 1 : 0);
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = this.d();
                    var3.writeNoException();
                    var3.writeInt(var9 ? 1 : 0);
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = this.e();
                    var3.writeNoException();
                    var3.writeInt(var9 ? 1 : 0);
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.f();
                    var3.writeNoException();
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.g();
                    var3.writeNoException();
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = this.h();
                    var3.writeNoException();
                    var3.writeInt(var1);
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = this.i();
                    var3.writeNoException();
                    var3.writeInt(var1);
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = var2.readInt();
                    this.a(var1);
                    var3.writeNoException();
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = var2.readInt();
                    this.b(var1);
                    var3.writeNoException();
                    return true;
                case 19:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != var2.readInt();
                    this.b(var9);
                    var3.writeNoException();
                    return true;
                case 20:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = var2.readInt();
                    this.c(var1);
                    var3.writeNoException();
                    return true;
                case 21:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = this.j();
                    var3.writeNoException();
                    var3.writeInt(var1);
                    return true;
                case 22:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = var2.readInt();
                    this.d(var1);
                    var3.writeNoException();
                    return true;
                case 23:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var16 = var2.readString();
                    this.a(var16);
                    var3.writeNoException();
                    return true;
                case 24:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != var2.readInt();
                    this.c(var9);
                    var3.writeNoException();
                    return true;
                case 25:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != var2.readInt();
                    this.d(var9);
                    var3.writeNoException();
                    return true;
                case 26:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var14 = (var13 = var2.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IOnFullscreenListener")) != null && var8 instanceof e ? (e)var8 : new com.google.android.youtube.player.internal.e.a.a(var13));
                    this.a((e)var14);
                    var3.writeNoException();
                    return true;
                case 27:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var14 = (var13 = var2.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlaylistEventListener")) != null && var8 instanceof h ? (h)var8 : new com.google.android.youtube.player.internal.h.a.a(var13));
                    this.a((h)var14);
                    var3.writeNoException();
                    return true;
                case 28:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var14 = (var13 = var2.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener")) != null && var8 instanceof g ? (g)var8 : new com.google.android.youtube.player.internal.g.a.a(var13));
                    this.a((g)var14);
                    var3.writeNoException();
                    return true;
                case 29:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var14 = (var13 = var2.readStrongBinder()) == null ? null : ((var8 = var13.queryLocalInterface("com.google.android.youtube.player.internal.IPlaybackEventListener")) != null && var8 instanceof f ? (f)var8 : new com.google.android.youtube.player.internal.f.a.a(var13));
                    this.a((f)var14);
                    var3.writeNoException();
                    return true;
                case 30:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.k();
                    var3.writeNoException();
                    return true;
                case 31:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.l();
                    var3.writeNoException();
                    return true;
                case 32:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    Configuration var10;
                    if (0 != var2.readInt()) {
                        var10 = (Configuration)Configuration.CREATOR.createFromParcel(var2);
                    } else {
                        var10 = null;
                    }

                    this.a(var10);
                    var3.writeNoException();
                    return true;
                case 33:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.m();
                    var3.writeNoException();
                    return true;
                case 34:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.n();
                    var3.writeNoException();
                    return true;
                case 35:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.o();
                    var3.writeNoException();
                    return true;
                case 36:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.p();
                    var3.writeNoException();
                    return true;
                case 37:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var9 = 0 != var2.readInt();
                    this.e(var9);
                    var3.writeNoException();
                    return true;
                case 38:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.q();
                    var3.writeNoException();
                    return true;
                case 39:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var6 = this.r();
                    var3.writeNoException();
                    if (var6 != null) {
                        var3.writeInt(1);
                        var6.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 40:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (0 != var2.readInt()) {
                        var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var6 = null;
                    }

                    boolean var15 = this.a(var6);
                    var3.writeNoException();
                    var3.writeInt(var15 ? 1 : 0);
                    return true;
                case 41:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = var2.readInt();
                    if (0 != var2.readInt()) {
                        var12 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var12 = null;
                    }

                    var7 = this.a(var1, var12);
                    var3.writeNoException();
                    var3.writeInt(var7 ? 1 : 0);
                    return true;
                case 42:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var1 = var2.readInt();
                    if (0 != var2.readInt()) {
                        var12 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(var2);
                    } else {
                        var12 = null;
                    }

                    var7 = this.b(var1, var12);
                    var3.writeNoException();
                    var3.writeInt(var7 ? 1 : 0);
                    return true;
                case 43:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    u var5 = this.s();
                    var3.writeNoException();
                    var3.writeStrongBinder(var5 != null ? var5.asBinder() : null);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class a implements d {
            private IBinder a;

            a(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(boolean var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1 ? 1 : 0);
                    this.a.transact(1, var2, var3, 0);
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
                    this.a.transact(2, var3, var4, 0);
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
                    this.a.transact(3, var3, var4, 0);
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
                    this.a.transact(4, var4, var5, 0);
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
                    this.a.transact(5, var4, var5, 0);
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
                    this.a.transact(6, var4, var5, 0);
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
                    this.a.transact(7, var4, var5, 0);
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
                    this.a.transact(8, var1, var2, 0);
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
                    this.a.transact(9, var1, var2, 0);
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
                    this.a.transact(10, var1, var2, 0);
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
                    this.a.transact(11, var1, var2, 0);
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
                    this.a.transact(12, var1, var2, 0);
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
                    this.a.transact(13, var1, var2, 0);
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
                    this.a.transact(14, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final int h() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                int var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(15, var1, var2, 0);
                    var2.readException();
                    var3 = var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public final int i() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                int var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(16, var1, var2, 0);
                    var2.readException();
                    var3 = var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public final void a(int var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1);
                    this.a.transact(17, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void b(int var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1);
                    this.a.transact(18, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void b(boolean var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1 ? 1 : 0);
                    this.a.transact(19, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void c(int var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1);
                    this.a.transact(20, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final int j() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                int var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(21, var1, var2, 0);
                    var2.readException();
                    var3 = var2.readInt();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public final void d(int var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1);
                    this.a.transact(22, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void a(String var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeString(var1);
                    this.a.transact(23, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void c(boolean var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1 ? 1 : 0);
                    this.a.transact(24, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void d(boolean var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeInt(var1 ? 1 : 0);
                    this.a.transact(25, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void a(e var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.a.transact(26, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void a(h var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.a.transact(27, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void a(g var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.a.transact(28, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void a(f var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    var2.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.a.transact(29, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void k() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(30, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void l() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(31, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void a(Configuration var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    if (var1 != null) {
                        var2.writeInt(1);
                        var1.writeToParcel(var2, 0);
                    } else {
                        var2.writeInt(0);
                    }

                    this.a.transact(32, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void m() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(33, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void n() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(34, var1, var2, 0);
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
                    this.a.transact(35, var1, var2, 0);
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
                    this.a.transact(36, var1, var2, 0);
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
                    this.a.transact(37, var2, var3, 0);
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
                    this.a.transact(38, var1, var2, 0);
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
                    this.a.transact(39, var1, var2, 0);
                    var2.readException();
                    if (0 != var2.readInt()) {
                        var3 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
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

                    this.a.transact(40, var2, var3, 0);
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

                    this.a.transact(41, var3, var4, 0);
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

                    this.a.transact(42, var3, var4, 0);
                    var4.readException();
                    var7 = 0 != var4.readInt();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

                return var7;
            }

            public final u s() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                u var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                    this.a.transact(43, var1, var2, 0);
                    var2.readException();
                    var3 = com.google.android.youtube.player.internal.u.a.a(var2.readStrongBinder());
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }
        }
    }
}
