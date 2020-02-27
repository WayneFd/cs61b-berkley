import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        String caseone = "a";
        assertTrue(palindrome.isPalindrome(caseone));
        String casetwo = "answer";
        assertFalse(palindrome.isPalindrome(casetwo));
        String casethree = "noon";
        assertTrue(palindrome.isPalindrome(casethree));
        String casefour = "abcba" ;
        assertTrue(palindrome.isPalindrome(casefour));
        String casefive = "ABCDCba";
        assertFalse(palindrome.isPalindrome(casefive));
        String casesix = "";
        assertTrue(palindrome.isPalindrome(casesix));
        String caseseven = "Wayne";
        assertFalse(palindrome.isPalindrome(caseseven));
    }
    @Test
    public void testisPalindromeoff() {
        assertTrue(palindrome.isPalindrome("flake",cc));
        assertFalse(palindrome.isPalindrome("aha",cc));

    }
}
