package VYZ.ErmakovJava.kyrs2sem1.streambeta;

import java.util.Iterator;
import java.util.Objects;


final class MapPotok<IN, OUT> extends Potok<OUT> {

    private final Potok<IN> pervIteratPotok;
    private final ApplyBeta<? super IN, ? extends OUT> rule;

    MapPotok(Potok<IN> pervIteratPotok, ApplyBeta<? super IN, ? extends OUT> rule) {
        this.pervIteratPotok = Objects.requireNonNull(pervIteratPotok, "pervIteratPotok");
        this.rule = Objects.requireNonNull(rule, "rule");
    }

    @Override
    public Iterator<OUT> iterator() {
        Iterator<IN> it = pervIteratPotok.iterator();

        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public OUT next() {
                IN in = it.next();
                return rule.apply(in);
            }
        };
    }
}
