import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    @Test
    public void getPosition() throws Exception {
        assertEquals(new Position(2,3), new Car(new RectangularMap(4,4), 2,3).getPosition());
    }

    @Test
    public void testToString() throws Exception {
        Car testCar = new Car(new RectangularMap(4,4));
        assertEquals("^", testCar.toString());
        testCar.move(MoveDirection.Right);
        assertEquals(">", testCar.toString());
        testCar.move(MoveDirection.Right);
        assertEquals("v", testCar.toString());
        testCar.move(MoveDirection.Right);
        assertEquals("<", testCar.toString());
    }

    @Test
    public void move() throws Exception {
        Car testCar = new Car(new RectangularMap(4,4),2,2);
        testCar.move(MoveDirection.Forward);
        assertEquals(new Position(2,3), testCar.getPosition());
        testCar.move(MoveDirection.Forward);
        assertEquals(new Position(2,4), testCar.getPosition());
        testCar.move(MoveDirection.Forward);
        assertEquals(new Position(2,4), testCar.getPosition());


        testCar.move(MoveDirection.Left);
        assertEquals("<", testCar.toString());
        testCar.move(MoveDirection.Backward);
        testCar.move(MoveDirection.Backward);
        assertEquals(new Position(4,4), testCar.getPosition());
        testCar.move(MoveDirection.Backward);
        assertEquals(new Position(4,4), testCar.getPosition());

        testCar.move(MoveDirection.Right);
        assertEquals("^", testCar.toString());
        testCar.move(MoveDirection.Forward);
        assertEquals(new Position(4,4), testCar.getPosition());
    }

}