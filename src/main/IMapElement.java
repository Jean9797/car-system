/**
 * Interface responsible for interacting with objects at map of the world.
 *
 * @author janko
 *
 */
public interface IMapElement {
    /**
     * @return Current position of the element.
     */
    Position getPosition();

    /**
     * @return String representation of the object.
     */
    String toString();
}
