package VYZ.ErmakovJava.kyrs2sem1.pract1;

public class Tochka {
    private int X;
    private int Y;
    private int Z;

    public Tochka(int x, int y, int z){
        this.X=x;
        this.Y=y;
        this.Z=z;
    }
    public Tochka(int x, int y){
        this(x, y, 0);
    }
    public Tochka(Tochka tochka){
        this(tochka.getX(), tochka.getY(), tochka.getZ());
    }
// setters
    public void setX(int X){
        this.X = X;
    }
    public void setY(int Y){
        this.Y = Y;
    }
    public void setZ(int Z){
        this.Z = Z;
    }
// getters
    public int getX(){
        return this.X;
    }
    public int getY(){
        return this.Y;
    }
    public int getZ(){
        return this.Z;
    }
// up setters
    public void setTochka(int X, int Y, int Z){
        setX(X);
        setY(Y);
        setZ(Z);    
    }
    @Override
    public String toString() {
        return "{" + X + ";" + Y + ";"+Z+"}";
    }
}
