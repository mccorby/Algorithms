package com.mccorby.algorithms.lesson3;

public abstract class Collinear {

    protected Point[] points;

    public Collinear(Point[] points) {
        checkArgumentIsCorrect(points);
        this.points = points;

    }

    abstract int numberOfSegments();

    abstract LineSegment[] segments();

    private void checkArgumentIsCorrect(Point[] points) throws IllegalArgumentException {
        if (points == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        for (Point p: points) {
            if (p == null) {
                throw new IllegalArgumentException("Point cannot be null");
            }
            if (isDuplicated(points, p)) {
                throw new IllegalArgumentException("Point " + p + " is duplicated");
            }
        }
    }

    private boolean isDuplicated(Point[] points, Point p) {
        int count = 0;
        for (Point q: points) {
            if (q == null) {
                throw new IllegalArgumentException("Point cannot be null");
            }
            if (p.compareTo(q) == 0) {
                count++;
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}
