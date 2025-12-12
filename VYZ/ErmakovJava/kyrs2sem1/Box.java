package VYZ.ErmakovJava.kyrs2sem1;

import java.util.Objects;

public final class Box<O> {
    private O obj;

    public Box(O obj) {
        this.obj = obj;
    }

    public void setObj(O obj) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> other = (Box<?>) o;
        return Objects.equals(this.obj, other.obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(obj);
    }
    @Override
    public String toString() {
        return obj == null ? "null" : obj.toString();
    }
    
}
