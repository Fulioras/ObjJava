public class Rectangle extends VectorialObject{
private double width;
private double height;
private double rx;
private double ry;


Rectangle(){
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

private String toSVG(){

	StringBuilder svg = new StringBuilder("<rect ");

 	svg.append("x=\"").append(String.valueOf(super.getX())).append("\" ");
 	svg.append("y=\"").append(String.valueOf(super.getY())).append("\" ");
 	svg.append("width=\"").append(String.valueOf(getWidth())).append("\" ");
 	svg.append("height=\"").append(String.valueOf(getHeight())).append("\" ");
 	svg.append("fill=\"").append(super.getColor()).append("\" ");
 	///FIX ME:
 	/// This need support for all fields
 	/// perhaps add verification to avoid unnecesary info like if x=0 then maybe don't add it. 


 	svg.append("/>");
	return svg.toString();
}
}