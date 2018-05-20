package com.mccorby.algorithms.lesson2.sorting

import com.mccorby.algorithms.merge

class Mergesort: BasicSorting() {

    override fun sort(items: Array<Int>): Array<out Int> {
        val aux = Array<Int>(items.size, {-1})
        return sort(items, aux, 0, items.size - 1)
    }

    private fun sort(items: Array<Int>, aux: Array<Int>, low: Int, high: Int): Array<out Int> {
        if (high <= low) return items
        val mid = low + (high - low) / 2
        sort(items, aux, low, mid)
        sort(items, aux, mid + 1, high)
        items.merge(aux, low, mid, high)
        return items
    }

}