import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {
    @Test
    public void objectAt() throws Exception {
        IWorldMap map = new RectangularMap(4,4);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                assertEquals(null, map.objectAt(new Position(i,j)));
            }
        }
        Car testCar = new Car(map,2,2);
        map.add(testCar);
        assertEquals(testCar, map.objectAt(testCar.getPosition()));
    }

    @Test
    public void isOccupied() throws Exception {
        IWorldMap map = new RectangularMap(4,4);
        assertFalse(map.isOccupied(new Position(2,2)));
        Car testCar = new Car(map,2,2);
        map.add(testCar);
        assertTrue(map.isOccupied(testCar.getPosition()));
    }

    @Test
    public void add() throws Exception {
        IWorldMap map = new RectangularMap(4,4);
        assertTrue(map.add(new Car(map,2,2)));
        assertFalse(map.add(new Car(map,2,2)));
        assertFalse(map.add(new Car(map,5,2)));
        assertFalse(map.add(new Car(map,-1,1)));
    }

    @Test
    public void canMoveTo() throws Exception {
        IWorldMap map = new RectangularMap(4,4);
        assertTrue(map.canMoveTo(new Position(2,2)));
        Car testCar = new Car(map,2,2);
        map.add(testCar);
        assertFalse(map.canMoveTo(testCar.getPosition()));
        assertFalse(map.canMoveTo(new Position(4,5)));
        assertFalse(map.canMoveTo(new Position(-1,2)));
    }

    @Test
    public void run() throws Exception {
        IWorldMap map = new RectangularMap(4,4);
        Car[] cars = new Car[5];
        for(int i = 0; i < 5; i++){
            cars[i] = new Car(map,i,0);
            map.add(cars[i]);
        }
        MoveDirection[] directions = {MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward,
                MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Right,
                MoveDirection.Right, MoveDirection.Right, MoveDirection.Right, MoveDirection.Right, MoveDirection.Right, MoveDirection.Backward};

        map.run(directions);
        for(int i = 0; i < 4; i++){
            assertTrue(map.isOccupied(new Position(i,2)));
        }
        assertTrue(map.isOccupied(new Position(4,1)));
    }
}