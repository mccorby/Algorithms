package com.mccorby.algorithms.lesson3;

import java.util.Comparator;

public class Point extends java.awt.Point implements Comparable<Point> {

    public Point(int x, int y) {
        super(x, y);
    }

    /**
     * Compare two points by y-coordinates, breaking ties by x-coordinates
     * Formally, the invoking point (x0, y0) is less than the argument point (x1, y1)
     * if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     * @param that
     * @return
     */
    @Override
    public int compareTo(Point that) {
        int result;
        if (this.y < that.y || (this.y == that.y && this.x < that.x)) {
            result = -1;
        } else {
            result = Math.min(1, this.y - that.y);
        }
        return result;
    }

    /**
     * The slope between this point and that point
     * @param that
     * @return
     */
    public double slopeTo(Point that) {
        if (that.x == this.x) {
            if (that.y > this.y) {
                return java.lang.Double.POSITIVE_INFINITY;
            } else if (that.y < this.y) {
                return java.lang.Double.NEGATIVE_INFINITY;
            } else {
                return 0.0;
            }
        }
        return (that.y - this.y) / (that.x - this.x);
    }

    /**
     * Compare two points by slopes they make with this point
     * @return
     */
    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double diff = o1.slopeTo(o2);
                if (diff > 0) {
                    return 1;
                } else if (diff < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }
}
