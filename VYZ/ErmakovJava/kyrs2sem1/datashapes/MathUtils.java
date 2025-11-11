package VYZ.ErmakovJava.kyrs2sem1.datashapes;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MathUtils {
    private MathUtils(){}

    public static BigDecimal sum(Number... numbers) {
        BigDecimal result = BigDecimal.ZERO;
        for (Number number : numbers) {
            if (number instanceof Integer) {
                result = result.add(BigDecimal.valueOf(number.intValue()));
            } else if (number instanceof Double) {
                result = result.add(BigDecimal.valueOf(number.doubleValue()));
            } else if (number instanceof BigInteger) {
                result = result.add(new BigDecimal((BigInteger) number));
            } else if (number instanceof Decimal) {
                // Для вашего класса Decimal
                Decimal decimal = (Decimal) number;
                result = result.add(BigDecimal.valueOf(decimal.doubleValue()));
            }
            // добавьте другие типы по необходимости
        }
        return result;
    }

    public static void main(String[] args) {
        // 2 + 3/5 + 2.3 (Integer, Decimal, Double)
        var result1 = sum(2, new Decimal(3, 5), 2.3);
        System.out.println("2 + 3/5 + 2.3 = " + result1);

        // 3.6 + 49/12 + 3 + 3/2 (Double, Decimal, Integer, Decimal)
        var result2 = sum(3.6, new Decimal(49, 12), 3, new Decimal(3, 2));
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);

        // 1/3 + 1 (Decimal, Integer)
        var result3 = sum(new Decimal(1, 3), 1);
        System.out.println("1/3 + 1 = " + result3);

        BigInteger bigInt = new BigInteger("12345678912345678912");
        var resultBig313 = sum(4.,
                                new Decimal(11, 1), // [11] как дробь 11/1
                                3.21,
                                bigInt);
        System.out.println("4.7 + [11] + 3.21 + 12345678912345678912 = " + resultBig313);
    }
}
