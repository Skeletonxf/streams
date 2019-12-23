# Streams

An extremely and deliberately incomplete Java Stream library mirroring the public interfaces of the Java 8 standard library stream classes. This is primarily intended for Android development where a full reimplementation of the Stream library would be overkill or is otherwise infeasible (ie using the Android Stream library requires a minimum SKD of 24 which will exclude many Android devices still in use).

## Usage

You must ensure that you have enabled Java 8 language features https://developer.android.com/studio/write/java8-support?utm_source=android-studio to use this library. If your minimum SDK version is 24 or higher then you should use the Android stream library instead.

This library is intended to be used by copying the source files into a package such as `com.example.myapplication.streams`. This enables you to add any missing functionality that is needed.

Examples of use
```java
// Modify every element in a list them print it back out:
// Java 8 standard library:
System.out.println(list.stream().map(i -> i * 5).collect(Collectors.toList()));
// This library:
System.out.println(Stream.of(list).map(i -> i * 5).collect(Collectors.toList()));

// Filter a list and turn it into a set
//Java 8 standard library:
Set filtered = list.stream().filter(e -> e.someTest()).collect(Collectors.toSet());
// This library:
Set filtered = Stream.of(list).filter(e -> e.someTest()).collect(Collectors.toSet());
```
The only syntax difference on the consuming code side is needing to use `Stream.of()` instead of calling the `.stream()` method on the list/set/map. If you see the error "Call requires API level 24 (current min is XX)" then you are trying to use the Android SDK library's Streams API and the code will fail on older android devices which would be very bad if you plan on supporting them.

## Non goals

Coverage: I have implemented only what methods I frequentely use: `filter`, `map`, `forEach` and `collect`. Aside from a few other additions like `reduce`, or collecting into Maps that might be useful in the future, I have no plans to add more functionality. [There may already be more complete backports that may be more useful to you if you desire more functionality](https://stackoverflow.com/questions/39515035/is-it-possible-to-use-the-java-8-stream-api-on-android-api-24).

Performance: I created these classes to help with writing data structure manipulating code in the same way I would in desktop Java. Internally everything is implemented by iterating through an ArrayList and as a result is probably slightly slower and uses more memory than using plain `for` loops.

Streaming: This library does not actually perform stream processing. It is not lazy, it holds the entire datastructure in memory rather than streaming and does not support any parallel processing.
