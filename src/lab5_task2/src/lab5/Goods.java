package lab5;

import java.util.Objects;

public class Goods {
    private String code;
    private String name;
    private double price;
    private int number;

    public Goods(String name, double price, int number){
        code = Long.toString(Math.round(Math.random() * 1000000));
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public Double totalPrice(){
        return Math.round(price * number * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Double.compare(goods.price, price) == 0 &&
                number == goods.number &&
                code.equals(goods.code) &&
                name.equals(goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price, number);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
