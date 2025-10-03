package VYZ.ErmakovJava.kyrs2sem1.pract2;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;

public class Main {

    public static void main(String[] args) {
        // 1.2.1
        System.out.println("1.2.1 :");
        Tochka A = new Tochka(1, 3, 0);
        Tochka B = new Tochka(23, 8, 0);
        Line lineOne = new Line(A,B);
        // // Line lineTwo = new Line(5,10,0,25,10,0);
        // Line lineThrid = new Line(A,lineTwo.getB());
        // System.out.println("Вводные:");
        // System.out.println(lineOne);
        // System.out.println(lineTwo);
        // System.out.println(lineThrid);
        // B.setY(2);
        // lineTwo.getA().setX(111);
        // System.out.println("изменения:");
        // System.out.println(lineOne);
        // System.out.println(lineTwo);
        // System.out.println(lineThrid);
        System.out.println("======================");
        // 1.2.2 - 1.2.3
        System.out.println("1.2.2 - 1.2.3 :");
        People people1 = new People("Иван","Чудов");
        People people2 = new People("Петр","Чудов");
        People people3 = new People("Борис");
        people2.setPhather(people1);
        people3.setPhather(people2);
        System.out.println(people1);
        System.out.println(people2);
        System.out.println(people3);
        System.out.println("======================");
        // 1.2.4
        System.out.println("1.2.4 :");
        // EmployeesAndDepartments structut1 = new EmployeesAndDepartments("Петров", "IT");
        Departament IT = new Departament("IT");
        Employee Petrov = new Employee("Петров");
        Employee Kozlov = new Employee("Козлов");
        Employee Sidorov = new Employee("Сидоров");

        // IT.setCheif(Kozlov);
        // Petrov.setWorkDepartament(IT);
        // System.out.println(IT);
        // System.out.println(IT.getEmployeeList());

        IT.addNewEmploye(Sidorov);
        Petrov.setWorkDepartament(IT);
        IT.setCheif(Petrov);
        IT.deleteEmployee(Sidorov);
        System.out.println(IT.getEmployeeList().contains(Sidorov));
        System.out.println(Sidorov.getWorkDepartament());
        System.out.println(IT.getEmployeeList());
        System.out.println(Sidorov.getWorkDepartament());
        System.out.println(IT);
        System.out.println("======================");
        IT.addNewEmploye(Kozlov);
        System.out.println(Petrov.getWorkDepartament().getEmployeeList());
        System.out.println("======================");

    }
}
