package VYZ.ErmakovJava.kyrs2sem1.datashapes;

import VYZ.ErmakovJava.kyrs2sem1.pract5.Decimal;

public class MathUtils {
    private MathUtils(){}

    public static double sum(Number... numbers) {
        double result = 0.0;
        for (Number number : numbers) {
            result += number.doubleValue();
        }
        return result;
    }

    public static void main(String[] args) {
        // 2 + 3/5 + 2.3 (Integer, Decimal, Double)
        double result1 = sum(2, new Decimal(3, 5), 2.3);
        System.out.println("2 + 3/5 + 2.3 = " + result1);

        // 3.6 + 49/12 + 3 + 3/2 (Double, Decimal, Integer, Decimal)
        double result2 = sum(3.6, new Decimal(49, 12), 3, new Decimal(3, 2));
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);

        // 1/3 + 1 (Decimal, Integer)
        double result3 = sum(new Decimal(1, 3), 1);
        System.out.println("1/3 + 1 = " + result3);
    }
}
