package lab4;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------- Калькулятор Integer --------");

        // Целые операнды позволяют проверить получение дробного частного.
        Calculator<Integer> integers = new Calculator<>(5, 2);

        System.out.println("Первое число: 5");
        System.out.println("Второе число: 2");
        printResults(integers);

        System.out.println("\n-------- Калькулятор Double --------");

        // Дробные операнды демонстрируют вычисления с отрицательным числом.
        Calculator<Double> decimals = new Calculator<>(-4.5, 1.5);

        System.out.println("Первое число: -4.5");
        System.out.println("Второе число: 1.5");
        printResults(decimals);

        System.out.println("\n-------- Проверка ошибок --------");

        // Деление на ноль перехватывается, программа продолжает работу.
        try {
            Calculator<Integer> zeroDivisor = new Calculator<>(5, 0);
            zeroDivisor.divide();
        } catch (ArithmeticException error) {
            System.out.println("Проверка деления: " + error.getMessage());
        }

        // Конструктор запрещает создание калькулятора с отсутствующим числом.
        try {
            new Calculator<Integer>(null, 2);
        } catch (IllegalArgumentException error) {
            System.out.println("Проверка null: " + error.getMessage());
        }

        System.out.println("\n-------- Квадрат числа --------");

        // Статический метод вызывается через класс для Integer и Double.
        System.out.println("Квадрат 5: " + Calculator.square(5));
        System.out.println("Квадрат -1.5: " + Calculator.square(-1.5));
    }

    // Вывод всех пяти операций для калькулятора любого допустимого типа.
    private static void printResults(Calculator<?> calculator) {
        System.out.println("Сумма: " + calculator.add());
        System.out.println("Разность: " + calculator.subtract());
        System.out.println("Произведение: " + calculator.multiply());
        System.out.println("Частное: " + calculator.divide());
        System.out.println("Среднее арифметическое: " + calculator.average());
    }
}