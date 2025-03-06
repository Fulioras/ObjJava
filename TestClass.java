public class TestClass extends VectorialObject{
    public static void main(String args[]) {
        VectorialObject obj1 = new VectorialObject();
        VectorialObject obj2 = new VectorialObject();

        obj2.setLineWidth(2.1);
        obj2.setRotation(0.7);

        obj2.transform(-15, 5.36);
        obj1.transform(15, 30, 1.02);

        obj2.setColor("green");

        VectorialObject.setBaseColor("blue");
        TestClass obj3 = new TestClass();

        obj1.println();
        obj2.println();
        obj3.println();
    }
}
