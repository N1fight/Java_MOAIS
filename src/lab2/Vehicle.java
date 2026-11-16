package lab2;

public abstract class Vehicle {
    // Общие характеристики транспортного средства.
    private final String brand;
    private final String model;
    private final int year;
    private final Engine engine;

    // Инициализация общих полей и проверка наличия двигателя.
    protected Vehicle(String brand, String model, int year, Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Двигатель не указан.");
        }

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engine = engine;
    }

    // final запрещает наследникам переопределять этот метод.
    public final void printInfo() {
        System.out.println("Марка: " + brand);
        System.out.println("Модель: " + model);
        System.out.println("Год выпуска: " + year);
        engine.printEngineInfo();
    }

    // Реализацию движения определяет каждый класс-наследник.
    public abstract void move();

    // Статический вложенный класс описывает двигатель.
    public static class Engine {
        private final int power;
        private final String type;

        // Создание двигателя с заданной мощностью и типом.
        public Engine(int power, String type) {
            if (power <= 0) {
                throw new IllegalArgumentException(
                        "Мощность двигателя должна быть положительной.");
            }
            if (type == null || type.trim().isEmpty()) {
                throw new IllegalArgumentException("Тип двигателя не указан.");
            }

            this.power = power;
            this.type = type;
        }

        // Вывод характеристик двигателя.
        public void printEngineInfo() {
            System.out.println("Тип двигателя: " + type);
            System.out.println("Мощность: " + power + " л. с.");
        }
    }
}