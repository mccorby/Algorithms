package com.mccorby.algorithms.lesson1

/**
 * Modify quick-union to avoid tall trees.
 * Keep track of size of each tree (number of objects).
 * Balance by linking root of smaller tree to root of larger tree
 *
 * Weighted QuickUnion reduces the average distance of any node to the root
 *
 * Implementation: Use an array to keep track of the size of the trees
 *
 * Running time.
 * ・Find: takes time proportional to depth of p and q.
 * ・Union: takes constant time, given roots.
 * Proposition. Depth of any node x is at most lg N.
 *
 * Pf. When does depth of x increase?
 * Increases by 1 when tree T1 containing x is merged into another tree T2.
 * ・The size of the tree containing x at least doubles since | T 2 | ≥ | T 1 |.
 * ・Size of tree containing x can double at most lg N times
 */
open class WeightedQuickUnion(private val ids: Array<Int>): UnionFind(ids) {

    var sizes: Array<Int> = Array(5, { i -> initialSizes(ids, i) })

    override fun union(p: Int, q: Int) {
        val rootP = getRoot(p)
        val rootQ = getRoot(q)

        if (rootP == rootQ) return

        if (sizes[rootP] < sizes[rootQ]) {
            ids[rootP] = rootQ
            sizes[rootP] += sizes[rootQ]
        } else {
            ids[rootQ] = rootP
            sizes[rootQ] += sizes[rootP]
        }
    }

    override fun connected(p: Int, q: Int): Boolean {
        return getRoot(p) == getRoot(q)
    }

    open fun getRoot(node: Int): Int {
        var i = node
        while (i != ids[i]) i = ids[i]
        return i
    }

    private fun initialSizes(ids: Array<Int>, index: Int): Int {
        val i = ids[index]
        var count = 0
        while (i != ids[i]) count++
        return count
    }
}