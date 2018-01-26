package com.mccorby.algorithms.lesson1

import com.mccorby.algorithms.lesson1.QuickFind
import com.mccorby.algorithms.lesson1.UnionFind

internal class QuickFindTest: UnionFindTest() {
    override fun getImplementation(ids: Array<Int>): UnionFind {
        return QuickFind(ids)
    }
}