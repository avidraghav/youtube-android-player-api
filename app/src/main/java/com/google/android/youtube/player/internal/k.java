package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface k extends IInterface {
    void a(String var1) throws RemoteException;

    void a(String var1, int var2) throws RemoteException;

    void a() throws RemoteException;

    void b() throws RemoteException;

    void c() throws RemoteException;

    void d() throws RemoteException;

    public abstract static class a extends Binder implements k {
        public static k a(IBinder var0) {
            if (var0 == null) {
                return null;
            } else {
                IInterface var1;
                return (k)((var1 = var0.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService")) != null && var1 instanceof k ? (k)var1 : new k.a.a(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            String var5;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    var5 = var2.readString();
                    this.a(var5);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    var5 = var2.readString();
                    int var6 = var2.readInt();
                    this.a(var5, var6);
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a();
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.b();
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.c();
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.d();
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class a implements k {
            private IBinder a;

            a(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(String var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    var2.writeString(var1);
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
                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    var3.writeString(var1);
                    var3.writeInt(var2);
                    this.a.transact(2, var3, var4, 0);
                    var4.readException();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

            }

            public final void a() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a.transact(3, var1, var2, 0);
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
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a.transact(4, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void c() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a.transact(5, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void d() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.a.transact(6, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }
        }
    }
}
