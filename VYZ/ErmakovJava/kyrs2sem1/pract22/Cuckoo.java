package VYZ.ErmakovJava.kyrs2sem1.pract22;

public class Cuckoo extends Bird {
    
    public Cuckoo(String name, String shout){
        super(shout);
        super.name = name != null ? name.trim() : "";
    }
    public Cuckoo(String shout){
        this(null, shout);
    }

    @Override
    public void sing() {
        for (int i = 0; i < Math.random()*10; i++) {
            super.sing();
        }
    }
}

