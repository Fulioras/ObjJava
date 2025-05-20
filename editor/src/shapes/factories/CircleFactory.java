package shapes.factories;

import shapes.derived.Circle;
import shapes.base.VectorialObject;

public class CircleFactory implements ShapeFactory {
    @Override
    public VectorialObject createShape() {
        return new Circle(); // default Circle
    }
}