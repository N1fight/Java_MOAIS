package lab2;

public class Motorcycle extends Vehicle {
    // Признак наличия коляски.
    private final boolean hasSidecar;

    // Создание мотоцикла с общими и собственными характеристиками.
    public Motorcycle(String brand, String model, int year,
                      Engine engine, boolean hasSidecar) {
        super(brand, model, year, engine);
        this.hasSidecar = hasSidecar;
    }

    // Собственная реализация движения мотоцикла.
    @Override
    public void move() {
        System.out.println("Мотоцикл едет по трассе.");
        System.out.println("Наличие коляски: " + (hasSidecar ? "да" : "нет"));
    }

    // Возможность поднять переднее колесо зависит от наличия коляски.
    public void doWheelie() {
        if (hasSidecar) {
            System.out.println("Подъём переднего колеса с коляской недоступен.");
        } else {
            System.out.println("Мотоцикл поднимает переднее колесо.");
        }
    }
}