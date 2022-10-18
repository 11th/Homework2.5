package transport;

import java.util.Objects;

public class Mechanic<T extends Transport> {
    private String name;
    private String surname;
    private String company;
    private TransportType transportType;

    public Mechanic(String name, String surname, String company, TransportType transportType) throws Exception {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new Exception("Укажите имя");
        }
        if (surname != null && !surname.isEmpty()) {
            this.surname = surname;
        } else {
            throw new Exception("Укажите фамилию");
        }
        if (company != null && !company.isEmpty()) {
            this.company = company;
        } else {
            throw new Exception("Укажите компанию");
        }
        if (transportType != null) {
            this.transportType = transportType;
        } else {
            throw new Exception("Укажите тип транспорта для ремонта");
        }
    }

    public void doService(T transport) throws Exception {
        if (!transportType.equals(transport.getTransportType())){
            throw new Exception("Механик может работать только с транспортом " + getTransportType().getName());
        }
        transport.performChecks();
    }

    public void doRepair(T transport) throws Exception {
        if (!transportType.equals(transport.getTransportType())){
            throw new Exception("Механик может работать только с транспортом " + getTransportType().getName());
        }
        transport.performRepairs();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany() {
        return company;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return name.equals(mechanic.name) && surname.equals(mechanic.surname) && company.equals(mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, company);
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }
}
