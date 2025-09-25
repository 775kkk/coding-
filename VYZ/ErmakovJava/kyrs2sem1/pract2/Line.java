package VYZ.ErmakovJava.kyrs2sem1.pract2;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka111;

public class Line {
    private Tochka111 tochkaA;
    private Tochka111 tochkaB;

    public Line(Tochka111 a, Tochka111 b){
        this.setLine(a,b);
    }
    public Line(int Ax, int Ay, int Az, int Bx, int By, int Bz){
        this.setLine(Ax,Ay,Az,Bx,By,Bz);
    }
    public void setLine(Tochka111 tochka1, Tochka111 tochka2){
        if (tochka1 == null || tochka2 == null) {
            throw new IllegalArgumentException("Точки не должны быть null");
        }
        this.tochkaA=tochka1;
        this.tochkaB=tochka2;
    }

    public void setLine(int Ax, int Ay, int Az, int Bx, int By, int Bz){
        this.tochkaA= new Tochka111(Ax,Ay,Az);
        this.tochkaB=new Tochka111(Bx,By,Bz);
    }

    public Tochka111 getA() { return tochkaA; }//не копию специально
    public Tochka111 getB() { return tochkaB; }//не копию специально
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
