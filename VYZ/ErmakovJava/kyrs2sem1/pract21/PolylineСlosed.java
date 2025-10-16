package VYZ.ErmakovJava.kyrs2sem1.pract21;

import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.GeomEngineering;
import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;
import VYZ.ErmakovJava.kyrs2sem1.pract3.Polyline;

public class PolylineСlosed extends Polyline{

    public PolylineСlosed(String lineName) {
        super(lineName);
    }
    
    public PolylineСlosed(String lineName, int[]... argsOfArgs){
        super(lineName, argsOfArgs);
    }
    public PolylineСlosed(String lineName, List<Tochka> polylineVerticesList){
        super(lineName, polylineVerticesList);
    }

    @Override
    public double getLineLong(){
        return GeomEngineering.getLineLong(this,true);
    }
}
