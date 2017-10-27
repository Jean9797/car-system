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
    }


    @Override
    public boolean canMoveTo(Position position) {
        return false;
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
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        return null;
    }

    @Override
    public String toString(){
        return visual.dump(this, this.leftDownMapCorner, this.rightUpMapCorner);
    }
}
