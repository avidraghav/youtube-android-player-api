package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IThumbnailLoaderService extends IInterface {


    void setVideo(String videoId) throws RemoteException;

    void setPlaylist(String playlistId, int skipTo) throws RemoteException;

    void next() throws RemoteException;

    void previous() throws RemoteException;

    void first() throws RemoteException;

    void release() throws RemoteException;

    abstract class Stub extends Binder implements IThumbnailLoaderService {
        public static IThumbnailLoaderService asInterface(IBinder binder) {
            if (binder == null) {
                return null;
            } else {
                IInterface var1 = binder.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                return var1 instanceof IThumbnailLoaderService ? (IThumbnailLoaderService)var1 : new ThumbnailLoaderService(binder);
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            String var5;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    var5 = var2.readString();
                    this.setVideo(var5);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    var5 = var2.readString();
                    int var6 = var2.readInt();
                    this.setPlaylist(var5, var6);
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.next();
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.previous();
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.first();
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    this.release();
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        // was private before
        public static class ThumbnailLoaderService implements IThumbnailLoaderService {
            private IBinder a;

            ThumbnailLoaderService(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void setVideo(String videoId) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    var2.writeString(videoId);
                    this.a.transact(1, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void setPlaylist(String playlistId, int skipTo) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                try {
                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderService");
                    var3.writeString(playlistId);
                    var3.writeInt(skipTo);
                    this.a.transact(2, var3, var4, 0);
                    var4.readException();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

            }

            public final void next() throws RemoteException {
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

            public final void previous() throws RemoteException {
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

            public final void first() throws RemoteException {
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

            public final void release() throws RemoteException {
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
