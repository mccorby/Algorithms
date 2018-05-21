package com.mccorby.algorithms.lesson4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class Solver {

    private MinPQ<Board> pq;
    private int moves = 0;
    private Board predecessor;
    private ArrayList<Board> solution;

    /**
     * Find a solution to the initial board (using the A* algorithm)
     *
     * @param initial
     */
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Initial board must not be null");
        }
        pq = new MinPQ<>();
        pq.insert(initial);
        predecessor = null;
        solve();
    }

    /**
     * Is the initial board solvable?
     *
     * @return
     */
    public boolean isSolvable() {
        return true;
    }

    /**
     * Min number of moves to solve initial board; -1 if unsolvable
     *
     * @return
     */
    public int moves() {
        return moves;
    }


    /**
     * Sequence of boards in a shortest solution; null if unsolvable
     *
     * @return
     */
    public Iterable<Board> solution() {
        return solution;
    }

    private void solve() {
        solution = new ArrayList<>();
        Board board = pq.delMin();
        while (!board.isGoal()) {
            solution.add(board);
            predecessor = board;
            moves++;
            for (Board neighbour: board.neighbors()) {
                if (!neighbour.equals(predecessor)) {
                    pq.insert(neighbour);
                }
            }
            board = pq.delMin();
        }
        if (board.isGoal()) {
            solution.add(board);
        }
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}