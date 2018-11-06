package lab3_1;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Menedger {
	
	private List<Customer> List;
	
	public Menedger(){
		List = new ArrayList<Customer>();
	}
	
	public String addCustomer(String _surname, 
					String _name, 
					String _patronymic, 
					String _adress, 
					String _creditCard, 
					String _bankAccount) {
		List.add(new Builder()
					.buildId()
					.buildSurname(_surname) 
					.buildName(_name) 
					.buildPatronymic(_patronymic) 
					.buildAdress(_adress) 
					.buildCreditCard(_creditCard) 
					.buildBankAccount(_bankAccount)
					.build());
		return List.get(List.size() - 1).toString();
	}
	
	public void deleteCustomer(int id) {
		if(!List.isEmpty()) {
			for(Customer customer : List) {
				if(customer.getId() == id)
					List.remove(customer);
			}
		}
	}
	
	public String getCustomer(int id) {
		if(!List.isEmpty()) {
			for(Customer customer : List) {
				if(customer.getId() == id)
					return customer.toString();
			}
		}
		return "No customer with such id";
	}
	
	public String alphabetOrder() {
		if(List.isEmpty()) 
			return "Empty list";
		List<Customer> sortedList = new ArrayList<Customer>();
		for(Customer customer : List) {
			sortedList.add(customer);
		}
		Collections.sort(sortedList, (a, b) -> a.compareSurnameTo(b));
		String string = "";
		for(Customer customer : sortedList) {
			string = string + customer.toString() + "\n";
		}
		return string;
	}
	
	public String creditFilter(String l, String r) {
		if(List.isEmpty()) 
			return "Empty list";
		if(List.get(0).compareCreditsTo(l) == -2 || List.get(0).compareCreditsTo(r) == -2)
			return "Wrong border of number";
		List<Customer> filtredList = new ArrayList<Customer>();
		for(Customer customer : List) {
			if(customer.compareCreditsTo(l) == 1 && customer.compareCreditsTo(r) == -1)	
				filtredList.add(customer);
		}
		String string = "";
		for(Customer customer : filtredList) {
			string = string + customer.toString() + "\n";
		}
		return string;
	}
	
	@Override
	public String toString() {
		String string = "";
		for(Customer customer : List) {
			string = string + customer.toString() + "\n";
		}
		return string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((List == null) ? 0 : List.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menedger other = (Menedger) obj;
		if (List == null) {
			if (other.List != null)
				return false;
		} else if (!List.equals(other.List))
			return false;
		return true;
	}
}
