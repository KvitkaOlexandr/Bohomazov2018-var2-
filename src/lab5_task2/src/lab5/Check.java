package lab5;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class Check {
    private String number;
    private Date date;
    private HashMap<Goods, Double> goodsList;
    private double totalCost;

    public Check(){
        number = Long.toString(Math.round(Math.random() * 10000));
        date = new Date();
        goodsList = new HashMap<>();
        totalCost = 0.0;
    }

    public void addGoods(String name, double price, int number){
        Goods goods = new Goods(name, price, number);
        goodsList.put(goods, goods.totalPrice());
        totalCost();
    }

    public void setGoods(String code, int newNumber){
        for(Map.Entry<Goods, Double> entry : goodsList.entrySet()){
            Goods key = entry.getKey();
            if(key.getCode().equals(code)){
                key.setNumber(newNumber);
                entry.setValue(key.totalPrice());
                totalCost();
                return;
            }
        }
        System.out.println("No such code");
    }

    public void removeGoods(String code){
        for(Map.Entry<Goods, Double> entry : goodsList.entrySet()){
            Goods key = entry.getKey();
            if(key.getCode().equals(code)){
                goodsList.remove(key);
                totalCost();
                return;
            }
        }
        System.out.println("No such code");
    }

    public void totalCost(){
        totalCost = 0.0;
        for(Map.Entry<Goods, Double> entry : goodsList.entrySet()){
            totalCost += entry.getValue();
        }
    }

    public String getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public HashMap<Goods, Double> getGoodsList() {
        return goodsList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        String string =  "Check ATB №" + number + "\n" + date.toString() + "\n";
        for(Map.Entry<Goods, Double> entry : goodsList.entrySet()){
            string += entry.getKey().getName() + "   " + entry.getKey().getNumber() + "x" + entry.getKey().getPrice() +
                    "   " + entry.getValue() + "\n";
        }
        string += "Total " + totalCost;
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Double.compare(check.totalCost, totalCost) == 0 &&
                number.equals(check.number) &&
                date.equals(check.date) &&
                goodsList.equals(check.goodsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, date, goodsList, totalCost);
    }
}
