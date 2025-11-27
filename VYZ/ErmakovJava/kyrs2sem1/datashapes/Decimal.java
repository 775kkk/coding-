package VYZ.ErmakovJava.kyrs2sem1.datashapes;

public class Decimal extends Number implements Cloneable{
    private final int numerator;//числитель
    private final int denominator;//знаменатель

    public Decimal(int numerator, int denominator){
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator cannot be 0 ; x/0 unreal!");
        }
        this.denominator=denominator;
        this.numerator=numerator;
    }

    // public void setDenominator(int denominator) {
    //     this.denominator = denominator;
    // }
    // public void setNumerator(int numerator) {
    //     this.numerator = numerator;
    // }
    public int getDenominator() {
        return denominator;
    }
    public int getNumerator() {
        return numerator;
    }

    @Override
    public int intValue() {
        return numerator/denominator;
    }
    @Override
    public float floatValue() {
        return numerator/denominator;
    }
    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
    
    @Override
    public long longValue() {
        return numerator/denominator;
    }

    @Override
    public short shortValue() {
        return (short) (numerator / denominator);
    }
    @Override
    public byte byteValue() {
        return (byte) (numerator / denominator);
    }


    // public void trimDecimal(){
    //     int tempNok = Math.abs(this.getDenominator());
    //     int temp = Math.abs(this.getNumerator());
        
    //     while (temp != 0) {
    //         int tempVar = temp;
    //         temp = tempNok % temp;
    //         tempNok = tempVar;
    //     }
        
    //     this.setNumerator(this.getNumerator() / tempNok);
    //     this.setDenominator(this.getDenominator() / tempNok);
    // }

    // public void addUpDecimal(Decimal decimal){
    //     this.setNumerator(
    //         this.getNumerator()*decimal.getDenominator()
    //         +
    //         decimal.getNumerator()*this.getDenominator()
    //     );
    //     this.setDenominator(
    //         this.getDenominator()*decimal.getDenominator()
    //     );
    //     this.trimDecimal();
    // }
    // public void multiplyDecimal(Decimal decimal){
    //     this.setDenominator(this.getDenominator()*decimal.getDenominator());
    //     this.setNumerator(this.getNumerator()*decimal.getNumerator());
    //     this.trimDecimal();
    // }
    // public void divideDecimal(Decimal decimal){
    //     this.setDenominator(this.getDenominator()*decimal.getNumerator());
    //     this.setNumerator(this.getNumerator()*decimal.getDenominator());
    //     this.trimDecimal();
    // }


    @Override
    public String toString() {
        return this.numerator+"/"+this.denominator;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decimal decimal = (Decimal) o;
        return (numerator  == decimal.numerator) && (decimal.denominator == denominator);
    }

    @Override
    public int hashCode() {
        return 31 * numerator + denominator;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Decimal(numerator, denominator);
    }
}


