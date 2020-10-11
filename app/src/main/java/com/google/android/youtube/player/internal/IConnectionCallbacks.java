package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IConnectionCallbacks extends IInterface {
    void a(String var1, IBinder var2) throws RemoteException;

    abstract class Stub extends Binder implements IConnectionCallbacks {
        public Stub() {
            this.attachInterface(this, "com.google.android.youtube.player.internal.IConnectionCallbacks");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    String var5 = var2.readString();
                    IBinder var6 = var2.readStrongBinder();
                    this.a(var5, var6);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        // was private before
        public static class ConnectionCallbacks implements IConnectionCallbacks {
            private IBinder a;

            ConnectionCallbacks(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(String var1, IBinder var2) throws RemoteException {
                Parcel var3 = Parcel.obtain();
                Parcel var4 = Parcel.obtain();

                try {
                    var3.writeInterfaceToken("com.google.android.youtube.player.internal.IConnectionCallbacks");
                    var3.writeString(var1);
                    var3.writeStrongBinder(var2);
                    this.a.transact(1, var3, var4, 0);
                    var4.readException();
                } finally {
                    var4.recycle();
                    var3.recycle();
                }

            }
        }
    }
}
