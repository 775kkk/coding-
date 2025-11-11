package VYZ.ErmakovJava.kyrs2sem1.geometrics.interfaces;

import java.util.ArrayList;
import java.util.List;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.line.Polyline;
import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;

public interface Polylinable {//2.3.7
    public static Polyline getSumPolyline(Polylinable... polylinables) {
        List<Tochka> retList = new ArrayList<>();
        for (Polylinable polylinable : polylinables) {
            Polyline polyline = polylinable.getPolyline(); // один вызов
            retList.addAll(polyline.getPolylineVerticesList()); // добавляем все точки
        }
        return new Polyline(retList); // создаем полилинию из всех точек
    }
    public Polyline getPolyline();
}
