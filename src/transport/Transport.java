package transport;

public abstract class Transport {
    private String brand;
    private String model;
    private double engineVolume;

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

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    @Override
    public String toString() {
        return String.format("Марка %s, Модель %s, Двигатель %s", brand, model, engineVolume);
    }
}
