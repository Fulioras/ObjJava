package shapes.interfaces;

/**
 * Interface for objects that can be transformed.
 * <p>
 * Extends {@link Movable} to include rotation and scaling operations.
 */
public interface Transformable extends Movable {

	/**
	 * Rotates the object by the specified angle.
	 *
	 * @param r the angle of rotation in degrees (or radians, based on implementation)
	 */
	void rotate(double r);

	/**
	 * Scales the object by the specified factor.
	 *
	 * @param s the scaling factor
	 */
	void scale(double s);

	/**
	 * Returns the current scale factor of the object.
	 *
	 * @return the scale factor
	 */
	double getScale();
}
