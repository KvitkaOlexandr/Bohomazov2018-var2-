package lab1.task1;

public class PasswordValidator {
    private final String realPassword = "password";

    public boolean validate(String password) {
        return realPassword.equals(password);
    }
}
