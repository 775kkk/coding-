package VYZ.ErmakovJava.kyrs2sem1.datashapes;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class Powcmd {
    public static double power(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }
    
    public static void main(String[] args) {
        if (args.length >= 2) {
            double result = power(args[0], args[1]);
            System.out.println(args[0] + "^" + args[1] + " = " + result);
        } else {
            System.out.println("использовать: java PowerCalculator x y");
        }
    }
}
