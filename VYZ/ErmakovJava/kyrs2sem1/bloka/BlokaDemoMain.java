package VYZ.ErmakovJava.kyrs2sem1.bloka;

import VYZ.ErmakovJava.kyrs2sem1.pract3.City;
// import VYZ.ErmakovJava.kyrs2sem1.bloka.Marshrut;
import VYZ.ErmakovJava.kyrs2sem1.pract3.Road;

import java.util.Arrays;

public final class BlokaDemoMain {

    public static void main(String[] args) {
        demoImmutable();
        demoFixed();
        demoSpisok();
        demoNabor();
        demoSekret();
        demoPhone();
        demoKontacts();
        demoUzel();
        demoMarshrut();
    }

    private static void demoImmutable() {
        System.out.println("=== A.1.1 immutableSpisok ===");
        immutableSpisok a = new immutableSpisok(1, 2, 3);
        System.out.println("start " + a);
        System.out.println("get[1]=" + a.get(1));
        System.out.println("replace[1]=9 -> " + a.withReplaced(1, 9));
        System.out.println();
    }

    private static void demoFixed() {
        System.out.println("=== A.1.2 fixedSpisok ===");
        fixedSpisok f = new fixedSpisok(3);
        f.addLast(10);
        f.addLast(20);
        f.insertAt(1, 15);
        System.out.println("fill " + f + ", size=" + f.size() + ", cap=" + f.capacity());
        System.out.println("removeAt1=" + f.removeAt(1) + " -> " + f);
        System.out.println("canAddMore=" + f.canAddMore());
        System.out.println();
    }

    private static void demoSpisok() {
        System.out.println("=== A.1.3/1.4 spisokZnach ===");
        spisokZnach s = new spisokZnach();
        for (int i = 0; i < 8; i++) s.addLast(i);
        System.out.println("8 adds cap=" + s.capacity() + " data=" + s);
        s.addLast(99); // рост после 8
        System.out.println("after 9th cap=" + s.capacity() + " data=" + s);
        s.insertAt(2, 777);
        System.out.println("insert@2 -> " + s);
        System.out.println();
    }

    private static void demoNabor() {
        System.out.println("=== A.1.5 naborZnach ===");
        naborZnach set = new naborZnach();
        System.out.println("add a " + set.add("a"));
        System.out.println("add a again " + set.add("a"));
        System.out.println("addAll b,a,c -> " + set.addAll(new String[]{"b", "a", "c"}) + " " + set);
        System.out.println("remove b -> " + set.remove("b") + " " + set);
        System.out.println();
    }

    private static void demoSekret() {
        System.out.println("=== A.1.6 sekret ===");
        sekret first = new sekret("Вася", "секретное слово");
        sekret second = new sekret(first, "Петя");
        sekret third = new sekret(second, "Маша");
        System.out.println(first);
        System.out.println(second + " order=" + second.getOrder() + " after=" + second.countAfter());
        System.out.println("name +1=" + second.getHolderNameByOffset(1));
        System.out.println("len diff -1=" + third.diffTextLengthWithOffset(-1));
        System.out.println();
    }

    private static void demoPhone() {
        System.out.println("=== A.1.7/1.8 phoneSpravka ===");
        phoneSpravka book = new phoneSpravka();
        System.out.println("put ivan -> " + book.put("8900", "Иван"));
        System.out.println("put ivan new -> old=" + book.put("8901", "Иван"));
        System.out.println("put petr -> " + book.put("8800", "Петр"));
        System.out.println("containsPhone 8901? " + book.containsPhone("8901"));
        System.out.println("get ivan " + book.getPhoneByName("Иван"));
        System.out.println("pairs " + Arrays.toString(book.toPairsArray()));
        System.out.println("remove Петр " + book.removeByName("Петр"));
        System.out.println("pairs " + Arrays.toString(book.toPairsArray()));
        System.out.println();
    }

    private static void demoKontacts() {
        System.out.println("=== A.1.9 spisokKontactov ===");
        spisokKontactov ks = new spisokKontactov();
        ks.put("111", "Max");
        ks.put("222", "Max"); // новый основной
        ks.put("333", "Bob");
        // телефон 333 перепривязка к Max
        ks.put("333", "Max");
        System.out.println("phones Max " + Arrays.toString(ks.getPhonesByName("Max")));
        System.out.println("containsPhone 333? " + ks.containsPhone("333"));
        System.out.println("remove Bob " + ks.removeByName("Bob"));
        System.out.println("pairs " + Arrays.toString(ks.toPairsArray()));
        System.out.println();
    }

    private static void demoUzel() {
        System.out.println("=== A.1.10/1.11 Uzel ===");
        Uzel root = new Uzel();
        int[] nums = {3, 5, 4, 7, 1, 2};
        for (int n : nums) root.add(n);
        System.out.println("tree " + root);
        System.out.println("contains 4? " + root.contains(4));
        System.out.println("remove 5 -> " + root.remove(5) + " tree " + root);
        System.out.println();
    }

    private static void demoMarshrut() {
        System.out.println("=== A.1.12 Marshrut ===");
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");
        City f = new City("F");

        Road ab = new Road("AB", 1);
        ab.addCity(a);
        ab.addCity(b);
        Road bc = new Road("BC", 1);
        bc.addCity(b);
        bc.addCity(c);
        Road cd = new Road("CD", 1);
        cd.addCity(c);
        cd.addCity(d);
        Road fb = new Road("FB", 1);
        fb.addCity(f);
        fb.addCity(b);

        Marshrut m = new Marshrut(f, d);
        System.out.println("path F->D: " + m.toString());
    }
}
