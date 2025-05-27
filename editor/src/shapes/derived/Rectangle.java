package shapes.derived;

import shapes.base.*;
import shapes.exceptions.*;

import java.awt.*;

/**
 * Represents a drawable rectangle shape with optional rounded corners.
 * <p>
 * Inherits transformation, color, and stroke properties from {@link VectorialObject}.
 */
public class Rectangle extends VectorialObject{
	/** The width of the rectangle. */
	private double width = 10;
	/** The height of the rectangle. */
private double height = 10;

	/**
	 * Constructs a Rectangle with random position and default colors.
	 */
public Rectangle(){
	this(Math.random()*600, Math.random()*600, 0, VectorialObject.getBaseColor(), VectorialObject.getBaseColor());
}

	/**
	 * Constructs a Rectangle with specified position, line width, fill color, and stroke color.
	 *
	 * @param x           the x-coordinate of the rectangle's top-left corner
	 * @param y           the y-coordinate of the rectangle's top-left corner
	 * @param lineWidth   the stroke width
	 * @param fillColor   the fill (interior) color
	 * @param strokeColor the stroke (border) color
	 */
public Rectangle(double x, double y, double lineWidth, Color fillColor, Color strokeColor) {
    super(x, y, lineWidth, fillColor, strokeColor);
}

	/**
	 * Sets the width of the rectangle.
	 * @param width the new width
	 */
	public final void setWidth(double width) {
		this.width = width;
	}

	/**
	 * Returns the width of the rectangle.
	 * @return the width
	 */
	public double getWidth() {
		return this.width;
	}

	/**
	 * Sets the height of the rectangle.
	 * @param height the new height
	 */
	public final void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Returns the height of the rectangle.
	 * @return the height
	 */
	public double getHeight() {
		return this.height;
	}   /**
	 * Returns the x-coordinate of the rectangle's center.
	 *
	 * @return the center x-coordinate
	 */
	public double getCenterX() {
		return super.getX() + (getWidth() / 2);
	}

	/**
	 * Returns the y-coordinate of the rectangle's center.
	 *
	 * @return the center y-coordinate
	 */
	public double getCenterY() {
		return super.getY() + (getHeight() / 2);
	}

	/**
	 * Draws the rectangle using the provided {@link Graphics} context.
	 *
	 * @param g the graphics context for rendering
	 */
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// Fill the rectangle
		g2.setColor(super.getColor());
		g2.fillRect((int) getX(), (int) getY(),
				(int) (width * getScale()), (int) (height * getScale()));

		// Draw the rectangle stroke
		g2.setColor(super.getLineColor());
		g2.setStroke(new BasicStroke((float) super.getLineWidth()));
		g2.drawRect((int) getX(), (int) getY(),
				(int) (width * getScale()), (int) (height * getScale()));
	}

	/**
	 * Calculates the area of the rectangle.
	 *
	 * @return the area
	 * @throws EditorException if width or height is zero
	 */
	public double getArea() throws EditorException {
		if (width == 0 || height == 0) {
			throw new EditorException("Zero valued height or width at getArea()");
		}
		return getWidth() * getHeight() * super.getScale();
	}

	/**
	 * Calculates the perimeter of the rectangle.
	 *
	 * @return the perimeter
	 * @throws EditorException if width or height is zero
	 */
	public double getPerimeter() throws EditorException {
		if (width == 0 || height == 0) {
			throw new EditorException("Zero valued height or width at getPerimeter()");
		}
		return 2 * (getWidth() + getHeight()) * super.getScale();
	}

	/**
	 * Returns an SVG representation of the rectangle with transformations.
	 *
	 * @return an SVG-format string describing the rectangle
	 */
	public String toString(){

	StringBuilder svg = new StringBuilder("<rect ");

 	svg.append("x=\"").append(String.valueOf(super.getX())).append("\" ");
 	svg.append("y=\"").append(String.valueOf(super.getY())).append("\" ");
 	svg.append("width=\"").append(String.valueOf(getWidth())).append("\" ");
 	svg.append("height=\"").append(String.valueOf(getHeight())).append("\" ");
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
