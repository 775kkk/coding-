package VYZ.ErmakovJava.kyrs2sem1.bloka;

import java.util.Arrays;

public final class fixedSpisok {
    private static final int DEFAULT_CAPACITY = 100;

    private final int[] values; // фикс макс
    private int size;


    public fixedSpisok() {
        this.values = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public fixedSpisok(int maxCapacity) {
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("maxCapacity < 0");
        }
        this.values = new int[maxCapacity];
        this.size = 0;
    }

    public fixedSpisok(immutableSpisok other) {
        if (other == null) {
            throw new IllegalArgumentException("other == null");
        }
        int[] arr = other.getArray();
        this.values = Arrays.copyOf(arr, arr.length);
        this.size = arr.length;
    }

    public fixedSpisok(fixedSpisok other) {
        if (other == null) {
            throw new IllegalArgumentException("other == null");
        }
        int[] arr = other.getArray();
        this.values = Arrays.copyOf(arr, arr.length);
        this.size = arr.length;
    }

    // --- базовые свойства ---
    public int capacity() {
        return values.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean canAddMore() {
        return size < values.length;
    }

    public int[] getArray() {
        return Arrays.copyOf(values, size);
    }

    @Override
    public String toString() {
        return Arrays.toString(getArray());
    }

    public int get(int index) {
        checkIndex(index);
        return values[index];
    }

    public void set(int index, int newValue) {
        checkIndex(index);
        values[index] = newValue;
    }

    public void addLast(int value) {
        ensureFreeSlots(1);
        values[size] = value;
        size++;
    }

    // вставка в index
    public void insertAt(int index, int value) {
        ensureFreeSlots(1);
        checkInsertIndexStrict(index);

        // сдвиг вправо index size-1 -> index+1 size
        System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        size++;
    }
    // в конец
    public void addAllLast(int[] arr) {
        int[] src = requireArray(arr);
        if (src.length == 0) return;

        ensureFreeSlots(src.length);
        System.arraycopy(src, 0, values, size, src.length);
        size += src.length;
    }

    public void addAllLast(immutableSpisok other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        addAllLast(other.getArray());
    }

    public void addAllLast(fixedSpisok other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        addAllLast(other.getArray());
    }

    // кучу в index
    public void insertAllAt(int index, int[] arr) {
        int[] src = requireArray(arr);
        if (src.length == 0) return;

        ensureFreeSlots(src.length);
        checkInsertIndexStrict(index);

        // сдвигаем правую часть на k
        int k = src.length;
        System.arraycopy(values, index, values, index + k, size - index);
        // вставляем набор
        System.arraycopy(src, 0, values, index, k);

        size += k;
    }

    public void insertAllAt(int index, immutableSpisok other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        insertAllAt(index, other.getArray());
    }

    public void insertAllAt(int index, fixedSpisok other) {
        if (other == null) throw new IllegalArgumentException("other == null");
        insertAllAt(index, other.getArray());
    }

    // del
    public int removeAt(int index) {
        checkIndex(index);
        int removed = values[index];
        // сдвиг влево index+1 size-1 -> index size-2
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

    // строго по заданию: 0..size-1
    private void checkInsertIndexStrict(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("insert index=" + index + ", size=" + size);
        }
    }

    private void ensureFreeSlots(int howMany) {
        int cap = values.length;
        if (size + howMany > cap) {
            throw new IllegalStateException(
                    "список заполнен: size=" + size + ", кapacity=" + cap + ", need=" + howMany
            );
        }
    }

    private int[] requireArray(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("array == null");
        return arr;
    }
}

