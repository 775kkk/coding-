package VYZ.ErmakovJava.kyrs2sem1.pract2;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;

public class Line {
    private Tochka tochkaA;
    private Tochka tochkaB;

    public Line(Tochka a, Tochka b){
        this.setLine(a,b);
    }
    public Line(int Ax, int Ay, int Az, int Bx, int By, int Bz){
        this.setLine(Ax,Ay,Az,Bx,By,Bz);
    }
    public void setLine(Tochka tochka1, Tochka tochka2){
        if (tochka1 == null || tochka2 == null) {
            throw new IllegalArgumentException("Точки не должны быть null");
        }
        this.tochkaA=tochka1;
        this.tochkaB=tochka2;
    }

    public void setLine(int Ax, int Ay, int Az, int Bx, int By, int Bz){
        this.tochkaA= new Tochka(Ax,Ay,Az);
        this.tochkaB=new Tochka(Bx,By,Bz);
    }

    public Tochka getA() { return tochkaA; }//не копию специально
    public Tochka getB() { return tochkaB; }//не копию специально
    public boolean isInitialized() { 
        return !(tochkaA == null || tochkaB == null); 
    }
    public boolean isEmpty() {
        return (tochkaA == null || tochkaB == null); 
    }


    public void clear() {
        tochkaA = null;
        tochkaB = null;
    }

    @Override
    public String toString() {
        return "Line{" + String.valueOf(tochkaA) + " -> " + String.valueOf(tochkaB) + "}";
    }
}
