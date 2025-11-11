package VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces;

// import java.util.Arrays;

public abstract class Figure {
    private static int count=0;
    private final int id;
    private Integer vertex;
    private String name;

    protected Figure(Integer vertex, String name){
        count++;
        this.id = count;
        this.name = name;
        this.vertex = vertex;
    }
    public abstract double area();
    public abstract double perimeter();
    
    public double area(Figure... figurs){
        double result=0;
        for (Figure figure : figurs) {
            result+=figure.area();
        }
        return result;
    }

    // public double area(Figure... figures) {
    //     return Arrays.stream(figures)
    //                 .filter(Objects::nonNull)
    //                 .mapToDouble(Figure::area)
    //                 .filter(area -> area >= 0)
    //                 .sum();
    // }

    public static int getTotalFiguresCount() {
        return count;
    }
    public String getName() {
        return name;
    }
    public Integer getVertex() {
        return vertex;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Figure "+count+", name "+name+", vertex "+vertex;
    }
}
