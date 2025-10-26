package VYZ.ErmakovJava.kyrs2sem1.animals.realization;

import VYZ.ErmakovJava.kyrs2sem1.animals.interfaces.Bird;

public class Sparrow extends Bird {
    
    public Sparrow(String name, String shout){
        super(shout);
        super.name = name != null ? name.trim() : "";
    }
    public Sparrow(String shout){
        this(null, shout);
    }
}
