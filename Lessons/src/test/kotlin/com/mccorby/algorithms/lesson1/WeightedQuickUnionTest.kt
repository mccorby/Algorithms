package com.mccorby.algorithms.lesson1

import com.mccorby.algorithms.lesson1.UnionFind
import com.mccorby.algorithms.lesson1.WeightedQuickUnion

internal class WeightedQuickUnionTest: UnionFindTest() {
    override fun getImplementation(ids: Array<Int>): UnionFind {
        return WeightedQuickUnion(ids)
    }
}