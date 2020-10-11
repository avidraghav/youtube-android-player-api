package com.google.android.youtube.player.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IServiceBroker extends IInterface {
    void a(IConnectionCallbacks var1, int var2, String var3, String var4, String var5, Bundle var6) throws RemoteException;

    abstract class Stub extends Binder implements IServiceBroker {
        public static IServiceBroker a(IBinder var0) {
            if (var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.youtube.player.internal.IServiceBroker");
                return var1 instanceof IServiceBroker ? (IServiceBroker)var1 : new ServiceBroker(var0);
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.youtube.player.internal.IServiceBroker");
                    IBinder var8;
                    IInterface var11;
                    Object var9 = (var8 = var2.readStrongBinder()) == null ? null : ((var11 = var8.queryLocalInterface("com.google.android.youtube.player.internal.IConnectionCallbacks")) != null && var11 instanceof IConnectionCallbacks ? (IConnectionCallbacks)var11 : new IConnectionCallbacks.Stub.ConnectionCallbacks(var8));
                    var4 = var2.readInt();
                    String var5 = var2.readString();
                    String var6 = var2.readString();
                    String var7 = var2.readString();
                    Bundle var10;
                    if (0 != var2.readInt()) {
                        var10 = Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var10 = null;
                    }

                    this.a((IConnectionCallbacks)var9, var4, var5, var6, var7, var10);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.youtube.player.internal.IServiceBroker");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }

        // was private before
        public static class ServiceBroker implements IServiceBroker {
            private IBinder a;

            ServiceBroker(IBinder var1) {
                this.a = var1;
            }

            public final IBinder asBinder() {
                return this.a;
            }

            public final void a(IConnectionCallbacks var1, int var2, String var3, String var4, String var5, Bundle var6) throws RemoteException {
                Parcel var7 = Parcel.obtain();
                Parcel var8 = Parcel.obtain();

                try {
                    var7.writeInterfaceToken("com.google.android.youtube.player.internal.IServiceBroker");
                    var7.writeStrongBinder(var1 != null ? var1.asBinder() : null);
                    var7.writeInt(var2);
                    var7.writeString(var3);
                    var7.writeString(var4);
                    var7.writeString(var5);
                    if (var6 != null) {
                        var7.writeInt(1);
                        var6.writeToParcel(var7, 0);
                    } else {
                        var7.writeInt(0);
                    }

                    this.a.transact(1, var7, var8, 0);
                    var8.readException();
                } finally {
                    var8.recycle();
                    var7.recycle();
                }

            }
        }
    }
}
