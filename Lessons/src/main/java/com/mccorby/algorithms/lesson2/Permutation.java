package com.mccorby.algorithms.lesson2;

import edu.princeton.cs.algs4.StdOut;

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);

        String[] allStrings = new String[]{"AA", "BB", "BB", "BB", "BB", "BB", "CC", "DD"};
        if (k > allStrings.length) {
            throw new IllegalArgumentException("k must be less that " + allStrings.length);
        }
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        for (String s : allStrings) {
            queue.enqueue(s);
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(queue.dequeue());
        }
    }
}
