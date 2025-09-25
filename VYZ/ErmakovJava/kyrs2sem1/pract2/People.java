package VYZ.ErmakovJava.kyrs2sem1.pract2;

public class People {
    private String name;
    private String lastname;
    private String otchestvo;
    private People phather;

    public People(String name, String lastname, String otchestvo, People phather){
        this.lastname = lastname;
        this.name = name;
        this.otchestvo = otchestvo;
        this.phather = phather;
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
    public People(String name, People phather){
        this(name,phather.getLastName(),phather.getName()+"ович",phather);
    }
    public People(String name,String lastname, People phather){
        this(name,lastname,phather.getLastName()+"ович",phather);
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
        return this.phather;
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
    public void setPhather(People phather){
        this.phather = phather;
        this.setOtchestvo(phather.getName()+"ович");
        this.setLastname(phather.getLastName());
    }
}
