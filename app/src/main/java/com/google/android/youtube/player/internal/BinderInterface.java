package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface BinderInterface extends IInterface {
    void a() throws RemoteException;

    void b() throws RemoteException;

    void c() throws RemoteException;

    abstract class a extends Binder implements BinderInterface {
        public a() {
            this.attachInterface(this, "com.google.android.youtube.player.internal.IPlaylistEventListener");
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 1:
                    data.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.a();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.b();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.c();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class a implements BinderInterface {
            private IBinder a;

            a(IBinder var1) {
                this.a = var1;
            }

            @Override
            public final IBinder asBinder() {
                return this.a;
            }

            public final void a() throws RemoteException {
                Parcel var1 = Parcel.obtain();
                Parcel var2 = Parcel.obtain();

                try {
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.a.transact(1, var1, var2, 0);
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
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.a.transact(2, var1, var2, 0);
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
                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
                    this.a.transact(3, var1, var2, 0);
                    var2.readException();
                } finally {
                    var2.recycle();
                    var1.recycle();
                }

            }
        }
    }
}
