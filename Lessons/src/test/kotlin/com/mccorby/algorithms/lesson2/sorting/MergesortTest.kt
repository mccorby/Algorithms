package com.mccorby.algorithms.lesson2.sorting

internal class MergesortTest: BasicSortingTest() {
    override fun getImplementation(): BasicSorting {
        return Mergesort()
    }

}