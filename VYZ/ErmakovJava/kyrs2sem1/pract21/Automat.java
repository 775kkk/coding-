package VYZ.ErmakovJava.kyrs2sem1.pract21;

import VYZ.ErmakovJava.kyrs2sem1.pract5.Pistol;

public class Automat extends Pistol{
    private final int rateOfFire;
    
    public Automat(String pistolName, int bulletMax, int rateOfFire){
        super(pistolName, bulletMax);
        this.rateOfFire = rateOfFire;
    }
    public Automat(){
        this(null, 30, 30);
    }
    public Automat(int bulletMax){
        this(null, bulletMax, bulletMax/2);
    }
    public Automat(int bulletMax, int rateOfFire){
        this(null, bulletMax, rateOfFire);
    }

    @Override
    public void Pew() {
        for (int i = 0; i < rateOfFire; i++) {
            super.Pew();
        }
    }
    
    public void Pew(int N) {
        for (int i = 0; i < N; i++) {
            Pew();
        }
    }

}
