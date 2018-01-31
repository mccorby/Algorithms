package com.mccorby.algorithms.lesson2

class LinkedStack<T>: Iterable<T> {
    private var size: Int = 0
    private var first: Node<T>? = null

    fun push(item: T) {
        val oldFirst: Node<T>? = null
        first = Node(item, oldFirst)
        size++
    }

    fun size(): Int {
        return this.size
    }

    fun pop(): T? {
        val item = first?.item
        first = first?.next
        size--
        return item
    }

    fun isEmpty(): Boolean {
        return first == null
    }

    override fun iterator(): Iterator<T> {
        return StackIterator(first)
    }

    private class Node<out T>(val item: T, val next: Node<T>?)

    private class StackIterator<out T>(first: Node<T>?): Iterator<T> {

        private var current: Node<T>? = first

        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): T {
            val item = current?.item
            current = current?.next
            return item!!
        }

    }
}