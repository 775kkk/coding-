package VYZ.ErmakovJava.kyrs2sem1.pract3;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private String studentName;
    private ArrayList<Integer> gradesList;
    private GradesPolicy gradesPolicy;
    @FunctionalInterface
    public interface GradesPolicy {
        boolean rule(int gradePoint);

        static GradesPolicy DEFAULT(){
            return gradePoint -> true;
        }
    }


    public Student(String studentName, ArrayList<Integer> gradesList,GradesPolicy gradesPolicy){
        this.studentName = Objects.requireNonNull(studentName);
        // this.gradesList = (gradesList != null) ? new ArrayList<Integer>(gradesList) : null;
        for (int i = 0; i < gradesList.size; i++) {
            
        }
        this.gradesPolicy = gradesPolicy;
    }
    public Student(String studentName, int... args){
        this(studentName, convertIntArrayToArrayList(args), GradesPolicy.DEFAULT());
    }
    public Student(String studentName){
        this(studentName, new ArrayList<Integer>(), GradesPolicy.DEFAULT());
    }
    public void setStudentName(String studentName){
        if (studentName == null) throw new NullPointerException("studentName cant be null");
        
        this.studentName = studentName;
    }
    public void setGrades(ArrayList<Integer> gradesList) {
        if (gradesList == null) throw new NullPointerException("gradesList cant be null");
        
        this.gradesList = new ArrayList<Integer>(gradesList);
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

    private static ArrayList<Integer> convertIntArrayToArrayList(int[] args) {
        if (args == null) return new ArrayList<Integer>();
        
        ArrayList<Integer> newGradesList = new ArrayList<Integer>();
        for (int value : args) {
            newGradesList.add(value);
        }
        return newGradesList;
    }
    public double getAverageGrade(){
        if (this.gradesList.isEmpty()) return 0.0;
        int grades=0;
        // for (int i = 0; i < gradesList.size(); i++) {

        for (int grade : gradesList){
            grades+=grade;
        }
        return (double)grades/gradesList.size();
    }

    private void trimGradeList(int min,int max){
        for (int i = 0; i < this.gradesList.size(); i++) {
            if (this.gradesList.get(i)<min) {
                this.gradesList.set(i, min);
            }
            if (this.gradesList.get(i) >max) {
                this.gradesList.set(i, max);
            }
        }
    }
    @Override
    public String toString() {
        return studentName+":"+gradesList;
    }
}
