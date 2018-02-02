package com.mccorby.algorithms.lesson2

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class RandomizedQueueTest {

    @Test
    fun `given an empty queue when an item is added it returns size 1`() {
        // Given
        val expected = 1

        // When
        val cut = RandomizedQueue<Int>()
        cut.enqueue(1)
        val result = cut.size()

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `given a non-empty queue when an item is dequeue size is decrease by one`() {
        // Given
        val expected = 1
        val cut = RandomizedQueue<Int>()
        cut.enqueue(1)
        cut.enqueue(2)

        // When
        cut.dequeue()

        // Then
        assertEquals(expected, cut.size())
    }

    @Test
    fun `given an empty queue when an item is enqueued then dequeue returns the same item and the queue is empty`() {
        // Given
        val input = 1
        val cut = RandomizedQueue<Int>()

        // When
        cut.enqueue(input)
        val result = cut.dequeue()

        // Then
        assertEquals(input, result)
        assertTrue(cut.isEmpty)
    }

    @Test
    fun `given an empty queue when an item is enqueued then sample returns the same item and the queue size remains the same`() {
        // Given
        val input = 1
        val expectedSize = 1
        val cut = RandomizedQueue<Int>()

        // When
        cut.enqueue(input)
        val result = cut.sample()

        // Then
        assertEquals(input, result)
        assertEquals(expectedSize, cut.size())
    }

    @Test
    fun `given a queue with n items when executing n dequeue operations then the size is zero`() {
        // Given
        val cut = RandomizedQueue<Int>()
        cut.enqueue(1)
        cut.enqueue(2)
        cut.enqueue(3)

        // When
        cut.dequeue()
        cut.dequeue()
        cut.dequeue()

        // Then
        assertTrue(cut.isEmpty)
    }

    @Test
    fun `given a queue with n items when executing n dequeue operations all the items are returned`() {
        // Given
        val cut = RandomizedQueue<Int>()
        val expected = setOf(1, 2, 3)
        cut.enqueue(1)
        cut.enqueue(2)
        cut.enqueue(3)

        // When
        val result = mutableSetOf<Int>()
        result.add(cut.dequeue())
        result.add(cut.dequeue())
        result.add(cut.dequeue())

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `given a queue with n items when iterating through the queue all items are returned()`() {
        // Given
        val cut = RandomizedQueue<Int>()
        val expected = setOf(1, 2, 3)
        cut.enqueue(1)
        cut.enqueue(2)
        cut.enqueue(3)

        // When
        val result = mutableSetOf<Int>()
        for (item in cut) {
            result.add(item)
        }

        // Then
        assertEquals(expected, result)
    }
}