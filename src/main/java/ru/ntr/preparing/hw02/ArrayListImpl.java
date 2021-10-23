package ru.ntr.preparing.hw02;

import java.util.Arrays;
import java.util.Objects;

public class ArrayListImpl<E extends Comparable<? super E>> implements MyList<E> {


    protected static final int DEFAULT_CAPACITY = 10;
    protected static final float DEFAULT_SCALE_FACTOR = 1.5f;

    protected E[] data;
    protected int size;
    protected float scaleFactor = 1.5f;

    // Constructors

    public ArrayListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListImpl(int initialCapacity) {
        data = (E[]) new Comparable[initialCapacity];
    }

    @Override
    public void set(int index, E value) {
        checkIndex(index);
        data[index] = value;
    }

    @Override
    public void add(E value) {
        checkAndResize();
        data[size++] = value;
    }

    @Override
    public boolean add(int index, E value) {
        checkIndex(index);
        checkAndResize();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
        return true;
    }

    private void checkAndResize() {
        if (size == data.length) {
            data = Arrays.copyOf(data, calculateLength());
        }
    }

    private int calculateLength() {
        return size == 0 ? 1 : (int) (scaleFactor * size + 1);
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public boolean remove(E value) {
        int valueIndex = indexOf(value);
        if (valueIndex == -1) return false;
        return remove(indexOf(value)) != null;
    }

    @Override
    public int removeAll(E value) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                remove(i--);
                counter++;
            }
        }
        return counter;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return removedValue;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Incorrect index. Index must be in range [0..%s].", size - 1)
            );
        }
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E value) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i].toString()).append(" ");
        }
        sb.trimToSize();
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListImpl<?> array = (ArrayListImpl<?>) o;
        return size == array.size &&
                Arrays.equals(data, array.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
