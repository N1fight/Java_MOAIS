package lab4;

public class Calculator<T extends Number> {
    // Два операнда выбранного числового типа.
    private final T first;
    private final T second;

    // Проверка аргументов и сохранение чисел.
    public Calculator(T first, T second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("Оба числа должны быть заданы.");
        }

        this.first = first;
        this.second = second;
    }

    // Сложение после преобразования операндов в double.
    public double add() {
        return first.doubleValue() + second.doubleValue();
    }

    // Вычитание второго числа из первого.
    public double subtract() {
        return first.doubleValue() - second.doubleValue();
    }

    // Умножение двух чисел.
    public double multiply() {
        return first.doubleValue() * second.doubleValue();
    }

    // Проверка делителя и вычисление дробного частного.
    public double divide() {
        double divisor = second.doubleValue();

        if (divisor == 0.0) {
            throw new ArithmeticException("Деление на ноль.");
        }

        return first.doubleValue() / divisor;
    }

    // Среднее арифметическое двух чисел.
    public double average() {
        return add() / 2.0;
    }

    // Дополнительное задание: статический метод со своим параметром типа.
    public static <N extends Number> double square(N value) {
        if (value == null) {
            throw new IllegalArgumentException("Число должно быть задано.");
        }

        double number = value.doubleValue();
        return number * number;
    }
}