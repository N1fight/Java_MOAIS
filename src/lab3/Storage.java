package lab3;

public class Storage<T> {
    // Массив хранит элементы, size обозначает количество занятых ячеек.
    private final T[] elements;
    private int size;

    // По условию конструктор получает заранее созданный пустой массив.
    public Storage(T[] buffer) {
        if (buffer == null || buffer.length == 0) {
            throw new IllegalArgumentException(
                    "Необходимо передать массив положительной длины.");
        }

        elements = buffer;
        size = 0;
    }

    // Проверка индекса существующего элемента.
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Элемента с индексом " + index + " нет.");
        }
    }

    // Значение null запрещено для добавления и замены.
    private void checkValue(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Нельзя сохранить null.");
        }
    }

    // Добавление в первую свободную ячейку.
    public void add(T value) {
        checkValue(value);

        if (size == elements.length) {
            throw new IllegalStateException("Хранилище заполнено.");
        }

        elements[size] = value;
        size++;
    }

    // Получение существующего элемента по индексу.
    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    // Замена значения без изменения количества элементов.
    public void set(int index, T value) {
        checkIndex(index);
        checkValue(value);

        elements[index] = value;
    }

    // Удаление элемента со сдвигом следующих значений влево.
    public T remove(int index) {
        checkIndex(index);
        T removed = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;
        elements[size] = null;

        return removed;
    }

    // Получение текущего количества элементов.
    public int size() {
        return size;
    }

    // Получение общей вместимости массива.
    public int capacity() {
        return elements.length;
    }

    // Проверка отсутствия сохранённых элементов.
    public boolean isEmpty() {
        return size == 0;
    }
}