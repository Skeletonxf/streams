package com.example.myapplication.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *  An extremely incomplete reimplementation of the Java 8 stream library, using the same
 *  interface/methods where functionality is reimplemented. This facilitates porting examples
 *  from Stackoverflow that use the standard library.
 *
 *  Examples of use
 *
 *  Modify every element in a list them print it back out
 *
 *  Java 8 standard library:
 *  System.out.println(list.stream().map(i -> i * 5).collect(Collectors.toList()));
 *  This library:
 *  System.out.println(Stream.of(list).map(i -> i * 5).collect(Collectors.toList()));
 *
 *  Filter a list and turn it into a set
 *
 *  Java 8 standard library:
 *  Set filtered = list.stream().filter(e -> e.someTest()).collect(Collectors.toSet());
 *  This library:
 *  Set filtered = Stream.of(list).filter(e -> e.someTest()).collect(Collectors.toSet());
 *
 *  The only syntax difference on the consuming code side is needing to use Stream.of() instead
 *  of calling the .stream() method on the list/set/map. This is because it is not possible to add
 *  methods to List/Set/Map if you're not the one writing them in Java. Android does in fact
 *  support the full Java 8 stream library but it requires a minimum Android SDK of API of 24
 *
 *  If you see the error "Call requires API level 24 (current min is 15)" then you are trying to
 *  use the Android SDK library's Streams API and the code will fail on older android devices
 *  which would be very bad.
 */
public interface Stream<T> {
    /**
     * Filters this stream, retaining only elements that pass the predicate
     * @param predicate predicate to test elements in stream with
     * @return another stream
     */
    Stream<T> filter(Predicate<T> predicate);

    /**
     * Maps all the elements in this stream from type T to type R
     * @param mappingFunction function to map each element
     * @return another stream
     */
    <R> Stream<R> map(Function<T, R> mappingFunction);

    /**
     * Consumes every element in this stream
     *
     * Note this does not return a stream and hence cannot be
     * chained with additional methods after calling
     *
     * @param consumer function to consume every element
     */
    void forEach(Consumer<T> consumer);

    /**
     * Collects this stream into another datastructure of type R
     *
     * Note this does not return a stream and hence cannot be
     * chained with additional stream methods after calling
     *
     * @param collector collector to collect this stream with
     * @return a new datastructure
     */
    <R> R collect(Collector<T, R> collector);

    static <T> Stream<T> of(List<T> list) {
        return new SimpleStream<>(list);
    }

    static <T> Stream<T> of(Set<T> set) {
        return new SimpleStream<>(set);
    }

    static <T> Stream<T> of(T... values) {
        List<T> list = new ArrayList<>();
        for (T element : values) {
            list.add(element);
        }
        return new SimpleStream<T>(list);
    }
}
