package VYZ.ErmakovJava.kyrs2sem1.yniversitet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.ArrayDeque;// 7.3.4
import java.util.Deque;// 7.3.4
import VYZ.ErmakovJava.kyrs2sem1.pract3.IllegalGradeException;

public class Student implements VYZ.ErmakovJava.kyrs2sem1.Comparable<Student> {
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
    private final Deque<Runnable> undoStack = new ArrayDeque<>();// 7.3.4

    
    // 7.3.5
    public interface Save {
        void restore();
    }

    private final class SaveImpl implements Save {
        private final String nameSnapshot;
        private final List<Integer> gradesSnapshot;
        private final GradesPolicy policySnapshot;
        private final Deque<Runnable> undoSnapshot;

        private SaveImpl(String nameSnapshot,
                        List<Integer> gradesSnapshot,
                        GradesPolicy policySnapshot,
                        Deque<Runnable> undoSnapshot) {
            this.nameSnapshot = nameSnapshot;
            this.gradesSnapshot = gradesSnapshot;
            this.policySnapshot = policySnapshot;
            this.undoSnapshot = undoSnapshot;
        }

        @Override
        public void restore() {
            studentName = nameSnapshot;

            gradesList.clear();
            gradesList.addAll(gradesSnapshot);

            gradesPolicy = policySnapshot;

            // Важно для консистентности: откат истории к моменту сохранения
            undoStack.clear();
            undoStack.addAll(undoSnapshot);
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

    // 7.3.4
    public void addGrades(List<Integer> gradesList){
        if (!isValidGradesList(gradesList)) return;

        List<Integer> filtered = new ArrayList<>();
        for (Integer g : gradesList) {
            if (g != null) filtered.add(g);
        }
        if (filtered.isEmpty()) return;

        for (int g : filtered) cheсkRule(g);

        for (int g : filtered) this.gradesList.add(g);

        int added = filtered.size();
        undoStack.push(() -> {
                                for (int i = 0; i < added; i++) {
                                    if (!this.gradesList.isEmpty()) {
                                        this.gradesList.remove(this.gradesList.size() - 1);
                                    }
                                }
                            });
    }
    // 7.3.4
    public boolean undoLastAction() {
        Runnable undo = undoStack.pollFirst();
        if (undo == null) return false;
        undo.run();
        return true;
    }



    // 7.3.4
    public void addGrades(int... grades){
        for (int grade : grades) {
                cheсkRule(grade);//this.gradesPolicy.rule(grade)
            }

        int added = grades.length;
        for (int grade : grades) {
            this.gradesList.add(grade);
        }

        undoStack.push(() ->{
                                for (int i = 0; i < added; i++) {
                                    if (!gradesList.isEmpty()) {
                                        gradesList.remove(gradesList.size() - 1);
                                    }
                                }
                            });// действие складируем
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

    // 7.3.4
    public void setStudentName(String newName) {
        newName = Objects.requireNonNull(newName, "studentName cannot be null");
        if (Objects.equals(this.studentName, newName)) return;
        String old = this.studentName;
        this.studentName = newName;

        undoStack.push(() -> this.studentName = old);// действие складируем
    }

    // labyda
    public void setGrades(List<Integer> gradesList){// 7.3.4
        List<Integer> old = new ArrayList<>(this.gradesList);

        this.gradesList.clear();
        this.addGrades(gradesList);

        undoStack.push(() -> {
            this.gradesList.clear();
            this.gradesList.addAll(old);
        });
    }
    public void setGrades(int... grades){// 7.3.4
        List<Integer> old = new ArrayList<>(this.gradesList);

        this.gradesList.clear();
        this.addGrades(grades);

        undoStack.push(() -> {
            this.gradesList.clear();
            this.gradesList.addAll(old);
        });
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
        return Objects.equals(studentName, student2.studentName) && Math.abs(student2.getAverageGrade() - this.getAverageGrade()) < 1e-10;
    }
    @Override
    public int hashCode() {
        return Objects.hash(studentName, Double.hashCode(getAverageGrade()));
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(this.getAverageGrade(), student.getAverageGrade());
    }

}

