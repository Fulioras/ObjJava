package shapes.abstractShapes;

import shapes.interfaces.*;

public abstract class AbstractShape implements Transformable, ShapeMath{
	protected double x,y;
	protected double rotation = 0.0;
	protected double scale = 1.0;

	public AbstractShape(){
		this(0, 0);
	}

	public AbstractShape(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void move(double dx, double dy){
		this.x += dx;
		this.y += dy;
	}
	public void moveX(double dx){
		this.x += dx;
	}
	public void moveY(double dy){
		this.y += dy;
	}
	
	public void rotate(double r){
		this.rotation = r;
	}
	
	public void scale(double s){
		this.scale = s;
	}

	public double getScale(){
		return this.scale;
	}

	public abstract double getArea() throws Exception;
	public abstract double getPerimeter() throws Exception;
}