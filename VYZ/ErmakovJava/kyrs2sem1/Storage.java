package VYZ.ErmakovJava.kyrs2sem1;

import java.util.Objects;

public final class Storage<O> {
    private final O obj;

    public Storage(O obj) {
        this.obj = obj;
    }
    public O getObj() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return obj;
    }
    
    public boolean isEmpty(){
        return Objects.isNull(obj);
    }
}
