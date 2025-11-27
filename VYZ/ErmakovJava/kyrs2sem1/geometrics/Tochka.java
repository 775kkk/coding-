package VYZ.ErmakovJava.kyrs2sem1.geometrics;

public final class Tochka implements Cloneable {
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
    public Tochka(int[] tochka){
        this(
            tochka != null && tochka.length > 0 ? tochka[0] : 0,
            tochka != null && tochka.length > 1 ? tochka[1] : 0,
            tochka != null && tochka.length > 2 ? tochka[2] : 0
        );
    }

    // private int getValidCoordinate(int){
    // }
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Tochka tochka = (Tochka) o;
        return  X == tochka.X &&
                Y == tochka.Y &&
                Z == tochka.Z;
    }

    @Override
    public int hashCode() {
        return 31 * (31 * X + Y) + Z;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Tochka(this);
    }
}
