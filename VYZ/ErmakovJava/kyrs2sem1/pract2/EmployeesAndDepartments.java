package VYZ.ErmakovJava.kyrs2sem1.pract2;

public class EmployeesAndDepartments {
    private String workerName;
    private String departament;
    private String cheifName;
    private Boolean isCheif;

    public EmployeesAndDepartments(String workerName, String departament, String cheifName, Boolean isCheif){
        this.cheifName=cheifName;
        this.departament=departament;
        this.workerName=workerName;
        this.isCheif=isCheif;
    }
    public EmployeesAndDepartments(String workerName, String departament, String cheifName){
        this(workerName, departament, cheifName, null);
    }
    public EmployeesAndDepartments(String workerName, String departament){
        this(workerName, departament, null, null);
    }
    public EmployeesAndDepartments(String workerName){
        this(workerName, null, null, null);
    }

    public void setWorkerName(String workerName){
        this.workerName=workerName;
    }
    public void setDepartament(String departament){
        this.departament=departament;
    }
    public void setCheifName(String cheifName){
        this.cheifName=cheifName;
    }
    public void setIsCheif(Boolean isCheif) {
        this.isCheif = isCheif;
    }

    public String getCheifName() {
        return cheifName;
    }
    public String getDepartament() {
        return departament;
    }
    public Boolean getIsCheif() {
        return isCheif;
    }
    public String getWorkerName() {
        return workerName;
    }
    
    private String validField(String a){
        if (a==null) {
            return "";
        }
        return a;
    }
    @Override
    public String toString() {
        // если шеф то представляем как шефа
        // если работник то представляем как работника
        // если не указано то нейтрально, со стороны отдела
        if (isCheif) {
            String retResult = cheifName+"начальник ";
            if (departament!=null) {
                retResult+="отдела "+departament;
            }
            if (cheifName!=null) {
                retResult+=", сотрудник в штате: "+workerName;
            }
            return retResult.trim();
        }else if (!isCheif) {
            String retResult = workerName+"работает ";
            if (departament!=null) {
                retResult+="в отделе"+departament;
            }
            if (cheifName!=null) {
                retResult+=", начальник которого "+cheifName;
            }
            return retResult.trim();
        }else{
            if (departament!=null){
                String retResult = "Отдел "+departament;
                if (cheifName!=null) {
                    retResult+=", начальник отдела - "+cheifName;
                }
                if (workerName!=null) {
                    retResult+=", работник отдела: "+workerName;
                }
                return (retResult+=".").trim();
            }
            return workerName+"работник безымянного отдела.";
        }
    }
}
