package transport;

public interface Competing {
    void pitStop();

    double getBestLapTime();

    int getMaxSpeed();
}
