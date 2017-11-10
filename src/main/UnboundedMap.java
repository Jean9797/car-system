import java.util.ArrayList;

public class UnboundedMap implements IWorldMap {
    private MapVisualizer visualize;
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<HayStack> stacks;

    public UnboundedMap(ArrayList<HayStack> stacks){
        this.stacks = stacks;
        this.visualize = new MapVisualizer();
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public boolean add(Car car) {
        if(!isOccupied(car.getPosition())){
            cars.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if(cars.size() == 0) return;
        for(int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car vehicle : cars){
            if(position.equals(vehicle.getPosition())) return vehicle;
        }
        for(HayStack stack : stacks){
            if (position.equals(stack.getPosition())) return stack;
        }
        return null;
    }

    @Override
    public String toString() {
        int leftDownX = Integer.MAX_VALUE;
        int leftDownY = Integer.MAX_VALUE;
        int rightUpX = Integer.MIN_VALUE;
        int rightUpY = Integer.MIN_VALUE;;
        for(Car vehicle : cars){
            Position currentPosition = vehicle.getPosition();
            if (currentPosition.x > rightUpX) rightUpX = currentPosition.x;
            if (currentPosition.y > rightUpY) rightUpY = currentPosition.y;
            if (currentPosition.x < leftDownX) leftDownX = currentPosition.x;
            if (currentPosition.y < leftDownY) leftDownY = currentPosition.y;
        }
        for(HayStack stack : stacks){
            Position currentPosition = stack.getPosition();
            if (currentPosition.x > rightUpX) rightUpX = currentPosition.x;
            if (currentPosition.y > rightUpY) rightUpY = currentPosition.y;
            if (currentPosition.x < leftDownX) leftDownX = currentPosition.x;
            if (currentPosition.y < leftDownY) leftDownY = currentPosition.y;
        }
        return this.visualize.dump(this, new Position(leftDownX,leftDownY), new Position(rightUpX, rightUpY));
    }
}
