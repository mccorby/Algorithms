package com.mccorby.algorithms.lesson2.sorting

import kotlin.test.Test
import kotlin.test.assertTrue


internal abstract class BasicSortingTest {

    abstract fun getImplementation(): BasicSorting

    @Test
    fun `given a non sorted array of ints when sorting is applied the array is sorted in ascending order`() {
        // Given
        val items = arrayOf(4, 3, 5, 6, 3, 2, 1, 4, 6, 2)

        // When
        val cut = getImplementation()
        val result = cut.sort(items)

        // Then
        assertTrue(result.isSorted())
    }
}