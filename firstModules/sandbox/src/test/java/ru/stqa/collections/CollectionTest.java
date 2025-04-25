package ru.stqa.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionTest {

    @Test
    void arrayTests() {
        // var array = new String[]{"a","b","c"};
        var array = new String[3];
        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);

        array[0] = "d";
        Assertions.assertEquals("a", array[0]);
    }


    @Test
    void listTest() {
        var list = new ArrayList<>(List.of("a", "b","c"));

        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d");
        list.add(0, "h");
    }

    @Test
    void setTest(){
        var set = Set.copyOf(List.of("a","b","c","a"));
        Assertions.assertEquals(3, set.size());
        var element = set.stream().findAny().get();

    }
}