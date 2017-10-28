import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private MapVisualizer visual;
    private ArrayList<Car> cars;
    private Position leftDownMapCorner;
    private Position rightUpMapCorner;

    public RectangularMap(int width, int height){
        this.leftDownMapCorner = new Position(0,0);
        this.rightUpMapCorner = new Position(width, height);
        visual = new MapVisualizer();
        cars = new ArrayList<Car>();
    }


    @Override
    public boolean canMoveTo(Position position) {
        return position.smaller(rightUpMapCorner) && position.larger(leftDownMapCorner) && !isOccupied(position);
    }

    @Override
    public boolean add(Car car) {
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {

    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car vehicle : cars ){
            if(vehicle.getCurrentPosition().equals(position)) return vehicle;
        }
        return null;
    }

    @Override
    public String toString(){
        return visual.dump(this, this.leftDownMapCorner, this.rightUpMapCorner);
    }
}
