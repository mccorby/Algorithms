package com.mccoby.algorithms.lesson1

/*
 - Integer array id[] of length N.
 - Interpretation: p and q are connected iff they have the same id

 QuickFind is too slow because the union operation is too expensive
 A sequence of N unions takes a (quadratic) N^2 array access
 */
class QuickFind(private val ids: Array<Int>): UnionFind(ids) {

    /**
     * Change all entries with ids[p] to ids[q]
     * O(2N + 2)
     */
    override fun union(p: Int, q: Int) {
        val pId = ids[p]
        val qId = ids[q]

        /**
         *
         *  for (i in ids.indices) {
         *      if (ids[i] == pId) {
         *          ids[i] = qId
         *      }
         *   }
         */

        ids.indices.filter { ids[it] == pId }
                .forEach {ids[it] = qId}

    }

    /**
     * This takes O(1)
     */
    override fun connected(p: Int, q: Int): Boolean {
        return ids[p] == ids[q]
    }
}