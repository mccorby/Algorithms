package com.mccorby.algorithms.lesson4;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int[] blocks;
    private final int dimension;
    private int manhattanDistance = -1;

    private int zeroPosition = -1;

    /**
     * Construct a board from an n-by-n array of blocks
     * (where blocks[i][j] = block in row i, column j)
     *
     * @param blocks
     */
    public Board(int[][] blocks) {
        dimension = blocks[0].length;
        this.blocks = new int[blocks.length * blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                int value = blocks[i][j];
                this.blocks[fromMatrixPosition(i, j)] = value;
                if (value == 0) {
                    zeroPosition = fromMatrixPosition(i, j);
                }
            }
        }
    }
    
    /**
     * Board dimension n
     *
     * @return
     */
    public int dimension() {
        return dimension;
    }

    /**
     * Number of blocks out of place
     *
     * @return
     */
    public int hamming() {
        int distance = 0;
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] != 0 && blocks[i] != (i + 1)) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * Sum of Manhattan distances between blocks and goal
     *
     * @return
     */
    public int manhattan() {
        if (manhattanDistance == -1) {
            manhattanDistance = 0;
            for (int i = 0; i < blocks.length; i++) {
                int value = blocks[i];
                if (value != 0) {
                    // Where should it be
                    int row = (value - 1) / dimension;
                    int column = Math.max(0, (value - 1) - (dimension * row));

                    // Where it is actually
                    int actualRow = i / dimension;
                    int actualColumn = Math.max(0, i - (dimension * actualRow));

                    manhattanDistance += (Math.abs(row - actualRow) + Math.abs(column - actualColumn));
                }
            }
        }
        return manhattanDistance;
    }

    private int[] toMatrixPosition(int position) {
        int[] matrixPosition = new int[2];
        matrixPosition[0] = position / dimension;
        matrixPosition[1] = position % dimension;
        return matrixPosition;
    }

    private int fromMatrixPosition(int row, int col) {
        return row * dimension + col;
    }

    /**
     * Is this board the goal board?
     *
     * @return
     */
    public boolean isGoal() {
        // The last item should be 0 so do not consider it
        for (int i = 0; i < blocks.length - 1; i++) {
            if (blocks[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * A board that is obtained by exchanging any pair of blocks
     *
     * @return
     */
    public Board twin() {
        int[][] newBlocks = createNewBlocks();

        swapNonZeros(newBlocks);

        return new Board(newBlocks);
    }

    private int[][] createNewBlocks() {
        int[][] newBlocks = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                newBlocks[i][j] = blocks[fromMatrixPosition(i, j)];
            }
        }
        return newBlocks;
    }

    private void swapNonZeros(int[][] newBlocks) {
        int[] position1 = new int[]{0, 0};
        int[] position2 = new int[]{1, 0};
        int value = newBlocks[0][0];
        int value2 = newBlocks[1][0];
        if (value == 0) {
            value = newBlocks[0][1];
            position1[0] = 0;
            position1[1] = 1;
        }

        if (value2 == 0) {
            value2 = newBlocks[1][1];
            position2[0] = 1;
            position2[1] = 1;
        }

        newBlocks[position1[0]][position1[1]] = value2;
        newBlocks[position2[0]][position2[1]] = value;
    }

    /**
     * w
     * Does this board equal y?
     *
     * @param y
     * @return
     */
    @Override
    public boolean equals(Object y) {
        if (this == y) return true;
        if (y == null || getClass() != y.getClass()) return false;

        Board board = (Board) y;
        if (board.dimension != dimension) return false;

        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] != board.blocks[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * All neighboring boards
     *
     * @return
     */
    public Iterable<Board> neighbors() {
        for (int i = 0; i < blocks.length; i++)    // search for empty block
            if (blocks[i] == 0) {
                zeroPosition = i;
                break;
            }
        List<Board> neighborList = new ArrayList<>();
        int[] zeroInMatrix = toMatrixPosition(zeroPosition);
        // Swap with above block
        int swapElementRow;
        int swapElementCol;
        if (zeroInMatrix[0] != 0) {
            swapElementRow = zeroInMatrix[0] - 1;
            swapElementCol = zeroInMatrix[1];
            neighborList.add(createNeighbour(zeroInMatrix, swapElementRow, swapElementCol));
        }
        // Swap with block below
        if (zeroInMatrix[0] != dimension - 1) {
            swapElementRow = zeroInMatrix[0] + 1;
            swapElementCol = zeroInMatrix[1];
            neighborList.add(createNeighbour(zeroInMatrix, swapElementRow, swapElementCol));
        }
        // Swap with block to the left
        if (zeroInMatrix[1] != 0) {
            swapElementRow = zeroInMatrix[0];
            swapElementCol = zeroInMatrix[1] - 1;
            neighborList.add(createNeighbour(zeroInMatrix, swapElementRow, swapElementCol));
        }
        // Swap with block to the right
        if (zeroInMatrix[1] != dimension - 1) {
            swapElementRow = zeroInMatrix[0];
            swapElementCol = zeroInMatrix[1] + 1;
            neighborList.add(createNeighbour(zeroInMatrix, swapElementRow, swapElementCol));
        }

        return neighborList;
    }

    private Board createNeighbour(int[] zeroInMatrix, int swapElementRow, int swapElementCol) {
        int[][] newBlocks = createNewBlocks();
        int flatPosition = fromMatrixPosition(swapElementRow, swapElementCol);
        newBlocks[zeroInMatrix[0]][zeroInMatrix[1]] = blocks[flatPosition];
        newBlocks[swapElementRow][swapElementCol] = 0;
        return new Board(newBlocks);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(dimension).append("\n");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                sb.append(blocks[fromMatrixPosition(i, j)]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
