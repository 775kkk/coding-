package VYZ.ErmakovJava.kyrs2sem1.pract2;

import java.util.Objects;

public class Employee {
    private Departament workDepartament;
    private String workerName;

    public Employee(String workerName, Departament workDepartament){
        this.workDepartament = workDepartament;
        this.workerName = workerName;
    }
    public Employee(String workerName){
        this(workerName, null);
    }

    public void setWorkDepartament(Departament workDepartament) {
        if (workDepartament==null) {
            return;
        }
        if (this.workDepartament!=null) {
            this.workDepartament.deleteEmployee(this);
        }

        this.workDepartament = workDepartament;
        workDepartament.addNewEmploye(this);
    }
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Departament getWorkDepartament() {
        return workDepartament;
    }
    public String getWorkerName(){
        return workerName;
    }

    @Override
    public String toString(){
        if (workDepartament==null){
            return "Employee{"+workerName+"}";
        }
        return "Employee{"+workerName+" из "+workDepartament+"}";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(workerName, employee.workerName);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(workerName);
    }
}
