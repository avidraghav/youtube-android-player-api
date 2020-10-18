package com.google.android.youtube.player.internal;

import android.os.IBinder;

import java.lang.reflect.Field;

public final class ObjectWrapper<T> extends IObjectWrapper.Stub {

    private final T obj;

    private ObjectWrapper(T obj) {
        this.obj = obj;
    }

    public static <T> IObjectWrapper a(T t) {
        return new ObjectWrapper<>(t);
    }

    public static Object a(IObjectWrapper uVar) {
        if (uVar instanceof ObjectWrapper) {
            return ((ObjectWrapper) uVar).obj;
        }
        IBinder asBinder = uVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return field.get(asBinder);
                } catch (NullPointerException e) {
                    throw new IllegalArgumentException("Binder object is null.", e);
                } catch (IllegalArgumentException e2) {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
                } catch (IllegalAccessException e3) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e3);
                }
            } else {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
        } else {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
    }
}
