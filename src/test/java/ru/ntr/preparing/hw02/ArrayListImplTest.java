package ru.ntr.preparing.hw02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListImplTest {

    private MyList<String> arrayList;


    @BeforeEach
    void init() {
        arrayList = new ArrayListImpl<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
    }

    @Test
    void set() {
        arrayList.set(0, "0");
        assertEquals(5, arrayList.size());
        assertEquals("0", arrayList.get(0));
    }

    @Test
    void add() {
        arrayList.add(0, "0");
        assertEquals(6, arrayList.size());
        assertEquals("0", arrayList.get(0));
        assertEquals("5", arrayList.get(arrayList.size() - 1));
    }

    @Test
    void get() {
        assertEquals("2", arrayList.get(1));
    }

    @Test
    void remove() {
        arrayList.remove("2");
        assertTrue(arrayList.size() == 4);
    }

    @Test
    void removeAll() {
        arrayList.add("10");
        arrayList.add("10");
        assertEquals(2, arrayList.removeAll("10"));
    }


    @Test
    void indexOf() {
        assertEquals(arrayList.indexOf("2"), 1);
    }

    @Test
    void lastIndexOf() {
        assertEquals(0, arrayList.lastIndexOf("1"));
        arrayList.add("1");
        assertEquals(arrayList.lastIndexOf("1"), arrayList.size() - 1);
    }

    @Test
    void contains() {
        assertTrue(arrayList.contains("1"));
        assertFalse(arrayList.contains("11"));
    }

    @Test
    void isEmpty() {
        assertFalse(arrayList.isEmpty());
    }

    @Test
    void size() {
        assertEquals(5, arrayList.size());
    }
}