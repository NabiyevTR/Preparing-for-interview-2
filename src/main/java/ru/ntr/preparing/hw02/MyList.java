package ru.ntr.preparing.hw02;

public interface MyList<E> {

    void add(E value);

    boolean add(int index, E value);

    E get(int index);

    void set(int index, E value);

    boolean remove(E value);

    E remove(int index);

    int removeAll(E value);

    int indexOf(E value);

    int lastIndexOf(E value);

    boolean contains(E value);

    boolean isEmpty();

    int size();

}
