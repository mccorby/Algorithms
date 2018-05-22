package com.mccorby.algorithms.lesson4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Solver {

    private boolean canBeSolved;
    private SearchNode solutionNode;

    /**
     * A search node consists of the board, number of moves to reach
     */
    private class SearchNode {
        private int moves;
        private final Board board;
        private SearchNode predecessor;

        public SearchNode(Board initial) {
            moves = 0;
            predecessor = null;
            board = initial;
        }
    }

    private class PriorityOrder implements Comparator<SearchNode> {

        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            int priority1 = o1.board.manhattan() + o1.moves;
            int priority2 = o2.board.manhattan() + o2.moves;
            return Integer.compare(priority1, priority2);
        }
    }

    /**
     * Find a solution to the initial board (using the A* algorithm)
     *
     * @param initial
     */
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException("Initial board must not be null");
        }
        solve(initial);
    }

    /**
     * Is the initial board solvable?
     *
     * @return
     */
    public boolean isSolvable() {
        return canBeSolved;
    }

    /**
     * Min number of moves to solve initial board; -1 if unsolvable
     *
     * @return
     */
    public int moves() {
        return solutionNode != null ? solutionNode.moves : -1;
    }


    /**
     * Sequence of boards in a shortest solution; null if unsolvable
     *
     * @return
     */
    public Iterable<Board> solution() {
        if (isSolvable()) {
            Stack<Board> result = new Stack<>();
            for (SearchNode node = solutionNode; node != null; node = node.predecessor) {
                result.push(node.board);
            }
            return result;
        } else {
            return null;
        }
    }

    private void solve(Board initial) {
        MinPQ<SearchNode> pq = new MinPQ<>(new PriorityOrder());
        pq.insert(new SearchNode(initial));

        SearchNode searchNode = pq.delMin();
        SearchNode twinNode = new SearchNode(searchNode.board.twin());

        MinPQ<SearchNode> twinPQ = new MinPQ<>(new PriorityOrder());
        twinPQ.insert(twinNode);
        SearchNode twin = twinPQ.delMin();

        while (!searchNode.board.isGoal() && !twin.board.isGoal()) {
            for (Board neighbour : searchNode.board.neighbors()) {
                if (searchNode.predecessor == null || !neighbour.equals(searchNode.predecessor.board)) {
                    SearchNode sn = new SearchNode(neighbour);
                    sn.moves = searchNode.moves + 1;
                    sn.predecessor = searchNode;
                    pq.insert(sn);
                }
            }
            searchNode = pq.delMin();

            for (Board neighbour : twin.board.neighbors()) {
                if (twin.predecessor == null || !neighbour.equals(twin.predecessor.board)) {
                    SearchNode sn = new SearchNode(neighbour);
                    sn.moves = twin.moves + 1;
                    sn.predecessor = twin;
                    twinPQ.insert(sn);
                }
            }
            twin = twinPQ.delMin();
        }
        if (searchNode.board.isGoal()) {
            canBeSolved = true;
            solutionNode = searchNode;
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