package ru.ntr.preparing.hw02;

import java.util.NoSuchElementException;

public class LinkedListImpl<E> implements MyList<E>, MyDeque<E> {

    protected int size;
    private Node<E> firstElement;
    private Node<E> lastElement;

    @Override
    public boolean add(int index, E value) {
        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;
        int counter = 0;

        if (index < 0) throw new IndexOutOfBoundsException();

        if (index == 0) {
            Node<E> entry = new Node<>(value, null, current);
            current.previous = entry;
            firstElement = entry;
            size++;
            return true;
        }

        while (current != null && counter < index) {
            previous = current;
            current = current.next;
            next = current.next;
            counter++;
        }

        if (current == null) throw new IndexOutOfBoundsException();

        Node<E> entry = new Node<>(value, previous, next);

        if (current.next == null) {
            lastElement = entry;
        }

        current.next = entry;
        next.previous = entry;
        size++;

        return true;
    }

    @Override
    public void add(E value) {
        addLast(value);
    }

    @Override
    public E get(int index) {

        if (size == 0) throw new IndexOutOfBoundsException();

        Node<E> current = firstElement;
        int counter = 0;

        if (index < 0) throw new IndexOutOfBoundsException();

        while (counter < index) {
            current = current.next;
            if (current == null) throw new IndexOutOfBoundsException();
            counter++;
        }

        return current.item;

    }

    @Override
    public void set(int index, E value) {

        if (index < 0) throw new IndexOutOfBoundsException();

        Node<E> current = firstElement;
        int counter = 0;

        while (current != null) {
            if (counter == index) {
                current.item = value;
                return;
            }
            current = current.next;
            counter++;
        }

        throw new IndexOutOfBoundsException();
    }

    @Override
    public E remove(int index) {
        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;
        int counter = 0;

        if (index < 0) throw new IndexOutOfBoundsException();

        while (counter <= index) {
            previous = current;
            current = current.next;
            next = current.next;
            counter++;
        }

        if (current == null) throw new IndexOutOfBoundsException();

        current = null;
        previous.next = next.previous;
        next.previous = previous.next;
        size--;

        return null;
    }

    @Override
    public boolean remove(E value) {
        return removeFirstOccurrence(value);
    }

    @Override
    public int removeAll(E value) {

        if (size == 0) return 0;

        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;
        int removeCounter = 0;

        if (size == 0) return -1;

        while (current != null) {
            if (current.item.equals(value)) {

                if (current == firstElement) {
                    firstElement = next;
                    next.previous = null;
                } else if (current == lastElement) {
                    lastElement = previous;
                    previous.next = null;
                } else {
                    previous.next = current.next;
                    next.previous = current.previous;
                }

                size--;
                removeCounter++;


            }
            if (next == null) break;

            current = next;
            next = current.next;
            previous = current.previous;
        }

        return removeCounter;
    }

    @Override
    public int indexOf(E value) {
        Node<E> current = firstElement;
        int counter = 0;

        while (current != null) {
            if (current.item.equals(value)) return counter;
            current = current.next;
            counter++;
        }

        return -1;

    }

    @Override
    public int lastIndexOf(E value) {
        Node<E> current = lastElement;
        int counter = size - 1;

        while (current != null) {
            if (current.item.equals(value)) return counter;
            current = current.previous;
            counter--;
        }

        return -1;
    }

    @Override
    public void addFirst(E value) {
        Node<E> entry = new Node<>(value, null, firstElement);
        if (isEmpty()) {
            firstElement = entry;
        } else {
            firstElement.previous = entry;
            firstElement = entry;
        }

        size++;

        if (size == 1) {
            lastElement = firstElement;
        }
    }

    @Override
    public void addLast(E value) {
        Node<E> entry = new Node<>(value, lastElement, null);
        if (isEmpty()) {
            firstElement = entry;
        } else {
            lastElement.next = entry;
        }
        lastElement = entry;
        size++;
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E pollFirst() {
        return removeFirst();
    }

    @Override
    public E pollLast() {
        return removeLast();
    }

    @Override
    public E peekFirst() {
        if (size == 0)
            return null;
        return getFirst();
    }

    @Override
    public E peekLast() {
        if (size == 0)
            return null;
        return getLast();
    }

    @Override
    public boolean removeFirstOccurrence(E value) {

        if (size == 0) return false;

        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;


        while (current != null) {
            if (current.item.equals(value)) {

                if (current == firstElement) {
                    firstElement = current.next;
                } else if (current == lastElement) {
                    lastElement = current.previous;
                } else {
                    previous.next = next.previous;
                    next.previous = previous.next;
                }
                current = null;
                size--;
                return true;
            }
            if (current == lastElement) return false;
            previous = current;
            current = current.next;
            next = current.next;
        }

        return false;
    }

    @Override
    public boolean removeLastOccurrence(E value) {

        if (size == 0) return false;

        Node<E> current = lastElement;
        Node<E> next = null;
        Node<E> previous = current.previous;

        while (current != null) {
            if (current.item.equals(value)) {
                if (current == firstElement) {
                    firstElement = current.next;
                } else if (current == lastElement) {
                    lastElement = current.previous;
                } else {
                    previous.next = next.previous;
                    next.previous = previous.next;
                }
                current = null;
                size--;
                return true;
            }
            if (current == firstElement) return false;
            next = current;
            current = current.previous;
            previous = current.next;
        }

        return false;
    }

    @Override
    public boolean offer(E e) {
        add(e);
        return true;
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E element() {
        if (size == 0) throw new NoSuchElementException();
        return firstElement.item;
    }

    @Override
    public E peek() {
        if (size == 0) return null;
        return firstElement.item;
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        if (size == 0) throw new NoSuchElementException();

        return removeFirst();
    }


    @Override
    public E removeFirst() {

        if (size == 0) throw new NoSuchElementException();

        Node<E> removedElement = firstElement;
        E data = removedElement.item;
        firstElement = firstElement.next;
        removedElement.previous = null;
        removedElement.next = null;
        removedElement.item = null;
        size--;
        if (isEmpty()) {
            lastElement = null;
        }
        return data;
    }

    @Override
    public E removeLast() {

        if (size == 0) throw new NoSuchElementException();

        Node<E> removedElement = lastElement;
        E data = removedElement.item;
        lastElement = lastElement.previous;
        lastElement.next = null;
        removedElement.previous = null;
        removedElement.next = null;
        removedElement.item = null;
        size--;
        if (isEmpty()) {
            firstElement = null;
        }
        return data;
    }


    @Override
    public E getLast() {
        if (size == 0) throw new NoSuchElementException();
        return lastElement.item;
    }

    @Override
    public E getFirst() {
        if (size == 0) throw new NoSuchElementException();
        return firstElement.item;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        Node<E> current = firstElement;
        StringBuilder sb = new StringBuilder().append("[");
        while (current != null) {
            sb.append(current.item);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

}
