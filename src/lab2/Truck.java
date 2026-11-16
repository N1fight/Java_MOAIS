package lab2;

public class Truck extends Vehicle {
    // Максимальная масса груза в килограммах.
    private final double maxLoad;

    // Создание грузовика с проверкой грузоподъёмности.
    public Truck(String brand, String model, int year,
                 Engine engine, double maxLoad) {
        super(brand, model, year, engine);

        if (!Double.isFinite(maxLoad) || maxLoad <= 0) {
            throw new IllegalArgumentException(
                    "Грузоподъёмность должна быть конечным положительным числом.");
        }

        this.maxLoad = maxLoad;
    }

    // Переопределение метода move() из класса Vehicle.
    @Override
    public void move() {
        System.out.println("Грузовик едет по дороге.");
        System.out.println("Грузоподъёмность: " + maxLoad + " кг.");
    }

    // Проверка массы перед демонстрацией загрузки.
    public void loadCargo(double weight) {
        if (!Double.isFinite(weight) || weight <= 0) {
            System.out.println("Ошибка: масса груза должна быть конечным положительным числом.");
            return;
        }
        if (weight > maxLoad) {
            System.out.println("Ошибка: превышена грузоподъёмность.");
            return;
        }

        System.out.println("В грузовик загружено " + weight + " кг.");
    }
}