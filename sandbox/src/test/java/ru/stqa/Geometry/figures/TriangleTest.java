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

    @Test
    void cantCreateTriangleWithNegativSide(){
        try {
            new Triangle (-5.0, 4.0, 3.0);
            Assertions.fail();
        }catch (IllegalArgumentException exception){
            //ok
        }
    }

    @Test
    void testEquality(){
        var t1 = new Triangle( 3.0, 4.0, 5.0);
        var t2 = new Triangle (4.0, 5.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }
}