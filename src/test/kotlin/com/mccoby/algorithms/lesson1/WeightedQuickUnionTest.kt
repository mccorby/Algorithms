package com.mccoby.algorithms.lesson1

internal class WeightedQuickUnionTest: UnionFindTest() {
    override fun getImplementation(ids: Array<Int>): UnionFind {
        return WeightedQuickUnion(ids)
    }
}