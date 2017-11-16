import java.util.ArrayList;

abstract public class AbstractWorldMap implements IWorldMap {
    protected MapVisualizer visualise = new MapVisualizer();
    protected ArrayList<Car> cars = new ArrayList<>();

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    public boolean add(Car car) {
        if(canMoveTo(car.getPosition())){
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if(cars.size() == 0) return;
        for(int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);        //iterujemy po tablicy directions oraz jednocześnie po tablicy cars
        }
    }

    @Override
    abstract public boolean canMoveTo(Position position);

    @Override
    abstract public Object objectAt(Position position);

    @Override
    abstract public String toString();
}
