package com.mccorby.algorithms.lesson1

internal class PathCompressionQuickUnionTest: UnionFindTest() {
    override fun getImplementation(ids: Array<Int>): UnionFind {
        return PathCompressionQuickUnion(ids)
    }
}