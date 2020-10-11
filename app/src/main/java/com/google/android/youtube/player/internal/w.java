package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;

import java.lang.reflect.InvocationTargetException;

public final class w {
    public static EmbeddedPlayer a(Activity var0, IBinder var1, boolean var2) throws w.a {
        Validators.notNull(var0);
        Validators.notNull(var1);
        Context var3;
        if ((var3 = z.createContext(var0)) == null) {
            throw new w.a("Could not create remote context");
        } else {
            return EmbeddedPlayer.AbstractA.a(a(var3.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", v.a(var3).asBinder(), v.a(var0).asBinder(), var1, var2));
        }
    }

    private static IBinder a(ClassLoader var0, String var1, IBinder var2, IBinder var3, IBinder var4, boolean var5) throws w.a {
        try {
            return a(var0.loadClass(var1), var2, var3, var4, var5);
        } catch (ClassNotFoundException var6) {
            w.a var10000 = new w.a;
            String var10003 = String.valueOf(var1);
            String var10002;
            if (var10003.length() != 0) {
                var10002 = "Unable to find dynamic class ".concat(var10003);
            } else {
                String var10004 = new String;
                var10002 = var10004;
                var10004.<init>("Unable to find dynamic class ");
            }

            var10000.<init>(var10002, var6);
            throw var10000;
        }
    }

    private static IBinder a(Class<?> var0, IBinder var1, IBinder var2, IBinder var3, boolean var4) throws w.a {
        w.a var10000;
        String var10002;
        String var10003;
        String var10004;
        try {
            return (IBinder)var0.getConstructor(IBinder.class, IBinder.class, IBinder.class, Boolean.TYPE).newInstance(var1, var2, var3, var4);
        } catch (NoSuchMethodException var5) {
            var10000 = new w.a;
            var10003 = String.valueOf(var0.getName());
            if (var10003.length() != 0) {
                var10002 = "Could not find the right constructor for ".concat(var10003);
            } else {
                var10004 = new String;
                var10002 = var10004;
                var10004.<init>("Could not find the right constructor for ");
            }

            var10000.<init>(var10002, var5);
            throw var10000;
        } catch (InvocationTargetException var6) {
            var10000 = new w.a;
            var10003 = String.valueOf(var0.getName());
            if (var10003.length() != 0) {
                var10002 = "Exception thrown by invoked constructor in ".concat(var10003);
            } else {
                var10004 = new String;
                var10002 = var10004;
                var10004.<init>("Exception thrown by invoked constructor in ");
            }

            var10000.<init>(var10002, var6);
            throw var10000;
        } catch (InstantiationException var7) {
            var10000 = new w.a;
            var10003 = String.valueOf(var0.getName());
            if (var10003.length() != 0) {
                var10002 = "Unable to instantiate the dynamic class ".concat(var10003);
            } else {
                var10004 = new String;
                var10002 = var10004;
                var10004.<init>("Unable to instantiate the dynamic class ");
            }

            var10000.<init>(var10002, var7);
            throw var10000;
        } catch (IllegalAccessException var8) {
            var10000 = new w.a;
            var10003 = String.valueOf(var0.getName());
            if (var10003.length() != 0) {
                var10002 = "Unable to call the default constructor of ".concat(var10003);
            } else {
                var10004 = new String;
                var10002 = var10004;
                var10004.<init>("Unable to call the default constructor of ");
            }

            var10000.<init>(var10002, var8);
            throw var10000;
        }
    }

    public static final class a extends Exception {
        public a(String var1) {
            super(var1);
        }

        public a(String var1, Throwable var2) {
            super(var1, var2);
        }
    }
}
