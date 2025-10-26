package VYZ.ErmakovJava.kyrs2sem1.geometrics;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.function.ToDoubleFunction;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.line.Polyline;
import VYZ.ErmakovJava.kyrs2sem1.pract1.Tochka;
import VYZ.ErmakovJava.kyrs2sem1.pract2.Line;

public final class GeomEngineering {
    private GeomEngineering(){}

    public static double getLineLong(Polyline polyline,boolean endPolicy){
        if (polyline == null) throw new NullPointerException("polyline cant be null");
        double retResult=0;
        List<Tochka> pointsList = polyline.getPolylineVerticesList();
        if (pointsList.size()<2) {
            return 0;
        }
        for (int i = 1; i < pointsList.size(); i++) {
            retResult+=getLineLong(pointsList.get(i-1),pointsList.get(i));
        }
        if (endPolicy) {
            retResult+=getLineLong(pointsList.get(0),pointsList.get(pointsList.size()-1));
        }
        return retResult;
    }
    public static double getLineLong(Tochka tochka){
        if (tochka == null) throw new NullPointerException("tochka cant be null");
        return 0;
    }
    public static double getLineLong(Line line){
        if (line == null) throw new NullPointerException("line cant be null");
        return getLineLong(line.getA(),line.getB());
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

    public static OptionalInt validRangeGetFirstInvalidIndex(int range, Tochka... argsOfTochka){
        return validRangeGetFirstInvalidIndex(Arrays.asList(argsOfTochka),range);
    }

    public static OptionalInt validRangeGetFirstInvalidIndex(List<Tochka> pts, int range) {
        Objects.requireNonNull(pts, "pts");
        if (range == 0) return OptionalInt.empty();
        if (range<0) range=Math.abs(range);
        if (pts.size()<2) throw new IllegalArgumentException("pointsList must contain at least 2 items to validate step distances; got " + pts.size());
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


// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! !!!
    // ЧТОБЫ не тянуть за собой вот это вот ToDoubleFunction<T>...
    // НАДО БЫЛО наследоваться от абстрактного класса 
    //  И ПРИНИМАТЬ только наследников которые МЫ ЗНАЕМ как могут свои координаты отдать
    // !!!!
    /**
     * Вычитает два вектора одинаковой размерности: r = u - v.
     * @param u первый вектор
     * @param v второй вектор
     * @return разностный вектор u - v
     * @throws NullPointerException если любой из аргументов null
     * @throws IllegalArgumentException если размерности не совпадают
     */
    public static double[] toVector(double[] u, double[] v) {
        Objects.requireNonNull(u, "u");
        Objects.requireNonNull(v, "v");
        if (u.length != v.length) {
            throw new IllegalArgumentException("dimension mismatch: u=" + u.length + ", v=" + v.length);
        }
        double[] result = new double[u.length];
        for (int i = 0; i < u.length; i++) {
            result[i] = u[i] - v[i];
        }
        return result;
    }

    @SafeVarargs
    public static <T> double[] toVector(T p, ToDoubleFunction<T>... argOfCoordGettersList) {
        Objects.requireNonNull(p, "point");
        Objects.requireNonNull(argOfCoordGettersList, "argOfCoordGettersList");
        if (argOfCoordGettersList.length == 0) throw new IllegalArgumentException("no argOfCoordGettersList provided");

        double[] v = new double[argOfCoordGettersList.length];
        for (int i = 0; i < argOfCoordGettersList.length; i++) v[i] = argOfCoordGettersList[i].applyAsDouble(p);
        return v;
    }

    public interface EpsilonPolicy {
        double eps(double nBA2, double nBC2);
        EpsilonPolicy DEFAULT = (a2, c2) -> {
            double scale = Math.sqrt(a2 * c2); // ≈ |BA| * |BC|
            return 1e-12 * (1.0 + scale);      // относит. допуск + маленькая абсолютная “подпорка”
        };
    }

    //  COREE COREE COREE COREE COREE COREE COREE COREE COREE COREE COREE
    private final static OptionalInt validNinetyTriangleCore(
            double[] BA, double[] BC, EpsilonPolicy epsPolicy) {

        if (BA == null || BC == null) throw new NullPointerException("BA/BC");
        if (BA.length != BC.length) throw new IllegalArgumentException("dims differ");
        if (epsPolicy == null) {
            epsPolicy = EpsilonPolicy.DEFAULT;
        }
        int n = BA.length;
        if (n < 2) throw new IllegalArgumentException("need at least 2 dimensions");

        double dot = 0.0, nBA2 = 0.0, nBC2 = 0.0;
        for (int i = 0; i < n; i++) {
            double ba = BA[i];
            double bc = BC[i];
            dot  += ba * bc;//  BA · BC
            nBA2 += ba * ba;// |BA|^2
            nBC2 += bc * bc;// |BC|^2
        }

        if (nBA2 == 0.0) return OptionalInt.of(0); // вырожден BA
        if (nBC2 == 0.0) return OptionalInt.of(2); // вырожден BC

        double eps = epsPolicy.eps(nBA2, nBC2);
        return (Math.abs(dot) <= eps) ? OptionalInt.empty() : OptionalInt.of(1);
    }

    public static boolean isValidNinetyTriangle(double[] BA, double[] BC) {
        return validNinetyTriangleCore(BA, BC, EpsilonPolicy.DEFAULT).isEmpty();
    }

// --- Обёртка: из трёх точек и набора координат строим BA и BC и зовём core ---
    @SafeVarargs
    public static <T> OptionalInt validNinetyTriangleGetFirstInvalidIndex(
            T A, T B, T C,
            EpsilonPolicy epsPolicy,
            ToDoubleFunction<T>... coords
            )
    {
        Objects.requireNonNull(A, "A");
        Objects.requireNonNull(B, "B");
        Objects.requireNonNull(C, "C");
        Objects.requireNonNull(coords, "coords");
        Objects.requireNonNull(epsPolicy, "epsPolicy");
        if (coords.length < 2) throw new IllegalArgumentException("need at least 2 coordinates");

        // превращаем точки в координатные векторы
        double[] a = toVector(A, coords);
        double[] b = toVector(B, coords);
        double[] c = toVector(C, coords);

        // строим BA = A - B, BC = C - B (именно такие компоненты нужны для угла в B)
        double[] BA = toVector(a, b);
        double[] BC = toVector(c, b);

        // core-проверка на 90°
        return validNinetyTriangleCore(BA, BC, epsPolicy);
    }

    // Удобная булева обёртка с DEFAULT-политикой
    @SafeVarargs
    public static <T> boolean isValidNinetyTriangle(
            T A, T B, T C,
            ToDoubleFunction<T>... coords)
    {
        return validNinetyTriangleGetFirstInvalidIndex(A, B, C, EpsilonPolicy.DEFAULT, coords).isEmpty();
    }

    @SafeVarargs
    public static <T> OptionalInt validNinetyTriangleGetFirstInvalidIndex(
            T A, T B, T C,
            ToDoubleFunction<T>... coords)
    {
        return validNinetyTriangleGetFirstInvalidIndex(A, B, C, EpsilonPolicy.DEFAULT, coords);
    }

    @SafeVarargs
    public static <T> OptionalInt validNinetyTriangleGetFirstInvalidIndex(List<T> tOfList,boolean closedChain,ToDoubleFunction<T>... coords){
        if (tOfList.size()<3) throw new IllegalArgumentException("List of T .size()<3, cannot<3");
        if (coords.length < 2) throw new IllegalArgumentException("At least 2 coordinate accessors are required");

        final int n = tOfList.size();

        if (closedChain) {
            if (n < 4)
                throw new IllegalArgumentException("Closed chain requires at least 4 points");
            for (int i = 0; i < n; i++) {
                int ip = (i - 1 + n) % n;   // prev
                int in = (i + 1) % n;       // next
                var bad = validNinetyTriangleGetFirstInvalidIndex(
                        tOfList.get(ip), tOfList.get(i), tOfList.get(in), coords);
                if (bad.isPresent()) return OptionalInt.of(i); // индекс вершины с «не 90°»
            }
            return OptionalInt.empty();
        } else {
            if (n < 3)
                return OptionalInt.empty(); // нечего проверять
            for (int i = 1; i <= n - 2; i++) {
                var bad = validNinetyTriangleGetFirstInvalidIndex(
                        tOfList.get(i - 1), tOfList.get(i), tOfList.get(i + 1), coords);
                if (bad.isPresent()) return OptionalInt.of(i);
            }
            return OptionalInt.empty();
        }
    }






//     public static double[] tochkaToDoubleXY(Tochka tochka){
//         return new double[]{tochka.getX(),tochka.getY()};
//     }
//     public static boolean isValidNinetyTriangle(Tochka tochkaA, Tochka tochkaTarget, Tochka tochkaC){
//         return validNinetyTriangleGetFirstInvalidIndex(a,b,c).isEmpty();
//     }
//     public static boolean isValidNinetyTriangle(List<Tochka> tochkasList){
//         if (tochkasList.size()!=3) throw new IllegalArgumentException("not 3 points were passed to the triangle evaluation");
//         double[] a = { tochkasList.get(0).getX(), tochkasList.get(0).getY() };
//         double[] b = { tochkasList.get(1).getX(), tochkasList.get(1).getY() };
//         double[] c = { tochkasList.get(2).getX(), tochkasList.get(2).getY() };
//         return validNinetyTriangleGetFirstInvalidIndex(a,b,c).isEmpty();
//     }
//     public static boolean isValidNinetyTriangle(Tochka... argsOfTochka){
//         if (argsOfTochka.length!=3) throw new IllegalArgumentException("not 3 points were passed to the triangle evaluation");
//         double[] a = { to.getX(), A.getY() };
//         double[] b = { B.getX(), B.getY() };
//         double[] c = { C.getX(), C.getY() };
//         return validNinetyTriangleGetFirstInvalidIndex(a,b,c).isEmpty();
//     }

//     public static OptionalInt validNinetyTriangleGetFirstInvalidIndex(double[] a, double[] b, double[] c){

//     }

    
}
