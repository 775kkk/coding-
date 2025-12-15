package VYZ.ErmakovJava.kyrs2sem1.bloka;

import java.util.Arrays;

public final class spisokZnach {

    // для первые 8 добавлений в конец -O(1)
    private static final int BASE_CAPACITY = 8;

    private int[] values;
    private int size;

    // если делали вставки в позицию insertAt insertAllAt
    private boolean hadInsertions;


    public spisokZnach() {
        this.values = new int[BASE_CAPACITY];
        this.size = 0;
        this.hadInsertions = false;
    }

    public spisokZnach(int... initial) {
        if (initial == null) throw new IllegalArgumentException("values == null");

        int cap = Math.max(BASE_CAPACITY, initial.length);
        this.values = new int[cap];
        System.arraycopy(initial, 0, this.values, 0, initial.length);
        this.size = initial.length;
        this.hadInsertions = false;
    }

    public spisokZnach(spisokZnach other) {
        if (other == null) throw new IllegalArgumentException("other == null");

        int cap = Math.max(BASE_CAPACITY, other.size);
        this.values = new int[cap];
        System.arraycopy(other.values, 0, this.values, 0, other.size);
        this.size = other.size;

        // копия наследует факт вставок
        this.hadInsertions = other.hadInsertions;
    }

    public spisokZnach(fixedSpisok other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        this(other.getArray());
    }

    public spisokZnach(immutableSpisok other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        this(other.getArray());
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public int[] toArray() { return Arrays.copyOf(values, size); }

    @Override
    public String toString() { return Arrays.toString(toArray()); }

    int capacity() { return values.length; }

    public int get(int index) {
        checkIndex(index);
        return values[index];
    }

    public void set(int index, int newValue) {
        checkIndex(index);
        values[index] = newValue;
    }

    public void addLast(int value) {
        // addLast если НЕ было insertAt/insertAllAt
        if (!hadInsertions) {
            ensureCapacityForStarAddLast();
        } else {
            ensureCapacityGeneric(size + 1);
        }
        values[size] = value;
        size++;
    }

    // вставка в index элемент с index вправо
    public void insertAt(int index, int value) {
        checkInsertIndex(index);
        ensureCapacityGeneric(size + 1);

        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        size++;

        hadInsertions = true;
    }

    public void addAllLast(int[] arr) {
        int[] src = requireArray(arr);
        if (src.length == 0) return;

        ensureCapacityGeneric(size + src.length);
        System.arraycopy(src, 0, values, size, src.length);
        size += src.length;
    }

    public void addAllLast(spisokZnach other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        addAllLast(other.toArray());
    }

    // в позицию
    public void insertAllAt(int index, int[] arr) {
        int[] src = requireArray(arr);
        if (src.length == 0) return;

        checkInsertIndex(index);

        ensureCapacityGeneric(size + src.length);

        int k = src.length;
        System.arraycopy(values, index, values, index + k, size - index);
        System.arraycopy(src, 0, values, index, k);

        size += k;
        hadInsertions = true;
    }

    public void insertAllAt(int index, spisokZnach other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        insertAllAt(index, other.toArray());
    }

    public int removeAt(int index) {
        checkIndex(index);

        int removed = values[index];

        System.arraycopy(values, index + 1, values, index, size - index - 1);
        size--;
        values[size] = 0;

        return removed;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
        }
    }

    private void checkInsertIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("insert index=" + index + ", size=" + size);
        }
    }

    private void ensureCapacityForStarAddLast() {
        // первые base_cap вставок в конец — всегда O(1)
        if (size < values.length) return;

        int newCap = Math.max(values.length * 2, values.length + 1);
        values = Arrays.copyOf(values, newCap);
    }

    private void ensureCapacityGeneric(int minCapacity) {
        if (minCapacity <= values.length) return;

        int newCap = Math.max(values.length * 2, BASE_CAPACITY);
        while (newCap < minCapacity) {
            newCap *= 2;
        }

        values = Arrays.copyOf(values, newCap);
    }

    private int[] requireArray(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("array == null");
        return arr;
    }
}
