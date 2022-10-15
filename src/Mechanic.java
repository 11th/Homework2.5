import transport.TransportType;

public class Mechanic {
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

    public void doService(){
        System.out.println("Провожу техобслуживание");
    }

    public void doRepair(){
        System.out.println("Ремонтирую машину");
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
}
