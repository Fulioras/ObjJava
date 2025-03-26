package shapes.base;    

public class VectorialObject {
    private static int idCounter = 0;
    private final int id;
    private double x, y;
    private double rotation;
    private double lineWidth;
    private String lineColor;
    private String color;
    private static String baseColor = "black";

    // this() panaudojimas
    public VectorialObject() {
        this(0, 0, 0, 0, baseColor, baseColor); // Iskviecia standartizuota konstruktoriu
    }

    public VectorialObject(double x, double y, double rotation, double lineWidth, String lineColor, String color) {
        this.id = ++idCounter;
        setX(x);
        setY(y);
        setRotation(rotation);
        setLineWidth(lineWidth);
        setLineColor(baseColor);
        setColor(color);
    }

    // setters and getters
    public static void setBaseColor(String color){ baseColor = color; }

    public final int getId() { return id; }

    public final double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public final double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public final double getRotation() { return rotation; }
    public void setRotation(double rotation) { this.rotation = rotation; }

    public final double getLineWidth() { return lineWidth; }
    public void setLineWidth(double lineWidth) { this.lineWidth = lineWidth; }

    public final String getLineColor() {return lineColor; }
    public void setLineColor(String lineColor) {this.lineColor = lineColor; }

    public final String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public void transform(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void transform(double x, double y, double rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
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