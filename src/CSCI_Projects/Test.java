package CSCI_Projects;

import java.util.Random;
import java.util.Scanner;

public class Test {

    public static class Triangle {

        private int side1;
        private int side2;
        private int side3;

        public Triangle() {
            this.side1 = 3;
            this.side2 = 4;
            this.side3 = 5;
        }

        public Triangle(int side1, int side2, int side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        public int getSide1() {
            return side1;
        }

        public int getSide2() {
            return side2;
        }

        public int getSide3() {
            return side3;
        }

        public void setSide1(int side1) {
            this.side1 = side1;
        }

        public void setSide2(int side2) {
            this.side2 = side2;
        }

        public void setSide3(int side3) {
            this.side3 = side3;
        }

        public static boolean isValid(int a, int b, int c) {
            return (a + b > c) && (a + c > b) && (b + c > a);
        }

        public boolean isRight() {
            int[] sides = {side1, side2, side3};
            if (sides[0] > sides[1]) {
                int temp = sides[0];
                sides[0] = sides[1];
                sides[1] = temp;
            }
            if (sides[1] > sides[2]) {
                int temp = sides[1];
                sides[1] = sides[2];
                sides[2] = temp;
            }
            if (sides[0] > sides[1]) {
                int temp = sides[0];
                sides[0] = sides[1];
                sides[1] = temp;
            }
            return (sides[0] * sides[0] + sides[1] * sides[1]) == (sides[2] * sides[2]);
        }

        public boolean isIsosceles() {
            return (side1 == side2 || side1 == side3 || side2 == side3);
        }

        public boolean isEquilateral() {
            return (side1 == side2 && side2 == side3);
        }

        public int perimeter() {
            return side1 + side2 + side3;
        }

        public String toString() {
            return "(" + side1 + "," + side2 + "," + side3 + ")";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        System.out.print("How many triangles do you want to generate? ");
        int n = input.nextInt();
        Triangle[] triangles = new Triangle[n];
        System.out.println("\nSides\t\tPerimeter\t\tType");
        for (int i = 0; i < n; i++) {
            int a, b, c;
            do {
                a = r.nextInt(10) + 1;
                b = r.nextInt(10) + 1;
                c = r.nextInt(10) + 1;
            } while (!Triangle.isValid(a, b, c));
            triangles[i] = new Triangle(a, b, c);
            String type;
            if (triangles[i].isEquilateral()) {
                type = "Equilateral";
            } else if (triangles[i].isIsosceles()) {
                type = "Isosceles";
            } else {
                type = "Scalene";
            }
            if (triangles[i].isRight()) {
                type += " Right";
            }
            System.out.println(triangles[i].toString() + "\t\t" + triangles[i].perimeter() + "\t\t\t" + type);
        }

    }
}
