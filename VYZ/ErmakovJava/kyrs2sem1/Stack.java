package VYZ.ErmakovJava.kyrs2sem1;

import java.util.List;
import java.util.Objects;

public class Stack<O> {
    private List<O> elements;
    private int capasity;

    public Stack(List<O> elements, int capasity) {
        if (!Objects.isNull(elements)) {
            this.elements = elements;
        }
        this.capasity = capasity;
    }
    public void push(O element) {
        if (elements.size() >= capasity) {
            throw new IllegalStateException("Stack is full");
        }
        elements.add(element);
    }
    public O pop() {
        if (elements.size() <= 0) {
            throw new IllegalStateException("Stack is empty");
        }
        O element = elements.get(elements.size() - 1);
        elements.remove(elements.size() - 1);
        return element;
    }
    public boolean isEmpty() {
        return elements.size() <= 0;
    }
    public boolean isFull() {
        return elements.size() >= capasity;
    }
    public int size() {
        return elements.size();
    }
    public O peek() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("cтек пуст");
        }
        int lastIndex = elements.size() - 1;
        return elements.get(lastIndex);
    }

    public Stack(int capasity){
        this(null, capasity);
    }

}
