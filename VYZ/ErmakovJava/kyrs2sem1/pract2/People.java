package VYZ.ErmakovJava.kyrs2sem1.pract2;

public class People {
    private String name;
    private String lastname;
    private String otchestvo;
    private People father;

    public People(String name, String lastname, String otchestvo, People father){
        this.lastname = lastname;
        this.name = name;
        this.otchestvo = otchestvo;
        this.father = father;
    }
    public People(String name, String lastname, String otchestvo){
        this(name,lastname,otchestvo,null);
    }
    public People(String name, String lastname){
        this(name,lastname,null,null);
    }
    public People(String name){
        this(name,null,null,null);
    }
    public People(String name, People father){
        this(name,father.getLastName(),father.getName()+"ович",father);
    }
    public People(String name,String lastname, People father){
        this(name,lastname,father.getLastName()+"ович",father);
    }

    public String getLastName(){
        return this.lastname;
    }
    public String getName(){
        return this.name;
    }
    public String getOtchestvo(){
        return this.otchestvo;
    }
    public People getPhather(){
        return this.father;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setOtchestvo(String otchestvo){
        this.otchestvo=otchestvo;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public void setPhather(People father){
        this.father = father;
    }
    private String validField(String a){
        if (a==null) {
            return "";
        }
        return a;
    }
    private String validOtchestvo(){
        // return otchestvo==null ? ( father==null ? null : father.getName()+"ович" ):otchestvo;
        if (otchestvo==null) {
            if (father!=null) {//&& father.getName() != null
                return father.getName()+"ович";
            }
            return null;
        }
        return otchestvo;
    }
    @Override
    public String toString() {
        String retResult = String.join(" ", 
            validField(lastname), 
            validField(name), 
            validField(validOtchestvo())
        ).trim();
        return String.format("People{%s}", retResult);
        // if (father == null) {
        //     return String.format("People{%s}", retResult);
        // } else {
        //     return String.format("People{%s ;Father{%s}}", retResult, father);
        // }
    }
}
