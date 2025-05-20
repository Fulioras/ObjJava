package shapes.derived;

import shapes.base.*;
import shapes.exceptions.*;

import java.util.ArrayList;

public class Circle extends VectorialObject{
	private double radius = 10;

	private ArrayList<String> tags;


	public Circle(){
		this(0, 0, 0, VectorialObject.getBaseColor());
	}

	public Circle(double x, double y, double lineWidth, String color){
    	super(x, y, lineWidth, color);
    	tags = new ArrayList<>();
	}
	

	public final void setRadius(double radius) throws BadRadiusValue{ 
		if(radius <= 0){
			throw new BadRadiusValue("Can't set circle radius to a non positive value, tried to set Radius = ", radius);
		}
		this.radius = radius; 
	}
	public double getRadius(){ return this.radius; }

	public void addTag(String tag){
		tags.add(tag);
	}

	public ArrayList<String> getTags() {
	    return tags;
	}

	@Override
	public Circle clone() {
        Circle cloned = (Circle) super.clone(); // Shallow copy of base class

        //Deep copy
        cloned.tags = new ArrayList<>(this.tags);
        return cloned;
	}


	public double getArea() throws BadRadiusValue{
		if(getRadius() <= 0) 
			throw new BadRadiusValue("Circle radius has to be a positive value", getRadius());
		return Math.PI * Math.pow(getRadius() * super.getScale(), 2);
	}

	public double getPerimeter() throws BadRadiusValue{
		if(getRadius() <= 0) 
			throw new BadRadiusValue("Circle radius has to be a positive value", getRadius());
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