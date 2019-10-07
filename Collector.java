package com.example.myapplication.stream;

/**
 * @param <T> The type of element this collector takes
 * @param <R> The return type of this collector
 * Note this interface does not even try to reimplement the complexity of the standard
 * library Collector interface https://docs.oracle.com/javase/8/docs/api/java/util/function/Collector.html
 * and instead exists to facilitate writing code as if using the real Java 8 standard library.
 */
public interface Collector<T, R> {
    /*
     * Collects a stream of type T into a data structure of type R
     * @param t
     */
    R collect(Stream<T> stream);
}
