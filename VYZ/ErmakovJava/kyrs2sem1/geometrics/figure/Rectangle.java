package VYZ.ErmakovJava.kyrs2sem1.geometrics.figure;

import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces.Figure;
// import VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces.GettingsPolyline;implements GettingsPolyline
// import VYZ.ErmakovJava.kyrs2sem1.geometrics.line.Polyline;

public class Rectangle extends Figure {
    private int a;
    private int b;
    

    public Rectangle(String name, int... args){
        super(4, name);
        // if (args.length<2) throw new IllegalArgumentException("args cant belenght<4");
        this.a = args[0];
        try {
            this.b = args[1];
        } catch (Exception e) {
            this.b = a;
        }
    }

    public Rectangle(String name,List<Integer> args){
        super(4, name);
        if (args.size()<1) throw new IllegalArgumentException("args cant be lenght<1");
        this.a = args.get(0);
        try {
        this.b = args.get(1);
        } catch (Exception e) {
            this.b = a;
        }
    }
    public Rectangle(List<Integer> args){
        this("", args);
    }
    public Rectangle(int... args){
        this("", args);
    }

    @Override
    public double area() {
        return a*b;
    }
    @Override
    public double perimeter() {
        return a+b+a+b;
    }

    // @Override
    // public Polyline getPolyline(){
    //     return Polyline();
    // }

}
