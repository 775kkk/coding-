package VYZ.ErmakovJava.kyrs2sem1.pract5;

import java.util.ArrayList;
import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.GeomEngineering;
import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;

public class Square {
    private List<Tochka> vertexOfSquareList;
    private String squareName;
    private int lengthSideOfSquare;

    public Square(String squareName, int lengthSideOfSquare, List<Tochka> vertexOfSquareList){
        this.squareName = squareName;
        if (lengthSideOfSquare<=0) {
            throw new IllegalArgumentException("lengthSideOfSquare cant be <=0");
        }
        this.lengthSideOfSquare = lengthSideOfSquare;
        if (vertexOfSquareList==null) {
            this.vertexOfSquareList = new ArrayList<Tochka>();
        }else{
            this.vertexOfSquareList = new ArrayList<Tochka>(vertexOfSquareList);
        }
        validateVertexList();
    }

    public void completeVertexList(){
        int sizeOfList = this.vertexOfSquareList.size();
        // задача сложная - объеденить все возможные варианты в единую систему ответа
        // 0   1

        // 2   3

    }

    public void validateVertexList(){
        if (this.vertexOfSquareList.size()<4) {
            completeVertexList();
        }else{
            var conclusionOfRange = GeomEngineering.validRangeGetFirstInvalidIndex(this.getVertexOfSquareList(), this.getLengthSideOfSquare());
            if (conclusionOfRange.isPresent()) {
                completeVertexListOfRange(conclusionOfRange.getAsInt());
                this.validateVertexList();
            }
            // проверки на 90 градусов
            
            var conclusionOfDegrees = GeomEngineering.validNinetyTriangleGetFirstInvalidIndex(
                    this.getVertexOfSquareList(),
                    true, // квадрат — замкнутый
                    Tochka::getX, Tochka::getY
                );
            if(conclusionOfDegrees.isPresent()){
                completeVertexListOfDegrees(conclusionOfDegrees.getAsInt());
            }

            }
    }

    public int getLengthSideOfSquare() {
        return lengthSideOfSquare;
    }
    public String getSquareName() {
        return squareName;
    }
    public List<Tochka> getVertexOfSquareList() {
        return new ArrayList<Tochka>(vertexOfSquareList);
    }

}
