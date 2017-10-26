import org.junit.*;

import static org.junit.Assert.*;


public class MapDirectionTest {

    @Test
    public void testToString() throws Exception {
        assertEquals("Północ", MapDirection.North.toString());
        assertEquals("Południe", MapDirection.South.toString());
        assertEquals("Wschód", MapDirection.East.toString());
        assertEquals("Zachód", MapDirection.West.toString());
    }

    @Test
    public void next() throws Exception {
        assertEquals(MapDirection.West, MapDirection.South.next());
        assertEquals(MapDirection.South, MapDirection.East.next());
        assertEquals(MapDirection.East, MapDirection.North.next());
        assertEquals(MapDirection.North, MapDirection.West.next());
    }

    @Test
    public void previous() throws Exception {
        assertEquals(MapDirection.East, MapDirection.South.previous());
        assertEquals(MapDirection.North, MapDirection.East.previous());
        assertEquals(MapDirection.West, MapDirection.North.previous());
        assertEquals(MapDirection.South, MapDirection.West.previous());
    }

}