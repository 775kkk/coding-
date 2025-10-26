package VYZ.ErmakovJava.kyrs2sem1.gunpower;

public class Gunman {
    private String nameGunman;
    private Automat automatGun;

    public Gunman(String name, Automat automatGun){
        this.nameGunman = name;
        this.automatGun = automatGun;
    }
    public Gunman(String name){
        this(name,null);
    }
    
    public void Gunfight(){
        if (automatGun == null) {
            System.out.println("не могу участвовать в шмальбе");
            return;
        }
        automatGun.Pew();
    }

    public void setAutomatGun(Automat automatGun) {
        this.automatGun = automatGun;
    }
    public void setNameGunman(String nameGunman) {
        this.nameGunman = nameGunman;
    }
    public Automat getAutomatGun() {
        return automatGun;
    }
    public String getNameGunman() {
        return nameGunman;
    }
}
