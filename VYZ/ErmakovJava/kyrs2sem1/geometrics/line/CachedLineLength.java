package VYZ.ErmakovJava.kyrs2sem1.geometrics.line;

import VYZ.ErmakovJava.kyrs2sem1.geometrics.figure.interfaces.GetLongs;

public final class CachedLineLength implements GetLongs {

    private final Line line;      // живая линия, которую кто-то может двигать
    private Line snapshot;        // копия линии на момент последнего расчёта
    private Double cachedLength;  // закешированная длина

    public CachedLineLength(Line line) {
        if (line == null) {
            throw new NullPointerException("line cannot be null");
        }
        this.line = line;
    }

    @Override
    public double getLong() {
        // если уже есть кэш и линия не менялась — возвращаем кэш
        if (cachedLength != null && snapshot != null && snapshot.equals(line)) {
            return cachedLength;
        }

        // иначе считаем длину заново
        double length = line.getLong(); // или свой метод, если изменишь

        // обновляем snapshot и кэш
        try {
            snapshot = (Line) line.clone();
        } catch (ClassCastException e) {
            // если clone вдруг вернул не Line — это программная ошибка
            throw new IllegalStateException("Line.clone() returned wrong type", e);
        }
        cachedLength = length;

        return length;
    }

    public Line getLine() {
        return line;
    }
    public void resetCache() {
        snapshot = null;
        cachedLength = null;
    }
}
