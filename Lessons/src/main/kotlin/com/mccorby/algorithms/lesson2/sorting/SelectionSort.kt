package com.mccorby.algorithms.lesson2.sorting

/**
 * In iteration i, find index min of smallest remaining entry.
 * ・Swap a[i] and a[min].
 *
 * Invariants.
 * ・Entries the left of ↑ (including ↑) fixed and in ascending order.
 * ・No entry to right of ↑ is smaller than any entry to the left of ↑.
 *
 * Selection sort uses (N– 1) + (N– 2) + ... + 1 + 0 ~ N^2 / 2 compares and N exchanges.
 * Quadratic time, even if input is sorted
 */
class SelectionSort: BasicSorting() {

    override fun sort(items: Array<Int>): Array<out Int> {
        for (i in 0 until items.size) {
            var min = i
            (i + 1 until items.size)
                    .asSequence()
                    .filter { items[it].less(items[min]) }
                    .forEach { min = it }
            items.exch(i, min)
        }
        return items
    }

    /**
     * Following the algorithm as it is
     *
    override fun sort(items: Array<Int>): Array<out Int> {
        for (i in 0 until items.size) {
            var min = i
            for (j in i + 1 until items.size) {
                if (items[j].less(items[min])) {
                    min = j
                }
            }
            items.exch(i, min)
        }
        return items
    }
    */
}