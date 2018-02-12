package com.mccorby.algorithms.lesson3

import kotlin.test.Test
import kotlin.test.assertEquals

internal abstract class CollinearPointsTest {

    abstract fun getImplementation(points: Array<Point?>): Collinear

    @Test(expected = IllegalArgumentException::class)
    fun `given a list of points where at least one is null when constructing the object then the points is not legal`() {
        // Given
        val points = arrayOf(Point(1, 2), Point(1, 3), null)

        // When Then
        getImplementation(points)
    }

//    @Test(expected = IllegalArgumentException::class)
//    fun `given a null argument when constructing the object then the argument is not legal`() {
//        // Given
//        val points = null
//
//        // When Then
//        points?.let { getImplementation(it) }
//    }

    @Test(expected = IllegalArgumentException::class)
    fun `given a list of points with at least one repeated point when constructing the object then the argument is not legal`() {
        val points: Array<Point?> = arrayOf(Point(1, 2), Point(3, 4), Point(1, 2))

        // When Then
        getImplementation(points)
    }

    @Test
    fun `given a list with one collinear then when segments if invoked it returns a line segment`() {
        // Given
        val points: Array<Point?> = arrayOf(
                Point(19000, 10000),
                Point(18000, 10000),
                Point(32000, 10000),
                Point(21000, 10000),
                Point(1234, 5678),
                Point(14000, 10000))

        // When
        val cut = getImplementation(points)
        val result = cut.segments()

        // Then
        assertEquals(1, result.size)
    }

    @Test
    fun `given a list of points with two collinears then when segments if invoked it returns two line segments`() {
        // Given
        val points: Array<Point?> = arrayOf(
                Point(10000, 0),
                Point(0, 10000),
                Point(3000, 7000),
                Point(7000, 3000),
                Point(20000, 21000),
                Point(3000, 4000),
                Point(14000, 15000),
                Point(6000, 7000))

        // When
        val cut = getImplementation(points)
        val result = cut.segments()

        // Then
        assertEquals(2, result.size)
    }
}