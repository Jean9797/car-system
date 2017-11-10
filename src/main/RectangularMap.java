public class RectangularMap extends AbstractWorldMap implements IWorldMap{
    private Position leftDownMapCorner;
    private Position rightUpMapCorner;

    public RectangularMap(int width, int height){
        super();
        this.leftDownMapCorner = new Position(0,0);
        this.rightUpMapCorner = new Position(width, height);
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
        throw new IllegalArgumentException(carPosition.toString() + " is already busy");
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
        return this.visualise.dump(this, this.leftDownMapCorner, this.rightUpMapCorner);
    }
}
