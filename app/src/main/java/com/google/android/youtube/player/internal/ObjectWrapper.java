package com.google.android.youtube.player.internal;

import android.os.IBinder;

import com.google.android.youtube.player.internal.dynamic.IObjectWrapper;

import java.lang.reflect.Field;

public final class ObjectWrapper<T> extends IObjectWrapper.Stub {
    private final T a;

    private ObjectWrapper(T var1) {
        this.a = var1;
    }

    public static <T> IObjectWrapper a(T var0) {
        return new ObjectWrapper(var0);
    }

    public static <T> T a(IObjectWrapper wrapper) {
        if (wrapper instanceof ObjectWrapper) {

            return (T)((ObjectWrapper) wrapper).a;
        } else {
            Field[] fields;
            IBinder remoteBinder;
            if ((fields = (remoteBinder = wrapper.asBinder()).getClass().getDeclaredFields()).length == 1) {
                Field field;
                if (!(field = fields[0]).isAccessible()) {
                    field.setAccessible(true);

                    try {
                        return (T) field.get(remoteBinder);
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
