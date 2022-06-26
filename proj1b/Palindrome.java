public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> curr = new LinkedListDeque<>();
        for (int i = 0; i< word.length(); i++) {
            curr.addLast(word.charAt(i));
        }
        return curr;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> curr = wordToDeque(word);
        if (curr.size() == 0) {
            return false;
        }

        while (curr.size() > 1) {
            if (curr.removeFirst() != curr.removeLast()) return false;
        }
        return true;
    }

    //TODO
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> curr = wordToDeque(word);

        if (curr.size() == 0) {
            return false;
        }

        while (curr.size() > 1) {
            char x = curr.removeFirst();
            char y = curr.removeLast();
            boolean result =  cc.equalChars(x, y);
            return result;
        }
        return true;

    }


}
