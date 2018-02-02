package com.mccorby.algorithms.lesson2;

import edu.princeton.cs.algs4.StdRandom;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizeQueue<T> implements Iterable<T> {

    private T[] items;
    private int size;

    public RandomizeQueue() {
        items = (T[]) new Object[2];
    }

    public void enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        // Double size if required
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size] = item;
        size++;
    }

    /**
     * Remove and return a random item
     *
     * @return
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = StdRandom.uniform(size);
        T item = items[index];
        items[index] = null;
        // shrink size of array if necessary
        if ((size - 1) > 0 && (size - 1) == items.length / 4) {
            resize(items.length / 2);
        }
        size--;
        return item;
    }

    @NotNull
    public T sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int index = StdRandom.uniform(size);

        return items[index];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Resize the underlying array holding the elements
     */
    private void resize(int capacity) {
        assert capacity >= size;

        // textbook implementation
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < size; i++) {
            if (items[i] != null) {
                temp[j++] = items[i];
            }
        }
        items = temp;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private final int[] permutation;
        private int current;

        public QueueIterator() {
            permutation = StdRandom.permutation(size);
        }

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public T next() {
            T item = items[permutation[current]];
            current++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }
}
