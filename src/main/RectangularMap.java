import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private MapVisualizer visualising;
    private ArrayList<Car> cars;
    private Position leftDownMapCorner;
    private Position rightUpMapCorner;

    public RectangularMap(int width, int height){
        this.leftDownMapCorner = new Position(0,0);
        this.rightUpMapCorner = new Position(width, height);
        visualising = new MapVisualizer();
        cars = new ArrayList<>();
    }


    @Override
    public boolean canMoveTo(Position position) {
        return position.smaller(rightUpMapCorner) && position.larger(leftDownMapCorner) && !isOccupied(position);
    }

    @Override
    public boolean add(Car car) {
        Position carPosition = car.getPosition();
        if(!isOccupied(carPosition) && carPosition.larger(leftDownMapCorner) && carPosition.smaller(rightUpMapCorner)) {
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
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car vehicle : cars ){
            Position currentPosition = vehicle.getPosition();
            if(currentPosition.equals(position) && currentPosition.larger(leftDownMapCorner) && currentPosition.smaller(rightUpMapCorner)) return vehicle;
        }
        return null;
    }

    @Override
    public String toString(){
        return visualising.dump(this, this.leftDownMapCorner, this.rightUpMapCorner);
    }
}
