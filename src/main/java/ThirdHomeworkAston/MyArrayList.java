package ThirdHomeworkAston;

import java.util.Collection;
import java.util.Arrays;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    // Конструктор по умолчанию
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Конструктор, принимающий другую коллекцию
    public MyArrayList(Collection<? extends T> c) {
        elements = new Object[c.size()];
        addAll(c);
    }

    // Метод для добавления элемента
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Метод для добавления всех элементов из другой коллекции
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacity(size + numNew);  // Использование метода с параметром
        System.arraycopy(a, 0, elements, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    // Перегруженный метод ensureCapacity без параметров
    private void ensureCapacity() {
        ensureCapacity(size + 1);  // Увеличиваем емкость на 1 для нового элемента
    }

    // Метод для увеличения емкости массива при необходимости
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Метод для получения элемента по индексу
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    // Метод для удаления элемента по индексу
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T oldValue = (T) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldValue;
    }

    // Метод для получения текущего размера списка
    public int size() {
        return size;
    }

    // Метод для проверки, пустой ли список
    public boolean isEmpty() {
        return size == 0;
    }

    // Метод для очистки списка
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Статический метод сортировки
    public static <T extends Comparable<? super T>> void sort(MyArrayList<T> list) {
        boolean swapped;
        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.elements[j] = list.get(j + 1);
                    list.elements[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
