package VYZ.ErmakovJava.kyrs2sem1.pract5;

import java.util.ArrayList;
import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;
import VYZ.ErmakovJava.kyrs2sem1.pract3.Polyline;


public class Square {
    private List<Tochka> vertexOfSquareList;
    private String squareName;
    private int lengthSideOfSquare;

    public Square(String squareName, int lengthSideOfSquare, List<Tochka> vertexOfSquareList){
        this.squareName = squareName;
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
        // 0   1

        // 2   3

    }

    public void validateVertexList(){
        if (this.vertexOfSquareList.size()<4) {
            completeVertexList();
        }else{
            List<Tochka> exampleVertexList = this.getVertexOfSquareList();
            // List<Integer> exceptionIndexList = new ArrayList<Integer>();
            for (int i = 1; i < exampleVertexList.size(); i++) {
                if (Polyline.getLineLong(exampleVertexList.get(i-1),exampleVertexList.get(i))!=this.lengthSideOfSquare) {
                    // exceptionIndexList.add(i);
                    completeVertexList(i);// выкинуть индекс неисправной точки в комплитер точек (вместо исключения сразу исправим с записью в логе)
                    // предполагается раз у комплит вертекс лист есть один аргумент типа инт, то 
                    // он конкретно должен отработать по этой ошибке
                    // но применить тот же код компановки этой точке к остальным - код компановки должен 
                    // урегулировать эту точку по отношению к двум другим в треугольнике чтобы она была валидной для точки квадрата
                    // 

                    // я не вижу смысла напрягаться,, я всегда старался, я не знаю зачем, да мне давали автоматы, скорее всего и без этого
                    // напряга мне дадут автомат, я никогда не понимал зачем я напрягаюсь, зачем я хочу все сделать как надо и по максимуму
                    // в моей ситуации можно +- ничего не делать и казаться умным что не будет просто показухой, я реально чтото умею
                    //  чтото знаю, зачем я перенапрягаюсь, перевыполняю, переделываю? ничего больше чем автомат мне не дадут и не давали
                    //  люди делают ровно столько за сколько им платят, никто не будет проверять мой код так как он даже без этих двух функций 
                    // гораздо лучше всей массы того что принесут люди. так зачем мне сейчас часа 3 ломать голову и строить сложное взаимодействие?
                    // ради чего все это, ради чего вцелом все мои труды? как тут не закурить и не выпить? это невыносимо
                    // один фиг я в итоге буду работать по целевому один фиг я и так лучше окружающих, консервация моего времени с учетом сил в 
                    // конкретно этот код не возвысит меня в выборке мнеподобных, там на это способен каждый... , а над этими куда выше то
                    // 
                    //  даже если я это сделаю, никто не оценит моих трудов ни сегодня ни завтра ни когда либо, а сам для себя я не вижу смысла напрягаться
                    // не вижу стимулов за которые мне впрыснут эндорфина в голову и я охотно буду сидеть 3 часа втыкать в монитор

                    // да благодоря тому что я старался делать на максимум я выполнил многие задания еще до их оглашения, но я их все равно бы выполнил
                    // даже затратил бы меньше сил
                }
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
