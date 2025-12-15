package VYZ.ErmakovJava.kyrs2sem1.streambeta;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * FilterPotok: пропускает только элементы, удовлетворяющие pred.
 * Итератор "буферизует" следующий подходящий элемент, чтобы hasNext() был честным.
 */
final class FilterPotok<T> extends Potok<T> {

    private final Potok<T> pervIteratPotok;
    private final TestBeta<? super T> ruleTestBeta;

    FilterPotok(Potok<T> pervIteratPotok, TestBeta<? super T> ruleTestBeta) {
        this.pervIteratPotok = Objects.requireNonNull(pervIteratPotok, "pervIteratPotok");
        this.ruleTestBeta = Objects.requireNonNull(ruleTestBeta, "ruleTestBeta");
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = pervIteratPotok.iterator();

        return new Iterator<>() {

            private T nextValue;// именно валюе не а не иттератор
            private boolean nextReady;
            private boolean finished;

            private void prepareNext() {
                if (nextReady || finished) return;

                while (it.hasNext()) {
                    T candidate = it.next();
                    if (ruleTestBeta.test(candidate)) {
                        nextValue = candidate;
                        nextReady = true;
                        return;
                    }
                }
                finished = true;
            }

            @Override
            public boolean hasNext() {
                prepareNext();
                return nextReady;
            }

            @Override
            public T next() {
                prepareNext();
                if (!nextReady) throw new NoSuchElementException();

                T result = nextValue;

                // сброс буфера (гербейдж коллектор спаси и помоги)
                nextValue = null;
                nextReady = false;

                return result;
            }
        };
    }
}
