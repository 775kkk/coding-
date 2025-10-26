package VYZ.ErmakovJava.kyrs2sem1.animals;

import VYZ.ErmakovJava.kyrs2sem1.animals.interfaces.Bird;

public class BirdMarket {
    
    public void BirdsSings(Bird... birds){
        for (Bird bird : birds) {
            bird.sing();
        }
    }
}
