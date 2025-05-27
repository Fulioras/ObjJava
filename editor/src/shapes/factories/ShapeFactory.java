package shapes.factories;

import shapes.base.VectorialObject;

/**
 * Interface defining a factory for creating {@link VectorialObject} instances.
 * <p>
 * Implementations of this interface provide methods to instantiate specific shapes.
 */
public interface ShapeFactory {

	/**
	 * Creates and returns a new instance of a {@link VectorialObject}.
	 *
	 * @return a new shape instance
	 */
	VectorialObject createShape();
}
