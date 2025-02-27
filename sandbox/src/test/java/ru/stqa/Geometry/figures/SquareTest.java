package ru.stqa.Geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(25.0, Square.squareArea(5.0));
    }


    @Test
     void canCalculatePerimeter() {
        Assertions.assertEquals(20.0, Square.perimeter(5.0));
    }
}

