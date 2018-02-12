package com.mccorby.algorithms.lesson3

internal class BruteCollinearPointsTest: CollinearPointsTest() {
    override fun getImplementation(points: Array<Point?>): Collinear {
        return BruteCollinearPoints(points)
    }
}