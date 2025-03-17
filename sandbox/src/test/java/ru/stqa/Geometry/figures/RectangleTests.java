package ru.stqa.Geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests{

@Test
void cantCreateRectangleWithNegativeSide(){
    try {
        new Rectangle (5.0, 7.0);
        Assertions.fail();
    }catch (IllegalArgumentException exception){
    }
}

    @Test
    void testEquality(){
        var r1 = new Rectangle( 5.0, 4.0);
        var r2 = new Rectangle (4.0, 5.0);
        Assertions.assertEquals(r1, r2);
    }
}
