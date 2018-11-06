package lab3_1;

import java.util.concurrent.ThreadLocalRandom;

public class Builder {
	
	private int Id;
	private String Surname;
	private String Name;
	private String Patronymic;
	private String Adress;
	private String CreditCard;
	private String BankAccount;
	
	Builder buildId() {
		Id = ThreadLocalRandom.current().nextInt(1, 1000);
		return this;
	}
	
	Builder buildSurname(String _surname) {
		Surname = _surname;
		return this;
	}
	
	Builder buildName(String _name) {
		Name = _name;
		return this;
	}
	
	Builder buildPatronymic( String _patronymic) {
		Patronymic = _patronymic;
		return this;
	}
	
	Builder buildAdress( String _adress) {
		Adress = _adress;
		return this;
	}
	
	Builder buildCreditCard( String _creditCard) {
		CreditCard = _creditCard;
		return this;
	}
	
	Builder buildBankAccount( String _bankAccount) {
		BankAccount = _bankAccount;
		return this;
	}
	
	Customer build() {
		Customer customer = new Customer();
		customer.setId(Id);
		customer.setSurname(Surname);
		customer.setName(Name);
		customer.setPatronymic(Patronymic);
		customer.setAdress(Adress);
		customer.setCreditCard(CreditCard);
		customer.setBankAccount(BankAccount);
		return customer;
	}

}
