package com.mccorby.algorithms.lesson1

internal class QuickFindTest: UnionFindTest() {
    override fun getImplementation(ids: Array<Int>): UnionFind {
        return QuickFind(ids)
    }
}