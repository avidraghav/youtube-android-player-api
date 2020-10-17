package com.google.android.youtube.player.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;

import androidx.annotation.NonNull;

import java.lang.reflect.InvocationTargetException;

public final class RemoteEmbeddedPlayer {
    public static IEmbeddedPlayer a(Activity activity, IBinder client, boolean var2) throws RemotePlayerException {
        Validators.notNull(activity);
        Validators.notNull(client);
        Context remoteContext = ApplicationUtils.createContext(activity);
        if (remoteContext == null) {
            throw new RemotePlayerException("Could not create remote context");
        } else {
            return IEmbeddedPlayer.Stub.asInterface(a(remoteContext.getClassLoader(), "com.google.android.youtube.api.jar.client.RemoteEmbeddedPlayer", ObjectWrapper.a(remoteContext).asBinder(), ObjectWrapper.a(activity).asBinder(), client, var2));
        }
    }

    private static IBinder a(ClassLoader loader, String className, IBinder var2, IBinder var3, IBinder var4, boolean var5) throws RemotePlayerException {
        try {
            return a(loader.loadClass(className), var2, var3, var4, var5);
        } catch (ClassNotFoundException e) {
            throw new RemotePlayerException("Unable to find dynamic class \"" + className + "\".", e);
        }
    }

    private static IBinder a(@NonNull Class<?> clazz, IBinder var1, IBinder var2, IBinder var3, boolean var4) throws RemotePlayerException {
        try {
            return (IBinder)clazz.getConstructor(IBinder.class, IBinder.class, IBinder.class, Boolean.TYPE).newInstance(var1, var2, var3, var4);
        } catch (NoSuchMethodException nsme) {
            throw new RemotePlayerException("Could not find the right constructor for \"" + clazz.getName() + "\".", nsme);
        } catch (InvocationTargetException ite) {
            throw new RemotePlayerException("Exception thrown by invoked constructor in \"" + clazz.getName() + "\".", ite);
        } catch (InstantiationException ie) {
            throw new RemotePlayerException("Unable to instantiate the dynamic class \"" + clazz.getName() + "\".", ie);
        } catch (IllegalAccessException iae) {
            throw new RemotePlayerException("Unable to call the default constructor of \"" + clazz.getName() + "\".", iae);
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
