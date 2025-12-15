package VYZ.ErmakovJava.kyrs2sem1.bloka;

import java.util.Arrays;

public final class immutableSpisok {

    private final int[] values;
    private final int size;

    public immutableSpisok(int... values) {
        if (values == null) {
            throw new IllegalArgumentException("values == null");
        }
        this.values = Arrays.copyOf(values, values.length);
        size = values.length;
    }

    public immutableSpisok(immutableSpisok other) {
        if (other == null) {
            throw new IllegalArgumentException("other == null");
        }
        this.values = Arrays.copyOf(other.values, other.values.length);
        size = other.values.length;
    }

    public int get(int index) {
        checkIndex(index);
        return values[index];
    }

    public immutableSpisok withReplaced(int index, int newValue) {
        checkIndex(index);
        int[] copy = Arrays.copyOf(values, values.length);
        copy[index] = newValue;
        return new immutableSpisok(copy);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int[] getArray() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

    private void checkIndex(int index) {
        int n = values.length;
        if (index < 0 || index >= n) {
            throw new IndexOutOfBoundsException("index=" + index + ", size=" + n);
        }
    }
}

