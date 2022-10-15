package transport;

public enum TransportType {
    CAR("Автомобиль"),
    BUS("Автобус"),
    TRUCK("Грузовик");

    private String name;

    TransportType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
