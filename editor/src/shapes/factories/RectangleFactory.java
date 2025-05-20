package shapes.factories;

import shapes.derived.Rectangle;
import shapes.base.VectorialObject;

public class RectangleFactory implements ShapeFactory {
    @Override
    public VectorialObject createShape() {
        return new Rectangle(); // default Rectangle
    }
}