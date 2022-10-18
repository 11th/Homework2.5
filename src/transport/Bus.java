package transport;

public class Bus extends Transport implements Competing {
    public Bus(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void start() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void stop() {
        System.out.println("Автобус остановился");
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп");
    }

    @Override
    public double getBestLapTime() {
        return 4;
    }

    @Override
    public int getMaxSpeed() {
        return 90;
    }
}
