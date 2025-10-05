package VYZ.ErmakovJava.kyrs2sem1.pract5;

public class Pistol {
    private short bullet;
    private String pistolName;

    private void trimBullet(){
        if (this.bullet>5) {
            this.bullet=5;
        }
        if (this.bullet<0) {
            this.bullet=0;
        }
    }

    public Pistol(String pistolName, int bullet){
        this.bullet = (short)bullet;
        this.pistolName = pistolName;
        trimBullet();
    }

    public Pistol(){
        this(null, 5);
    }
    public Pistol(int bullet){
        this(null,bullet);
    }

    public void Pew(){
        if (this.bullet<=0) {
            System.out.println("клац");
            return;
        }
        System.out.println("pew!");
        this.bullet-=1;
        trimBullet();
    }
}
