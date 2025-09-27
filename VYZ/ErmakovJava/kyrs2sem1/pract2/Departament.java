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
       this.employeeList = (employeeList != null) ? new ArrayList<>(employeeList) : new ArrayList<>();
       this.cheif = cheif;
    }
    public Departament(String departamentName,List<Employee> employeeList){
        this(departamentName, employeeList, null);
    }
    public Departament(String departamentName){
        this(departamentName, null, null);
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
        this.employeeList = employeeList;
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
            employeeList = new ArrayList<>(); // Инициализируем если null
            return;
        }
        employeeList.removeIf(Objects::isNull);
        
        for (Employee employee : employeeList) {
            if (employee != null) {
                employee.setWorkDepartament(this);
            }
        }
    }

    public void deleteEmployee(Employee employee){
        if (employee!=null && employeeList!=null) {
            this.employeeList.remove(employee);        
        }    
    }

    public void addNewEmploye(Employee employee){
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
