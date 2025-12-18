package VYZ.ErmakovJava.kyrs2sem1.streambeta;

import java.util.Arrays;

//мне не нравится что у нас якобы ленивые вычисления реализованы через создание объектов которые по сути обертки -> обертки должны быть вокруг логики -> будто оборачивать логику в обёртку так что делается объект обертки позор

//цепочка обёрток, каждая хранит к кому обратиться дальше + что сделать с элементом(или как понять к кому обратиться дальше).
public abstract class Potok<T> implements Iterable<T> {// общий абстрактный класс для всех оберток над итератором

    public static <T> Potok<T> of(Iterable<T> bazaIterable) {
        return new SourcePotok<>(bazaIterable);
    }

    @SafeVarargs
    public static <T> Potok<T> of(T... items) {
        return of(Arrays.asList(items));// create Iterable2000
    }
    // обертки итератора
    public <R> Potok<R> mapBeta(ApplyBeta<? super T, ? extends R> ruleApplyBeta) {
        return new MapPotok<>(this, ruleApplyBeta);
    }

    public Potok<T> filterBeta(TestBeta<? super T> rule) {
        return new FilterPotok<>(this, rule);
    }
    // сразу делать что-то с элементами внутри каждой обертки
    public <A> A reduceBeta(A identity, ApplyTripleBeta<A, ? super T, A> ruleApplyTripleBeta) {
        A acc = identity;
        for (T value : this) {
            acc = ruleApplyTripleBeta.apply(acc, value);
        }
        return acc;
    }

    public <C> C collectBeta(GetTBeta<C> supplier, AcceptBeta<C, ? super T> ruleAcceptBeta) {
        C container = supplier.get();
        for (T value : this) {
            ruleAcceptBeta.accept(container, value);
        }
        return container;
    }
}
