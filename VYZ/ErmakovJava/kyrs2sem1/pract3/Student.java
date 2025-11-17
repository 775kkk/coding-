package VYZ.ErmakovJava.kyrs2sem1.pract3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Student {
    private String studentName;
    private List<Integer> gradesList;
    private GradesPolicy gradesPolicy;
    @FunctionalInterface
    public interface GradesPolicy {
        boolean rule(int gradePoint);

        static GradesPolicy ALWAYS_TRUE(){
            return gradePoint -> true;
        }
    }

    //проверка входящего списка оценок
    private boolean isValidGradesList(List<Integer> gradesList){
        return gradesList != null && !gradesList.isEmpty();
    }
    private void cheсkRule(int grade){
        if (this.gradesPolicy.rule(grade)) {
            return;
        }
        throw new IllegalGradeException(studentName);
    }
    public void addGrades(List<Integer> gradesList){
        if (isValidGradesList(gradesList)) {
            for (Integer grade : gradesList) {
                if (grade != null) {
                    this.addGrades(grade);
                }
            }
        }
    }
    public void addGrades(int... grades){
        for (int grade : grades) {
                cheсkRule(grade);//this.gradesPolicy.rule(grade)
                this.gradesList.add(grade);
            }
    }

    public Student(String studentName, List<Integer> gradesList, GradesPolicy gradesPolicy){
        this.studentName = Objects.requireNonNull(studentName, "studentName cannot be null");
        this.gradesPolicy = (gradesPolicy!=null) ? gradesPolicy : GradesPolicy.ALWAYS_TRUE();
        this.gradesList = new ArrayList<>();
        this.addGrades(gradesList);
    }
    public Student(String studentName, List<Integer> gradesList){
        this(studentName, gradesList, null);
    }
    public Student(String studentName){
        this(studentName, null, null);
    }
    public Student(String studentName, GradesPolicy gradesPolicy){
        this(studentName,null, gradesPolicy);
    }

    // labyda
    public void setGrades(List<Integer> gradesList){
        this.gradesList = new ArrayList<>();
        this.addGrades(gradesList);
    }
    public void setGrades(int... grades){
        this.gradesList = new ArrayList<>();
        this.addGrades(grades);
    }
    public void addGrade(int... grades){
        this.addGrades(grades);
    }
    public void addGrade(List<Integer> gradesList){
        this.addGrades(gradesList);
    }
    public ArrayList<Integer> getGrades() {
        if (this.gradesList==null) {
            return new ArrayList<Integer>();
        }
        return new ArrayList<Integer>(gradesList);
    }
    public String getStudentName() {
        return studentName;
    }
    public double getAverageGrade(){
        if (this.gradesList.isEmpty()) return 0.0;
        int grades=0;
        for (int grade : gradesList){
            grades+=grade;
        }
        return (double)grades/gradesList.size();
    }
    public GradesPolicy getGradesPolicy() {
        return gradesPolicy;
    }
    public void setGradesPolicy(GradesPolicy gradesPolicy) {
        this.gradesPolicy = gradesPolicy;
    }
    @Override
    public String toString() {
        return "Student{name='" + studentName + "', grades=" + gradesList + "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student2 = (Student) o;
        return Objects.equals(studentName, student2.studentName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(studentName);
    }

}

