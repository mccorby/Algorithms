package com.mccorby.algorithms.lesson3

internal class FastCollinearPointsTest : CollinearPointsTest() {
    override fun getImplementation(points: Array<Point?>): Collinear {
        return FastCollinearPoints(points)
    }
}