package com.mccorby.algorithms.lesson1

import com.mccorby.algorithms.lesson1.QuickUnion
import com.mccorby.algorithms.lesson1.UnionFind

internal class QuickUnionTest: UnionFindTest() {

    override fun getImplementation(ids: Array<Int>): UnionFind {
        return QuickUnion(ids)
    }
}