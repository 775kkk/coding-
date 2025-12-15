package VYZ.ErmakovJava.kyrs2sem1.bloka;

import java.util.Arrays;

public final class naborZnach {

    private static final int BASE_CAPACITY = 8;

    private String[] values;
    private int size;
    // пусто
    public naborZnach() {
        this.values = new String[BASE_CAPACITY];
        this.size = 0;
    }

    public naborZnach(naborZnach other) {
        if (other == null) {
            throw new IllegalArgumentException("other == null");
        }
        int cap = Math.max(BASE_CAPACITY, other.size);
        this.values = Arrays.copyOf(other.values, cap);
        this.size = other.size;
    }

    public boolean add(String value) {
        requireNonNull(value);

        if (contains(value)) {
            return false;
        }

        ensureCapacity(size + 1);
        values[size] = value;
        size++;
        return true;
    }

    // добаввка кучи
    public boolean addAll(String[] arr) {
        if (arr == null) throw new IllegalArgumentException("array == null");

        boolean anyAdded = false;
        for (String s : arr) {
            if (s == null) throw new IllegalArgumentException("array contains null");
            if (add(s)) anyAdded = true;
        }
        return anyAdded;
    }

    public boolean addAll(naborZnach other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        return addAll(other.toArray());
    }

    public boolean remove(String value) {
        requireNonNull(value);

        int idx = indexOf(value);
        if (idx < 0) return false;

        // чтобы не сдвигать O(n) кладём на место удаляемого последний элемент
        values[idx] = values[size - 1];
        values[size - 1] = null;
        size--;

        return true;
    }

    // удаление кучи
    public boolean removeAll(String[] arr) {
        if (arr == null) throw new IllegalArgumentException("array == null");

        boolean anyRemoved = false;
        for (String s : arr) {
            if (s == null) throw new IllegalArgumentException("array contains null");
            if (remove(s)) anyRemoved = true;
        }
        return anyRemoved;
    }

    public boolean removeAll(naborZnach other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        return removeAll(other.toArray());
    }

    // наличте
    public boolean contains(String value) {
        requireNonNull(value);
        return indexOf(value) >= 0;
    }

    public int size() {
        return size;
    }

    public String[] toArray() {
        return Arrays.copyOf(values, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private int indexOf(String value) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(value)) return i;
        }
        return -1;
    }
    // расширение
    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= values.length) return;

        int newCap = Math.max(BASE_CAPACITY, values.length);
        while (newCap < minCapacity) {
            int grown = newCap + (newCap + 1) / 2;
            if (grown <= newCap) {// если переполнение то капец
                newCap = Integer.MAX_VALUE;
                break;
            }
            newCap = grown;
        }
        values = Arrays.copyOf(values, newCap);
    }

    private void requireNonNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value == null");
        }
    }
}
