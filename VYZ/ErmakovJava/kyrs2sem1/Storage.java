package VYZ.ErmakovJava.kyrs2sem1;

import java.util.Objects;

public final class Storage<O> {
    private static final Box<?> NULL_BOX = new Box<>(null);

    private Box<O> box;

    private Storage(Box<O> box) {
        this.box = box;
    }
    public O getObj() {
        if (this.isEmpty()) {
            throw new IllegalStateException("storage is empty (contains null)");
        }
        return box.getObj();
    }

    public void setObj(O obj) {
        if (this.box == NULL_BOX) {
            this.box = new Box<>(obj);
            return;
        }
        if (obj == null) {
            @SuppressWarnings("unchecked")
            Box<O> nb = (Box<O>) NULL_BOX;
            this.box = nb;
            return;
        }
        this.box.setObj(obj);
    }

    public static <O> Storage<O> Nullable(O obj) {
        if (obj == null) {
            @SuppressWarnings("unchecked")
            Storage<O> nullStorage = new Storage<>((Box<O>) NULL_BOX);
            return nullStorage;
        }
        return new Storage<>(new Box<>(obj));
    }

    public static <O> Storage<O> NonNull(O obj) {
        if (obj == null) {
            throw new NullPointerException("null is not allowed in this storage");
        }
        return new Storage<>(new Box<>(obj));
    }

    public boolean isEmpty() {
        return box == null || box.isEmpty();
    }


    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Storage{obj=null}";
        }
        return "Storage{obj=" + box.toString() + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Storage<?> other = (Storage<?>) obj;
        return Objects.equals(this.box, other.box);
    }
    @Override
    public int hashCode() {
        return Objects.hash(box);
    }
}