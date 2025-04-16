package shapes.derived;

import shapes.base.*;

public class Circle extends VectorialObject{
	private double radius;

	public Circle(){
		this(0, 0, 0, VectorialObject.getBaseColor());
	}

	public Circle(double x, double y, double lineWidth, String color){
    	super(x, y, lineWidth, color);
    	setRadius(10);
	}
	

	public final void setRadius(double radius){ this.radius = radius; }
	public double getRadius(){ return this.radius; }

	public double getArea(){
		return Math.PI * Math.pow(getRadius() * super.getScale(), 2);
	}

	public double getPerimeter(){
		return 2 * Math.PI * getRadius() * super.getScale();
	}

	public String toString(){

	StringBuilder svg = new StringBuilder("<circle ");

 	svg.append("cx=\"").append(String.valueOf(super.getX())).append("\" ");
 	svg.append("cy=\"").append(String.valueOf(super.getY())).append("\" ");
 	svg.append("r=\"").append(String.valueOf(getRadius())).append("\" ");
 	svg.append(super.toString());

	if(super.getRotation() != 0){
 		svg.append("transform=\"rotate(").append(String.valueOf(super.getRotation()));
 		svg.append(" ").append(String.valueOf(getCenterX()));
 		svg.append(" ").append(String.valueOf(getCenterY())).append(")\" ");
 	}
 	svg.append("/>");
 	return svg.toString();
 	}

 	
}