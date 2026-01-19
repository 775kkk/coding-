package dto;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import exceptions.ParentsException;
import interfaces.ParentsInterface;
import interfaces.PolicyInterface;
import policy.DefoultPolicy;

public class Student extends NotifactionsAbstract{
    private final String name;
    private List<Integer> marks;
    private List<ParentsInterface<
                                Integer,ReactionsEnum,PolicyInterface<
                                                                    Integer,ReactionsEnum
                                                                    >
                                >
                > parents;
    private static PolicyInterface<Integer,ReactionsEnum> defoult = new DefoultPolicy<>();  

    public Student(String name, List<Integer> marks,List<ParentsInterface<Integer,ReactionsEnum,PolicyInterface<Integer,ReactionsEnum>>> parents){
        this.marks = marks;
        this.name = name;
        this.parents = parents;
    }

    public Student(String name){
        this(name,new ArrayList<>(), new ArrayList<>());
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(this.marks);
    }

    public void addMark(int m){
        try{
            this.notificate(m, defoult);
            this.marks.add(m);
        }catch(Exception e){
            
        }

    }
    public void addParent(ParentsInterface<Integer,ReactionsEnum,PolicyInterface<Integer,ReactionsEnum>> parent){
        this.parents.add(parent);
    }
    private void notificate(int mark, PolicyInterface<Integer,ReactionsEnum> policy){
        for (int i = 0; i < this.parents.size(); i++) {
            try{
                ReactionsEnum react = parents.get(i).react((Integer) mark, policy);
                
            }catch(ParentsException e){
                notificateBack(i);
            }
        }
    }

    private void notificateBack(int iterator){
        for (int i = iterator; i >0; i--) {
            this.parents.get(i).// undo както реализовать
        }
    }

    public String getName() {
        return name;
    }
    private void notificateOfNewMarks(){
        for (Integer mark : marks) {
         this.notificate(mark, defoult);
        }
    }
    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList(marks);
        this.notificateOfNewMarks();
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", marks=" + marks + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((marks == null) ? 0 : marks.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (marks == null) {
            if (other.marks != null)
                return false;
        } else if (!marks.equals(other.marks))
            return false;
        return true;
    }

    

}
