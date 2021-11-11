package ru.anrivlev.lab1;

import org.junit.Assert;
import org.junit.Test;

public class MyListTest {

    @Test
    public void getSize_1() {
        MyList listTest = new MyList("TEXT1");

        int expected = 1;
        int actual = listTest.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSize() {
        MyList listTest = new MyList("TEXT1");
        listTest.add("TEXT2");
        listTest.add("TEXT3");

        int expected = 3;
        int actual = listTest.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSize_0() {
        MyList listTest = new MyList();

        int expected = 0;
        int actual = listTest.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void add() {
        MyList actual = new MyList();

        int expected = 78;

        actual.add(78);

        Assert.assertTrue(actual.get(0).equals(expected) && actual.getSize() == 1);
    }

    @Test
    public void remove() {
        MyList actual = new MyList("78");
        actual.add("TEXT1");
        actual.add("TEXT2");

        actual.remove(1);

        Assert.assertTrue(actual.get(0) == "78" && actual.get(1) == "TEXT2" && actual.getSize() == 2);
    }

    @Test
    public void remove_last() {
        MyList actual = new MyList("TEXT1");

        actual.remove(0);

        Assert.assertTrue(actual.isEmpty());
    }


    @Test
    public void remove_tail() {
        MyList actual = new MyList("TEXT1");
        actual.add("TEXT2");
        actual.add("TEXT3");

        actual.remove(2);

        Assert.assertTrue(!actual.contains("TEXT3") && actual.contains("TEXT1") && actual.contains("TEXT2"));
    }

    @Test
    public void get() {
        MyList actual = new MyList("TEXT1");

        Assert.assertEquals(actual.get(0), "TEXT1");
    }

    @Test
    public void set() {
        MyList actual = new MyList("TEXT1");

        actual.set("NewText", 0);

        Assert.assertEquals(actual.get(0), "NewText");
    }

    @Test
    public void isEmpty() {
        MyList actual = new MyList();

        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void contains() {
        MyList actual = new MyList("TEXT1");

        Assert.assertTrue(actual.contains("TEXT1") && !actual.contains("TEXT2"));
    }

    @Test
    public void indexOf() {
        MyList actual = new MyList("TEXT1");

        Assert.assertTrue(actual.indexOf("TEXT1") == 0 && actual.indexOf("TEXT2") == -1);
    }

    @Test
    public void testToString() {
    }

    @Test
    public void merge() {
        MyList list1 = new MyList(1.0);
        list1.add(2.7);
        list1.add(6.2);
        list1.add(8.3);
        list1.add(10.0);
        list1.add(10.1);
        MyList list2 = new MyList(3.4);
        list2.add(3.7);
        list2.add(9.4);

        MyList list3 = MyList.merge(list1, list2);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }
}
