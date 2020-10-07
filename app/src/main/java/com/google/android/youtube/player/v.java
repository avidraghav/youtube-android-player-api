package com.google.android.youtube.player;

import android.os.IBinder;

import java.lang.reflect.Field;

public final class v<T> extends a {
    private final T a;

    private v(T var1) {
        this.a = var1;
    }

    public static <T> u a(T var0) {
        return new v(var0);
    }

    public static <T> T a(u var0) {
        if (var0 instanceof v) {
            return ((v)var0).a;
        } else {
            Field[] var1;
            IBinder var5;
            if ((var1 = (var5 = var0.asBinder()).getClass().getDeclaredFields()).length == 1) {
                Field var6;
                if (!(var6 = var1[0]).isAccessible()) {
                    var6.setAccessible(true);

                    try {
                        return var6.get(var5);
                    } catch (NullPointerException var2) {
                        throw new IllegalArgumentException("Binder object is null.", var2);
                    } catch (IllegalArgumentException var3) {
                        throw new IllegalArgumentException("remoteBinder is the wrong class.", var3);
                    } catch (IllegalAccessException var4) {
                        throw new IllegalArgumentException("Could not access the field in remoteBinder.", var4);
                    }
                } else {
                    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
                }
            } else {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
        }
    }
}
