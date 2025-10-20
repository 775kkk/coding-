package VYZ.ErmakovJava.kyrs2sem1.pract22;

public abstract class Bird {
    protected String name;
    private String shout;

    protected Bird(String shout){
        this.shout = shout;
    }

    public void sing(){
        System.out.println(shout);
    }
    public String getShout() {
        return shout;
    }
    public String getName(){
        return this.name;
    };

    @Override
    public String toString() {
        return "Bird " + name.trim() + ": " + shout;
    }
}
