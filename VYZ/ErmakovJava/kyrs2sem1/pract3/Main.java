package VYZ.ErmakovJava.kyrs2sem1.pract3;

import java.util.Arrays;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.Tochka;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.line.Polyline;
import VYZ.ErmakovJava.kyrs2sem1.yniversitet.Student;

public class Main {
    public static void main(String[] args) {
        int[] marks = {1,2,3};
        Student vanek = new Student("ZZZ", marks);
        Student vanek1 = new Student("ZZZ", 1,2,3);
        System.out.println(vanek);

        int[] arr1 ={1,2};
        int[] arr2 ={2,1};
        Tochka tochka1 = new Tochka(1, 2);
        Tochka tochka2 = new Tochka(3, 2);
        Polyline line2 = new Polyline("zz",tochka1,tochka2);
        Polyline line1 = new Polyline("zz", arr1,arr2);
        System.out.println(line2);
        System.out.println(line1);
        // 1: 
        Tochka a1 = new Tochka(1, 5);
        Tochka a2 = new Tochka(2, 8);
        Tochka a3 = new Tochka(5, 3);
        Polyline L1 = new Polyline("",Arrays.asList(a1, a2, a3));

        // 2: первая и последняя — a1 a3
        Tochka m1 = new Tochka(2, -5);
        Tochka m2 = new Tochka(4, -8);
        Polyline L2 = new Polyline("",Arrays.asList(a1, m1, m2, a3));
        System.out.println(L1);
        System.out.println(L2);
        //

        City gorodPelmeney = new City("Pelmeney");
        Road roadSmetana = new Road("Smetana", 10);
        Road roadPerec = new Road("Perec", 10);
        gorodPelmeney.addNewRoad(roadSmetana);
        roadPerec.addCity(gorodPelmeney);
        System.out.println(gorodPelmeney);
        System.out.println(roadPerec);

    }
}
