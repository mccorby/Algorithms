package com.mccoby.algorithms.lesson1

import com.mccorby.algorithms.lesson1.QuickFind
import org.junit.Assert.*
import org.junit.Test

internal class QuickFindTest {

    @Test
    fun `test algorithm is symmetric`() {
        // Given
        val ids = arrayOf(0, 1, 1, 8, 8, 0, 0, 1, 8, 8)
        val p = 0
        val q = 5
        // When
        val cut = QuickFind(ids)

        // Then
        assertEquals(cut.connected(p, q), cut.connected(q, p))
    }

    @Test
    fun `test algorithm is reflexive`() {
        // Given
        val ids = arrayOf(0, 1, 1, 8, 8, 0, 0, 1, 8, 8)
        val q = 0
        val p = 0

        // When
        val cut = QuickFind(ids)

        // Then
        assertTrue(cut.connected(p, q))
    }

    @Test
    fun `test algorithm is transitive`() {
        // Given
        val ids = arrayOf(0, 1, 1, 8, 8, 0, 0, 1, 8, 8)
        val p = 0
        val q = 5
        val r = 6

        // When
        val cut = QuickFind(ids)

        // Then
        assertTrue(cut.connected(p, q))
        assertTrue(cut.connected(q, r))
        assertTrue(cut.connected(p, r))
    }

    @Test
    fun `test p and q are connected iif they have the same id`() {
        // Given
        val ids = arrayOf(0, 1, 1, 8, 8, 0, 0, 1, 8, 8)

        // When
        val cut = QuickFind(ids)

        // Then
        assertTrue(cut.connected(0, 5))
    }

    @Test
    fun `test p and q are not connected if their ids are different`() {
        // Given
        val ids = arrayOf(0, 1, 1, 8, 8, 0, 0, 1, 8, 8)

        // When
        val cut = QuickFind(ids)

        // Then
        assertFalse(cut.connected(1, 6))
    }

    @Test
    fun `test p and q are connected after union`() {
        // Given
        val ids = arrayOf(0, 1, 1, 8, 8, 0, 0, 1, 8, 8)

        // When
        val cut = QuickFind(ids)
        cut.union(0, 1)

        // Then
        assertTrue(cut.connected(0, 1))
        assertTrue(cut.connected(1, 7))
    }

    @Test
    fun `test p and q are not connected after union`() {
        // Given
        val ids = arrayOf(0, 1, 1, 8, 8, 0, 0, 1, 8, 8)

        // When
        val cut = QuickFind(ids)
        cut.union(0, 1)

        // Then
        assertFalse(cut.connected(0, 3))
    }
}