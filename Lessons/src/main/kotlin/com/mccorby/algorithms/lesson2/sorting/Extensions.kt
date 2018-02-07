package com.mccorby.algorithms.lesson2.sorting

/**
 * Helper functions. Refer to data through compares and exchanges
 */

/**
 * Is item v less than w ?
 */
fun <T: Comparable<T>> Comparable<T>.less(other: T): Boolean {
    return this < other
}

/**
 * Swap item in array a[] at index i with the one at index j.
 */
fun <T> Array<T>.exch(i: Int, j: Int) {
    val swap = this[i]
    this[i] = this[j]
    this[j] = swap
}

fun <T : Comparable<T>> Array<T>.isSorted(): Boolean {
    // none Returns `true` if no elements match the given [predicate].
    return (1 until this.size).none { this[it].less(this[it - 1 ])}
}