package com.mccorby.algorithms.lesson2

class LinkedStack<T>: Iterable<T> {
    private var size: Int = 0
    private var first: Node<T> = Node.Empty

    fun push(item: T) {
        first = when (first) {
            Node.Empty -> {
                Node.Item(item, Node.Empty)
            }
            is Node.Item<T> -> {
                Node.Item(item, first)
            }
        }
        size++
    }

    fun pop(): T? {
        val aNode = first
        return when(aNode) {
            Node.Empty -> null
            is Node.Item<T> -> {
                first = aNode.next
                size--
                aNode.item
            }
        }
    }

    fun size(): Int {
        return this.size
    }

    fun isEmpty(): Boolean {
        return first == Node.Empty
    }

    override fun iterator(): Iterator<T> {
        return StackIterator(first)
    }

    private sealed class Node<out A> {
        object Empty: Node<Nothing>()
        class Item<out T>(val item: T, val next: Node<T>): Node<T>()
    }

    private class StackIterator<out T>(first: Node<T>): Iterator<T> {

        private var current: Node<T> = first

        override fun hasNext(): Boolean {
            return current != Node.Empty
        }

        override fun next(): T {
            val aNode: Node.Item<T> = current as Node.Item<T>
            val item = aNode.item
            current = aNode.next
            return item
        }
    }
}