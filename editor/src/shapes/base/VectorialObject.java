package shapes.base;  

import shapes.abstractShapes.*; 
import shapes.exceptions.*; 

public class VectorialObject extends AbstractShape implements Cloneable{
    private static int idCounter = 0;
    private final int id;

    private double lineWidth;
    private String lineColor;
    private String color;
    private static String baseColor = "black";

    // this() panaudojimas
    public VectorialObject() {
        this(0, 0, 0, baseColor); // Iskviecia standartizuota konstruktoriu
    }

    public VectorialObject(double x, double y, double lineWidth, String color) {
        super(x, y);
        this.id = ++idCounter;
        setLineWidth(lineWidth);
        setLineColor(color);
        setColor(color);
    }

    // setters and getters
    public final int getId() { return id; }

    public static void setBaseColor(String color){ baseColor = color; }
    public static final String getBaseColor() {return baseColor; }

    public final double getX() { return super.x; }

    public final double getY() { return super.y; }

    public final double getRotation() { return super.rotation; }

    public final double getScale() { return super.scale; }

    public final double getLineWidth() { return lineWidth; }
    public void setLineWidth(double lineWidth) { this.lineWidth = lineWidth; }

    public final String getLineColor() {return lineColor; }
    public void setLineColor(String lineColor) {this.lineColor = lineColor; }

    public final String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    
    public double getCenterX(){
        return getX();
    }
    public double getCenterY(){
        return getY();
    }

    @Override
    public VectorialObject clone() {
        try {
            return (VectorialObject) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed", e);
        }
    }

    public double getArea() throws EditorException{
        throw new EditorException("Can't calculate area of VectorialObject(is a point)");
    }

    public double getPerimeter() throws EditorException{
        throw new EditorException("Can't calculate perimeter of VectorialObject(is a point)");
    }


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