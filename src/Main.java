import transport.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
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
        Driver<Car> mitya = new Driver<>("Митя", "B", bmw);
        System.out.println(mitya);
        Driver<Truck> sasha = new Driver<>("Саша", "C", kamaz);
        System.out.println(sasha);
        Driver<Bus> vova = new Driver<>("Вова", "D", paz);
        System.out.println(vova);

        System.out.println("***");
        checkTransports(bmw, kamaz, paz);

        System.out.println("***");
        Sponsor vtb = new Sponsor("ВТБ", 10000);
        Sponsor sber = new Sponsor("Сбер", 100000);
        Sponsor ivanov = new Sponsor("Иванов И.И.", 1000);

        Mechanic vasya = new Mechanic("Вася", "Иванов", "Компания1", TransportType.CAR);
        Mechanic petya = new Mechanic("Петя", "Иванов", "Компания2", TransportType.TRUCK);
        Mechanic kolya = new Mechanic("Коля", "Иванов", "Компания3", TransportType.BUS);

        bmw.getDrivers().add(mitya);
        bmw.getMechanics().add(vasya);
        bmw.getSponsors().add(sber);

        kamaz.getDrivers().add(sasha);
        kamaz.getMechanics().add(petya);
        kamaz.getSponsors().add(vtb);

        paz.getDrivers().add(vova);
        paz.getMechanics().add(kolya);
        paz.getSponsors().add(ivanov);

        List<Transport> transports = List.of(bmw, kamaz, paz);
        for (Transport transport: transports) {
            printTransportInfo(transport);
        }

        System.out.println("***");
        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addCar(bmw);
        serviceStation.addTruck(kamaz);
        serviceStation.service();
    }

    private static void printTransportInfo(Transport transport){
        System.out.println(transport.getBrand() + " " + transport.getModel());
        var drivers = transport.getDrivers();
        for (Driver driver: drivers) {
            System.out.println("Водитель " + driver.getFullName());
        }
        System.out.println("Механики: " + transport.getMechanics());
        System.out.println("Спонсоры: " + transport.getSponsors());
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