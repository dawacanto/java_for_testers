package ru.stqa.Geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    void canCalculateArea() {
        var s = new Square(6.0);
        double result = s.area();
        Assertions.assertEquals(25.0, result);

    }



    @Test
     void canCalculatePerimeter() {
        Assertions.assertEquals(20.0, new Square(5.0).perimeter());
    }

    @Test
    void cantCreateSquareWithNegativSide(){
        try {
        new Square (-5.0);
        Assertions.fail();
    }catch (IllegalArgumentException exception){
            //ok
        }
    }

    @Test
    void testNonEquality(){
        var s1 = new Square( 5.0);
        var s2 = new Square (4.0);
        Assertions.assertNotEquals(s1, s2);
    }

    @Test
    void testPass(){
        var s1 = new Square (5.0);
        var s2 = new Square (5.0);
        Assertions.assertTrue(s1.equals(s2));
    }
}

