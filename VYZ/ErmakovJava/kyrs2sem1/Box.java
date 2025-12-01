package VYZ.ErmakovJava.kyrs2sem1;

import java.util.Objects;

public final class Box<O> {
    private O obj;

    public Box(O obj) {
        this.obj = obj;
    }

    public void setObj(O obj) {
        if (!this.isEmpty()) {
            throw new IllegalStateException();
        }
        this.obj = obj;
    }

    public O getObj() {
        O temp =obj;
        obj=null;
        return temp;
    }

    public boolean isEmpty(){
        return Objects.isNull(obj);
    }
}
