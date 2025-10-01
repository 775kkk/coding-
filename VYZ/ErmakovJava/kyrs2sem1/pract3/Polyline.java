package VYZ.ErmakovJava.kyrs2sem1.pract3;

import java.util.ArrayList;
import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;

public class Polyline {
    private String lineName;
    private List<Tochka> polylineVerticesList;

    public Polyline(String lineName, List<Tochka> polylineVerticesList){
        this.lineName = lineName;
        this.polylineVerticesList = polylineVerticesList;
    }
    public Polyline(String lineName){
        this(lineName, new ArrayList<Tochka>());
    }
    // как еще я хочу задавать точки?
    public Polyline(String lineName, int[]... argsOfArgs){
        this(lineName);
        for (int[] coords : argsOfArgs) {
            if (coords.length == 2) {
                this.polylineVerticesList.add(new Tochka(coords[0], coords[1]));
            }
            if (coords.length >= 3) {
                this.polylineVerticesList.add(new Tochka(coords[0], coords[1], coords[2]));
            }
        }

    }
}
