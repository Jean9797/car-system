public class HayStack implements IMapElement {
    private Position coords;
    public HayStack(Position coords){
        this.coords = coords;
    }

    public Position getPosition(){
        return this.coords;
    }

    @Override
    public String toString() {
        return "s";
    }
}
