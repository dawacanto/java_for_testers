package ru.stqa.Geometry.figures;

public class Square {
   public static void printSquareArea (double a ){
       String text = String.format("Площадь квадрата со стороной %f = %f", a, squareArea(a));
       System.out.println(text);
    }

    public static double squareArea(double a) {
        return a * a;
    }

    public static double perimeter(double a) {
       return a*4;
    }
}
