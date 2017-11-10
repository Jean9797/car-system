import java.util.ArrayList;

abstract public class AbstractWorldMap implements IWorldMap {
    protected MapVisualizer visualise = new MapVisualizer();
    protected ArrayList<Car> cars = new ArrayList<>();

    @Override
    public void run(MoveDirection[] directions) {
        if(cars.size() == 0) return;
        for(int i = 0; i < directions.length; i++){
            cars.get(i%cars.size()).move(directions[i]);        //iterujemy po tablicy directions oraz jednocześnie po tablicy cars
        }
    }
}
