package VYZ.ErmakovJava.kyrs2sem1.pract22;

public class SizedPoint implements Point{
    private Point point;
    private int size;
    
    public SizedPoint(Point point, int size) {
        this.point = point;
        this.size = size;
    }
    
    @Override
    public String getInfo() {
        return point.getInfo() + ", size: " + size;
    }
}
