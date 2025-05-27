package shapes.factories;

import shapes.derived.Circle;
import shapes.base.VectorialObject;

/**
 * Factory class for creating instances of {@link Circle}.
 * <p>
 * Implements the {@link ShapeFactory} interface to provide
 * a standardized way to create Circle objects.
 */
public class CircleFactory implements ShapeFactory {

    /**
     * Creates and returns a new default {@link Circle} instance.
     *
     * @return a new Circle object with default properties
     */
    @Override
    public VectorialObject createShape() {
        return new Circle();
    }
}
