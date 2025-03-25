package shapes.derived;

import shapes.base.*;

public class Circle extends VectorialObject{
	private double radius;

	public Circle(){
		setRadius(10);
	}


	public void setRadius(double radius){
		this.radius = radius;
	}
	public double getRadius(){
		return this.radius;
	}

	public String toString(){

	StringBuilder svg = new StringBuilder("<circle ");

 	svg.append("cx=\"").append(String.valueOf(super.getX())).append("\" ");
 	svg.append("cy=\"").append(String.valueOf(super.getY())).append("\" ");
 	svg.append("r=\"").append(String.valueOf(getRadius())).append("\" ");
 	svg.append(super.toString());
 	svg.append("/>");
 	return svg.toString();
 	}

 	
}