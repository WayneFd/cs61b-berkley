public class Palindrome {
    /* transform a word to a deque */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque= new LinkedListDeque<>();
        for (int i = 0; i< word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    /* return true if the given word is Palindrome */
    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque);
    }

    /* compare the char of the given index */
    private boolean isPalindrome(Deque<Character> word) {
        if (word.size() == 0 || word.size() == 1) {
            return true;
        }
        if (word.removeFirst() != word.removeLast()) {
            return false;
        } else {
            return isPalindrome(word);
        }

    }

    /* return true if the given word is offbyone Palindrome */
    public boolean isPalindrome(String word,CharacterComparator cc) {
        return isPalindrome(wordToDeque(word),cc);
    }

    /* help function */
    private boolean isPalindrome(Deque<Character> word,CharacterComparator cc) {
        if (word.size() <= 1) {
            return true;
        } else {
            return (cc.equalChars(word.removeFirst(), word.removeLast()) && isPalindrome(word, cc));
        }
    }

}
