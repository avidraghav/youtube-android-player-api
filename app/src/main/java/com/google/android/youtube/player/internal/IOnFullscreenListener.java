package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IOnFullscreenListener extends IInterface {

    void onFullscreen(boolean fullscreen) throws RemoteException;

    abstract class Stub extends Binder implements IOnFullscreenListener {

        private static final String DESCRIPTOR = "com.google.android.youtube.player.internal.IOnFullscreenListener";
        static final int TRANSACTION_onFullscreen = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);

        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case TRANSACTION_onFullscreen:
                    var2.enforceInterface(DESCRIPTOR);
                    boolean var5 = 0 != var2.readInt();
                    this.onFullscreen(var5);
                    var3.writeNoException();
                    return true;
                case INTERFACE_TRANSACTION:
                    var3.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        // was private before, is replaced by "asInterface" which is not provided in this class
        static class Proxy implements IOnFullscreenListener {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final void onFullscreen(boolean fullscreen) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken(DESCRIPTOR);
                    var2.writeInt(fullscreen ? 1 : 0);
                    this.mRemote.transact(1, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }
        }
    }
}
