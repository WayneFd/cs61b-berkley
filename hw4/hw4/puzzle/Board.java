package hw4.puzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

public class Board implements WorldState {
    private int N;
    private int[][] tile;
    private static final int BLANK = 0;
    public Board(int[][] tiles){
        this.N = tiles.length;
        this.tile = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.tile[i][j] = tiles[i][j];
            }
        }
    }
    public int tileAt(int i, int j){
        if (i < 0 || j < 0 || i >= N || j >= N) {
            throw  new IndexOutOfBoundsException();
        } else {
            return this.tile[i][j];
        }
    }
    public int size(){
        return N;}
    public Iterable<WorldState> neighbors(){
        Queue<WorldState> neigh = new LinkedList<>();
        int[][] tiles = new int[N][N];
        int row = -1;
        int col = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tiles[i][j] = this.tile[i][j];
                if (this.tile[i][j] == BLANK) {
                    row = i;
                    col = j;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Math.abs(i - row) + Math.abs(j - col) - 1 == 0 ) {
                    tiles[i][j] = BLANK;
                    tiles[row][col] = tile[i][j];
                    Board neighbor = new Board(tiles);
                    neigh.add(neighbor);
                    tiles[i][j] = tile[i][j];
                    tiles[row][col] = BLANK;

                }
            }
        }
        return neigh;
    }
    public int hamming(){
        int ham = 0;
        int expect = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(expect== N * N) {
                    break;
                }
                if (tile[i][j] != expect) {
                    ham ++;
                }
                expect ++;
            }
        }
        return ham;
    }
    public int manhattan(){
        int man = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tile[i][j] == BLANK) {
                    continue;
                }
                int k = tile[i][j];
                int row = (k - 1) % N;
                int col = k - row * N - 1;
                man += Math.abs(row - i) + Math.abs(col - j);
            }
        }
        return man;
    }
    public int estimatedDistanceToGoal(){return this.hamming();}
    public boolean equals(Object y){
        if (this == y) {
            return true;
        }
        if (y == null || y.getClass() != this.getClass()) {
            return false;
        }
        Board other = (Board) y;
        if (N != other.N) {
            return false;
        }
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N; j++) {
                if (this.tileAt(i, j) != other.tileAt(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /** Returns the string representation of the board. 
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
