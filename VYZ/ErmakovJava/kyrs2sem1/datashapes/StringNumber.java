package VYZ.ErmakovJava.kyrs2sem1.datashapes;

public final class StringNumber extends Number {

    private final String value;

    public StringNumber(String value) {
        if (value == null) {
            throw new IllegalArgumentException("String cannot be null");
        }
        this.value = value;
    }

    @Override
    public int intValue() {
        return value.length();
    }

    @Override
    public long longValue() {
        return value.length();
    }

    @Override
    public float floatValue() {
        return value.length();
    }

    @Override
    public double doubleValue() {
        return value.length();
    }

    @Override
    public String toString() {
        return "StringNumber(\"" + value + "\") = " + value.length();
    }
    
}
