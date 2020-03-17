package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int L;
    private int[][] world;
    private WeightedQuickUnionUF QF;
    private int opensite;
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be greater than zero");
        } else {
            L = N;
            opensite = 0;
            world = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    world[i][j] = 0;
                }
            }
            QF = new WeightedQuickUnionUF(N * N);
        }
    }

    // convert the 2d Coordinate to the id in QF
    private int coorTrans(int row, int col) {
        return row * L + col;
    }

    // to make connect when neighbors are open
    private void makeConnect(int row, int col) {
        int target = coorTrans(row, col);
        if (isOpen(row - 1, col)) {
            QF.union(target, coorTrans(row - 1, col));
        }
        if (isOpen(row + 1, col)) {
            QF.union(target, coorTrans(row + 1, col));
        }
        if (isOpen(row, col - 1)) {
            QF.union(target, coorTrans(row, col - 1));
        }
        if (isOpen(row, col + 1)) {
            QF.union(target, coorTrans(row, col + 1));
        }

    }
    public boolean isOpen(int row, int col) {
        if (row == -1 || row == L || col == -1 || col == L) {
            return false;
        } else {
            return world[row][col] == 1;
        }
    }

    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            world[row][col] = 1;
            opensite += 1;
            makeConnect(row, col);


        }
    }

    public boolean isFull(int row, int col) {
        int target = coorTrans(row, col);
        for (int j = 0; j < L; j++) {
            if (isOpen(0, j)) {
                if (QF.connected(target, j)) {
                    return true;
                }
            }
        }
        return  false;
    }

    public int numberOfOpenSites() {
        return opensite;
    }

    public boolean percolates() {
        for (int j = 0; j < L; j++) {
            if (isFull(L - 1, j)) {
                return true;
            }
        }
        return false;
    }

}

