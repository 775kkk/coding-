package VYZ.ErmakovJava.kyrs2sem1.geometrics.line;

import java.util.ArrayList;
import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.GeomEngineering;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.Tochka;

public class Polyline {
    private String lineName;
    private List<Tochka> polylineVerticesList;

    // надо сделать конструктор без имени
    public Polyline(String lineName, List<Tochka> polylineVerticesList){
        this.lineName = lineName;
        if (polylineVerticesList==null) {
            this.polylineVerticesList = new ArrayList<Tochka>();
        } else{
            this.polylineVerticesList = new ArrayList<>(polylineVerticesList);
        }
    }
    public Polyline(String lineName){
        this(lineName, new ArrayList<Tochka>());
    }
    public Polyline(List<Tochka> polylineVerticesList){
        this("", polylineVerticesList);
        
    }

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
    public Polyline(String lineName, Tochka... argsOfTochkas){
        this(lineName);
        for (Tochka tochka : argsOfTochkas) {
            this.polylineVerticesList.add(tochka);
        }
    }

    public String getLineName() {
        return lineName;
    }
    public List<Tochka> getPolylineVerticesList() {
        if (this.polylineVerticesList == null) {
            return new ArrayList<Tochka>();
        }
        return new ArrayList<Tochka>(polylineVerticesList);
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
    public void setPolylineVerticesList(List<Tochka> polylineVerticesList) {
        this.polylineVerticesList = new ArrayList<Tochka>(polylineVerticesList);
    }
    public void addVertices(Tochka tochka){
        this.polylineVerticesList.add(tochka);
    }
    public void popVertices(){
        this.polylineVerticesList.remove(this.polylineVerticesList.size()-1);
    }
    public void removeVerticesByIndex(int index){
        this.polylineVerticesList.remove(index);
    }
    public void moveVerticesByIndexOfVector(int index, int x,int y,int z){
        Tochka tempTochka = this.polylineVerticesList.get(index); 
        tempTochka.setX(tempTochka.getX()+x);
        tempTochka.setY(tempTochka.getY()+y);
        tempTochka.setZ(tempTochka.getZ()+z);
    }
    public void moveVerticesByIndexOfVector(int index, int x,int y){
        this.moveVerticesByIndexOfVector(index,x,y,0);
    }
    public void moveVerticesByIndexOfVector(int index,int x){
        this.moveVerticesByIndexOfVector(index,x,0,0);
    }
    // НЕ КОПИЯ !!!!!!!!!!!!!!!!!!!! !
    public Tochka getVerticesByIndex(int index){// НЕ КОПИЯ !!!!!!!!!!!!!!!!!!!! !
        return this.polylineVerticesList.get(index);// НЕ КОПИЯ !!!!!!!!!!!!!!!!!!!! !
    }// НЕ КОПИЯ !!!!!!!!!!!!!!!!!!!! !

    public void moveStartOfVector(int x, int y) {
        if (!polylineVerticesList.isEmpty()) {
            Tochka start = polylineVerticesList.get(0);
            start.setX(start.getX() + x);
            start.setY(start.getY() + y);
        }
    }

    public int getCountVertices(){
        return this.polylineVerticesList.size();
    }

    public double getLineLong(){
        return GeomEngineering.getLineLong(this,false);
    }

    @Override
    public String toString() {
        return lineName + "; Vertices:" + this.polylineVerticesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Polyline polyline = (Polyline) o;
        List<Tochka> thisPoints = this.polylineVerticesList;
        List<Tochka> otherPoints = polyline.polylineVerticesList;
        
        if (thisPoints.size() != otherPoints.size()) {
            return false;
        }
        
        if (thisPoints.isEmpty()) {
            return true;
        }
        
        // чекаем прямые списки и реверснутый второй
        boolean forwardValid = true;
        boolean reverseValid = true;
        
        for (int i = 0; i < thisPoints.size(); i++) {
            Tochka thisPoint = thisPoints.get(i);// базовый
            Tochka otherForwardPoint = otherPoints.get(i);// второй
            Tochka otherReversePoint = otherPoints.get(otherPoints.size() - 1 - i);// обратынй второй
            
            // прямой
            if (forwardValid && !thisPoint.equals(otherForwardPoint)) {
                forwardValid = false;
            }
            
            // обратный
            if (reverseValid && !thisPoint.equals(otherReversePoint)) {
                reverseValid = false;
            }
            
            // оба варианта в гвне ливаем
            if (!forwardValid && !reverseValid) {
                return false;
            }
        }
        
        return forwardValid || reverseValid;
    }

    @Override
    public int hashCode() {
        if (polylineVerticesList == null || polylineVerticesList.isEmpty()) {
            return 0;
        }
        
        // вычисляем хэш для прямого и обратного порядка, берем минимальный
        int forwardHash = 1;
        int reverseHash = 1;
        
        for (int i = 0; i < polylineVerticesList.size(); i++) {
            Tochka point = polylineVerticesList.get(i);
            Tochka reversePoint = polylineVerticesList.get(polylineVerticesList.size() - 1 - i);
            forwardHash = 31 * forwardHash + point.hashCode();
            reverseHash = 31 * reverseHash + reversePoint.hashCode();
        }
        
        return Math.min(forwardHash, reverseHash);
    }
}
