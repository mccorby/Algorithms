package com.mccorby.algorithms.lesson1

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

internal class PercolationTest {

    @Test
    fun `test initialization is correct`() {
        // Given
        val initSize = 10

        // When
        val cut = Percolation(initSize)

        // Then
        assertTrue(initSize == cut.size)
        assertFalse(cut.isOpen(1, 2))
    }


    @Test(expected = IllegalArgumentException::class)
    fun `test illegal argument if initial size is zero or less than zero`() {
        // Given
        val initSize = 0

        // When
        Percolation(initSize)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test row is less than one when executing open`() {
        // Given
        val initSize = 10
        val row = 0
        val col = 5

        // When
        val cut = Percolation(initSize)

        // Then
        cut.open(row, col)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `test row is greater than initial size when executing open`() {
        // Given
        val initSize = 10
        val row = 11
        val col = 5

        // When
        val cut = Percolation(initSize)

        // Then
        cut.open(row, col)
    }

    @Test
    fun `test when a site is open its value is changed`() {
        // Given
        val initSize = 10
        val row = 8
        val col = 5

        // When
        val cut = Percolation(initSize)
        cut.open(row, col)

        // Then
        assertTrue(cut.isOpen(row, col))
    }

    @Test
    fun `test site is open and connected to its right`() {
        // Given
        val initSize = 10
        val row = 8
        val col = 5

        // When
        val cut = Percolation(initSize)
        cut.open(row, col + 1)
        cut.open(row, col)

        // Then
        assertTrue(cut.isConnected(row, col, row, col + 1))
    }

    @Test
    fun `test coordinates for first row and column are transformed into a one-dimensional value`() {
        // Given
        val initSize = 10
        val row = 1
        val col = 1
        val expectedValue = 1

        // When
        val cut = Percolation(initSize)
        val result = cut.getIndexForCoordinates(row, col)

        // Then
        assertEquals(expectedValue, result)
    }

    @Test
    fun `test coordinates for any other row and column are transformed into a one-dimensional value`() {
        // Given
        val initSize = 10
        val row = 2
        val col = 2
        val expected = 12

        // When
        val cut = Percolation(initSize)
        val result = cut.getIndexForCoordinates(row, col)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `test coordinates of the last site in the grid`() {
        // Given
        val initSize = 10
        val row = 10
        val col = 10
        val expected = 100

        // When
        val cut = Percolation(initSize)
        val result = cut.getIndexForCoordinates(row, col)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `test bottom site is full`() {
        // Given
        val initSize = 5

        // When
        val cut = Percolation(initSize)
        for (i in 1..initSize) {
            cut.open(i, 1)
        }

        // Then
        assertTrue(cut.isFull(5, 1))
    }

}