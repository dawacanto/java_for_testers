package ru.stqa.Geometry.figures;

public record Rectangle (double a, double b) {



    public static void printRectangleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f равна %f", a, b, rectangleArea(a,b));
        System.out.println(text);
    }

    private static double rectangleArea(double a, double b) {
        return a*b;
    }
}
