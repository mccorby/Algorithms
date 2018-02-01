package com.mccorby.algorithms.lesson2

class LinkedStack<T>: Iterable<T> {
    private var size: Int = 0
    private var first: Node = Node.Empty

    fun push(item: T) {
        first = when (first) {
            Node.Empty -> {
                Node.Item(item, Node.Empty)
            }
            is Node.Item<*> -> {
                Node.Item(item, first)
            }
        }
        size++
    }

    fun size(): Int {
        return this.size
    }

    fun pop(): T? {
        val aNode = first
        return when(aNode) {
            Node.Empty -> null
            is Node.Item<*> -> {
                first = aNode.next
                size--
                aNode.item as T
            }
        }
    }

    fun isEmpty(): Boolean {
        return first == Node.Empty
    }

    override fun iterator(): Iterator<T> {
        return StackIterator(first)
    }

    private sealed class Node {
        object Empty: Node()
        class Item<out T>(val item: T, val next: Node): Node()
    }

    private class StackIterator<out T>(first: Node): Iterator<T> {

        private var current: Node = first

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