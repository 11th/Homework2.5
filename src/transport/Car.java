package transport;

public class Car extends Transport implements Competing {
    public Car(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void start() {
        System.out.println("Авто поехал");
    }

    @Override
    public void stop() {
        System.out.println("Авто остановился");
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп");
    }

    @Override
    public double getBestLapTime() {
        return 10;
    }

    @Override
    public int getMaxSpeed() {
        return 200;
    }
}
