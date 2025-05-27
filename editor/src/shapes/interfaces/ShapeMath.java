package shapes.interfaces;

/**
 * Interface defining mathematical operations for shapes.
 * <p>
 * Provides methods to calculate the area and perimeter of a shape.
 */
public interface ShapeMath {

	/**
	 * Calculates and returns the area of the shape.
	 *
	 * @return the area of the shape
	 * @throws Exception if the area cannot be calculated (e.g., invalid dimensions)
	 */
	double getArea() throws Exception;

	/**
	 * Calculates and returns the perimeter of the shape.
	 *
	 * @return the perimeter of the shape
	 * @throws Exception if the perimeter cannot be calculated (e.g., invalid dimensions)
	 */
	double getPerimeter() throws Exception;
}
