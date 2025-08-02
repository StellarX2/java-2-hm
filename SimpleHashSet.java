
import java.util.Arrays;

class SimpleHashSet<E> {
    private Object[] elements;
    private int size;

    public SimpleHashSet() {
        elements = new Object[10];
        size = 0;
    }

    public boolean insert(E element) {
        if (contains(element)) return false;
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                elements[i] = elements[size - 1];
                elements[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    private boolean contains(E element) {
        for (int i = 0; i < size; i++)
            if (elements[i].equals(element))
                return true;
        return false;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size));
    }
}