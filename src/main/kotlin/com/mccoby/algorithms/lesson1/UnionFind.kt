package com.mccoby.algorithms.lesson1

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
abstract class UnionFind(private val ids: Array<Int>) {
    abstract fun union(p: Int, q: Int)
    abstract fun connected(p: Int, q: Int): Boolean

}