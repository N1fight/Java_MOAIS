package lab2;

public class Main {
    public static void main(String[] args) {
        // Восходящее преобразование: объекты наследников сохраняются в Vehicle.
        Vehicle car = new Car(
                "Lada", "Vesta", 2022,
                new Vehicle.Engine(106, "бензиновый"), 3);

        Vehicle motorcycle = new Motorcycle(
                "Урал", "Турист", 2019,
                new Vehicle.Engine(41, "бензиновый"), true);

        Vehicle truck = new Truck(
                "ГАЗ", "ГАЗон", 2020,
                new Vehicle.Engine(149, "дизельный"), 5000);

        // Анонимный подкласс Vehicle реализует абстрактный метод move().
        Vehicle electricBus = new Vehicle(
                "КамАЗ", "6282", 2021,
                new Vehicle.Engine(250, "электрический")) {

            @Override
            public void move() {
                System.out.println("Электробус следует по городскому маршруту.");
            }
        };

        // Все созданные транспортные средства хранятся в одном массиве.
        Vehicle[] vehicles = {car, motorcycle, truck, electricBus};

        System.out.println("\n-------- Автопарк --------");

        // Полиморфизм: вызывается move() фактического класса объекта.
        for (Vehicle vehicle : vehicles) {
            System.out.println();
            vehicle.printInfo();
            vehicle.move();

            // Нисходящее преобразование выполняется после проверки типа.
            if (vehicle instanceof Car) {
                Car currentCar = (Car) vehicle;
                currentCar.openTrunk();

            } else if (vehicle instanceof Motorcycle) {
                Motorcycle currentMotorcycle = (Motorcycle) vehicle;
                currentMotorcycle.doWheelie();

            } else if (vehicle instanceof Truck) {
                Truck currentTruck = (Truck) vehicle;
                currentTruck.loadCargo(1200);
            }

            System.out.println("--------------------------");
        }

        // Неправильное приведение: motorcycle ссылается на объект Motorcycle.
        // Car wrongCar = (Car) motorcycle;
        // Если выполнить эту строку, возникнет ClassCastException.
        // Безопасный вариант с instanceof показан в цикле выше.
    }
}