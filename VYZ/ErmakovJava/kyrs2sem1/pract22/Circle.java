package VYZ.ErmakovJava.kyrs2sem1.pract22;

// Круг
public class Circle extends Figure {
    private double radius;
    
    public Circle(String name,int radius){
        super(0, name);
        this.radius = radius;
    }
    public Circle(int radius){
        this("",radius);
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    @Override
    public double perimeter() {
       return 2 * Math.PI * radius;
    }
    public double getRadius() {
        return radius;
    }
    public double getDiametr() {
        return this.radius*2;
    }

}