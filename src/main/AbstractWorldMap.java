import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected MapVisualizer visualise = new MapVisualizer();
    protected ArrayList<Car> cars = new ArrayList<>();
    protected Map<Position, IMapElement> elements = new HashMap<>();

    public void positionChanged(Position oldPosition, Position newPosition){
        Car vehicle = (Car) elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition, vehicle);
    }

    abstract public boolean canMoveTo(Position position);

    public boolean add(Car car) {
        if(canMoveTo(car.getPosition())){
            cars.add(car);
            elements.put(car.getPosition(), car);
            car.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException(car.getPosition().toString() + " is already busy");
    }

    public void run(MoveDirection[] directions) {
        if(cars.size() == 0) return;
        for(int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);        //iterujemy po tablicy directions oraz jednocześnie po tablicy cars
        }
    }

    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    abstract public Object objectAt(Position position);

    @Override
    abstract public String toString();
}
