package transport;

import java.util.ArrayDeque;
import java.util.IllegalFormatCodePointException;
import java.util.Queue;

public class ServiceStation {
    private final Queue<Transport> transports = new ArrayDeque<>();

    public void addCar(Car car){
        add(car);
    }

    public void addTruck(Truck truck){
        add(truck);
    }

    private void add(Transport transport){
        transports.offer(transport);
    }

    public void service(){
        if (!transports.isEmpty()){
            Transport transport = transports.poll();
            try {
                if (!transport.performChecks()) {
                    transport.performRepairs();
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
