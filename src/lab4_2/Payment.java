package lab4_2;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment {

    private class Item{
        Item(String name, double cost) {
            if(cost < 0){
                throw new IllegalArgumentException("Cost can't be negative");
            }
            this.name = name;
            this.cost = cost;
        }

        private String name;
        private double cost;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return Double.compare(item.cost, cost) == 0 &&
                    Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name, cost);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", cost=" + cost +
                    '}';
        }
    }
    private List<Item> itemList;

    public void addItem(String name, double cost){
        itemList.add(new Item(name, cost));
    }

    public String getAllItems(){
        return itemList.toString();
    }
    
    public double getTotalCost(){
        double res = 0;
        for (Item item: itemList) {
            res += item.cost;
        }
        return res;
    }

    public Payment(){
        itemList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(itemList, payment.itemList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemList);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "itemList=" + itemList +
                '}';
    }
}
