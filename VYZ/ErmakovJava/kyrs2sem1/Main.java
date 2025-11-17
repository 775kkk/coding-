package VYZ.ErmakovJava.kyrs2sem1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import VYZ.ErmakovJava.kyrs2sem1.electronicsystems.exceptions.ConnectionLostException;
import VYZ.ErmakovJava.kyrs2sem1.electronicsystems.exceptions.ResourceClosedException;
import VYZ.ErmakovJava.kyrs2sem1.electronicsystems.networks.Connection;
import VYZ.ErmakovJava.kyrs2sem1.pract3.IllegalGradeException;
import VYZ.ErmakovJava.kyrs2sem1.pract3.Student;
import VYZ.ErmakovJava.kyrs2sem1.pract3.Student.GradesPolicy;

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


    
    public static void main(String[] args) {
        // readData();
        // System.out.println(operationStrings("1", "dddd dd", "3","6"));

        Student s1 = new Student("Петров", List.of(5, 4, 5), GradesPolicy.ALWAYS_TRUE());
        Student s2 = new Student("Иванов", List.of(3, 2), grade -> grade >= 2);
        Student s3 = new Student("Сидоров", List.of(3), grade -> grade <= 5);
        List<Student> students = List.of(s1, s2, s3);
        System.out.println(addRandomGrade(students));

    }
}
