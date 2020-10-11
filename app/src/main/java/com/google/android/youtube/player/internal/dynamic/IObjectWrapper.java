package com.google.android.youtube.player.internal.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IObjectWrapper extends IInterface {
    abstract class Stub extends Binder implements IObjectWrapper {
        public Stub() {
            this.attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
        }

        public static IObjectWrapper a(IBinder var0) {
            if (var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
                return var1 instanceof IObjectWrapper ? (IObjectWrapper)var1 : new ObjectWrapper(var0);
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        private static class ObjectWrapper implements IObjectWrapper {
            private IBinder a;

            ObjectWrapper(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }
        }
    }
}
