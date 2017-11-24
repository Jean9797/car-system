public class RectangularMap extends AbstractWorldMap{
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
    public Object objectAt(Position position) {
        return elements.get(position);
    }

    @Override
    public String toString(){
        return this.visualise.dump(this, this.leftDownMapCorner, this.rightUpMapCorner);
    }
}
