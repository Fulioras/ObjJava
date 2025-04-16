package test;

import shapes.base.*;
import shapes.derived.*;

public class Test{
    public static void main(String args[]) {

        VectorialObject c1 = new Circle();
        c1.moveX(20);
        c1.moveY(35);
        c1.setLineWidth(5);
        c1.setLineColor("Blue");
        c1.setColor("Green");

        Rectangle r1 = new Rectangle();
        r1.move(60, 60);
        r1.rotate(45);
        r1.setWidth(40);
        r1.setHeight(40);
        r1.setColor("red");
        r1.scale(2);


        Rectangle r2 = new Rectangle(70, 70, 0, "pink");
        r2.setWidth(20);
        r2.setHeight(20);
        r2.rotate(45);

        VectorialObject v1 = new VectorialObject();
        System.out.println(v1.getArea());

        System.out.println(c1.toString());
        System.out.println(c1.getArea() + " " + c1.getPerimeter());
        
        System.out.println(r1.toString());
        System.out.println(r1.getArea() + " " + r1.getPerimeter());

        System.out.println(r2.toString());
        System.out.println(r2.getArea() + " " + r2.getPerimeter());
    }
}


