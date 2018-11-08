package lab3_1;

public class Main {

	public static void main(String[] args) {
		task1();		
	}
	
	public static void task1() {
		Menedger menedger = new Menedger();
		
		System.out.println("Adding: \n");
		System.out.println(menedger.addCustomer("Petrov", "Petr", "Petrovich", "Stroiteley str, 3, 12", "1234567890123453", "12345678901234567890"));
		System.out.println(menedger.addCustomer("Ivanov", "Ivan", "Ivanovich", "Stroiteley str, 3, 12", "1234567890123454", "12345678901234567890"));
		System.out.println(menedger.addCustomer("Sidorov", "Sidr", "Sidrovich", "Stroiteley str, 3, 12", "1234567890123455", "12345678901234567890"));
		System.out.println(menedger.addCustomer("Andreev", "Andrey", "Andreevich", "Stroiteley str, 3, 12", "1234567890123456", "12345678901234567890"));
		
		System.out.println("Sorting: \n");
		System.out.println(menedger.alphabetOrder());
		
		System.out.println("Filtering: \n");
		System.out.println(menedger.creditFilter("1234567890123453", "1234567890123456"));
	}

}
