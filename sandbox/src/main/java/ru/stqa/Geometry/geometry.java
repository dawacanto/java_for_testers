package ru.stqa.Geometry;

import ru.stqa.Geometry.figures.Rectangle;
import ru.stqa.Geometry.figures.Square;

public class geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square (6.8));
        Square.printSquareArea((new Square(8.8)));
        Square.printSquareArea((new Square(6.2)));

        Rectangle.printRectangleArea (3.0, 5.0);
        Rectangle.printRectangleArea (4.0, 5.0);
        Rectangle.printRectangleArea (7.0, 9.0);

    }

}
