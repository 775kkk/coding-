package VYZ.ErmakovJava.kyrs2sem1.pract22;

public class Sparrow extends Bird {
    
    public Sparrow(String name, String shout){
        super(shout);
        super.name = name != null ? name.trim() : "";
    }
    public Sparrow(String shout){
        this(null, shout);
    }
}
