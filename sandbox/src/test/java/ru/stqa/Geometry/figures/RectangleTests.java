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
}
