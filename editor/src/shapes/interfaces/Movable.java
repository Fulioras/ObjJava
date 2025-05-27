package shapes.interfaces;

/**
 * Interface representing objects that can be moved in 2D space.
 * <p>
 * Provides methods to move an object and set its individual coordinates.
 */
public interface Movable {

	/**
	 * Moves the object by the specified offsets along the x and y axes.
	 *
	 * @param x the offset to move along the x-axis
	 * @param y the offset to move along the y-axis
	 */
	void move(double x, double y);

	/**
	 * Sets the x-coordinate of the object.
	 *
	 * @param x the new x-coordinate
	 */
	void setX(double x);

	/**
	 * Sets the y-coordinate of the object.
	 *
	 * @param y the new y-coordinate
	 */
	void setY(double y);
}
