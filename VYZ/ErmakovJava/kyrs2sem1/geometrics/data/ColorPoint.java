package VYZ.ErmakovJava.kyrs2sem1.geometrics.data;

public class ColorPoint implements Point{
    private Point point;
    private String color;
    
    public ColorPoint(Point point, String color) {
        this.point = point;
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String getInfo() {
        return point.getInfo() + ", color: " + color;
    }
}
