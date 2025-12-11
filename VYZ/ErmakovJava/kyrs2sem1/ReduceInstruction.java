package VYZ.ErmakovJava.kyrs2sem1;

import java.util.List;

public interface ReduceInstruction<T> {
    // public T Reduce(List<? extends Reduceable> reducedableList);
    public T Reduce(List<T> reducedableList);

}
