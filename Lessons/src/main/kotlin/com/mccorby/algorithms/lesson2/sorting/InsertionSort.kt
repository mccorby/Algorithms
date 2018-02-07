package com.mccorby.algorithms.lesson2.sorting

/**
 * In iteration i, swap a[i] with each larger entry to its left
 *
 * Invariants.
 * ・Entries to the left of ↑ (including ↑) are in ascending order.
 * ・Entries to the right of ↑ have not yet been seen.
 *
 * Best case. If the array is in ascending order, insertion sort makes
 * N- 1 compares and 0 exchanges
 *
 * Worst case. If the array is in descending order (and no duplicates),
 * insertion sort makes ~ ½ N^2 compares and ~ ½ N^2 exchanges.
 */
class InsertionSort: BasicSorting() {

    override fun sort(items: Array<Int>): Array<out Int> {
        (0 until items.size)
                .asSequence()
                .flatMap { (it downTo 1).asSequence() }
                .filter { items[it].less(items[it - 1]) }
                .forEach { items.exch(it, it - 1) }

        return items
    }

    /**
     * Java-like as proposed in the lessons
     *
    override fun sort(items: Array<Int>): Array<out Int> {
        for (i in 0 until items.size) {
            for (j in i downTo 1) {
                if (items[j].less(items[j - 1])) {
                    items.exch(j, j - 1)
                } else {
                    break
                }
            }
        }

        return items
    }
    */
}