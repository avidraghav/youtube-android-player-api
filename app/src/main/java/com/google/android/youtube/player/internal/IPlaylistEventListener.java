package com.google.android.youtube.player.internal;

//
//public interface IPlaylistEventListener extends IInterface {
//
//    int ON_PREVIOUS = 1;
//    int ON_NEXT = 2;
//    int ON_PLAYLIST_ENDED = 3;
//    int UNKNOWN = 1598968902;
//
//    void onPrevious() throws RemoteException;
//
//    void onNext() throws RemoteException;
//
//    void onPlaylistEnded() throws RemoteException;
//
//    abstract class Stub extends Binder implements IPlaylistEventListener {
//        public Stub() {
//            this.attachInterface(this, "com.google.android.youtube.player.internal.IPlaylistEventListener");
//        }
//
//        @Override
//        public IBinder asBinder() {
//            return this;
//        }
//
//        @Override
//        public boolean onTransact(int code, @NonNull Parcel data, Parcel reply, int flags) throws RemoteException {
//            switch(code) {
//                case ON_PREVIOUS:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
//                    this.onPrevious();
//                    reply.writeNoException();
//                    return true;
//                case ON_NEXT:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
//                    this.onNext();
//                    reply.writeNoException();
//                    return true;
//                case ON_PLAYLIST_ENDED:
//                    data.enforceInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
//                    this.onPlaylistEnded();
//                    reply.writeNoException();
//                    return true;
//                case UNKNOWN:
//                    reply.writeString("com.google.android.youtube.player.internal.IPlaylistEventListener");
//                    return true;
//                default:
//                    return super.onTransact(code, data, reply, flags);
//            }
//        }
//
//        // was private before
//        public static class Proxy implements IPlaylistEventListener {
//            private IBinder a;
//
//            Proxy(IBinder var1) {
//                this.a = var1;
//            }
//
//            @Override
//            public final IBinder asBinder() {
//                return this.a;
//            }
//
//            public final void onPrevious() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
//                    this.a.transact(1, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void onNext() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
//                    this.a.transact(2, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//
//            public final void onPlaylistEnded() throws RemoteException {
//                Parcel var1 = Parcel.obtain();
//                Parcel var2 = Parcel.obtain();
//
//                try {
//                    var1.writeInterfaceToken("com.google.android.youtube.player.internal.IPlaylistEventListener");
//                    this.a.transact(3, var1, var2, 0);
//                    var2.readException();
//                } finally {
//                    var2.recycle();
//                    var1.recycle();
//                }
//
//            }
//        }
//    }
//}
