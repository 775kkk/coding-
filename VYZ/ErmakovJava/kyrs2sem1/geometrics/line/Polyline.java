package VYZ.ErmakovJava.kyrs2sem1.geometrics.line;

import java.util.ArrayList;
import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.GeomEngineering;
import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;

public class Polyline {
    private String lineName;
    private List<Tochka> polylineVerticesList;

    // надо сделать конструктор без имени
    public Polyline(String lineName, List<Tochka> polylineVerticesList){
        this.lineName = lineName;
        if (polylineVerticesList==null) {
            this.polylineVerticesList = new ArrayList<Tochka>();
        } else{
            this.polylineVerticesList = polylineVerticesList;
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
}
