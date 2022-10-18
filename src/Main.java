import transport.*;

import javax.sound.midi.Track;

public class Main {
    public static void main(String[] args) {
        System.out.println("***");
        Car bmw = new Car("BMW", "F30");
        bmw.setBodyType(Car.BodyType.SEDAN);
        System.out.println(bmw);
        Car rr = new Car("Rolls-Royce", "Fantom");
        Car mini = new Car("Mini", "JCV");
        Car vaz = new Car("VAZ", "Vesta sport");

        System.out.println("***");
        Truck kamaz = new Truck("Камаз", "М1");
        kamaz.setCarrying(Truck.Carrying.N2);
        System.out.println(kamaz);
        kamaz.determineType();
        Truck maz = new Truck("МАЗ", "М2");
        Truck kraz = new Truck("Краз", "М3");
        Truck zil = new Truck("ЗИЛ", "М4");

        System.out.println("***");
        Bus paz = new Bus("ПАЗ", "M1");
        paz.setCategory(Bus.Category.SMALL);
        System.out.println(paz);
        paz.determineType();
        Bus gaz = new Bus("ГАЗ", "M2");
        Bus liaz = new Bus("ЛИАЗ", "M3");
        Bus kavz = new Bus("КАВЗ", "M4");

        System.out.println("***");
        printMaxSpeed(bmw, kamaz, paz);

        System.out.println("***");
        try {
            Driver<Car> mitya = new Driver<>("Митя", "B", bmw);
            System.out.println(mitya);
            Driver<Truck> sasha = new Driver<>("Саша", "D", kamaz);
            System.out.println(sasha);
            Driver<Bus> vova = new Driver<>("Вова", "", paz);
            System.out.println(vova);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("***");
        checkTransports(bmw, kamaz, paz);
    }

    private static void checkTransports(Transport... transports){
        for (Transport transport: transports) {
            checkTransport(transport);
        }
    }

    private static void checkTransport(Transport transport){
        try {
            if (transport.performChecks()){
                System.out.println(transport.getBrand() + " " + transport.getModel() + " " + "проверку прошел");
            } else {
                System.out.println(transport.getBrand() + " " + transport.getModel() + " " + "проверку не прошел");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void printMaxSpeed(Competing... transports) {
        for (Competing transport : transports) {
            if (transport instanceof Car) {
                System.out.println("Скорость авто " + transport.getMaxSpeed());
            } else if (transport instanceof Truck) {
                System.out.println("Скорость грузовика " + transport.getMaxSpeed());
            } else if (transport instanceof Bus) {
                System.out.println("Скорость автобуса " + transport.getMaxSpeed());
            }
        }
    }
}