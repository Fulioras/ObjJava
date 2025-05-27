package shapes.derived;

import shapes.base.*;
import shapes.exceptions.*;

import java.util.ArrayList;
import java.awt.*;

/**
 * Represents a drawable circle shape in a vector graphics editor.
 * <p>
 * Inherits transformation and styling behavior from {@link VectorialObject},
 * and adds support for radius and tagging.
 */
public class Circle extends VectorialObject{
	/** The radius of the circle. Must be positive for valid area/perimeter calculations. */
	private double radius = 10;
	/** A list of user-defined tags associated with the circle. */
	private ArrayList<String> tags;

	/**
	 * Constructs a Circle with a random position and default colors from the base class.
	 */
	public Circle(){
		this(Math.random()*600, Math.random()*600, 0, VectorialObject.getBaseColor(), VectorialObject.getBaseColor());
	}

	/**
	 * Constructs a Circle with specified position, line width, fill color, and stroke color.
	 *
	 * @param x           the x-coordinate of the center
	 * @param y           the y-coordinate of the center
	 * @param lineWidth   the stroke width
	 * @param fillColor   the fill (interior) color
	 * @param strokeColor the stroke (border) color
	 */
	public Circle(double x, double y, double lineWidth, Color fillColor, Color strokeColor){
    	super(x, y, lineWidth, fillColor, strokeColor);
    	tags = new ArrayList<>();
	}

	/**
	 * Sets the radius of the circle.
	 *
	 * @param radius the new radius (must be positive for valid geometric calculations)
	 */
	public final void setRadius(double radius){
		this.radius = radius; 
	}

	/**
	 * Returns the current radius of the circle.
	 *
	 * @return the radius
	 */
	public double getRadius(){ return this.radius; }

	/**
	 * Adds a tag (label) to the circle.
	 *
	 * @param tag the tag to add
	 */
	public void addTag(String tag){
		tags.add(tag);
	}

	/**
	 * Returns the list of tags associated with the circle.
	 *
	 * @return the list of tags
	 */
	public ArrayList<String> getTags() {
	    return tags;
	}

	/**
	 * Creates a deep clone of this circle, including a copy of its tags.
	 *
	 * @return a cloned {@code Circle} instance
	 */
	@Override
	public Circle clone() {
        Circle cloned = (Circle) super.clone(); // Shallow copy of base class

        //Deep copy
        cloned.tags = new ArrayList<>(this.tags);
        return cloned;
	}
	/**
	 * Draws the circle using the provided {@link Graphics} context.
	 *
	 * @param g the graphics context used for rendering
	 */
	@Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Fill
        g2.setColor(super.getColor()); // inherited
        g2.fillOval((int)(x - radius), (int)(y - radius), (int)(radius * 2 * super.getScale()), (int)(radius * 2 * super.getScale()));
        // Stroke
        g2.setColor(super.getLineColor());
    	g2.setStroke(new BasicStroke((float)super.getLineWidth()));
    	
    	g2.drawOval((int)(x - radius), (int)(y - radius), (int)(radius * 2 * super.getScale()), (int)(radius * 2 * super.getScale()));
        
    }

	/**
	 * Calculates the area of the circle.
	 *
	 * @return the area
	 * @throws BadRadiusValue if the radius is not positive
	 */
	public double getArea() throws BadRadiusValue{
		if(getRadius() <= 0) 
			throw new BadRadiusValue("Circle radius has to be a positive value", getRadius());
		return Math.PI * Math.pow(getRadius() * super.getScale(), 2);
	}

	/**
	 * Calculates the perimeter (circumference) of the circle.
	 *
	 * @return the perimeter
	 * @throws BadRadiusValue if the radius is not positive
	 */
	public double getPerimeter() throws BadRadiusValue{
		if(getRadius() <= 0) 
			throw new BadRadiusValue("Circle radius has to be a positive value", getRadius());
		return 2 * Math.PI * getRadius() * super.getScale();
	}
	/**
	 * Returns an SVG representation of the circle with styling and optional transform.
	 *
	 * @return an SVG-format string describing the circle
	 */
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