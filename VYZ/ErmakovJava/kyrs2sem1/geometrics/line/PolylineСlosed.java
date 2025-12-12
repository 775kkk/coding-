package VYZ.ErmakovJava.kyrs2sem1.geometrics.line;

import java.util.List;

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
    public double getLong(){
        double retResult= super.getLong();
        List<Tochka> pointsList = this.getPolylineVerticesList();
        if (pointsList.size()<2) {
            return 0;
        }
        retResult+=getLineLong(pointsList.get(0),pointsList.get(pointsList.size()-1));
        return retResult;
    }
}
