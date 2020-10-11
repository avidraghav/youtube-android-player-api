package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IThumbnailLoaderClient extends IInterface {
    void a(Bitmap var1, String var2, boolean var3, boolean var4) throws RemoteException;

    void a(String var1, boolean var2, boolean var3) throws RemoteException;

    abstract class Stub extends Binder implements IThumbnailLoaderClient {
        public Stub() {
            this.attachInterface(this, "com.google.android.youtube.player.internal.IThumbnailLoaderClient");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            boolean var5;
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    Bitmap var7;
                    if (0 != var2.readInt()) {
                        var7 = Bitmap.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    String var10 = var2.readString();
                    var5 = 0 != var2.readInt();
                    boolean var8 = 0 != var2.readInt();
                    this.a(var7, var10, var5, var8);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    String var6 = var2.readString();
                    boolean var9 = 0 != var2.readInt();
                    var5 = 0 != var2.readInt();
                    this.a(var6, var9, var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        // was private before
        public static class ThumbnailLoaderClient implements IThumbnailLoaderClient {
            private IBinder a;

            ThumbnailLoaderClient(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(Bitmap var1, String var2, boolean var3, boolean var4) throws RemoteException {
                Parcel var5 = Parcel.obtain();
                Parcel var6 = Parcel.obtain();

                try {
                    var5.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    if (var1 != null) {
                        var5.writeInt(1);
                        var1.writeToParcel(var5, 0);
                    } else {
                        var5.writeInt(0);
                    }

                    var5.writeString(var2);
                    var5.writeInt(var3 ? 1 : 0);
                    var5.writeInt(var4 ? 1 : 0);
                    this.a.transact(1, var5, var6, 0);
                    var6.readException();
                } finally {
                    var6.recycle();
                    var5.recycle();
                }

            }

            public final void a(String var1, boolean var2, boolean var3) throws RemoteException {
                Parcel var4 = Parcel.obtain();
                Parcel var5 = Parcel.obtain();

                try {
                    var4.writeInterfaceToken("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
                    var4.writeString(var1);
                    var4.writeInt(var2 ? 1 : 0);
                    var4.writeInt(var3 ? 1 : 0);
                    this.a.transact(2, var4, var5, 0);
                    var5.readException();
                } finally {
                    var5.recycle();
                    var4.recycle();
                }

            }
        }
    }
}
