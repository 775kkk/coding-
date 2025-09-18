package VYZ.ErmakovJava.kyrs2sem1.pract1.testZadacha;

public class test {
    
    public static void main(String[] args) {
        DynamicMass d = new DynamicMass();
        System.out.println(d.getLenght());

        d.add(1);
        d.add(2);
        d.add(33);
        d.add(33);

        System.out.println(d);
        d.remove(0);
        System.out.println(d);
        d.add(33);
        System.out.println(d.size());
        System.out.println(d.getLenght());
        d.add(33);
        System.out.println(d.getLenght());
        System.out.println(d.size());
        System.out.println(d);
        System.out.println(d.getValue(3));


    }
}
