import java.util.Arrays;

class SimpleArrayList<E> {
    private Object[] elements;
    private int size;

    public SimpleArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public E get(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        return (E) elements[index];
    }

    public void remove(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public void addAll(SimpleArrayList<E> otherList) {
        for (int i = 0; i < otherList.size; i++)
            add(otherList.get(i));
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