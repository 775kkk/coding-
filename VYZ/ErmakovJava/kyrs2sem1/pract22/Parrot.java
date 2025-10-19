package VYZ.ErmakovJava.kyrs2sem1.pract22;

public class Parrot extends Bird {

    public Parrot(String name, String shout){
        super(shout);
        super.name = name != null ? name.trim() : "";
    }
    public Parrot(String shout){
        this(null, shout);
    }

    @Override
    public void sing() {
        int n = (int) (Math.random() * getShout().length()) + 1;
        System.out.println(getShout().substring(0, n));
    }
    
}
