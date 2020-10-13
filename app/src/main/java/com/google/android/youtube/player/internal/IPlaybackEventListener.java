package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPlaybackEventListener extends IInterface {
    void onPlaying() throws RemoteException;

    void onPaused() throws RemoteException;

    void onStopped() throws RemoteException;

    void onBuffering(boolean isBuffering) throws RemoteException;

    void onSeekTo(int newPositionMillis) throws RemoteException;

    abstract class Stub extends Binder implements IPlaybackEventListener {
        public Stub() {
            this.attachInterface(this, "com.google.android.youtube.player.internal.IPlaybackEventListener");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.onPlaying();
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.onPaused();
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.onStopped();
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    boolean var5 = 0 != var2.readInt();
                    this.onBuffering(var5);
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    var1 = var2.readInt();
                    this.onSeekTo(var1);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        // was private before
        public static class Proxy implements IPlaybackEventListener {
            private IBinder a;

            Proxy(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void onPlaying() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.a.transact(1, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void onPaused() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.a.transact(2, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void onStopped() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    this.a.transact(3, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }

            public final void onBuffering(boolean isBuffering) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    var2.writeInt(isBuffering ? 1 : 0);
                    this.a.transact(4, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }

            public final void onSeekTo(int newPositionMillis) throws RemoteException {
                Parcel var2 = Parcel.obtain();
                Parcel var3 = Parcel.obtain();

                try {
                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaybackEventListener");
                    var2.writeInt(newPositionMillis);
                    this.a.transact(5, var2, var3, 0);
                    var3.readException();
                } finally {
                    var3.recycle();
                    var2.recycle();
                }

            }
        }
    }
}
