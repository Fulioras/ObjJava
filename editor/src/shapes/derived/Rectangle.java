package shapes.derived;

import shapes.base.*;
import shapes.exceptions.*;

public class Rectangle extends VectorialObject{
private double width = 10;
private double height = 10;
private double rx = 0;
private double ry = 0;

public Rectangle(){
	this(0, 0, 0, VectorialObject.getBaseColor());
}

public Rectangle(double x, double y, double lineWidth, String color){
    super(x, y, lineWidth, color);
}

public final void setWidth(double width) throws EditorException{ 
	if(width == 0)
		throw new EditorException("Rectangle width can't be set to zero");
	this.width = width; 
}
public double getWidth(){ return this.width; }

public final void setHeight(double height) throws EditorException{ 
	if(height == 0)
		throw new EditorException("Rectangle height can't be set to zero");
	this.height = height; }
public double getHeight(){ return this.height; }

public final void setRX(double rx){ this.rx = rx; }
public double getRX(){ return this.rx; }

public final void setRY(double ry){ this.ry = ry; }
public double getRy(){ return this.ry; }

public double getCenterX(){
	return super.getX()+(getWidth()/2);
}
public double getCenterY(){
	return super.getY()+(getHeight()/2);
}

public double getArea() throws EditorException{
	if(width == 0 || height == 0){
		throw new EditorException("Zero valued height or width at getArea()");
	}
	return getWidth() * getHeight() * super.getScale();
}

public double getPerimeter() throws EditorException{
	if(width == 0 || height == 0){
		throw new EditorException("Zero valued height or width at getPerimeter()");
	}
	return 2 * (getWidth() + getHeight()) * super.getScale();
}



public String toString(){

	StringBuilder svg = new StringBuilder("<rect ");

 	svg.append("x=\"").append(String.valueOf(super.getX())).append("\" ");
 	svg.append("y=\"").append(String.valueOf(super.getY())).append("\" ");
 	svg.append("width=\"").append(String.valueOf(getWidth())).append("\" ");
 	svg.append("height=\"").append(String.valueOf(getHeight())).append("\" ");
 	svg.append(super.toString());

 	if(getRX() != 0 ){
 		svg.append("rx = \"").append(String.valueOf(getRX())).append("\" ");
 	}
 	if(getRy() != 0 ){
 		svg.append("ry = \"").append(String.valueOf(getRy())).append("\" ");
 	}
 	if(super.getRotation() != 0){
 		svg.append("transform=\"rotate(").append(String.valueOf(super.getRotation()));
 		svg.append(" ").append(String.valueOf(getCenterX()));
 		svg.append(" ").append(String.valueOf(getCenterY())).append(")\" ");
 	}

 	svg.append("/>");
	return svg.toString();
}
}
