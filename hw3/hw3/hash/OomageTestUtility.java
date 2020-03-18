package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        double [] bucket = new double[M];
        for (double t : bucket) {
            t = 0.0;
        }
        double length = oomages.size();
        for (Oomage s : oomages) {
            int bucketNum = (s.hashCode() & 0x7FFFFFFF) % M;
            bucket[bucketNum] += 1;
        }
        for (double t : bucket) {
            if (t < (length / 50) || t > (length / 2.5)) {
                return false;
            }
        }
        return true;
    }
}
