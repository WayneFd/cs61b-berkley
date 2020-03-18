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
            opened[i] = (double) expe.numberOfOpenSites() / (N * N);
        }
    }
    public double mean() {
        double mean = 0.0;
        for (int i = 0; i < opened.length; i++) {
            mean += opened[i];
        }
        return mean / times;
    }

    public double stddev() {
        double mean = mean();
        double sigma = 0.0;
        for (int i = 0; i < opened.length; i++) {
            sigma += Math.pow((opened[i] - mean), 2);
        }
        return sigma / (times - 1);
    }

    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(times);
    }

    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(times);
    }

//    public static void main(String[] args) {
//        double[] time = new double[200];
//        PercolationFactory pf = new PercolationFactory();
//        for (int N = 1; N <= 200; N++) {
//            Stopwatch sw = new Stopwatch();
//            PercolationStats test = new PercolationStats(N, 1, pf);
//            time[N - 1] = sw.elapsedTime();
//
//        }
//        StdDraw.setXscale(0, 40);
//        StdDraw.setYscale(0, 2);
//        StdDraw.setPenRadius(0.01);
//        for (int i = 0; i < 200; i++) {
//            StdDraw.point(i, time[i]);
//        }
//
////
////        System.out.println(test.mean());
////        System.out.println(test.stddev());
////        System.out.println(test.confidenceHige());
////        System.out.println(test.confidenceLow());
////        System.out.println(test.opened[1]);
//    }


}
