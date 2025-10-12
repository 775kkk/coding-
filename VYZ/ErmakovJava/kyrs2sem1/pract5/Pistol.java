package VYZ.ErmakovJava.kyrs2sem1.pract5;

public class Pistol {
    private int bullet;
    private int bulletMax;
    private String pistolName;

    private void trimBullet(){
        if (this.bullet>this.bulletMax) {
            this.bullet=this.bulletMax;
        }
        if (this.bullet<0) {
            this.bullet=0;
        }
    }

    public Pistol(String pistolName, int bulletMax){
        this.bulletMax = bulletMax;
        this.pistolName = pistolName;
        this.bullet = bulletMax;
    }

    public Pistol(int bulletMax){
        this(null, bulletMax);
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
    public void reload(int reloadBullet){
        if (reloadBullet<=0) {
            throw new IllegalArgumentException("reloadBullet cant be <=0");
        }
        this.bullet = reloadBullet;
        trimBullet();
    }
    public int getBullet() {
        return bullet;
    }
    public String getPistolName() {
        return pistolName;
    }
    public boolean isLoaded(){
        return this.bullet!=0;
    }
}
