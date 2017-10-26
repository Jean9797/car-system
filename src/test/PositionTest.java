import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void equals() throws Exception {
        Position coords = new Position(1,1);
        assertTrue(coords.equals(new Position(1,1)));
        assertFalse(coords.equals(new Position(1,2)));
    }

    @Test
    public void testToString() throws Exception {
        Position coords = new Position(1,1);
        assertEquals("(1,1)", coords.toString());
    }

    @Test
    public void smaller() throws Exception {
        Position coords = new Position(1,1);
        assertEquals(true, coords.smaller(new Position(2,2)));
        assertEquals(true, coords.smaller(new Position(1,2)));
        assertEquals(true, coords.smaller(new Position(2,1)));
        assertEquals(true, coords.smaller(new Position(1,1)));
        assertEquals(false, coords.smaller(new Position(1,0)));
        assertEquals(false, coords.smaller(new Position(0,0)));
        assertEquals(false, coords.smaller(new Position(0,1)));
    }

    @Test
    public void larger() throws Exception {
        Position coords = new Position(1,1);
        assertEquals(false, coords.larger(new Position(2,2)));
        assertEquals(false, coords.larger(new Position(1,2)));
        assertEquals(false, coords.larger(new Position(2,1)));
        assertEquals(true, coords.larger(new Position(1,1)));
        assertEquals(true, coords.larger(new Position(1,0)));
        assertEquals(true, coords.larger(new Position(0,0)));
        assertEquals(true, coords.larger(new Position(0,1)));
    }

    @Test
    public void add() throws Exception {
        Position coords = new Position(1,1);
        assertEquals("(2,3)", coords.add(new Position(1,2)).toString());
    }




}