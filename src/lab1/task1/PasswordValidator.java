package lab1.task1;

import java.util.Objects;

public class PasswordValidator {
	
	private String realPassword;
	
	public PasswordValidator(String password) {
        realPassword = password;
    }

    public String getRealPassword() {
        return realPassword;
    }

    public void setRealPassword(String realPassword) {
        this.realPassword = realPassword;
    }

    
    public boolean validate(String password){
        return realPassword.equals(password);
    }

    
    @Override
    public String toString() {
        return "PasswordValidator{" +
                "realPassword='" + realPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordValidator that = (PasswordValidator) o;
        return Objects.equals(realPassword, that.realPassword);
    }

    @Override
    public int hashCode() {

        return Objects.hash(realPassword);
    }
}