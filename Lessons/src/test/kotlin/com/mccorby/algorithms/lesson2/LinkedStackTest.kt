package com.mccorby.algorithms.lesson2

import org.junit.Assert.*
import org.junit.Test

class LinkedStackTest {

    @Test
    fun `given string is pushed then stack has one more element`() {
        // Given
        val item = "Another item"
        val expected = 1

        // When
        val cut = LinkedStack<String>()
        cut.push(item)

        // Then
        assertEquals(expected, cut.size())
    }

    @Test
    fun `given stack has items and pop is invoked then stack has one item less and the item`() {
        // Given
        val item = "Another item"
        val expected = 0

        // When
        val cut = LinkedStack<String>()
        cut.push(item)
        val resultItem = cut.pop()

        // Then
        assertEquals(expected, cut.size())
        assertEquals(item, resultItem)
    }

    @Test
    fun `given no items in the stack then it returns is empty`() {
        // When
        val cut = LinkedStack<String>()
        val result = cut.isEmpty()

        // Then
        assertTrue(result)
    }

    @Test
    fun `given there are more elements then the iterator returns an item`() {
        // Given
        val cut = LinkedStack<String>()
        cut.push("1")
        cut.push("2")
        cut.push("3")

        // When
        val nextValue = cut.iterator().next()

        // Then
        assertNotNull(nextValue)
    }
}