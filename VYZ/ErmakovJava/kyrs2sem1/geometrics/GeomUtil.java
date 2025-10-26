package VYZ.ErmakovJava.kyrs2sem1.geometrics;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces.Figure;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces.GetLongs;

public class GeomUtil {
    private GeomUtil(){}

    public static double totalarea(Figure... argsFigures){
        double ret=0;
        for (Figure figure : argsFigures) {
            ret+=figure.area();
        }
        return ret;
    }
    public static double getLong(GetLongs... args){
        double ret=0;
        for (GetLongs gettingsLong : args) {
            ret+=gettingsLong.getLong();
        }
        return ret;
    }
}
