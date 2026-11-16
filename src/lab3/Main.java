package lab3;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------- Хранилище строк --------");

        // Создание пустого хранилища вместимостью три элемента.
        Storage<String> names = new Storage<>(new String[3]);
        printState(names);

        // Добавление строк и получение элемента по индексу.
        names.add("Константин");
        names.add("Пётр");
        names.add("Ира");

        System.out.println("\nПосле добавления:");
        printState(names);
        System.out.println("Элемент с индексом 1: " + names.get(1));

        // Замена существующего значения.
        names.set(1, "Анна");

        System.out.println("\nПосле замены:");
        printState(names);

        // Проверка добавления в заполненный массив.
        try {
            names.add("Алексей");
        } catch (IllegalStateException error) {
            System.out.println("\nПроверка переполнения: " + error.getMessage());
        }

        // Удаление из середины показывает сдвиг оставшегося элемента.
        System.out.println("\nУдалён элемент: " + names.remove(1));
        printState(names);

        // Индекс 2 уже не входит в занятую часть массива.
        try {
            names.get(2);
        } catch (IndexOutOfBoundsException error) {
            System.out.println("\nПроверка индекса: " + error.getMessage());
        }

        // Свободное место есть, но сохранять null запрещено.
        try {
            names.add(null);
        } catch (IllegalArgumentException error) {
            System.out.println("\nПроверка null: " + error.getMessage());
        }

        System.out.println("\n-------- Хранилище чисел --------");

        // Тот же класс используется с типом Integer.
        Storage<Integer> numbers = new Storage<>(new Integer[2]);
        printState(numbers);

        // Добавление чисел и получение элемента по индексу.
        numbers.add(10);
        numbers.add(20);

        System.out.println("\nПосле добавления:");
        printState(numbers);
        System.out.println("Элемент с индексом 0: " + numbers.get(0));

        // Замена числа и удаление первого элемента со сдвигом второго.
        numbers.set(0, 15);

        System.out.println("\nПосле замены:");
        printState(numbers);

        System.out.println("\nУдалён элемент: " + numbers.remove(0));
        printState(numbers);

        // Удаление последнего элемента делает хранилище пустым.
        System.out.println("\nУдалён элемент: " + numbers.remove(0));
        printState(numbers);
    }

    // Символ ? позволяет выводить хранилище с любым типом элементов.
    private static void printState(Storage<?> storage) {
        System.out.println("Количество элементов: " + storage.size());
        System.out.println("Вместимость: " + storage.capacity());
        System.out.println("Хранилище пустое: " + storage.isEmpty());

        for (int i = 0; i < storage.size(); i++) {
            System.out.println("[" + i + "] " + storage.get(i));
        }
    }
}