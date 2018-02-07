package com.mccorby.algorithms.lesson2.sorting

internal class InsertionSortTest: BasicSortingTest() {

    override fun getImplementation(): BasicSorting {
        return InsertionSort()
    }

}