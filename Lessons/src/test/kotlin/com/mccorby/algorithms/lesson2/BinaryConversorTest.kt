package com.mccorby.algorithms.lesson2

import kotlin.test.Test
import kotlin.test.assertEquals


class BinaryConversorTest {

    @Test
    fun `given a decimal number when applying the conversor it returns its binary representation`() {
        // Given
        val input = 50
        val expected = "110010"

        // When
        val cut = BinaryConversor()
        val result = cut.convert(input)

        // Then
        assertEquals(expected, result)
    }
}