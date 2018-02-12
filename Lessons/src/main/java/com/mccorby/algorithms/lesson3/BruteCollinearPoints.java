package com.mccorby.algorithms.lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Examines 4 points at a time and checks whether they all lie on the same line segment,
 * returning all such line segments.
 * To check whether the 4 points p, q, r, and s are collinear,
 * check whether the three slopes between p and q, between p and r, and between p and s are all equal.
 */
public class BruteCollinearPoints extends Collinear {

    private int numberOfSegments;

    /**
     * Corner cases. Throw a java.lang.IllegalArgumentException if the argument to the constructor is null,
     * if any point in the array is null, or if the argument to the constructor contains a repeated point.
     *
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {
        super(points);
    }

    @Override
    public int numberOfSegments() {
        return numberOfSegments;
    }

    /**
     * If 4 points appear on a line segment in the order p→q→r→s,
     * then you should include either the line segment p→s or s→p (but not both)
     * and you should not include subsegments such as p→r or q→r
     *
     * Performance requirement. The order of growth of the running time of your program should be n^4 in the worst case
     * and it should use space proportional to n plus the number of line segments returned.
     *
     * @return segment includes each line segment containing 4 points exactly once
     */
    @Override
    public LineSegment[] segments() {
        Point[] workingPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(workingPoints);
        List<LineSegment> result = new ArrayList<>();
        for (int i = 0; i < workingPoints.length - 3; i++) {
            for (int j = i + 1; j < workingPoints.length - 2; j++) {
                for (int k = j + 1; k < workingPoints.length - 1; k++) {
                    if (workingPoints[i].slopeTo(workingPoints[j]) == workingPoints[j].slopeTo(workingPoints[k])) {
                        for (int m = k + 1; m < workingPoints.length; m++) {
                            if (workingPoints[j].slopeTo(workingPoints[k]) == workingPoints[k].slopeTo(workingPoints[m])) {
                                result.add(new LineSegment(workingPoints[i], workingPoints[m]));
                            }
                        }
                    }
                }
            }
        }
        numberOfSegments = result.size();
        return result.toArray(new LineSegment[result.size()]);

    }
}
