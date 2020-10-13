package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnFullscreenListener extends IInterface {
    void onFullscreen(boolean fullscreen) throws RemoteException;

    abstract class Stub extends Binder implements IOnFullscreenListener {
        public Stub() {
            this.attachInterface(this, "com.google.android.youtube.player.internal.IOnFullscreenListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    boolean var5 = 0 != var2.readInt();
                    this.onFullscreen(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        // was private before
        public static class OnFullscreenListener implements IOnFullscreenListener {
            private IBinder a;

            OnFullscreenListener(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void onFullscreen(boolean fullscreen) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IOnFullscreenListener");
                    var2.writeInt(fullscreen ? 1 : 0);
                    this.a.transact(1, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }
        }
    }
}
