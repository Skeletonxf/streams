package com.example.myapplication.stream;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
 * @param <T> The type this function takes
 * @param <R> The type this function returns
 */
public interface Function<T, R> {
    /**
     * Takes t and returns something of type R
     */
    R apply(T t);
}
