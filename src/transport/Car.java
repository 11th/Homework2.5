package transport;

public class Car extends Transport implements Competing {

    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купэ"),
        UNIVERSAL("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private String bodyTypeName;

        BodyType(String bodyTypeName){
            this.bodyTypeName = bodyTypeName;
        }

        public String getBodyTypeName() {
            return bodyTypeName;
        }
    };

    private BodyType bodyType;

    public Car(String brand, String model) {
        super(brand, model);
        setTransportType(TransportType.CAR);
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
    public boolean performChecks() throws Exception{
        return true;
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

    public void setBodyType(BodyType bodyType){
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("Тип кузова %s", bodyType.getBodyTypeName());
    }

    public BodyType getBodyType() {
        return bodyType;
    }
}
