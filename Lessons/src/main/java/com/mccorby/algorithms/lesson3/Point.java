package com.mccorby.algorithms.lesson3;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param x the <em>x</em>-coordinate of the point
     * @param y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }


    /**
     * Compare two points by y-coordinates, breaking ties by x-coordinates
     * Formally, the invoking point (x0, y0) is less than the argument point (x1, y1)
     * if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param that
     * @return
     */
    @Override
    public int compareTo(Point that) {
        if (this.y < that.y) {
            return -1;
        } else if (this.y > that.y) {
            return 1;
        } else if (this.x < that.x) {
            return -1;
        } else if (this.x > that.x) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * The slope between this point and that point
     *
     * @param that
     * @return
     */
    public double slopeTo(Point that) {
        if (this.x != that.x) {
            if (this.y != that.y) {
                return (double) (this.y - that.y) / (this.x - that.x);
            } else {
                return +0.0;
            }
        } else if (this.y != that.y) {
            return Double.POSITIVE_INFINITY;
        } else {
            return Double.NEGATIVE_INFINITY;
        }
    }

    /**
     * Compare two points by slopes they make with this point
     *
     * @return
     */
    public Comparator<Point> slopeOrder() {
        return SLOPE_ORDER;
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    private class SlopeOrder implements Comparator<Point> {
        @Override
        public int compare(Point p, Point q) {
            double pSlope = slopeTo(p);
            double qSlope = slopeTo(q);

            if (pSlope > qSlope) return 1;
            else if (pSlope < qSlope) return -1;
            else return 0;

        }
    }
}
