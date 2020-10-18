package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;

import java.lang.reflect.InvocationTargetException;

public final class RemoteEmbeddedPlayer {

    public static IEmbeddedPlayer a(Activity activity, IBinder iBinder, boolean z) throws RemotePlayerException {
        Validators.notNull(activity);
        Validators.notNull(iBinder);
        Context b = ApplicationUtils.createContext((Context) activity);
        if (b != null) {
            return IEmbeddedPlayer.Stub.asInterface(a(b.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", ObjectWrapper.a(b).asBinder(), ObjectWrapper.a(activity).asBinder(), iBinder, z));
        }
        throw new RemotePlayerException("Could not create remote context");
    }

    private static IBinder a(ClassLoader loader, String className, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) throws RemotePlayerException {
        try {
            IBinder b = a(loader.loadClass(className), iBinder, iBinder2, iBinder3, z);
            return b;
            //return a(loader.loadClass(className), iBinder, iBinder2, iBinder3, z);
        } catch (ClassNotFoundException e) {
            String valueOf = String.valueOf(className);
            throw new RemotePlayerException(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : "Unable to find dynamic class ", e);
        }
    }

    private static IBinder a(Class<?> cls, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, boolean z) throws RemotePlayerException {
        try {
            return (IBinder) cls.getConstructor(IBinder.class, IBinder.class, IBinder.class, Boolean.TYPE).newInstance(new Object[]{iBinder, iBinder2, iBinder3, z});
        } catch (NoSuchMethodException e) {
            String valueOf = cls.getName();
            throw new RemotePlayerException(valueOf.length() != 0 ? "Could not find the right constructor for ".concat(valueOf) : "Could not find the right constructor for ", e);
        } catch (InvocationTargetException e2) {
            String valueOf2 = cls.getName();
            throw new RemotePlayerException(valueOf2.length() != 0 ? "Exception thrown by invoked constructor in ".concat(valueOf2) : "Exception thrown by invoked constructor in ", e2);
        } catch (InstantiationException e3) {
            String valueOf3 = cls.getName();
            throw new RemotePlayerException(valueOf3.length() != 0 ? "Unable to instantiate the dynamic class ".concat(valueOf3) : "Unable to instantiate the dynamic class ", e3);
        } catch (IllegalAccessException e4) {
            String valueOf4 = cls.getName();
            throw new RemotePlayerException(valueOf4.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf4) : "Unable to call the default constructor of ", e4);
        }
    }

    public static final class RemotePlayerException extends Exception {
        public RemotePlayerException(String message) {
            super(message);
        }

        public RemotePlayerException(String message, Throwable throwable) {
            super(message, throwable);
        }
    }
}
