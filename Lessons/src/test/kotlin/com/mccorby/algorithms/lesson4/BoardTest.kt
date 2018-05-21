package com.mccorby.algorithms.lesson4

import org.junit.Assert.*
import org.junit.Test

internal class BoardTest {

    @Test
    fun `Given a matrix of dimension nxn when board is created then its dimension is n`() {
        // Given
        val blocksArray = createBoard()
        val expected = 3

        // When
        val board = Board(blocksArray)
        val dimension = board.dimension()

        // Then
        assertEquals(expected, dimension)
    }

    @Test
    fun `Given an input board when compared with another with the same distribution then they are equals`() {
        // Given
        val inputBoard = Board(createBoard())

        // When
        val cut = Board(createBoard())

        // Then
        assertEquals(inputBoard, cut)
    }

    @Test
    fun `Given an input board when compared with another with different distribution then they are not equals`() {
        // Given
        val inputBoard = Board(createGoalBoard())

        // When
        val cut = Board(createBoard())

        // Then
        assertNotEquals(inputBoard, cut)
    }

    @Test
    fun `Given a board when a twin is created they are not equals`() {
        // Given
        val cut = Board(createGoalBoard())

        // When
        val result = cut.twin()

        // Then
        assertNotEquals(cut, result)
    }

    @Test
    fun `Given a board that is a goal when queried it returns true`() {
        // Given
        val cut = Board(createGoalBoard())

        // When/Then
        assertTrue(cut.isGoal)
    }

    @Test
    fun `Given a non-goal board when manhattan is invoked the result is greater than 0`() {
        // Given
        val cut = Board(createBoard())
        val expected = 10

        // When
        val result = cut.manhattan()

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `Given a non-goal board when hamming is invoked the result is greater than 0`() {
        // Given
        val cut = Board(createBoard())
        val expected = 5

        // When
        val result = cut.hamming()

        // Then
        assertEquals(expected, result)
    }

    @Test
    fun `Given a board with possible neighbours when requested the list of neighbours is returned`() {
        // Given
        val cut = Board(createBoard())
        val n1 = Board(neighbour1())
        val n2 = Board(neighbour2())
        val n3 = Board(neighbour3())
        val n4 = Board(neighbour4())
        val neighbours = listOf(n1, n2, n3, n4)

        // When
        val result = cut.neighbors()

        // Then
        assertEquals(neighbours.size, result.count())
    }

    private fun createBoard(): Array<IntArray> {
        val row1 = intArrayOf(8, 1, 3)
        val row2 = intArrayOf(4, 0, 2)
        val row3 = intArrayOf(7, 6, 5)

        return arrayOf(row1, row2, row3)
    }

    private fun neighbour1(): Array<IntArray> {
        val row1 = intArrayOf(8, 0, 3)
        val row2 = intArrayOf(4, 1, 2)
        val row3 = intArrayOf(7, 6, 5)

        return arrayOf(row1, row2, row3)
    }

    private fun neighbour2(): Array<IntArray> {
        val row1 = intArrayOf(8, 1, 3)
        val row2 = intArrayOf(0, 4, 2)
        val row3 = intArrayOf(7, 6, 5)

        return arrayOf(row1, row2, row3)
    }

    private fun neighbour3(): Array<IntArray> {
        val row1 = intArrayOf(8, 1, 3)
        val row2 = intArrayOf(4, 2, 0)
        val row3 = intArrayOf(7, 6, 5)

        return arrayOf(row1, row2, row3)

    }

    private fun neighbour4(): Array<IntArray> {
        val row1 = intArrayOf(8, 1, 3)
        val row2 = intArrayOf(4, 6, 2)
        val row3 = intArrayOf(7, 0, 5)

        return arrayOf(row1, row2, row3)

    }

    private fun createGoalBoard(): Array<IntArray> {
        val row1 = intArrayOf(1, 2, 3)
        val row2 = intArrayOf(4, 5, 6)
        val row3 = intArrayOf(7, 8, 0)

        return arrayOf(row1, row2, row3)
    }
}