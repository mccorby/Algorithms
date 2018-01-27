package com.mccorby.algorithms.lesson1

internal class QuickUnionTest: UnionFindTest() {

    override fun getImplementation(ids: Array<Int>): UnionFind {
        return QuickUnion(ids)
    }
}