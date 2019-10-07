package com.example.myapplication.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An extremely incomplete reimplementation of the Java 8 stream Collectors class,
 * implementing only toList and toSet.
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
 *
 * toMap might be a good idea at a later point
 */
public final class Collectors {

    private static class ArrayListCollector<T> implements Collector<T, List<T>> {
        @Override
        public List<T> collect(Stream<T> stream) {
            List<T> list = new ArrayList<>();
            stream.forEach(list::add);
            return list;
        }
    }

    public static <T> Collector<T, List<T>> toList() {
        return new ArrayListCollector<T>();
    }

    private static class HashSetCollector<T> implements Collector<T, Set<T>> {
        @Override
        public Set<T> collect(Stream<T> stream) {
            Set<T> set = new HashSet<>();
            stream.forEach(set::add);
            return set;
        }
    }

    public static <T> Collector<T, Set<T>> toSet() {
        return new HashSetCollector<T>();
    }
}
