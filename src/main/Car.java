public class Car {
    private IWorldMap map;
    private MapDirection currentDirection;
    private Position currentPosition;


    public Car(IWorldMap map){
        this.currentDirection = MapDirection.North;
        this.map = map;
    }

    public Car(IWorldMap map, int x, int y){
        this.currentDirection = MapDirection.North;
        this.currentPosition = new Position(x, y);
        this.map = map;
    }

    @Override
    public String toString(){
        switch (this.currentDirection){
            case North: return "N";
            case South: return "S";
            case East: return "E";
            default: return "W";
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
                    this.currentPosition = moveOnPosition;
                }
                break;
        }
    }
}