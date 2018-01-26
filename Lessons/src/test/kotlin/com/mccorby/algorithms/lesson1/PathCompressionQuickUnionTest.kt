package com.mccorby.algorithms.lesson1

import com.mccorby.algorithms.lesson1.PathCompressionQuickUnion
import com.mccorby.algorithms.lesson1.UnionFind

internal class PathCompressionQuickUnionTest: UnionFindTest() {
    override fun getImplementation(ids: Array<Int>): UnionFind {
        return PathCompressionQuickUnion(ids)
    }
}