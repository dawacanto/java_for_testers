package ru.stqa.Geometry.figures;

public record Triangle(double a, double b, double c) {

    public Triangle{
        if ( a< 0 || b < 0 || c<0){
            throw new IllegalArgumentException("Triangle's sides should be non-negative");
        }
        if ( (a+b)<c || (a+c)< 0 || (b+c) <0 ){
            throw new IllegalArgumentException("The sum of any two sides must not be less than the third side");
        }
    }

    public double perimeter(){
        return a+b+c;
    }

    public double area() {
        var s = (a+b+c)/2;
        return Math.sqrt (s*(s-a)*(s-b)*(s-c));
    }
}
