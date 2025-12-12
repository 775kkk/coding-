package VYZ.ErmakovJava.kyrs2sem1.geometrics.line;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.Tochka;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces.GetLongs;

public class Line implements Cloneable, GetLongs {
    private Tochka tochkaA;
    private Tochka tochkaB;

    public Line(Tochka a, Tochka b){
        this.tochkaA= new Tochka(a);
        this.tochkaB= new Tochka(b);
    }
    public Line(int[] tochka1, int[] tochka2){
        this(new Tochka(tochka1), new Tochka(tochka2));
    }
    public Line(Line line){
        this(line.tochkaA,line.tochkaB);
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
    public double getLong() {
        double dx = tochkaA.getX() - tochkaB.getX();
        double dy = tochkaA.getY() - tochkaB.getY();
        double dz = tochkaA.getZ() - tochkaB.getZ();
        
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    public static double getLineLong(Tochka a, Tochka b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        double dz = a.getZ() - b.getZ();
        
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    @Override
    public String toString() {
        return "Line{" + String.valueOf(tochkaA) + " -> " + String.valueOf(tochkaB) + "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Line line = (Line) o;
        
        return (tochkaA.equals(line.tochkaA) && tochkaB.equals(line.tochkaB)) ||
            (tochkaA.equals(line.tochkaB) && tochkaB.equals(line.tochkaA));
    }

    @Override
    public int hashCode() {
        int hashA = tochkaA != null ? tochkaA.hashCode() : 0;
        int hashB = tochkaB != null ? tochkaB.hashCode() : 0;
        return (hashA + hashB);
    }

    @Override
    protected Object clone() {
        try {
            Line retLine = (Line) super.clone();
            retLine.setLine(this.tochkaA, this.tochkaB);
            return retLine;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
