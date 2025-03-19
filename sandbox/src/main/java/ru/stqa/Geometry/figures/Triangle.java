package ru.stqa.Geometry.figures;

import java.util.Objects;

public record Triangle(double a, double b, double c) {

    public Triangle{
        if ( a< 0 || b < 0 || c<0){
            throw new IllegalArgumentException("Triangle's sides should be non-negative");
        }
        if ( (a+b)<c || (a+c)< b || (b+c) <a ){
            throw new IllegalArgumentException("The sum of any two sides must not be less than the third side");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.c) == 0 && Double.compare(c, triangle.b) == 0)
                ||(Double.compare(a, triangle.a) == 0 && Double.compare(c, triangle.b) == 0 && Double.compare(b, triangle.c) == 0)
                ||(Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.c) == 0)
                ||(Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.c) == 0 && Double.compare(c, triangle.a) == 0)
                ||(Double.compare(a, triangle.c) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.a) == 0)
                ||(Double.compare(a, triangle.c) == 0 && Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.b) == 0);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public double perimeter(){
        return a+b+c;
    }

    public double area() {
        var s = (a+b+c)/2;
        return Math.sqrt (s*(s-a)*(s-b)*(s-c));
    }
}
