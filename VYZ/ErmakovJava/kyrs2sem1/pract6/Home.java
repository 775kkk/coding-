package VYZ.ErmakovJava.kyrs2sem1.pract6;

public class Home {
    private final int floor;

    public Home(int floor){
        if (floor<0) {
            throw new IllegalArgumentException("int florr cant be <0");
        }
        this.floor = floor;
    }
    public int getFloor(){
        return this.floor;
    }
}
