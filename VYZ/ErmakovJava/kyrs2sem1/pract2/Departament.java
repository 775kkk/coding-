package VYZ.ErmakovJava.kyrs2sem1.pract2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Departament {
    private String departamentName;
    private List<Employee> employeeList;
    private Employee cheif;

    public Departament(String departamentName, List<Employee> employeeList,Employee cheif){
       this.departamentName = Objects.requireNonNull(departamentName, "Department name cant be null");
       this.employeeList = (employeeList != null) ? new ArrayList<Employee>(employeeList) : new ArrayList<Employee>();
       this.cheif = cheif;
    }
    public Departament(String departamentName,List<Employee> employeeList){
        this(departamentName, employeeList, null);
    }
    public Departament(String departamentName){
        this(departamentName, null, null);
    }
    public Departament(String departamentName, Employee cheif){
        this(departamentName, null, cheif);
    }

    public void setCheif(Employee cheif) {
        if (this.employeeList!=null) {
            if (!(this.employeeList.contains(cheif))) {
                this.employeeList.add(cheif);
            }
        }
        this.cheif = cheif;
    }
    public void setDepartamentName(String departamentName) {
        this.departamentName = departamentName;
    }
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = new ArrayList<Employee>(employeeList);
    }

    public Employee getCheif(){
        return cheif;
    }
    public String getDepartamentName(){
        return departamentName;
    }
    public List<Employee> getEmployeeList() {
        if (this.employeeList!=null) {
            return new ArrayList<>(employeeList);
        }
        return new ArrayList<>();
    }

    public void trimEmployeeList(){
        if (employeeList == null) {
            employeeList = new ArrayList<>();
            return;
        }
        employeeList.removeIf(Objects::isNull);
        for (Employee employee : employeeList) {
            if (employee != null) {
                employee.setWorkDepartament(this);
            }
        }
    }

    // метод департамента для удаления сотрудника
    public void deleteEmployee(Employee employee){
        if (employee== null) throw new NullPointerException("employee cant be null");
        this.deleteEmployeeFromDepartamentList(employee);// внутренний метод департамента для удаления сотрудника из списка
        employee.newWorkDepartament(null);
    }
    // внутренний метод департамента для удаления сотрудника из списка
    public void deleteEmployeeFromDepartamentList(Employee employee){
        if (employee!=null && employeeList!=null) {
            this.employeeList.remove(employee);        
        } 
    }
    // метод департамента для добавления нового сотрудника
    public void addNewEmploye(Employee employee){
        this.writeToDepartmentList(employee);// вунтренний метод департамента для внесения в список сотрудников департаментиа
        employee.newWorkDepartament(this);// внутренний метод сотрудника для отвязки от старого департмента и собственной привязки к новому
    }

    // вунтренний метод департамента для внесения в список сотрудников департаментиа
    public void writeToDepartmentList(Employee employee){
        if (employee==null) {
            return;
        }
        if (employeeList==null) {
            return;
        }
        if (!employeeList.contains(employee)) {
            employeeList.add(employee);
        }
    }

    @Override
    public String toString() {
        String retResult="Отдел "+departamentName;
        if (cheif!=null) {
            retResult+=", начальник "+cheif.getWorkerName();
        }
        if (employeeList!=null) {
            retResult+=", имеется список сотрудников";
        }
        return retResult+".";
    }
}
