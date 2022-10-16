package transport;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {
    private String brand;
    private String model;
    private double engineVolume;
    private TransportType transportType;
    private List<Driver> drivers = new ArrayList<>();
    private List<Sponsor> sponsors = new ArrayList<>();
    private List<Mechanic> mechanics = new ArrayList<>();

    public Transport(String brand, String model) {
        this(brand, model, 0);
    }

    public Transport(String brand, String model, double engineVolume) {
        if (brand != null && !brand.isEmpty() && !brand.isBlank()) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }
        if (model != null && !model.isEmpty() && !model.isBlank()) {
            this.model = model;
        } else {
            this.model = "default";
        }
        if (engineVolume >= 0) {
            this.engineVolume = 1.5;
        }
    }

    public abstract void start();

    public abstract void stop();

    public abstract boolean performChecks() throws Exception;
    public abstract boolean performRepairs() throws Exception;

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    @Override
    public String toString() {
        return String.format("Марка %s, Модель %s, Двигатель %s", brand, model, engineVolume);
    }
}
