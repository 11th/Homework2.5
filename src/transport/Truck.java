package transport;

public class Truck extends Transport implements Competing {
    public enum Carrying {
        N1("с полной массой до 3,5 тонн"),
        N2("с полной массой свыше 3,5 до 12 тонн"),
        N3("с полной массой свыше 12 тонн");

        private String description;

        Carrying (String description){
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    };

    private Carrying carrying;

    public Truck(String brand, String model) {
        super(brand, model);
        setTransportType(TransportType.TRUCK);
    }

    public void determineType(){
        if (carrying != null){
            System.out.println("Тип грузоподъемности - " + carrying.getDescription());
        } else {
            System.out.println("Данных недостаточно");
        }
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
    public boolean performChecks() throws Exception {
        return false;
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

    @Override
    public String toString() {
        return super.toString() + " " + String.format("Грузоподьемность %s", carrying.name());
    }

    public void setCarrying(Carrying carrying) {
        this.carrying = carrying;
    }

    public Carrying getCarrying() {
        return carrying;
    }
}
