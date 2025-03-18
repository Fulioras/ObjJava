public class Circle extends VectorialObject{
	private double radius;

	Circle(){
		setRadius(10);
	}


	public void setRadius(double radius){
		this.radius = radius;
	}
	public double getRadius(){
		return this.radius;
	}

	private String toSVG(){

	StringBuilder svg = new StringBuilder("<circle ");

 	svg.append("cx=\"").append(String.valueOf(super.getX())).append("\" ");
 	svg.append("cy=\"").append(String.valueOf(super.getY())).append("\" ");
 	svg.append("r=\"").append(String.valueOf(getRadius())).append("\" ");
 	svg.append("fill=\"").append(super.getColor()).append("\" ");
 	///FIX ME:
 	/// This need support for all fields

 	svg.append("/>");
 	return svg.toString();
 	}

	public static void main(String[] args){
		Circle gaming = new Circle();
		System.out.println(gaming.toSVG());
	}
}