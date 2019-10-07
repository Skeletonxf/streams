package com.example.myapplication.stream;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
 * @param <T> The type this function takes
 */
public interface Consumer<T> {
    /*
     * Does something with t
     * @param t
     */
    void accept(T t);
}
