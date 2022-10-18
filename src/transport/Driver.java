package transport;

import transport.Transport;

import java.util.Objects;

public class Driver<T extends Transport> {
    private String fullName;
    private boolean hasDriverCard;
    private int experience;
    private String driverCategory;
    private T transport;

    public Driver(String fullName, String driverCategory, T transport) throws Exception {
        this.fullName = fullName;
        this.transport = transport;
        setDriverCategory(driverCategory);
    }

    public void start() {
        transport.start();
    }

    public void stop() {
        transport.stop();
    }

    public void addFuel() {
        System.out.println("Заправляю " + transport.getBrand() + " " + transport.getModel());
    }

    public void setHasDriverCard(boolean hasDriverCard) {
        this.hasDriverCard = hasDriverCard;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setDriverCategory(String driverCategory) {
        if (driverCategory == null || driverCategory.isEmpty()){
            throw new RuntimeException("Укажите категорию для водителя " + getFullName());
        }
        this.driverCategory = driverCategory;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return fullName.equals(driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return String.format("Водитель %s управояет автомобилем %s и будет учавствовать в заезде",
                fullName, transport.getBrand() + " " + transport.getModel()
        );
    }
}
