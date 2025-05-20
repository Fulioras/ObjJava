package shapes.interfaces;

public interface Transformable extends Movable{

	void rotate(double r);
	
	void scale(double s);
	double getScale();
}