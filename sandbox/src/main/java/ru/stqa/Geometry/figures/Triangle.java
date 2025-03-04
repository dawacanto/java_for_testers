package ru.stqa.Geometry.figures;

public record Triangle(double a, double b, double c) {

    public double perimeter(){
        return a+b+c;
    }

    public double area() {
        var s = (a+b+c)/2;
        return Math.sqrt (s*(s-a)*(s-b)*(s-c));
    }
}
