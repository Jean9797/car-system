
public enum MapDirection {
    North,
    South,
    West,
    East;

    public String toString(){
        switch(this){
            case East: return "Wschód";
            case West: return "Zachód";
            case North: return "Północ";
            case South: return "Południe";
            default: return "";
        }
    }

    public MapDirection next(){
        switch(this){
            case East: return South;
            case West: return North;
            case North: return East;
            case South: return West;
            default: return this;
        }
    }

    public MapDirection previous(){
        switch(this){
            case East: return North;
            case West: return South;
            case North: return West;
            case South: return East;
            default: return this;
        }
    }
}
