import java.util.*;
class Solution {
        public static boolean searchMatrix(int[][] matrix, int target) {
            int n = matrix.length;
            if (n==0) return false;
            int m = matrix[0].length;
            if (m == 0) return false;
            int col = getcol(matrix, target, 0, m-1);
            int row = getrow(matrix, target, 0, n-1);
            return search(matrix, target, 0, n-1,col)||searchrow(matrix, target, 0, m-1,row);

        }
        private static int getcol(int[][] matrix, int target, int s, int e) {
            while(s<e) {
                int mid = s + 1+(e - s) /2;
                if (matrix[0][mid] == target) {
                    s = mid;
                    break;
                }
                if (matrix[0][mid] > target) {
                    e = mid - 1;
                } else {
                    s = mid;
                }
            }
            return s;
        }
        private static int getrow(int[][] matrix, int target, int s, int e) {
            while(s<e) {
                int mid = s + 1+(e - s) /2;
                if (matrix[mid][0] == target) {
                    s = mid;
                    break;
                }
                if (matrix[mid][0] > target) {
                    e = mid - 1;
                } else {
                    s = mid;
                }
            }
            return s;
        }
        private static boolean searchrow(int[][] matrix ,int target, int s, int e, int row){
            while(s<e) {
                int mid = s + (e-s) /2;
                if (matrix[row][mid] == target) {
                    s = mid;
                    break;
                }
                if(matrix[row][mid] > target) {
                    e = mid - 1;
                } else {
                    s = mid +1;
                }
            }
            return matrix[row][s] == target;
        }

        private static boolean search(int[][] matrix ,int target, int s, int e, int col){
            while(s<e) {
                int mid = s + (e-s) /2;
                if (matrix[mid][col] == target) {
                    s = mid;
                    break;
                }
                if(matrix[mid][col] > target) {
                    e = mid - 1;
                } else {
                    s = mid +1;
                }
            }
            return matrix[s][col] == target;
    }



    public static void main(String[] args) {
        System.out.println(26/26);
  }
}
