package ru.ntr.preparing.hw02;

import java.util.Collection;
import java.util.Iterator;

public interface MyDeque<E>  {

    void addFirst(E e);

    void addLast(E e);

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E removeFirst();

    E removeLast();

    E pollFirst();

    E pollLast();

    E getFirst();

    E getLast();

    E peekFirst();

    E peekLast();

    boolean removeFirstOccurrence(E value);

    boolean removeLastOccurrence(E value);

    boolean add(int index, E e);

    boolean offer(E e);

    E poll();

    E element();

    E peek();

    void push(E e);

    E pop();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    class Node<E> {
        E item;
        Node<E> previous;
        Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }


}
