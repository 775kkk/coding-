package VYZ.ErmakovJava.kyrs2sem1.pract1.testZadacha;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Dom115;
import VYZ.ErmakovJava.kyrs2sem1.pract1.FIO113;
import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka111;
import VYZ.ErmakovJava.kyrs2sem1.pract1.human112;
import VYZ.ErmakovJava.kyrs2sem1.pract1.time114;

public class test {
    
    public static void main(String[] args) {
        // DynamicMass d = new DynamicMass();
        // System.out.println(d.getLenght());

        // d.add(1);
        // d.add(2);
        // d.add(33);
        // d.add(33);

        // System.out.println(d);
        // d.remove(0);
        // System.out.println(d);
        // d.add(33);
        // System.out.println(d.size());
        // System.out.println(d.getLenght());
        // d.add(33);
        // System.out.println(d.getLenght());
        // System.out.println(d.size());
        // System.out.println(d);
        // System.out.println(d.getValue(3));
// ------------------------------------------------
        // 1.1.1
        System.out.println("1.1.1 :");
        Tochka111 A = new Tochka111(1, 2, 0);
        System.out.println(A);
        System.out.println("======================");

        // 1.1.2
        System.out.println("1.1.2 :");
        human112 human1 = new human112("Andrey",177);
        System.out.println(human1);
        System.out.println("======================");

        // 1.1.3
        System.out.println("1.1.3 :");
        FIO113 human2 = new FIO113("Дом", "Домиков", "Усчадьбъевич");
        System.out.println(human2);
        System.out.println("======================");

        // 1.1.4
        System.out.println("1.1.4 :");
        time114 time = new time114(245661);
        System.out.println(time);
        System.out.println("======================");

        // 1.1.5
        System.out.println("1.1.5 :");
        Dom115 dom = new Dom115(5);
        System.out.println(dom);
        System.out.println("======================");

        


    }
}
