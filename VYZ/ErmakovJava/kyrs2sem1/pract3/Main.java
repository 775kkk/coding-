package VYZ.ErmakovJava.kyrs2sem1.pract3;

public class Main {
    public static void main(String[] args) {
        int[] marks = {1,2,3};
        Student vanek = new Student("ZZZ", marks);
        Student vanek1 = new Student("ZZZ", 1,2,3);
        System.out.println(vanek);
    }
}
