package com.example.myapplication.stream;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
 * @param <T> The type to test with this predicate
 */
public interface Predicate<T> {
    /**
     * Tests t, returning true or false
     */
    boolean test(T t);

    /**
     * Negates this predicate, returning a new predicate
     * which returns true if the the original returns false
     * and false if the original returns true
     */
    default Predicate<T> negate() {
        return t -> !this.test(t);
    }
}
