package com.google.android.youtube.player.internal;

//
//public interface IPlayerStateChangeListener extends IInterface {
//    void onLoading() throws RemoteException;
//
//    void onLoaded(String videoId) throws RemoteException;
//
//    void onAdStarted() throws RemoteException;
//
//    void onVideoStarted() throws RemoteException;
//
//    void onVideoEnded() throws RemoteException;
//
//    void onError(String reason) throws RemoteException;
//
//    abstract class Stub extends Binder implements IPlayerStateChangeListener {
//        public Stub() {
//            this.attachInterface(this, "com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//        }
//
//        public IBinder asBinder() {
//            return this;
//        }
//
//        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
//            String var5;
//            switch(var1) {
//                case 1:
//                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    this.onLoading();
//                    var3.writeNoException();
//                    return true;
//                case 2:
//                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    var5 = var2.readString();
//                    this.onLoaded(var5);
//                    var3.writeNoException();
//                    return true;
//                case 3:
//                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    this.onAdStarted();
//                    var3.writeNoException();
//                    return true;
//                case 4:
//                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    this.onVideoStarted();
//                    var3.writeNoException();
//                    return true;
//                case 5:
//                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    this.onVideoEnded();
//                    var3.writeNoException();
//                    return true;
//                case 6:
//                    var2.enforceInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    var5 = var2.readString();
//                    this.onError(var5);
//                    var3.writeNoException();
//                    return true;
//                case 1598968902:
//                    var3.writeString("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    return true;
//                default:
//                    return super.onTransact(var1, var2, var3, var4);
//            }
//        }
//
//        // was private before
//        public static class Proxy implements IPlayerStateChangeListener {
//            private IBinder a;
//
//            Proxy(IBinder var1) {
//                this.a = var1;
//            }
//
//            public final IBinder asBinder() {
//                return this.a;
//            }
//
//            public final void onLoading() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    this.a.transact(1, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void onLoaded(String videoId) throws RemoteException {
//                Parcel var2 = Parcel.obtain();
//                Parcel var3 = Parcel.obtain();
//
//                try {
//                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    var2.writeString(videoId);
//                    this.a.transact(2, var2, var3, 0);
//                    var3.readException();
//                } finally {
//                    var3.recycle();
//                    var2.recycle();
//                }
//
//            }
//
//            public final void onAdStarted() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    this.a.transact(3, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void onVideoStarted() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    this.a.transact(4, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void onVideoEnded() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    this.a.transact(5, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void onError(String reason) throws RemoteException {
//                Parcel var2 = Parcel.obtain();
//                Parcel var3 = Parcel.obtain();
//
//                try {
//                    var2.writeInterfaceToken("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
//                    var2.writeString(reason);
//                    this.a.transact(6, var2, var3, 0);
//                    var3.readException();
//                } finally {
//                    var3.recycle();
//                    var2.recycle();
//                }
//
//            }
//        }
//    }
//}
