package lab5;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Check check = new Check();

        check.addGoods("AMA milk", 25.0, 2);
        check.addGoods("bread Ukrainian", 10.15, 1);
        System.out.println(check.toString());
    }
}
