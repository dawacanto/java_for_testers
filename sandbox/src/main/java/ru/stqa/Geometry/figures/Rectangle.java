package ru.stqa.Geometry.figures;

import java.util.Objects;

public record Rectangle (double a, double b) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(a, rectangle.a) == 0 && Double.compare(b, rectangle.b) == 0)|| (Double.compare(a, rectangle.b) == 0 && Double.compare(b, rectangle.a) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public Rectangle{
        if (a < 0 || b < 0 ){
            throw new IllegalArgumentException("Rectangle side should be non negative");
        }
    }



    public static void printRectangleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f равна %f", a, b, rectangleArea(a,b));
        System.out.println(text);
    }

    private static double rectangleArea(double a, double b) {
        return a*b;
    }
}
