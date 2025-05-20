package shapes.exceptions;

public class BadRadiusValue extends EditorException {
    public double radiusValue;
    public BadRadiusValue(String message, double radiusValue) {
        super(message);
    }

    public double getRadiusValue(){
        return radiusValue;
    }
}