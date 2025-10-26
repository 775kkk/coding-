package VYZ.ErmakovJava.kyrs2sem1.geometrics.figure;

import java.util.ArrayList;
import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces.Figure;

public class Triangle extends Figure {
    private List<Double> degreList;
    private List<Integer> distanceList;
    
    public Triangle(String name,List<Integer> distanceList ,List<Double> degressList){
        super(3, name);
        this.degreList = degressList==null ? new ArrayList<Double>(3):new ArrayList<Double>(degressList);
        this.distanceList = distanceList==null ? new ArrayList<Integer>(3) : new ArrayList<Integer>(distanceList);
        if (!isValidTriangleDistance(distanceList.get(0), distanceList.get(1), distanceList.get(2))) {
            throw new IllegalArgumentException("distance uncorrect");
        }
        if (!isValidTriangleDegree(degreList.get(0), degreList.get(1), degreList.get(2))) {
            throw new IllegalArgumentException("degrees uncorrect");
        }
    }
    public Triangle(List<Integer> distanceList ,List<Double> degressList){
        this("",distanceList ,degressList);
    }

    private boolean isValidTriangleDistance(double a, double b, double c) {
        return a + b > c && a + c > b && b + c > a;
    }
    private boolean isValidTriangleDegree(double a, double b, double c) {
        return a+b+c<=180;
    }

    public void setDegreList(List<Double> degreList) {
        if (!isValidTriangleDegree(degreList.get(0), degreList.get(1), degreList.get(2))) {
            throw new IllegalArgumentException("degrees uncorrect");
        }
        this.degreList = new ArrayList<>(degreList);
    }
    public void setDistanceList(List<Integer> distanceList) {
        if (!isValidTriangleDistance(distanceList.get(0), distanceList.get(1), distanceList.get(2))) {
            throw new IllegalArgumentException("distance uncorrect");
        }
        this.distanceList = new ArrayList<>(distanceList);
    }
    public List<Double> getDegreList() {
        return new ArrayList<>(degreList);
    }

    public List<Integer> getDistanceList() {
        return new ArrayList<>(distanceList);
    }

    @Override
    public double area() {
        // герона
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - distanceList.get(0)) * (p - distanceList.get(1)) * (p - distanceList.get(2)));
    }
    @Override
    public double perimeter() {
        return distanceList.get(0) + distanceList.get(1) + distanceList.get(2);
    }
    
}
