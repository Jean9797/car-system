import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnboundedMapTest {
    @Test
    public void objectAt() throws Exception {
        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(6,7)));
        IWorldMap map = new UnboundedMap(stacks);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                assertEquals(null, map.objectAt(new Position(i,j)));
            }
        }
        Car testCar = new Car(map,2,2);
        map.add(testCar);
        assertEquals(testCar, map.objectAt(testCar.getPosition()));
        assertEquals(stacks.get(0), map.objectAt(stacks.get(0).getPosition()));
    }

    @Test
    public void isOccupied() throws Exception {
        ArrayList<HayStack> stacks = new ArrayList<>();
        IWorldMap map = new UnboundedMap(stacks);
        assertFalse(map.isOccupied(new Position(2,2)));
        Car testCar = new Car(map,2,2);
        map.add(testCar);
        assertTrue(map.isOccupied(testCar.getPosition()));
    }

    @Test
    public void add() throws Exception {
        ArrayList<HayStack> stacks = new ArrayList<>();
        IWorldMap map = new UnboundedMap(stacks);
        assertTrue(map.add(new Car(map,2,2)));
        assertFalse(map.add(new Car(map,2,2)));
        assertTrue(map.add(new Car(map,-1,1)));
    }

    @Test
    public void canMoveTo() throws Exception {
        ArrayList<HayStack> stacks = new ArrayList<>();
        IWorldMap map = new UnboundedMap(stacks);
        assertTrue(map.canMoveTo(new Position(2,2)));
        Car testCar = new Car(map,2,2);
        map.add(testCar);
        assertFalse(map.canMoveTo(testCar.getPosition()));
    }

    @Test
    public void run() throws Exception {
        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(0,1)));
        IWorldMap map = new UnboundedMap(stacks);
        Car[] cars = new Car[5];
        for(int i = 0; i < 5; i++){
            cars[i] = new Car(map,i,0);
            map.add(cars[i]);
        }
        MoveDirection[] directions = {MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward,
                MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Forward, MoveDirection.Right,
                MoveDirection.Right, MoveDirection.Right, MoveDirection.Right, MoveDirection.Right, MoveDirection.Right, MoveDirection.Backward};

        map.run(directions);
        assertTrue(map.isOccupied(new Position(-1,0)));
        assertTrue(map.isOccupied(new Position(1,2)));
        assertTrue(map.isOccupied(new Position(2,2)));
        assertTrue(map.isOccupied(new Position(3,2)));
        assertTrue(map.isOccupied(new Position(4,1)));
    }
}
