package com.mccorby.algorithms.lesson1

/*
We assume "is connected to" is an equivalence relation:
・Reflexive: p is connected to p.
・Symmetric: if p is connected to q, then q is connected to p.
・Transitive: if p is connected to q and q is connected to r, then p is connected to r.
Connected components. Maximal set of objects that are mutually connected

Operations:
- Find query. Check if two objects are in the same component.
- Union command. Replace components containing two objects with their union.
 */
interface UnionFind {
    fun union(p: Int, q: Int)
    fun connected(p: Int, q: Int): Boolean
}