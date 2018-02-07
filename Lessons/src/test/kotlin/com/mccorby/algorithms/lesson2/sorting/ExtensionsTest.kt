package com.mccorby.algorithms.lesson2.sorting

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ExtensionsTest {

    @Test
    fun `given two comparable items when comparing them the first item is less that the second one`() {
        // Given
        val item1 = 10
        val item2 = 20

        // When
        val result = item1.less(item2)

        // Then
        assertTrue(result)
    }

    @Test
    fun `given an array and two indexes when they are exchanged the array values are exchanged`() {
        // Given
        val anArray = arrayOf(1, 2)

        // When
        anArray.exch(0, 1)

        // Then
        assertEquals(2, anArray[0])
        assertEquals(1, anArray[1])
    }

    @Test
    fun `given an array sorted in ascending order when asked if it is sorted then returns true`() {
        // Given
        val anArray = arrayOf(1, 2, 2, 3, 4, 5, 6, 6, 7)

        // When
        val result = anArray.isSorted()

        // Then
        assertTrue(result)
    }

    @Test
    fun `given an array not sorted in ascending order when asked if it is sorted then returns false`() {
        // Given
        val anArray = arrayOf(1, 3, 2, 1, 4, 5, 6, 6, 2)

        // When
        val result = anArray.isSorted()

        // Then
        assertFalse(result)
    }

}