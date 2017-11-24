import java.util.ArrayList;

public class UnboundedMap extends AbstractWorldMap{
    private ArrayList<HayStack> stacks;

    public UnboundedMap(ArrayList<HayStack> stacks){
        super();
        this.stacks = stacks;
        for(HayStack stack : stacks){
            elements.put(stack.getPosition(), stack);
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public Object objectAt(Position position) {
        return elements.get(position);
    }

    @Override
    public String toString() {
        int leftDownX = Integer.MAX_VALUE;
        int leftDownY = Integer.MAX_VALUE;
        int rightUpX = Integer.MIN_VALUE;
        int rightUpY = Integer.MIN_VALUE;
        for(IMapElement element : elements.values()){
            Position currentPosition = element.getPosition();
            if (currentPosition.x > rightUpX) rightUpX = currentPosition.x;
            if (currentPosition.y > rightUpY) rightUpY = currentPosition.y;
            if (currentPosition.x < leftDownX) leftDownX = currentPosition.x;
            if (currentPosition.y < leftDownY) leftDownY = currentPosition.y;
        }

        return this.visualise.dump(this, new Position(leftDownX,leftDownY), new Position(rightUpX, rightUpY));
    }
}
