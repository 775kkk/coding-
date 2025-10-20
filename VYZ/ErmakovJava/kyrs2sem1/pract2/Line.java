package VYZ.ErmakovJava.kyrs2sem1.pract2;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;

public class Line {
    private Tochka tochkaA;
    private Tochka tochkaB;

    public Line(Tochka a, Tochka b){// вместо точка коллекцию?
        this.tochkaA= new Tochka(a);
        this.tochkaB= new Tochka(b);
    }
    public Line(int[] tochka1, int[] tochka2){//вместо точка коллекцию?
        this(new Tochka(tochka1), new Tochka(tochka2));// чтобы не плодить сущности лишний раз
    }
    public void setLine(Tochka tochka1, Tochka tochka2){
        if (tochka1 == null || tochka2 == null) {
            throw new NullPointerException("Точки не должны быть null");
        }
        this.tochkaA=tochka1;
        this.tochkaB=tochka2;
    }

    public void setLine(int Ax, int Ay, int Az, int Bx, int By, int Bz){
        this.tochkaA= new Tochka(Ax,Ay,Az);
        this.tochkaB=new Tochka(Bx,By,Bz);
    }
    public void setLine(int[] tochka1, int[] tochka2){
        this.tochkaA= new Tochka(tochka1);
        this.tochkaB= new Tochka(tochka2);
    }

    public Tochka getA() { return new Tochka(tochkaA); }
    public Tochka getB() { return new Tochka(tochkaB); }
    
    public boolean isEmpty() {
        return (tochkaA == null || tochkaB == null); 
    }

    @Override
    public String toString() {
        return "Line{" + String.valueOf(tochkaA) + " -> " + String.valueOf(tochkaB) + "}";
    }
}
