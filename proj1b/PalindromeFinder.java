/** This class outputs all palindromes in the words file in the current directory. */
import java.util.Scanner;
import edu.princeton.cs.algs4.*;
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        CharacterComparator cc = new OffByN(N);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word,cc)) {
                System.out.println(word);
            }
        }
    }
}
