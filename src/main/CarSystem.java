import java.util.ArrayList;

public class CarSystem {

    public static void main(String[] args){
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            ArrayList<HayStack> stacks = new ArrayList<>();
            stacks.add(new HayStack(new Position(-4, -4)));
            stacks.add(new HayStack(new Position(7, 7)));
            stacks.add(new HayStack(new Position(3, 6)));
            stacks.add(new HayStack(new Position(2, 0)));
            IWorldMap map = new UnboundedMap(stacks);
            map.add(new Car(map));
            map.add(new Car(map, 3, 4));
            map.run(directions);
            System.out.print(map.toString());
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
}
