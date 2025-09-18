package VYZ.ErmakovJava.kyrs2sem1.pract1;

public class human112 {
    private String name ;
    private int height;

    public void setName(String name){
        this.name=name;
    }
    public void setHeight(int height){
        this.height=height;
    }
    public int getHeight(){
        return this.height;
    }
    public String getName(){
        return this.name;
    }

    public human112(String name, int height){
        this.height=height;
        this.name=name;
    }

    @Override
    public String toString() {
        return ""+this.name +", рост: "+this.height;
    }
}
