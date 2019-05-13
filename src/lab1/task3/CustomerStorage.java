package task3;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class CustomerStorage {
	
	private List<Customer> list;
	
	public CustomerStorage(){
		list = new ArrayList<Customer>();
	}
	
	public String addCustomer(Customer customer) {
		list.add(customer);
		return list.get(list.size() - 1).toString();
	}
	
	public void deleteCustomer(int id) {
		if(!list.isEmpty()) {
			for(Customer customer : list) {
				if(customer.getId() == id)
					list.remove(customer);
			}
		}
	}
	
	public Customer getCustomer(int id) {
		if(!list.isEmpty()) {
			for(Customer customer : list) {
				if(customer.getId() == id)
					return customer;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public List<Customer> alphabetOrder() {
		if(list.isEmpty()) 
			throw new IllegalArgumentException("Empty list");
		List<Customer> sortedList = new ArrayList<Customer>();
		for(Customer customer : list) {
			sortedList.add(customer);
		}
		Collections.sort(sortedList, (a, b) -> a.compareSurnameTo(b));
		return sortedList;
	}
	
	public List<Customer> creditFilter(String l, String r) {
		if(list.isEmpty()) 
			throw new IllegalArgumentException("Empty list");
		if(list.get(0).compareCreditsTo(l) == -2 || list.get(0).compareCreditsTo(r) == -2)
			throw new IllegalArgumentException("Wrong border of number");
		List<Customer> filtredList = new ArrayList<Customer>();
		for(Customer customer : list) {
			if(customer.compareCreditsTo(l) == 1 && customer.compareCreditsTo(r) == -1)	
				filtredList.add(customer);
		}
		return filtredList;
	}
	
	@Override
	public String toString() {
		String string = "";
		for(Customer customer : list) {
			string = string + customer.toString() + "\n";
		}
		return string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		CustomerStorage other = (CustomerStorage) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}
}
