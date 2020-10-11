package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IYouTubeService extends IInterface {
    IBinder a() throws RemoteException;

    IThumbnailLoaderService a(IThumbnailLoaderClient var1) throws RemoteException;

    void a(boolean var1) throws RemoteException;

    abstract class YouTubeService extends Binder implements IYouTubeService {
        public static IYouTubeService a(IBinder var0) {
            if (var0 == null) {
                return null;
            } else {
                IInterface var1  = var0.queryLocalInterface("com.google.android.youtube.player.internal.IYouTubeService");
                return var1 instanceof IYouTubeService ? (IYouTubeService)var1 : new YouTubeServiceImpl(var0);
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            IBinder var6;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    var6 = this.a();
                    var3.writeNoException();
                    var3.writeStrongBinder(var6);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    IInterface var8;
                    Object var7 = (var6 = var2.readStrongBinder()) == null ? null : ((var8 = var6.queryLocalInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient")) != null && var8 instanceof IThumbnailLoaderClient ? (IThumbnailLoaderClient)var8 : new IThumbnailLoaderClient.ThumbnailLoaderClient.ThumbnailLoaderClientImpl(var6));
                    IThumbnailLoaderService var9 = this.a((IThumbnailLoaderClient)var7);
                    var3.writeNoException();
                    var3.writeStrongBinder(var9 != null ? var9.asBinder() : null);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IYouTubeService");
                    boolean var5 = 0 != var2.readInt();
                    this.a(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IYouTubeService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        // was private before
        public static class YouTubeServiceImpl implements IYouTubeService {
            private IBinder a;

            YouTubeServiceImpl(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final IBinder a() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                IBinder var3;
                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    this.a.transact(1, var1, var2, 0);
                    var2.readException();
                    var3 = var2.readStrongBinder();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

                return var3;
            }

            public final IThumbnailLoaderService a(IThumbnailLoaderClient var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                IThumbnailLoaderService var6;
                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    var2.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    this.a.transact(2, var2, var3, 0);
                    var3.readException();
                    var6 = IThumbnailLoaderService.ThumbnailLoaderService.a(var3.readStrongBinder());
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

                return var6;
            }

            public final void a(boolean var1) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IYouTubeService");
                    var2.writeInt(var1 ? 1 : 0);
                    this.a.transact(3, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }
        }
    }
}
