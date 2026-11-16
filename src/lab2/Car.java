package lab2;

public class Car extends Vehicle {
    // Количество пассажиров в автомобиле.
    private final int passengerCount;

    // Общие характеристики передаются конструктору Vehicle.
    public Car(String brand, String model, int year,
               Engine engine, int passengerCount) {
        super(brand, model, year, engine);

        if (passengerCount < 0) {
            throw new IllegalArgumentException(
                    "Количество пассажиров не может быть отрицательным.");
        }

        this.passengerCount = passengerCount;
    }

    // Собственная реализация движения автомобиля.
    @Override
    public void move() {
        System.out.println("Автомобиль едет по дороге.");
        System.out.println("Количество пассажиров: " + passengerCount);
    }

    // Действие, характерное для автомобиля.
    public void openTrunk() {
        System.out.println("Багажник автомобиля открыт.");
    }
}