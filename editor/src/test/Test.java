package test;

import shapes.base.*;
import shapes.derived.*;
import shapes.interfaces.*;
import shapes.exceptions.*;
import shapes.factories.*;

import java.util.Arrays;

public class Test{
    public static void main(String args[]) {

        try {
            // 1. Create a Circle using the Factory Method
            CircleFactory factory = new CircleFactory();
            Circle original = (Circle) factory.createShape();

            // Set additional attributes
            original.setRadius(30);
            original.addTag("marked");
            original.addTag("colored");

            // 2. Clone the Circle (deep copy)
            Circle clone = (Circle) original.clone();

            // Modify the clone to prove deep cloning
            clone.setRadius(60);
            original.addTag("moved");

            // 3. Print both objects
            System.out.println("Original Circle:");
            System.out.println(original);
            System.out.println(original.getTags());

            System.out.println("\nCloned Circle (Modified):");
            System.out.println(clone);
            System.out.println(clone.getTags());


        } catch (BadRadiusValue e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}