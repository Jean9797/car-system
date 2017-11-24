import java.util.LinkedList;

public class Car implements IMapElement {
    private IWorldMap map;
    private MapDirection currentDirection;
    private Position currentPosition;
    private LinkedList<IPositionChangeObserver> observers = new LinkedList<>();

    public Car(IWorldMap map){
        this.currentDirection = MapDirection.North;
        this.map = map;
        this.currentPosition = new Position(2,2);
    }

    public Car(IWorldMap map, int x, int y){
        this.currentDirection = MapDirection.North;
        this.map = map;
        this.currentPosition = new Position(x, y);
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    private void positionChanged(Position oldPosition, Position newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public String toString(){
        switch (this.currentDirection){
            case North: return "^";
            case South: return "v";
            case East: return ">";
            default: return "<";
        }
    }

    public Position getPosition() {
        return currentPosition;
    }

    public void move(MoveDirection direction){
        Position moveOnPosition = this.currentPosition;
        switch (direction){
            case Left:
                this.currentDirection = this.currentDirection.previous();
                break;
            case Right:
                this.currentDirection = this.currentDirection.next();
                break;
            case Forward:
                switch(this.currentDirection){
                    case North:
                        moveOnPosition = this.currentPosition.add(new Position(0, 1));
                        break;
                    case East:
                        moveOnPosition = this.currentPosition.add(new Position(1, 0));
                        break;
                    case West:
                        moveOnPosition = this.currentPosition.add(new Position(-1, 0));
                        break;
                    case South:
                        moveOnPosition = this.currentPosition.add(new Position(0, -1));
                        break;
                }
                if(map.canMoveTo(moveOnPosition)){
                    positionChanged(this.currentPosition, moveOnPosition);
                    this.currentPosition = moveOnPosition;
                }
                break;
            case Backward:
                switch(this.currentDirection){
                    case North:
                        moveOnPosition = this.currentPosition.add(new Position(0, -1));
                        break;
                    case East:
                        moveOnPosition = this.currentPosition.add(new Position(-1, 0));
                        break;
                    case West:
                        moveOnPosition = this.currentPosition.add(new Position(1, 0));
                        break;
                    case South:
                        moveOnPosition = this.currentPosition.add(new Position(0, 1));
                        break;
                }
                if(map.canMoveTo(moveOnPosition)){
                    positionChanged(this.currentPosition, moveOnPosition);
                    this.currentPosition = moveOnPosition;
                }
                break;
        }
    }
}