package com.mccorby.algorithms.lesson2;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    /**
     * Is the deque empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * The number of items on the deque
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * Add the item to the front
     *
     * @param item
     */
    public void addFirst(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node node = new Node();
        if (first != null) {
            first.prev = node;
        }
        node.item = item;
        node.next = first;
        size++;
        first = node;
        if (size == 1) {
            last = first;
        }
    }

    /**
     * Add the item to the end
     *
     * @param item
     */
    public void addLast(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node node = new Node();
        node.item = item;
        node.prev = last;
        if (last != null) {
            last.next = node;
        }
        last = node;
        size++;
        if (size == 1) {
            first = last;
        }
    }

    /**
     * Remove and return the item from the front
     *
     * @return
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        size--;
        return item;
    }

    /**
     * Remove and return the item from the end
     *
     * @return
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T item = last.item;
        last = last.prev;
        if (last == null) {
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return item;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new DequeIterator<>(first);
    }

    private class Node<B> {
        B item;
        Node next;
        Node prev;
    }

    private class DequeIterator<A> implements Iterator<A> {

        private Node<A> current;

        public DequeIterator(Node<A> first) {

            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public A next() {
            A item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
