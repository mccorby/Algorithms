package com.mccorby.algorithms.lesson2.sorting

internal class SelectionSortTest(): BasicSortingTest() {
    override fun getImplementation(): BasicSorting {
        return SelectionSort()
    }
}