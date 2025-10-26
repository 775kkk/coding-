package VYZ.ErmakovJava.kyrs2sem1.animals.realization;

import VYZ.ErmakovJava.kyrs2sem1.animals.interfaces.CatLike;

public class Cat implements CatLike{
    private String catName;
    
    public Cat(String catName){
        this.catName=catName;
    }

    public void meow(int count){
        String retString = this.catName+": ";
        for (int i = 0; i < count; i++) {
            retString+="мяу";
            if (i!=count-1) {
                retString+="-";
            }
        }
        retString+="!";
        System.out.println(retString);
    }
    
    @Override
    public void meow(){
        meow(1);
    }

    @Override
    public String toString() {
        return "кот: "+this.catName;
    }
}
