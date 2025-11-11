package VYZ.ErmakovJava.kyrs2sem1.geometrics.line;

import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.GeomEngineering;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.Tochka;

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
