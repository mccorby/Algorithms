package com.mccorby.algorithms.lesson2

import kotlin.test.Test
import kotlin.test.assertEquals

internal class DequeTest {

    @Test
    fun testGivenEmptyDequeWhenAddFirstThenSizeIncreasesAndRemoveFirstReturnsTheSameItem() {
        // Given
        val item = "anItem"

        // When
        val cut = Deque<String>()
        cut.addFirst(item)

        // Then
        assertEquals(1, cut.size())
        assertEquals(item, cut.removeFirst())
    }

    @Test
    fun `test given empty deque when addLast then size increases and remove last returns the same item`(){
        // Given
        val item = "anItem"

        // When
        val cut = Deque<String>()
        cut.addLast(item)

        // Then
        assertEquals(1, cut.size())
        assertEquals(item, cut.removeLast())
    }

    @Test
    fun `test given empty deque when addLast then removeFirst returns the same item`() {
        // Given
        val item = "anItem"

        // When
        val cut = Deque<String>()
        cut.addLast(item)

        // Then
        assertEquals(1, cut.size())
        assertEquals(item, cut.removeFirst())
    }

    @Test
    fun `given a deque when addFirst then removeFirst returns the same item`() {
        // Given
        val item = "anItem"

        // When
        val cut = Deque<String>()
        cut.addLast(item + "1")
        cut.addLast(item + "2")
        cut.addFirst(item)

        // Then
        assertEquals(item, cut.removeFirst())
        assertEquals(item + "2", cut.removeLast())
    }

    @Test
    fun `Given a deque when iterating the same sequence is returned`() {
        // Given
        val item = "anItem"
        val item2 = "anItem2"
        val item3 = "anItem3"
        val expected = "anItem3anItem2anItem"

        // When
        val cut = Deque<String>()
        cut.addFirst(item)
        cut.addFirst(item2)
        cut.addFirst(item3)

        val result = StringBuffer()
        for (node in cut) {
            result.append(node)
        }

        // Then
        assertEquals(expected, result.toString())
    }
}