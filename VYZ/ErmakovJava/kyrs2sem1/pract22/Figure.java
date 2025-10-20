package VYZ.ErmakovJava.kyrs2sem1.pract22;

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
