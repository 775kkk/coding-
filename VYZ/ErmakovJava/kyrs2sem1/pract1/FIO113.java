package VYZ.ErmakovJava.kyrs2sem1.pract1;

public class FIO113 {
    private String name;
    private String lastname;
    private String otchestvo;

    public FIO113(String name, String lastName, String othestvo){
        this.lastname = lastName;
        this.name = name;
        this.otchestvo = othestvo;
    }

    public String getName(){
        return this.name;
    }
    public String getLasntName(){
        return this.lastname;
    }
    public String getOtchestvo(){
        return this.otchestvo;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setLasntName(String lastname){
        this.lastname = lastname;
    }
    public void setOtchestvo(String otchestvo){
        this.otchestvo = otchestvo;
    }

    @Override
    public String toString() {
        return lastname+" "+name+" "+otchestvo;
    }
}
