package ru.anrivlev;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyMapTest {

    @Test
    public void put() {
        MyMap testMap = new MyMap(1, "elem1");
        testMap.put(2, "elem2");

        Assert.assertEquals(testMap.get(2), "elem2");
    }

    @Test
    public void get() {
        MyMap testMap = new MyMap(1, "elem1");

        Assert.assertEquals(testMap.get(1), "elem1");
    }

    @Test
    public void remove() {
        MyMap testMap = new MyMap(1, "elem1");
        testMap.put(2, "elem2");

        testMap.remove(1);

        Assert.assertFalse(testMap.keyContains(1));
    }

    @Test
    public void keyContains() {
        MyMap testMap = new MyMap(1, "elem1");
        testMap.put(2, "elem2");

        Assert.assertTrue(testMap.keyContains(1) && testMap.keyContains(2));
    }

    @Test
    public void getKeys() {
        MyMap testMap = new MyMap(1, "elem1");
        testMap.put(2, "elem2");

        Assert.assertTrue(testMap.getKeys().contains(1) && testMap.getKeys().contains(2) && testMap.getSize() == 2);
    }

    @Test
    public void getValues() {
        MyMap testMap = new MyMap(1, "elem1");
        testMap.put(2, "elem2");

        Assert.assertTrue(testMap.getValues().contains("elem1") && testMap.getValues().contains("elem2") && testMap.getSize() == 2);
    }

    @Test
    public void getEntries() {
    }

    @Test
    public void getSize() {
        MyMap testMap = new MyMap(1, "elem1");
        testMap.put(2, "elem2");
        testMap.put(3, "elem3");

        Assert.assertTrue(testMap.getSize() ==  3);
    }

    @Test
    public void isEmpty() {
        MyMap testMap = new MyMap(1, "elem1");
        testMap.remove(1);

        Assert.assertTrue(testMap.isEmpty());
    }
}