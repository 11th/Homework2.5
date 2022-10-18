package transport;

import java.util.Objects;

public class Sponsor {
    private String name;
    private double moneyAmount;

    public Sponsor(String name, double moneyAmount) throws Exception {
        if (name != null && !name.isEmpty()){
            this.name = name;
        } else {
            throw new Exception("Укажите имя спонсора");
        }
        setMoneyAmount(moneyAmount);
    }

    public void setMoneyAmount(double moneyAmount) throws Exception {
        if (moneyAmount > 0) {
            this.moneyAmount = moneyAmount;
        } else {
            throw new Exception("Сумма должна быть больше нуля");
        }
    }

    public void giveMoney(){
        System.out.println(String.format("Даю %s рублей на гонку", this.moneyAmount));
    }

    public String getName() {
        return name;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return name.equals(sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
