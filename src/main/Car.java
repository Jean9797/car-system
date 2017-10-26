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
                        if(this.currentPosition.add(new Position(0, 1)).smaller(this.rightUpMapCorner)){
                            this.currentPosition = this.currentPosition.add(new Position(0,1));
                        }
                        break;
                    case East:
                        if(this.currentPosition.add(new Position(1, 0)).smaller(this.rightUpMapCorner)){
                            this.currentPosition = this.currentPosition.add(new Position(1,0));
                        }
                        break;
                    case West:
                        if(this.currentPosition.add(new Position(-1, 0)).larger(this.leftDownMapCorner)){
                            this.currentPosition = this.currentPosition.add(new Position(-1,0));
                        }
                        break;
                    case South:
                        if(this.currentPosition.add(new Position(0, -1)).larger(this.leftDownMapCorner)){
                            this.currentPosition = this.currentPosition.add(new Position(0,-1));
                        }
                        break;
                }
                break;
            case Backward:
                switch(this.currentDirection){
                    case North:
                        if(this.currentPosition.add(new Position(0, -1)).larger(this.leftDownMapCorner)){
                            this.currentPosition = this.currentPosition.add(new Position(0,-1));
                        }
                        break;
                    case East:
                        if(this.currentPosition.add(new Position(-1, 0)).larger(this.leftDownMapCorner)){
                            this.currentPosition = this.currentPosition.add(new Position(-1,0));
                        }
                        break;
                    case West:
                        if(this.currentPosition.add(new Position(1, 0)).smaller(this.rightUpMapCorner)){
                            this.currentPosition = this.currentPosition.add(new Position(1,0));
                        }
                        break;
                    case South:
                        if(this.currentPosition.add(new Position(0, 1)).smaller(this.rightUpMapCorner)){
                            this.currentPosition = this.currentPosition.add(new Position(0,1));
                        }
                        break;
                }
                break;
        }
    }
}