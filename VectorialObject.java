public class VectorialObject {
    private static int idCounter = 0;
    private final int id;
    private double x, y;
    private double rotation;
    private double lineWidth;
    private String color;
    private static String baseColor = "black";

    // this() panaudojimas
    public VectorialObject() {
        this(0, 0, 0, 1.0, baseColor); // Iskviecia standartizuota konstruktoriu
    }

    public VectorialObject(double x, double y, double rotation, double lineWidth, String color) {
        this.id = ++idCounter;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.lineWidth = lineWidth;
        this.color = color;
    }

    // setters and getters
    public static void setBaseColor(String color){ baseColor = color; }

    public int getId() { return id; }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double getRotation() { return rotation; }
    public void setRotation(double rotation) { this.rotation = rotation; }

    public double getLineWidth() { return lineWidth; }
    public void setLineWidth(double lineWidth) { this.lineWidth = lineWidth; }

    public String getColor() { return color; }
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


    // println() metodas
    public void println() {
        System.out.println("VectorObject[id=" + id + ", x=" + x + ", y=" + y + ", posukis=" + rotation + ", linijos-plotis=" + lineWidth + ", spalva=" + color + "]");
    }

    // Lokalus testavimas

/*    public static void main(String[] args) {
        VectorialObject vg1 = new VectorialObject();
        vg1.setColor("green");
        vg1.setRotation(2.123);
        vg1.setLocation(50.35, 30);
        vg1.println();

        VectorialObject vg2 = new VectorialObject(10, 20, 45, 2.5, "blue");
        vg2.println();
    }*/
}

