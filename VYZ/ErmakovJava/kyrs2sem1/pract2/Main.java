package VYZ.ErmakovJava.kyrs2sem1.pract2;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka111;

public class Main {

    public static void main(String[] args) {
        // 1.2.1
        System.out.println("1.2.1 :");
        Tochka111 A = new Tochka111(1, 3, 0);
        Tochka111 B = new Tochka111(23, 8, 0);
        Line lineOne = new Line(A,B);
        Line lineTwo = new Line(5,10,0,25,10,0);
        Line lineThrid = new Line(A,lineTwo.getB());
        System.out.println("Вводные:");
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThrid);
        B.setY(2);
        lineTwo.getA().setX(111);
        System.out.println("изменения:");
        System.out.println(lineOne);
        System.out.println(lineTwo);
        System.out.println(lineThrid);
        System.out.println("======================");
        // 1.2.2
        System.out.println("1.2.2 :");
        People people1 = new People("Иван","Чудов");
        People people2 = new People("Петр","Чудов");
        People people3 = new People("Борис");
        people2.setPhather(people1);
        people3.setPhather(people2);
        System.out.println(people1);
        System.out.println(people2);
        System.out.println(people3);

        System.out.println("======================");
    }
}
