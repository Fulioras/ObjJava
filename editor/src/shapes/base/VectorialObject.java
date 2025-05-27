package shapes.base;  

import shapes.exceptions.*; 
import shapes.interfaces.*;

import java.awt.*;
import java.io.Serializable;

/**
 * Represents the base object class for all shapes
 * <p>
 * Provides common transformation (translation, rotation, scaling),
 * appearance (color, line width), and identification logic.
 * Intended to be extended by specific shape types.
 */

public abstract class VectorialObject implements Transformable, Cloneable, Serializable {
    // Transformation values
    protected double x, y;
    protected double rotation = 0.0;
    protected double scale = 1.0;

    // Base values
    private static int idCounter = 1;
    private final int id;
    private double lineWidth;
    private static Color baseColor = Color.BLUE;
    private Color color;
    private Color lineColor;

    /**
     * Constructs a VectorialObject with random position,
     * default scale, base color as fill, and black stroke.
     */
    public VectorialObject() {
        this(Math.random() * 600, Math.random() * 600, 1.0, baseColor, Color.BLACK);
    }

    /**
     * Constructs a VectorialObject with specified position, line width,
     * fill color, and stroke color.
     *
     * @param x           the x-coordinate of the object
     * @param y           the y-coordinate of the object
     * @param lineWidth   the stroke width
     * @param fillColor   the fill color of the object
     * @param strokeColor the stroke (border) color
     */
    public VectorialObject(double x, double y, double lineWidth, Color fillColor, Color strokeColor) {        this.x = x;
        this.x = x;
        this.y = y;
        this.id = ++idCounter;
        setLineWidth(lineWidth);
        setLineColor(strokeColor);
        setColor(fillColor);
    }

    /**
     * Moves the object to a new location.
     *
     * @param dx the new x-coordinate
     * @param dy the new y-coordinate
     */
    public void move(double dx, double dy) {
        this.x = dx;
        this.y = dy;
    }
    /**
     * Sets the x-coordinate of the object.
     *
     * @param dx new x value
     */
    public void setX(double dx) {
        this.x = dx;
    }

    /**
     * Sets the y-coordinate of the object.
     *
     * @param dy new y value
     */
    public void setY(double dy) {
        this.y = dy;
    }

    /**
     * Sets the rotation of the object in degrees.
     *
     * @param r the rotation angle
     */
    public void rotate(double r) {
        this.rotation = r;
    }

    /**
     * Sets the scale of the object.
     *
     * @param s the scaling factor
     */
    public void scale(double s) {
        this.scale = s;
    }

    /**
     * Returns the unique ID of this object.
     *
     * @return the object ID
     */
    public final int getId() { return id; }

    /**
     * Sets the default base color for new objects.
     *
     * @param color the base color to use
     */
    public static void setBaseColor(Color color){ baseColor = color; }
    /**
     * Returns the y-coordinate of this object.
     *
     * @return the y position
     */
    public static final Color getBaseColor() {return baseColor; }
    /**
     * Returns the x-coordinate of this object.
     *
     * @return the x position
     */
    public final double getX() { return this.x; }

    public final double getY() { return this.y; }
    /**
     * Returns the rotation value of this object.
     *
     * @return the rotation angle
     */
    public final double getRotation() { return this.rotation; }
    /**
     * Returns the scale value of this object.
     *
     * @return the scale factor
     */
    public final double getScale() { return this.scale; }
    /**
     * Returns the current stroke (line) width.
     *
     * @return the line width
     */
    public final double getLineWidth() { return lineWidth; }

    /**
     *
     * @param lineWidth
     */
    public void setLineWidth(double lineWidth) { this.lineWidth = lineWidth; }

    /**
     * Returns the stroke (line) color.
     *
     * @return the line color
     */
    public final Color getLineColor() {return lineColor; }

    /**
     * Sets the stroke (line) color.
     *
     * @param lineColor the color to use for the border
     */
    public void setLineColor(Color lineColor) {this.lineColor = lineColor; }

    /**
     *
     * @return shape fill color
     */
    public final Color getColor() { return color; }

    /**
     * sets shape fills color
     * @param color
     */
    public void setColor(Color color) { this.color = color; }

    /**
     *
     * @return shape center x coordinate
     */
    public double getCenterX() { return getX(); }

    /**
     *
     * @return shape center y coordinate
     */
    public double getCenterY() { return getY(); }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a clone of this instance
     * @throws AssertionError if cloning fails
     */
    @Override
    public VectorialObject clone() {
        try {
            return (VectorialObject) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed", e);
        }
    }

    /**
     *
     * @param g
     */
    public abstract void draw(Graphics g);

    /**
     *
     * @return
     * @throws EditorException
     */
    public abstract double getArea() throws EditorException;

    /**
     *
     * @return perimeter (double)
     * @throws EditorException
     */
    public abstract double getPerimeter() throws EditorException;
    /**
     * Returns a basic SVG-like description string for the shape's styling.
     *
     * @return SVG-style attributes string
     */
    public String toString() {
        StringBuilder svg = new StringBuilder("");

        svg.append("fill=\"").append(getColor()).append("\" ");
        if(getLineWidth() != 0 ){
            svg.append("stroke = \"").append(getLineColor()).append("\" ");
            svg.append("stroke-width = \"").append(String.valueOf(getLineWidth())).append("\" ");
        }

        return svg.toString();
    }
}