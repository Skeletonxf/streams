package com.example.myapplication.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class SimpleStream<T> implements Stream<T> {
    private List<T> data;

    /**
     * Performs a shallow copy of the data source
     * @param data data to copy into this stream
     */
    public SimpleStream(Collection<T> data) {
        this.data = new ArrayList<>();
        for (T element : data) {
            this.data.add(element);
        }
    }

    @Override
    public Stream<T> filter(Predicate<T> predicate) {
        for (int i = data.size() - 1; i >= 0; i--) {
            if (!predicate.test(data.get(i))) {
                data.remove(i);
            }
        }
        return this;
    }

    @Override
    public <R> Stream<R> map(Function<T, R> mappingFunction) {
        List<R> mappedData = new ArrayList<>();
        for (T element : data) {
            mappedData.add(mappingFunction.apply(element));
        }
        return new SimpleStream<>(mappedData);
    }

    @Override
    public void forEach(Consumer<T> consumer) {
        for (T element : data) {
            consumer.accept(element);
        }
    }

    @Override
    public <R> R collect(Collector<T, R> collector) {
        return collector.collect(this);
    }
}
