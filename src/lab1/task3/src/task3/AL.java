package task3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AL implements ActionListener {
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField dadnameField;
    private JTextField addressField;
    private JTextField creditCardField;
    private JTextField bankAccountField;
    private JTextArea answerArea;
    private CustomerStorage manager;

    public AL(MyFrame frame){
        surnameField = frame.getSurnameField();
        nameField = frame.getNameField();
        dadnameField = frame.getDadnameField();
        addressField = frame.getAddressField();
        creditCardField = frame.getCreditCardField();
        bankAccountField = frame.getBankAccountField();
        answerArea = frame.getAnswerArea();
        manager = frame.getManager();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Customer customer = new Builder()
                    .buildId()
                    .buildSurname(surnameField.getText())
                    .buildName(nameField.getText())
                    .buildPatronymic(dadnameField.getText())
                    .buildAdress(addressField.getText())
                    .buildCreditCard(creditCardField.getText())
                    .buildBankAccount(bankAccountField.getText())
                    .build();
            manager.addCustomer(customer);
            String answer = manager.alphabetOrder().toString();
            answer = answer.substring(1, answer.length() - 1);
            answerArea.setText(answer);
        }
        catch (Exception ex){
            System.out.println(ex);
            answerArea.setText("Validate input");
        }
    }
}
