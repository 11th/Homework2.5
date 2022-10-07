import transport.Transport;

public class Driver<T extends Transport> {
    private String fullName;
    private boolean hasDriverCard;
    private int experience;
    private T transport;

    public Driver(String fullName, T transport) {
        this.fullName = fullName;
        this.transport = transport;
    }

    public void start(T transport) {
        transport.start();
    }

    public void stop(T transport) {
        transport.stop();
    }

    public void addFuel(T transport) {
        System.out.println("Заправляю " + transport.getBrand() + " " + transport.getModel());
    }

    public void setHasDriverCard(boolean hasDriverCard) {
        this.hasDriverCard = hasDriverCard;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isHasDriverCard() {
        return hasDriverCard;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return String.format("Водитель %s управояет автомобилем %s и будет учавствовать в заезде",
                fullName, transport.getBrand() + " " + transport.getModel()
        );
    }
}
