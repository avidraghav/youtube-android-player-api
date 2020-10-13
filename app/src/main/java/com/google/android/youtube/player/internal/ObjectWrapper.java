package com.google.android.youtube.player.internal;

import android.os.IBinder;

import com.google.android.youtube.player.internal.dynamic.IObjectWrapper;

import java.lang.reflect.Field;

public final class ObjectWrapper<T> extends IObjectWrapper.Stub {
    private final T a;

    private ObjectWrapper(T var1) {
        this.a = var1;
    }

    public static <T> IObjectWrapper a(T t) {
        return new ObjectWrapper<Object>(t);
    }

    public static <T> T a(IObjectWrapper wrapper) {
        if (wrapper instanceof ObjectWrapper) {
            return (T) ((ObjectWrapper) wrapper).a;
        } else {
            Field[] declaredFields;
            IBinder remoteBinder;
            if ((declaredFields = (remoteBinder = wrapper.asBinder()).getClass().getDeclaredFields()).length == 1) {
                Field field;
                if (!(field = declaredFields[0]).isAccessible()) {
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
