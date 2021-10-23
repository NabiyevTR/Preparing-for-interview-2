package ru.ntr.preparing.hw02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListImplTest {

    private LinkedListImpl<String> linkedList;
    private LinkedListImpl<String> emptyLinkedList;

    @BeforeEach
    void init() {
        linkedList = new LinkedListImpl<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");

        emptyLinkedList = new LinkedListImpl<>();
    }

    @Test
    void add() {
        linkedList.add("6");
        assertEquals(6, linkedList.size());
        assertEquals("6", linkedList.getLast());
        emptyLinkedList.add("1");
        assertEquals("1", emptyLinkedList.getLast());
    }

    @Test
    void get() {
        assertEquals("1", linkedList.get(0));
        assertEquals("2", linkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> emptyLinkedList.get(5));
    }

    @Test
    void set() {
        linkedList.set(2, "33");
        assertEquals(5, linkedList.size());
        assertEquals("33", linkedList.get(2));
    }

    @Test
    void remove() {
        assertFalse(linkedList.remove("11"));
        assertTrue(linkedList.remove("1"));
        assertTrue(linkedList.remove("5"));
        assertFalse(emptyLinkedList.remove("1"));
    }

    @Test
    void removeAll() {
        linkedList.add("1");
        linkedList.add(2, "1");
        assertEquals(3, linkedList.removeAll("1"));
        assertFalse(linkedList.contains("1"));
        assertEquals(0, emptyLinkedList.removeAll("1"));
    }

    @Test
    void indexOf() {
        assertEquals(4, linkedList.indexOf("5"));
        assertEquals(-1, linkedList.indexOf("8"));
        assertEquals(-1, emptyLinkedList.indexOf("8"));
    }

    @Test
    void lastIndexOf() {
        linkedList.addLast("1");
        assertEquals(5, linkedList.lastIndexOf("1"));
        assertEquals(-1, emptyLinkedList.lastIndexOf("1"));
    }

    @Test
    void addFirst() {
        linkedList.addFirst("5");
        assertEquals("5", linkedList.getFirst());
        emptyLinkedList.addFirst("5");
        assertEquals("5", emptyLinkedList.getFirst());
    }

    @Test
    void addLast() {
        linkedList.addLast("6");
        assertEquals("6", linkedList.getLast());
        assertEquals(6, linkedList.size());
        emptyLinkedList.addLast("6");
        assertTrue(emptyLinkedList.contains("6"));
    }

    @Test
    void offerFirst() {
        assertTrue(linkedList.offerFirst("6"));
        assertEquals("6", linkedList.getFirst());
        assertTrue(emptyLinkedList.offerFirst("6"));
        assertEquals("6", emptyLinkedList.getFirst());
    }

    @Test
    void offerLast() {
        assertTrue(linkedList.offerLast("6"));
        assertEquals("6", linkedList.getLast());
        assertTrue(emptyLinkedList.offerLast("6"));
        assertEquals("6", emptyLinkedList.getLast());
    }

    @Test
    void pollFirst() {
        assertEquals("1", linkedList.pollFirst());
        assertEquals(4, linkedList.size());
        assertNull(emptyLinkedList.pollFirst());
    }

    @Test
    void pollLast() {
        assertEquals("5", linkedList.pollLast());
        assertEquals(4, linkedList.size());
        assertNull(emptyLinkedList.pollLast());
    }

    @Test
    void peekFirst() {
        assertEquals("1", linkedList.peekFirst());
        assertEquals(5, linkedList.size());
        assertNull(emptyLinkedList.peekFirst());
    }

    @Test
    void peekLast() {
        assertEquals("5", linkedList.peekLast());
        assertEquals(5, linkedList.size());
        assertNull(emptyLinkedList.peekLast());
    }

    @Test
    void removeFirstOccurrence() {
        linkedList.addFirst("5");
        assertTrue(linkedList.removeFirstOccurrence("5"));
        assertTrue(linkedList.contains("5"));
        assertEquals("5", linkedList.get(4));
        assertEquals(5, linkedList.size());
        assertFalse(emptyLinkedList.removeFirstOccurrence("1"));
    }

    @Test
    void removeLastOccurrence() {
        linkedList.add("1");
        assertTrue(linkedList.removeLastOccurrence("1"));
        assertTrue(linkedList.contains("1"));
        assertEquals("1", linkedList.get(0));
        assertEquals(5, linkedList.size());
        assertFalse(emptyLinkedList.removeLastOccurrence("1"));
    }

    @Test
    void offer() {
        assertTrue(linkedList.offer("6"));
        assertEquals(6, linkedList.size);
    }

    @Test
    void poll() {
        assertEquals("1", linkedList.poll());
        assertEquals(4, linkedList.size());
        assertNull(emptyLinkedList.poll());
    }

    @Test
    void element() {
        assertEquals("1", linkedList.element());
        assertThrows(NoSuchElementException.class, () -> emptyLinkedList.element());
    }

    @Test
    void peek() {
        assertEquals("1", linkedList.peek());
        assertNull(emptyLinkedList.peek());
    }

    @Test
    void push() {
        linkedList.push("0");
        assertEquals("0", linkedList.getFirst());
        assertEquals(6, linkedList.size());
    }

    @Test
    void pop() {
        assertEquals("1", linkedList.pop());
        assertThrows(NoSuchElementException.class, () -> emptyLinkedList.pop());
    }

    @Test
    void removeFirst() {
        assertEquals("1", linkedList.removeFirst());
        assertEquals(4, linkedList.size());
        assertThrows(NoSuchElementException.class, () -> emptyLinkedList.removeFirst());
    }

    @Test
    void removeLast() {
        assertEquals("5", linkedList.removeLast());
        assertEquals(4, linkedList.size());
        assertThrows(NoSuchElementException.class, () -> emptyLinkedList.removeLast());
    }

    @Test
    void getLast() {
        assertEquals("5", linkedList.getLast());
        assertThrows(NoSuchElementException.class, () -> emptyLinkedList.getLast());
    }

    @Test
    void getFirst() {
        assertEquals("1", linkedList.getFirst());
        assertThrows(NoSuchElementException.class, () -> emptyLinkedList.getFirst());
    }

    @Test
    void contains() {
        assertTrue(linkedList.contains("1"));
        assertFalse(emptyLinkedList.contains("1"));
    }

    @Test
    void size() {
        assertEquals(5, linkedList.size());
        assertEquals(0, emptyLinkedList.size());
    }

    @Test
    void isEmpty() {
        assertFalse(linkedList.isEmpty());
        assertTrue(emptyLinkedList.isEmpty());
    }
}