package com.mccorby.algorithms.lesson1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Run a MonteCarlo simulation to obtain the values of thresholds
 */
public class PercolationStats {

    private final int size;

    private double[] thresholds;
    /**
     * Perform trials independent experiments on an n-by-n grid
     *
     * @param n
     * @param trials
     */
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials < -0) {
            throw new IllegalArgumentException();
        }
        size = n;
        thresholds = new double[trials];

        runTrials(n, trials);
    }

    private void runTrials(int n, int trials) {
        for (int i = 0; i < trials; i++) {
            thresholds[i] = getPercolationThreshold(n);
        }
    }

    private double getPercolationThreshold(int n) {
        Percolation percolation = new Percolation(n);
        int rounds = 0;
        while (!percolation.percolates()) {
            int row = StdRandom.uniform(size) + 1;
            int col = StdRandom.uniform(size) + 1;

            if (!percolation.isOpen(row, col)) {
                percolation.open(row, col);
                rounds++;
            }

        }
        return (double) rounds / (double) (n * n);
    }

    /**
     * Sample mean of percolation threshold
     *
     * @return
     */
    public double mean() {
        return StdStats.mean(thresholds);
    }


    /**
     * Sample standard deviation of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    /**
     * Low  endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(thresholds.length));
    }

    /**
     * High endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(thresholds.length));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n, trials);
        System.out.println("mean = " + stats.mean());
        System.out.println("stddev = " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
}
