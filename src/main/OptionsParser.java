import java.util.ArrayList;

public class OptionsParser {

    public static MoveDirection[] parse(String[] input) {
        ArrayList<MoveDirection> orders = new ArrayList<>();
        for(String i : input){
            switch (i){
                case "f":
                    orders.add(MoveDirection.Forward);
                    break;
                case "forward":
                    orders.add(MoveDirection.Forward);
                    break;
                case "b":
                    orders.add(MoveDirection.Backward);
                    break;
                case "backward":
                    orders.add(MoveDirection.Backward);
                    break;
                case "r":
                    orders.add(MoveDirection.Right);
                    break;
                case "right":
                    orders.add(MoveDirection.Right);
                    break;
                case "l":
                    orders.add(MoveDirection.Left);
                    break;
                case "left":
                    orders.add(MoveDirection.Left);
                    break;
                default:;
            }
        }
        MoveDirection[] result = new MoveDirection[orders.size()];
        result = orders.toArray(result);
        return result;
    }
}
