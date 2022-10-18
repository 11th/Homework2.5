package transport;

public class Bus extends Transport implements Competing {
    public enum Category {
        SMALLEST("особо малая (до 10 мест)"),
        SMALL("малая (до 25 мест)"),
        MIDDLE("средняя (40–50 мест)"),
        BIG("большая (60–80) мест"),
        HUGE("особо большая (100–120 мест)");

        private String description;

        Category(String description){
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    };

    private Category category;

    public Bus(String brand, String model) {
        super(brand, model);
        setTransportType(TransportType.BUS);
    }

    public void determineType(){
        if (category != null){
            System.out.println("Тип вместимости - " + category.getDescription());
        } else {
            System.out.println("Данных недостаточно");
        }
    }

    @Override
    public void start() {
        System.out.println("Автобус поехал");
    }

    @Override
    public void stop() {
        System.out.println("Автобус остановился");
    }

    @Override
    public boolean performChecks() throws Exception{
        System.out.println("Проверка автобуса");
        throw new Exception("Автобусы не проходят проверку");
    }

    @Override
    public boolean performRepairs() throws Exception {
        System.out.println("Ремонт автобуса");
        return false;
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп");
    }

    @Override
    public double getBestLapTime() {
        return 4;
    }

    @Override
    public int getMaxSpeed() {
        return 90;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.format("Категория %s", category.name());
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
