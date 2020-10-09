package com.google.android.youtube.player.internal;

import android.text.TextUtils;

public final class Validators {
    public static <T> T notNull(T obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        } else {
            return obj;
        }
    }

    /**
     * Checks if {@param obj} is {@code null} and throw exception if that's the case.
     * TODO Remove this when java replaced with kotlin
     *
     * @param obj
     * @param message
     * @param <T>
     * @return the {@param obj} if it is not {@code null}.
     * @throws NullPointerException with predefined message if {@param obj} is {@code null}.
     */
    public static <T> T notNull(T obj, Object message) {
        if (obj == null) {
            throw new NullPointerException(String.valueOf(message));
        } else {
            return obj;
        }
    }

    /**
     * Checks if the {@param value} is an empty string and throws exception if that's the case.
     * TODO Remove this when java replaced with kotlin
     *
     * @param value   The string to check.
     * @param message The message to add to the exception thrown.
     * @return the {@param value} if it is not empty.
     * @throws IllegalArgumentException if the {@param value} is an empty string.
     */
    public static String notEmpty(String value, Object message) {
        if (TextUtils.isEmpty(value)) {
            throw new IllegalArgumentException(String.valueOf(message));
        } else {
            return value;
        }
    }

    /**
     * Checks if the state is {@code true} / valid and throws exception otherwise.
     *
     * TODO Rename to validateState
     *
     * @param state The state to check.
     * @throws IllegalStateException if the state is {@code false}.
     */
    public static void validateState(boolean state) {
        if (!state) {
            throw new IllegalStateException();
        }
    }
}
