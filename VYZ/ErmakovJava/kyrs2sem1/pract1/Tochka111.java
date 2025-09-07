package VYZ.ErmakovJava.kyrs2sem1.pract1;

public class Tochka111 {
    private int X;
    private int Y;
    private int Z;
// setters
    protected void setX(int X){
        this.X = X;
    }
    protected void setY(int Y){
        this.Y = Y;
    }
    protected void setZ(int Z){
        this.Z = Z;
    }
// getters
    protected int getX(){
        return this.X;
    }
    protected int getY(){
        return this.Y;
    }
    protected int getZ(){
        return this.Z;
    }
// upscale setters
    public void setTochka(int X, int Y, int Z){
        setX(X);
        setY(Y);
        setZ(Z);    
    }
// tostring
    @Override
    public String toString() {
        return "{" + X + ";" + Y + ";"+Z+"}";
    }
}
