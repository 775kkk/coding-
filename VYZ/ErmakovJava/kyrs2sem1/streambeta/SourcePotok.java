package VYZ.ErmakovJava.kyrs2sem1.streambeta;

import java.util.Iterator;
import java.util.Objects;

final class SourcePotok<T> extends Potok<T> {

    private final Iterable<T> bazaIterable;// часто просто список - коллекция - итеребл за которым точно стоит уже элемент а если нет то и не важно особо так как все равно через цепь итераторов будем идти

    SourcePotok(Iterable<T> bazaIterable) {
        this.bazaIterable = Objects.requireNonNull(bazaIterable, "bazaIterable");
    }

    @Override
    public Iterator<T> iterator() {// hasNext() next() базовые так как эта обертка ничо не умеет как и просто .stream()
        return bazaIterable.iterator();// бежит к базе просить итератор
    }
}

