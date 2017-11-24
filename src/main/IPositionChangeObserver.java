/**
 * Interface responsible for updating new car position.
 *
 * @author janko
 */
public interface IPositionChangeObserver {
    /**
     * Update position of the car.
     *
     * @param oldPosition
     *              Old car position.
     * @param newPosition
     *              New car position.
     */
    void positionChanged(Position oldPosition, Position newPosition);
}