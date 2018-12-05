package lab3_1;


public class Customer {
	private int id;
	private String surname;
	private String name;
	private String patronymic;
	private String adress;
	private String creditCard;
	private String bankAccount;
	
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		id = newId;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String newSurname) {
		surname = newSurname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	
	public void setPatronymic(String newPatronymic) {
		patronymic = newPatronymic;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String newAdress) {
		adress = newAdress;
	}
	public String getCreditCard() {
		return creditCard;
	}
	
	public void setCreditCard(String newCreditCard) {
		if(validateCreditCard(newCreditCard))
			creditCard = newCreditCard;
		else throw new IllegalArgumentException();
	}
	public String getBankAccount() {
		return bankAccount;
	}
	
	public void setBankAccount(String newBankAccount) {
		if(validateBankAccount(newBankAccount))
			bankAccount = newBankAccount;
		else throw new IllegalArgumentException();
	}
	
	private boolean validateCreditCard(String creditCard) {
		if(creditCard.length() == 16 && creditCard.matches("[+]?\\d+")) {
			return true;
		}
		return false;
	}
	
	private boolean validateBankAccount(String bankAccount) {
		if(bankAccount.length() == 20 && bankAccount.matches("[+]?\\d+")) {
			return true;
		}
		return false;
	}
	
	public int compareSurnameTo(Customer that) {
		int result = String.CASE_INSENSITIVE_ORDER.compare(surname, that.getSurname());
        if (result == 0) {
            result = surname.compareTo(that.getSurname());
        }
        return result;
	}
	
	public int compareCreditsTo(String credit) {
		int result = 0;
		if(validateCreditCard(credit)) {
			int current = 0;
			while(current < 16) {
				if(Integer.valueOf(credit.charAt(current)) < Integer.valueOf(creditCard.charAt(current))) {
					result = 1;
					break;
				}
				else if(Integer.valueOf(credit.charAt(current)) > Integer.valueOf(creditCard.charAt(current))) {
					result = -1;
					break;
				}	
				else
					current++;
			}
		}
		else {
			result = -2;
		}
		return result;
	}
	
	@Override
	public String toString() {
		String string = "Id: " + String.valueOf(id) + "\n" 
					  + "Surname: " + surname + "\n" 
					  + "Name: " + name + "\n" 
					  + "Patronymic: " + patronymic + "\n"
					  + "Adress: " + adress + "\n" 
					  + "Credit card: " + creditCard + "\n" 
					  + "Bank account: " + bankAccount + "\n";
		return string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((bankAccount == null) ? 0 : bankAccount.hashCode());
		result = prime * result + ((creditCard == null) ? 0 : creditCard.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Customer other = (Customer) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (bankAccount == null) {
			if (other.bankAccount != null)
				return false;
		} else if (!bankAccount.equals(other.bankAccount))
			return false;
		if (creditCard == null) {
			if (other.creditCard != null)
				return false;
		} else if (!creditCard.equals(other.creditCard))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patronymic == null) {
			if (other.patronymic != null)
				return false;
		} else if (!patronymic.equals(other.patronymic))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
}
