import org.junit.Test;
import static org.junit.Assert.*;

public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        if (x-y == 1 || x-y == -1) {
            return true;
        }
        return false;
    }



    @Test
    public void testEqualChars() {
        OffByOne obo = new OffByOne();
        boolean a = obo.equalChars('a', 'b');
        boolean b = obo.equalChars('a', 'e');
        assertEquals(true, a);
        assertEquals(false, b);
    }
    @Test
    public void testEqualChars2() {
        OffByN obo = new OffByN(5);
        boolean a = obo.equalChars('a', 'f');
        boolean b = obo.equalChars('a', 'e');
        assertEquals(true, a);
        assertEquals(false, b);
    }


}
