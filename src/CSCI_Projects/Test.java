package CSCI_Projects;

import java.util.Random;
import java.util.Scanner;

public class Test {
    
    class Triangle {
    // Private data fields
    private int side1;
    private int side2;
    private int side3;

    // No-arg constructor (default values)
    public Triangle() {
        this.side1 = 3;
        this.side2 = 4;
        this.side3 = 5;
    }

    // Constructor with parameters
    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Accessors (getters)
    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

    // Mutators (setters)
    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }

    // Static method to check if three sides form a valid triangle
    public static boolean isValid(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Check if triangle is right
    public boolean isRight() {
        int[] sides = {side1, side2, side3};
        java.util.Arrays.sort(sides); // sort to make sure the largest is last
        return (sides[0] * sides[0] + sides[1] * sides[1]) == (sides[2] * sides[2]);
    }

    // Check if triangle is isosceles
    public boolean isIsosceles() {
        return (side1 == side2 || side1 == side3 || side2 == side3);
    }

    // Check if triangle is equilateral
    public boolean isEquilateral() {
        return (side1 == side2 && side2 == side3);
    }

    // Compute perimeter
    public int perimeter() {
        return side1 + side2 + side3;
    }

    // toString method
    public String toString() {
        return "(" + side1 + "," + side2 + "," + side3 + ")";
    }
}

// Main class (application)
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many triangles do you want to generate? ");
        int n = input.nextInt();

        Triangle[] triangles = new Triangle[n];

        System.out.println("\nSides\t\tPerimeter\tType");

        for (int i = 0; i < n; i++) {
            int a, b, c;

            // Generate valid triangle sides
            do {
                a = rand.nextInt(10) + 1;
                b = rand.nextInt(10) + 1;
                c = rand.nextInt(10) + 1;
            } while (!Triangle.isValid(a, b, c));

            // Create triangle
            triangles[i] = new Triangle(a, b, c);

            // Determine type
            String type;
            if (triangles[i].isEquilateral()) {
                type = "Equilateral";
            } else if (triangles[i].isIsosceles()) {
                type = "Isosceles";
            } else {
                type = "Scalene";
            }

            // Check if right triangle
            if (triangles[i].isRight()) {
                type += " Right";
            }

            // Display results
            System.out.printf("%-10s\t%-10d\t%s\n", triangles[i].toString(), triangles[i].perimeter(), type);
        }

        input.close();
    }
}
}
