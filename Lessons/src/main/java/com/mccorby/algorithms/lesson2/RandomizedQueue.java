package com.mccorby.algorithms.lesson2;

import edu.princeton.cs.algs4.StdRandom;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    public RandomizedQueue() {
        items = (Item[]) new Object[2];
    }

    public void enqueue(Item item) {
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
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = StdRandom.uniform(size);
        Item item = items[index];
        items[index] = items[size - 1];
        items[size - 1] = null;
        // shrink size of array if necessary
        if ((size - 1) > 0 && (size - 1) == items.length / 4) {
            resize(items.length / 2);
        }
        size--;
        return item;
    }

    public Item sample() {
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
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0, j = 0; i < size; i++) {
            if (items[i] != null) {
                temp[j++] = items[i];
            }
        }
        items = temp;
    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
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
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = items[permutation[current]];
            current++;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }
}
