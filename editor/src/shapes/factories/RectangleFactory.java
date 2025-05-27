package shapes.factories;

import shapes.derived.Rectangle;
import shapes.base.VectorialObject;

/**
 * Factory class for creating instances of {@link Rectangle}.
 * <p>
 * Implements the {@link ShapeFactory} interface to provide
 * a standardized way to create Rectangle objects.
 */
public class RectangleFactory implements ShapeFactory {

    /**
     * Creates and returns a new default {@link Rectangle} instance.
     *
     * @return a new Rectangle object with default properties
     */
    @Override
    public VectorialObject createShape() {
        return new Rectangle();
    }
}
