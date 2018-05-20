package com.mccorby.algorithms

import org.junit.Assert.assertTrue
import org.junit.Test

class ExtensionsKtTest {

    @Test
    fun `Given an array with two halves sorted when merged then a single sorted array is returned`() {
        // Given
        val low = 0
        val mid = 4
        val high = 9
        val anArray = arrayOf(2, 4, 6, 8, 10, 1, 3, 4, 7, 9)
        val aux = Array(anArray.size, { -1})

        // When
        val result = anArray.merge(aux, low, mid, high)

        // Then
        assertTrue(result.isSorted())
    }

}