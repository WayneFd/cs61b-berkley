package hw2;

//import java.sql.Time;
//import java.util.Map;

public class PercolationStats {
    private int times;
    private double[] opened;
    private Percolation expe;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        times = T;
        opened = new double[T];
        for (int i = 0; i < T; i++) {
            expe  = pf.make(N);
            while (!expe.percolates()) {
                int row = (int) (Math.random() * N);
                int col = (int) (Math.random() * N);
                expe.open(row, col);
            }
            opened[i] = expe.numberOfOpenSites();
        }
    }
    public double mean() {
        double mean = 0.0;
        for (int i = 0; i < opened.length; i++) {
            mean += opened[i];
        }
        return mean / times;
    }

    public double stdddev() {
        double mean = mean();
        double sigma = 0.0;
        for (int i = 0; i < opened.length; i++) {
            sigma += Math.pow((opened[i] - mean), 2);
        }
        return sigma / (times - 1);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stdddev() / Math.sqrt(times);
    }

    public double confidenceHige() {
        return mean() + 1.96 * stdddev() / Math.sqrt(times);
    }

}
