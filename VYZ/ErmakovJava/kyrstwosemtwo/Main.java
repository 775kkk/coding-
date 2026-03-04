package VYZ.ErmakovJava.kyrstwosemtwo;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.Tochka;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.line.Line;
import VYZ.ErmakovJava.kyrstwosemtwo.annotations.ValidateTool;

public class Main {

    private static class Test extends Entity {
        private String s = "DDDDDDD";
        private int x = 241414;

        private Test() {
        }

        private Test(String s, int x) {
            this.s = s;
            this.x = x;
        }
    }
    private static class Testt extends Test {
        private String s = "FSFSFA";

        private Testt() {
        }
        private Testt(String s, int x, String smalls) {
            super(s, x);
            this.s = smalls;
        }

        //8.1.4
        @ValidateTool
        private static void nblank(Test value) {
            if (value.s == null || value.s.isBlank()) {
                throw new IllegalArgumentException("Test.s is blank");
            }
        }

        @ValidateTool
        private static boolean x(Test value) {
            return value.x > 0;
        }

        @ValidateTool
        private static void nblank(Testt value) {
            if (value.s == null || value.s.isBlank()) {
                throw new IllegalStateException("Testt.s is blank");
            }
        }
    }

    public static void main(String[] args) {

System.out.println("--------------8.1.1------------");
        System.out.println(Reflection.collectFields(Line.class));

System.out.println("--------------8.1.2------------");
        Line lineOne = new Line(new Tochka(0, 0, 0), new Tochka(1, 1, 1));
        Line lineTwo = new Line(new Tochka(9, 9, 9), new Tochka(5, 5, 5));
        Reflection.lineConnector(lineOne, lineTwo);
        System.out.println(lineOne);
        System.out.println(lineTwo);

System.out.println("--------------8.1.3------------");
        System.out.println(new Testt());

System.out.println("--------------8.1.4------------");
        Testt ok = new Testt("hello", 42, "child");
        Testt neok = new Testt("hello", -1, "child");

        try {
            Reflection.validate(ok, Testt.class);
            System.out.println("ok ok " + ok);
        } catch (Exception e) {
            System.out.println("ok ne ok " + e.getMessage());
        }

        try {
            Reflection.validate(neok, Testt.class);
            System.out.println("neok ok " + neok);
        } catch (Exception e) {
            System.out.println("neok ne ok " + e.getMessage());
        }

    }
}
