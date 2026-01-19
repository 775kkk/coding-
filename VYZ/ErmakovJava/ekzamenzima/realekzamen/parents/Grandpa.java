package parents;

import java.security.Policy;

import dto.Student;
import interfaces.ParentsInterface;

public class Grandpa<ReactionsEnum, PolicyInterface> implements ParentsInterface<Student,ReactionsEnum, PolicyInterface>{
    private String Name;
    private 
    
    public Grandpa(String name){
        this.Name=name;
    }
    public String getName() {
        return Name;
    }

    @Override
    public ReactionsEnum react(Integer mark, PolicyInterface policy){
        return policy.chekRule(mark);
    }
}
