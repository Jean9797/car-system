public class Car {

    private MapDirection currentDirection;
    private Position currentPosition;
    private Position leftDownMapCorner = new Position(0,0);
    private Position rightUpMapCorner = new Position(4,4);


    public Car(){
        this.currentDirection = MapDirection.North;
        this.currentPosition = new Position(2, 2);
    }

    public String toString(){
        return this.currentPosition.toString() + " => " + this.currentDirection.toString();
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
                if(moveOnPosition.smaller(rightUpMapCorner) && moveOnPosition.larger(leftDownMapCorner)){
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
                if(moveOnPosition.smaller(rightUpMapCorner) && moveOnPosition.larger(leftDownMapCorner)){
                    this.currentPosition = moveOnPosition;
                }
                break;
        }
    }
}