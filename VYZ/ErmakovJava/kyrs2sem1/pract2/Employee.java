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

    // для отвязки от старого департмента и собственной привязки к новому
    public void newWorkDepartament(Departament workDepartament){
        if (workDepartament==null) {
            return;
        }
        if (this.workDepartament!=null) {
            this.workDepartament.deleteEmployee(this);
        }
        this.workDepartament = workDepartament;
    }
    
    // для прикрепления сотрудника к департаменту с стороны департамента
    public void setWorkDepartament(Departament workDepartament) {
        this.newWorkDepartament(workDepartament);// внутренний метод сотрудника для отвязки от старого департмента и собственной привязки к новому
        workDepartament.writeToDepartmentList(this);// вунтренний метод департамента для внесения в список сотрудников департаментиа
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

    // для работы List.contains()
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
