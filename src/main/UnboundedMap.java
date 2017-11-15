import java.util.ArrayList;

public class UnboundedMap extends AbstractWorldMap implements IWorldMap {
    private ArrayList<HayStack> stacks;

    public UnboundedMap(ArrayList<HayStack> stacks){
        super();
        this.stacks = stacks;
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
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
        return this.visualise.dump(this, new Position(leftDownX,leftDownY), new Position(rightUpX, rightUpY));
    }
}
