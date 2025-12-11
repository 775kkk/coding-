package VYZ.ErmakovJava.kyrs2sem1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import VYZ.ErmakovJava.kyrs2sem1.electronicsystems.exceptions.ConnectionLostException;
import VYZ.ErmakovJava.kyrs2sem1.electronicsystems.exceptions.ResourceClosedException;
import VYZ.ErmakovJava.kyrs2sem1.electronicsystems.networks.Connection;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.Tochka;
import VYZ.ErmakovJava.kyrs2sem1.pract3.IllegalGradeException;
import VYZ.ErmakovJava.kyrs2sem1.pract3.Student;

public class Main {
    public static void readData() {//4.2.1
        Connection connection = new Connection("ermakov.edu");
        try {
                for (int i = 0; i < 10; i++) {
                    try {
                        String data = connection.getData();  // может бросить два исключения
                        System.out.println(data+", "+"chek id: "+i);
                    }
                    catch(ConnectionLostException e){
                        //ok
                    }
                    catch(ResourceClosedException e){
                        //ok
                    }
                }
            }
        finally{
            connection.close();
        }
    }

    // 4.2.2 Складываем строки. Разработайте метод, который принимает набор строк. Все числа в списке необходимо преобразовать к числу, и поделить первое число в списке на остальные числа в списке. Любую строку, не являющуюся числом, следует игнорировать. Результат деления верните из метода.
    public static double operationStrings(String... values) {
        List<Double> numbers = new ArrayList<>();
        for (String s : values) {
            try {
                double num = Double.parseDouble(s);
                numbers.add(num);
            } catch (NumberFormatException e) {
                // ok
            }
        }
        if (numbers.isEmpty()) {
            return 0.0;
        }
        double result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result /= numbers.get(i);
        }
        return result;
    }

    //4.2.3
    public static String addRandomGrade(List<Student> students) {
        int grade = ThreadLocalRandom.current().nextInt(1, 11);
        // сейвим оценки студентов
        List<List<Integer>> backups = new ArrayList<>();
        for (Student s : students) {
            backups.add(s.getGrades());
        }

        try {
            // добавляем всем
            for (Student s : students) {
                s.addGrade(grade); // если студент не принимает — бросит IllegalGradeException
            }
        } catch (IllegalGradeException e) {// получаем по лбу
            //фиксим косяки так как получили по лбу
            for (int i = 0; i < students.size(); i++) {
                students.get(i).setGrades(backups.get(i));
            }
            return "оценка " + grade + " не добавлена никому: студент "
                    + e.getMessage() + " не принимает такую оценку";
        }

        return "оценка " + grade + " успешно добавлена всем студентам";
    }

    public static double findMax(List<Box<? extends Number>> boxs) {//  6.2.2
        if (boxs.isEmpty()) {
            throw new IllegalArgumentException("cписок пуст");
        }
        double maxBox = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < boxs.size(); i++) {
            Number currValue = boxs.get(i).getObj();
            if (currValue == null) {
                throw new IllegalArgumentException("хранится null");
            }
            double currDoublee = currValue.doubleValue();
            if (currDoublee > maxBox) {
                maxBox = currDoublee;
            }
        }
        return maxBox;
    }

    public static void nachaloOtscheta(Box<? super Tochka> box) {//  6.2.3
        int x = ThreadLocalRandom.current().nextInt(-100, 101);
        int y = ThreadLocalRandom.current().nextInt(-100, 101);
        int z = ThreadLocalRandom.current().nextInt(-100, 101);

        box.setObj(new Tochka(x, y, z));
    }

    public static void fill(List<? super Integer> list) {// 6.2.4
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            return;
        }
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }
    public static <T, A> List<A> method(List<T> t, Applyable<T,A> a){//6.3.1
        List<A> ret = new ArrayList<>() ;
        for (T te : t) {
            ret.add(a.Apply(te));
        }
        return ret;
    }
    public static <T> List<T> filter(List<T> tList, Testyable<T> t){//6.3.2
        List<T> ret = new ArrayList<>() ;
        for (T et : tList) {
            if (!t.test(et)) {
                ret.add(et);
            }
        }
        return ret;
    }
    public static <T> T reduce(List<T> tList, ReduceInstruction<T> reduce){//6.3.3
        return reduce.Reduce(tList);
    }

    public static <P,T> List<P> collect(P sposob, T... argsT){//6.3.4
        List<P> ret = new ArrayList<>(); 
        for (T t : argsT) {
            ret.add((P) t);
        }
        return ret;
    }


    
    public static void main(String[] args) {
        Box<Integer> box = new Box<>(123);
        Storage<Integer> storage = new Storage<>(null);
        Testyable<String> testString = new Testyable<>() {
            public boolean test(String a){
                if (a.length()<=3) {
                    return true;
                }
                return false;
            }
        };
        List<String> a = new ArrayList<>();
        a.add("bbrbrbr");
        a.add("b33r3r3brbrbr");
        List<String> b = Filter(a, testString);
    }
}
