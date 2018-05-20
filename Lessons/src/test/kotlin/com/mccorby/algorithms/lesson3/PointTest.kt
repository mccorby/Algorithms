package com.mccorby.algorithms.lesson3

import org.junit.Assert.assertEquals
import org.junit.Test

internal class PointTest {

    @Test
    fun `given points with same y and x1 smaller than x2 when compared then result is -1`() {
        // Given
        val a = Point(1, 5)
        val b = Point(2, 5)
        val expected = -1

        // When
        val result = a.compareTo(b)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `given points with y1 less than y2 when compared the result is -1`() {
        // Given
        val a = Point(1, 3)
        val b = Point(2, 5)
        val expected = -1

        // When
        val result = a.compareTo(b)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `given points with y1 greater than y2 and same x when compared the result is 1`() {
        // Given
        val a = Point(2, 8)
        val b = Point(2, 5)
        val expected = 1

        // When
        val result = a.compareTo(b)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `given two different points when slopeTo is invoked a non-infinity number is returned and it is the slope`() {
        // Given
        val p1 = Point(1, 1)
        val p2 = Point(2, 2)
        val expected = 1.0

        // When
        val result = p1.slopeTo(p2)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `given two points in a horizontal line when slopeTo is invoked the result is a positive zero`() {
        // Given
        val p1 = Point(2, 2)
        val p2 = Point(4, 2)
        val expected = +0.0

        // When
        val result = p1.slopeTo(p2)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `given a vertical line segment when slopeTo is invoked the result is positive infinity`() {
        // Given
        val p1 = Point(2, 2)
        val p2 = Point(2, 4)
        val expected = Double.POSITIVE_INFINITY

        // When
        val result = p1.slopeTo(p2)

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `given a degenerate line segment when slopeTo is invoked the result is negative infinity`() {
        // Given
        val p1 = Point(2, 2)
        val p2 = Point(2, 2)
        val expected = Double.NEGATIVE_INFINITY

        // When
        val result = p1.slopeTo(p2)

        // Then
        assertEquals(expected, result)
    }
}