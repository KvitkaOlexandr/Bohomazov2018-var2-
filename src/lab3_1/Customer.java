package lab3_1;


public class Customer {
	private int Id;
	private String Surname;
	private String Name;
	private String Patronymic;
	private String Adress;
	private String CreditCard;
	private String BankAccount;
	
	/*public Customer(String _surname, 
					String _name, 
					String _patronymic, 
					String _adress, 
					String _creditCard, 
					String _bankAccount) {
		Id = ThreadLocalRandom.current().nextInt(1, 1000);
		Surname = _surname;
		Name = _name;
		Patronymic = _patronymic;
		Adress = _adress;
		if(validateCreditCard(_creditCard))
			CreditCard = _creditCard;
		else throw new IllegalArgumentException();
		if(validateBankAccount(_bankAccount))
			BankAccount = _bankAccount;
		else throw new IllegalArgumentException();
	}*/
	
	public int getId() {
		return Id;
	}
	
	public void setId(int newId) {
		Id = newId;
	}
	
	public String getSurname() {
		return Surname;
	}
	
	public void setSurname(String newSurname) {
		Surname = newSurname;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String newName) {
		Name = newName;
	}
	
	public String getPatronymic() {
		return Patronymic;
	}
	
	public void setPatronymic(String newPatronymic) {
		Patronymic = newPatronymic;
	}
	
	public String getAdress() {
		return Adress;
	}
	
	public void setAdress(String newAdress) {
		Adress = newAdress;
	}
	public String getCreditCard() {
		return CreditCard;
	}
	
	public void setCreditCard(String newCreditCard) {
		if(validateCreditCard(newCreditCard))
			CreditCard = newCreditCard;
		else throw new IllegalArgumentException();
	}
	public String getBankAccount() {
		return BankAccount;
	}
	
	public void setBankAccount(String newBankAccount) {
		if(validateBankAccount(newBankAccount))
			BankAccount = newBankAccount;
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
		int result = String.CASE_INSENSITIVE_ORDER.compare(Surname, that.getSurname());
        if (result == 0) {
            result = Surname.compareTo(that.getSurname());
        }
        return result;
	}
	
	public int compareCreditsTo(String credit) {
		int result = 0;
		if(validateCreditCard(credit)) {
			int i = 0;
			while(i < 16) {
				if(Integer.valueOf(credit.charAt(i)) < Integer.valueOf(CreditCard.charAt(i))) {
					result = 1;
					break;
				}
				else if(Integer.valueOf(credit.charAt(i)) > Integer.valueOf(CreditCard.charAt(i))) {
					result = -1;
					break;
				}	
				else
					i++;
			}
		}
		else {
			result = -2;
		}
		return result;
	}
	
	@Override
	public String toString() {
		String string = "Id: " + String.valueOf(Id) + "\n" 
					  + "Surname: " + Surname + "\n" 
					  + "Name: " + Name + "\n" 
					  + "Patronymic: " + Patronymic + "\n"
					  + "Adress: " + Adress + "\n" 
					  + "Credit card: " + CreditCard + "\n" 
					  + "Bank account: " + BankAccount + "\n";
		return string;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Adress == null) ? 0 : Adress.hashCode());
		result = prime * result + ((BankAccount == null) ? 0 : BankAccount.hashCode());
		result = prime * result + ((CreditCard == null) ? 0 : CreditCard.hashCode());
		result = prime * result + Id;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Patronymic == null) ? 0 : Patronymic.hashCode());
		result = prime * result + ((Surname == null) ? 0 : Surname.hashCode());
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
		if (Adress == null) {
			if (other.Adress != null)
				return false;
		} else if (!Adress.equals(other.Adress))
			return false;
		if (BankAccount == null) {
			if (other.BankAccount != null)
				return false;
		} else if (!BankAccount.equals(other.BankAccount))
			return false;
		if (CreditCard == null) {
			if (other.CreditCard != null)
				return false;
		} else if (!CreditCard.equals(other.CreditCard))
			return false;
		if (Id != other.Id)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Patronymic == null) {
			if (other.Patronymic != null)
				return false;
		} else if (!Patronymic.equals(other.Patronymic))
			return false;
		if (Surname == null) {
			if (other.Surname != null)
				return false;
		} else if (!Surname.equals(other.Surname))
			return false;
		return true;
	}
}
