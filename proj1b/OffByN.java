import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OffByN implements CharacterComparator {

    public int num;

    public OffByN(int N) {
        num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x-y == num || x-y == -num) {
            return true;
        }
        return false;
    }



}
