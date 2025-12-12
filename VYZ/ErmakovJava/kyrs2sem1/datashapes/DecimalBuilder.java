package VYZ.ErmakovJava.kyrs2sem1.datashapes;

public class DecimalBuilder {
    
    private DecimalBuilder() {
    }
    public static Decimal of(int numerator, int denominator){
        return new Decimal(numerator,denominator);
    }

}
