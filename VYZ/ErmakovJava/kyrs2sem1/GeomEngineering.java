package VYZ.ErmakovJava.kyrs2sem1;

import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;
import VYZ.ErmakovJava.kyrs2sem1.pract2.Line;
import VYZ.ErmakovJava.kyrs2sem1.pract3.Polyline;

public final class GeomEngineering {
    
    // ПЕРЕДЕЛАЮ

    
    // ЯВНЫЙ КОНТАКТ ЛУЧШЕ СКРЫТОГО тут скрытый
    // НЕ УДОБНО ПОДДЕРЖИВАТЬ И РАСШИРЯТЬ СВИЧТ
    // НИКОМУ НЕ НУЖНО РАЗРАСТАТЬ МЕТОД
    public static double getLineLong(Object object){// ПРИНИМАЕТСЯ ЛЮБОЙ ОБЪЕКТ - ОШИБКА ТОКА В РАНТАЙМ
        switch (object) {// ПРИНИМАЕТСЯ ЛЮБОЙ ОБЪЕКТ - ОШИБКА ТОКА В РАНТАЙМ
            case Polyline polyline:
                double retResult=0;
                List<Tochka> pointsList = polyline.getPolylineVerticesList();
                if (pointsList.size()<2) {
                    return 0;
                } 
                for (int i = 1; i < pointsList.size(); i++) {
                    retResult+=getLineLong(pointsList.get(i-1),pointsList.get(i));
                }
                return retResult;

            case Tochka tochka:
                return 0;

            case Line line:
                return getLineLong(line.getA(),line.getB());

            case null:
                throw new IllegalArgumentException("Передан null объект в getLineLong");
                
            default:
                throw new IllegalArgumentException(
                    "Неподдерживаемый тип: " + object.getClass().getSimpleName() + 
                    ". Поддерживаются: Polyline, Line, Tochka"
                );
                
        }
    }

    public static double getLineLong(Tochka tochka1, Tochka tochka2){
        double dx = tochka1.getX() - tochka2.getX();
        double dy = tochka1.getY() - tochka2.getY();
        double dz = tochka1.getZ() - tochka2.getZ();
        
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static boolean isValidRange(List<Tochka> listOfTochka, int range){
        return validRangeGetFirstInvalidIndex(listOfTochka, range).isEmpty();
    }

    public static OptionalInt validRangeGetFirstInvalidIndex(List<Tochka> pts, int range) {
        Objects.requireNonNull(pts, "pts");
        if (range == 0) return OptionalInt.empty();
        if (range<0) range=Math.abs(range);
        if (pts.size()<2) throw new IllegalArgumentException("pointsList must contain at least 2 items to validate step distances; got " + pts.size());
            // List<Integer> exceptionIndexList = new ArrayList<Integer>();
            for (int i = 1; i < pts.size(); i++) {
                // проверки на длинну
                if (GeomEngineering.getLineLong(pts.get(i-1),pts.get(i))!=range) {
                    return OptionalInt.of(i);
                }
                if (i==pts.size()-1) {
                    if (GeomEngineering.getLineLong(pts.get(0),pts.get(i))!=range) {
                        return OptionalInt.of(i);
                    }
                }
            }
        return OptionalInt.empty();
    }

    
}
