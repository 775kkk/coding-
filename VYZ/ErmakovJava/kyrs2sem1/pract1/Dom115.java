package VYZ.ErmakovJava.kyrs2sem1.pract1;

public class Dom115 {
    private int floor;

    public Dom115(int n){
        this.floor = n;
    }
    public void setFloor(int n){
        this.floor=n;
    }
    public int getFloor(){
        return this.floor;
    }

    @Override
    public String toString() {
        return "дом с "+ this.floor+" этажами";
    }
}
