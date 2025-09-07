package VYZ.ErmakovJava.kyrs2sem1.pract1;

import java.util.List;

public class line121 {
    private Tochka111 tochkaA;
    private Tochka111 tochkaB;
    private boolean initialized;

    public final void setLine(Tochka111 tochka1, Tochka111 tochka2){
        if (tochka1 == null || tochka2 == null) {
            throw new IllegalArgumentException("Точки не должны быть null");
        }
        this.tochkaA=tochka1;
        this.tochkaB=tochka2;
        this.initialized = true;
    }

    public final Tochka111 getA() { return tochkaA; }
    public final Tochka111 getB() { return tochkaB; }
    public final boolean getStatus() { return this.initialized; }
    public final boolean isEmpty() { return !initialized; }


    // список
    public final List<Tochka111> getPoints() {
        return List.of(tochkaA, tochkaB);
    }

    // делегат
    public final void withPoints(java.util.function.BiConsumer<Tochka111, Tochka111> action) {
        action.accept(tochkaA, tochkaB);
    }

    public final void clear() {
        tochkaA = null;
        tochkaB = null;
        initialized = false;
    }

    @Override
    public String toString() {
        return "Line121{" + String.valueOf(tochkaA) + " -> " + String.valueOf(tochkaB) + "}";
    }
}
