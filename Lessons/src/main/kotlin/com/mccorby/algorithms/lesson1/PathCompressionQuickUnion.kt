package com.mccorby.algorithms.lesson1

/**
 * Simpler one-pass variant: Make every other node in path point to its
 * grandparent (thereby halving path length).
 */
class PathCompressionQuickUnion(val ids: Array<Int>) : WeightedQuickUnion(ids) {

    override fun getRoot(node: Int): Int {
        var i = node
        while (i != ids[i]) {
            ids[i] = ids[ids[i]]
            i = ids[i]
        }
        return i
    }
}