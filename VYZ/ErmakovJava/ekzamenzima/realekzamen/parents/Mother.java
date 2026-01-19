package parents;


import interfaces.ParentsInterface;

public class Mother<ReactionsEnum, ReactionsEnum> implements ParentsInterface<Integer> {
    private final String Name;
    public Mother(String Name){
        this.Name = Name;
    }
    @Override
    public Student react(Integer mark){
        // Логика реакции - лябда из будущей политики 
        return student;
    }
    public String getName() {
        return Name;
    }
}
