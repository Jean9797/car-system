import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap {
    protected MapVisualizer visualise = new MapVisualizer();
    protected ArrayList<Car> cars = new ArrayList<>();
    protected Map<Position, IMapElement> elements = new HashMap<>();

    abstract public boolean canMoveTo(Position position);

    @Override
    public boolean add(Car car) {
        if(canMoveTo(car.getPosition())){
            cars.add(car);
            elements.put(car.getPosition(), car);
            return true;
        }
        throw new IllegalArgumentException(car.getPosition().toString() + " is already busy");
    }

    @Override
    public void run(MoveDirection[] directions) {
        if(cars.size() == 0) return;
        for(int i = 0; i < directions.length; i++){
            Car currentCar = cars.get(i%cars.size());
            Position currentPosition = currentCar.getPosition();
            currentCar.move(directions[i]);        //iterujemy po tablicy directions oraz jednocześnie po tablicy cars
            if(currentPosition.equals(currentCar.getPosition())) continue;
            elements.remove(currentPosition);
            elements.put(currentCar.getPosition(), currentCar);
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    abstract public Object objectAt(Position position);

    @Override
    abstract public String toString();
}
