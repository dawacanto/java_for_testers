package ru.stqa.Geometry.figures;

public record Square (double side) {

    public static void printSquareArea (Square q){
       String text = String.format("Площадь квадрата со стороной %f = %f", q.side, q.area());
       System.out.println(text);
    }


    public double perimeter() {
       return this.side*4;
    }

    public double area() {
        return this.side * this.side;
    }
}
