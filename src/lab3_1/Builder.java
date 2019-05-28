package lab3_1;

import java.util.concurrent.ThreadLocalRandom;

public class Builder {
	
	private int id;
	private String surname;
	private String name;
	private String patronymic;
	private String adress;
	private String creditCard;
	private String bankAccount;
	
	Builder buildId() {
		id = ThreadLocalRandom.current().nextInt(1, 1000);
		return this;
	}
	
	Builder buildSurname(String string) {
		surname = string;
		return this;
	}
	
	Builder buildName(String string) {
		name = string;
		return this;
	}
	
	Builder buildPatronymic( String string) {
		patronymic = string;
		return this;
	}
	
	Builder buildAdress( String string) {
		adress = string;
		return this;
	}
	
	Builder buildCreditCard( String string) {
		creditCard = string;
		return this;
	}
	
	Builder buildBankAccount( String string) {
		bankAccount = string;
		return this;
	}
	
	Customer build() {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setSurname(surname);
		customer.setName(name);
		customer.setPatronymic(patronymic);
		customer.setAdress(adress);
		customer.setCreditCard(creditCard);
		customer.setBankAccount(bankAccount);
		return customer;
	}

}
