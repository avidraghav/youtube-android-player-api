package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface u extends IInterface {
    public abstract static class a extends Binder implements u {
        public a() {
            this.attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
        }

        public static u a(IBinder var0) {
            if (var0 == null) {
                return null;
            } else {
                IInterface var1;
                return (u)((var1 = var0.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper")) != null && var1 instanceof u ? (u)var1 : new u.a.a(var0));
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

        private static class a implements u {
            private IBinder a;

            a(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }
        }
    }
}
