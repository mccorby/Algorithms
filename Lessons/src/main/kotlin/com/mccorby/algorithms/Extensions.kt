package com.mccorby.algorithms

/**
 * Helper functions. Refer to data through compares and exchanges
 */

/**
 * Is item v less than w ?
 */
fun <T : Comparable<T>> Comparable<T>.less(other: T): Boolean {
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
    // zip(drop(1)).all { (a, b) -> a < b }
    return (1 until this.size).none { (this[it]).less(this[it - 1]) }
}

/**
 * From the course
 */
fun <T : Comparable<T>> Array<T>.merge(aux: Array<T>, low: Int, mid: Int, high: Int): Array<T> {
    assert(this.sliceArray(kotlin.ranges.IntRange(low, mid)).isSorted())
    assert(this.sliceArray(kotlin.ranges.IntRange(mid + 1, high)).isSorted())

    /**
     *
     *  for (int k = lo; k <= hi; k++) aux[k] = a[k];

    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
    if (i > mid) a[k] = aux[j++];
    else if (j > hi) a[k] = aux[i++];
    else if (less(aux[j], aux[i])) a[k] = aux[j++];
    else a[k] = aux[i++];
    }
     */
    for (k in low..high) {
        aux[k] = this[k]
    }
    var i = low
    var j = mid + 1

    for (k in low..high) {
        when {
            i > mid -> this[k] = aux[j++]!!
            j > high -> this[k] = aux[i++]!!
            (aux[j] as Comparable<T>).less(aux[i]) -> this[k] = aux[j++]!!
            else -> this[k] = aux[i++]!!
        }
    }

    return this
}