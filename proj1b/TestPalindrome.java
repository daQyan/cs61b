import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.*/
    static Palindrome palindrome = new Palindrome();

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
    public void testIsPalindrome() {
        boolean a = palindrome.isPalindrome("noon");
        boolean b = palindrome.isPalindrome("haha");
        boolean c = palindrome.isPalindrome("a");
        boolean d = palindrome.isPalindrome("");

        assertEquals(true, a);
        assertEquals(false, b);
        assertEquals(true, c);
        assertEquals(false, d);
    }

    @Test
    public void testIsP2() {
        OffByOne obo = new OffByOne();
        boolean a = palindrome.isPalindrome("flake", obo);
        boolean b = palindrome.isPalindrome("blake", obo);

        assertEquals(true, a);
        assertEquals(false, b);
    }


}
