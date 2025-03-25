package shapes.derived;

import shapes.base.*;

public class Rectangle extends VectorialObject{
private double width;
private double height;
private double rx;
private double ry;


public Rectangle(){
	setWidth(10);
	setHeight(10);
	setRX(0);
	setRY(0);
}

public void setWidth(double width){ this.width = width; }
public double getWidth(){ return this.width; }

public void setHeight(double height){ this.height = height; }
public double getHeight(){ return this.height; }

public void setRX(double rx){ this.rx = rx; }
public double getRX(){ return this.rx; }

public void setRY(double ry){ this.ry = ry; }
public double getRy(){ return this.ry; }

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

 	svg.append("/>");
	return svg.toString();
}
}