package com.mccorby.algorithms.lesson3;

import java.util.*;

public class FastCollinearPoints extends Collinear {

    private int numberOfSegments;

    /**
     * Corner cases. Throw a java.lang.IllegalArgumentException if the argument to the constructor is null,
     * if any point in the array is null, or if the argument to the constructor contains a repeated point.
     *
     * @param points
     */
    public FastCollinearPoints(Point[] points) {
        super(points);
    }

    @Override
    public int numberOfSegments() {
        return numberOfSegments;
    }

    @Override
    public LineSegment[] segments() {
        Point[] workingPoints = Arrays.copyOf(points, points.length);
        List<LineSegment> result = new ArrayList<>();
        for (Point current : workingPoints) {
            Point[] copy = Arrays.copyOf(workingPoints, workingPoints.length);

            Arrays.sort(copy, current.slopeOrder());

            int j = 0;
            double previous = 0.0;
            List<Point> collinear = new ArrayList<>(4);
            for (Point p : copy) {
                if (j == 0 || p.slopeTo(current) != previous) {
                    if (collinear.size() >= 3) {
                        collinear.add(current);
                        Collections.sort(collinear);
                        if (current == collinear.get(0)) {
                            result.add(new LineSegment(current, collinear.get(3)));
                        }
                    }
                    collinear.clear();
                }
                collinear.add(p);

                previous = p.slopeTo(current);
                j++;
            }
        }
        numberOfSegments = result.size();
        return result.toArray(new LineSegment[result.size()]);
    }
}
