package com.mccoby.algorithms.lesson1

import com.sun.xml.internal.xsom.XSWildcard

/**
 * - Integer array id[] of length N.
 * - Interpretation: Each entry in the array contains a reference to its parent in the tree
 * - Find: Check if p and q has the same root
 * Note that the root is not the same as the parent!
 * - Union: To merge components containing p and q, set the id of p's root to the id of q's root
 *  Only one value needs to be changed
 */
class QuickUnion(private val ids: Array<Int>): UnionFind(ids) {

    override fun union(p: Int, q: Int) {
        val rootP = getRoot(p)
        val rootQ = getRoot(q)

        ids[rootP] = rootQ
    }

    override fun connected(p: Int, q: Int): Boolean {
        return getRoot(p) == getRoot(q)
    }

    /**
     * Gets the root of the node. The root is id[id[id[...id[i]...]]]
     *
     * The cost is the depth of i array accesses
     */
    private fun getRoot(node: Int): Int {
        var i = node
        while (i != ids[i]) {
            i = ids[i]
        }
        return i
    }
}