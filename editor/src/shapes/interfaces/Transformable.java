package shapes.interfaces;

public interface Transformable extends ShapeMath{
	void move(double dx, double dy);
	void moveX(double dx);
	void moveY(double dy);

	void rotate(double r);
	
	void scale(double s);
	double getScale();
}