package VYZ.ErmakovJava.kyrs2sem1.geometrics;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.data.ColorPoint;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.data.CoordsPoint;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.data.Point;
import VYZ.ErmakovJava.kyrs2sem1.geometrics.data.SizedPoint;

public class Main {
    public static void main(String[] args) {
    Point p1 = new ColorPoint(new CoordsPoint(3), "red");

    Point p2 = new SizedPoint(new CoordsPoint(4, 2, 5), 20);

    Point p3 = new ColorPoint(
                                new SizedPoint(
                                    new CoordsPoint(7, 7),
                                    20
                                    ),
                                "yellow"
                            );
    }
}
