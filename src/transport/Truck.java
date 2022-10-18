package transport;

public class Truck extends Transport implements Competing {
    public Truck(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void start() {
        System.out.println("Грузовик поехал");
    }

    @Override
    public void stop() {
        System.out.println("Грузовик остановился");
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп");
    }

    @Override
    public double getBestLapTime() {
        return 5;
    }

    @Override
    public int getMaxSpeed() {
        return 100;
    }
}
