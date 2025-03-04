package ru.stqa.Geometry.figures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TriangleTest {

    @Test
    void calculatePerimeter() {
        var T1 = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(12.0, T1.perimeter());
    }

    @Test
    void calculateSquare() {
        Assertions.assertEquals(6.0, new Triangle(3.0, 4.0, 5.0).area());

    }
}