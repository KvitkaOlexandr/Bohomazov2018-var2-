package task3;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private JTextField surnameField;
    private JTextField nameField;
    private JTextField dadnameField;
    private JTextField addressField;
    private JTextField creditCardField;
    private JTextField bankAccountField;
    private JButton calculateButton;
    private JTextArea answerArea;
    private CustomerStorage manager;

    public MyFrame(String title){
        super(title);
        surnameField = new JTextField(20);
        nameField = new JTextField(20);
        calculateButton = new JButton("Calculate");
        dadnameField = new JTextField(20);
        addressField = new JTextField(20);
        creditCardField = new JTextField(20);
        bankAccountField = new JTextField(20);
        JLabel label1 = new JLabel("         Surname:");
        JLabel label2 = new JLabel("               Name:");
        JLabel label3 = new JLabel("    Dad's name:");
        JLabel label4 = new JLabel("          Address:");
        JLabel label5 = new JLabel("     Credit card:");
        JLabel label6 = new JLabel("Bank account:");

        JPanel labels = new JPanel(new GridLayout(0, 2));
        labels.add(label1);
        labels.add(surnameField);
        labels.add(label2);
        labels.add(nameField);
        labels.add(label3);
        labels.add(dadnameField);
        labels.add(label4);
        labels.add(addressField);
        labels.add(label5);
        labels.add(creditCardField);
        labels.add(label6);
        labels.add(bankAccountField);
        JPanel left = new JPanel(new BorderLayout());
        left.add(labels, BorderLayout.NORTH);
        add(left, BorderLayout.NORTH);

        answerArea = new JTextArea(18,30);
        JScrollPane sp = new JScrollPane(answerArea);
        JPanel panel7 = new JPanel();
        panel7.add(calculateButton);
        add(panel7, BorderLayout.CENTER);

        JPanel panel8 = new JPanel();
        panel8.add(sp);
        panel8.setBackground(Color.BLACK);
        add(panel8, BorderLayout.PAGE_END);
        manager = new CustomerStorage();
        calculateButton.addActionListener(new AL(this));
    }

    public JTextField getSurnameField(){return surnameField;}
    public JTextField getNameField(){return nameField;}
    public JTextField getBankAccountField() { return bankAccountField; }
    public JTextField getDadnameField() { return dadnameField;}
    public JTextField getAddressField() { return addressField; }
    public JTextField getCreditCardField() { return creditCardField; }
    public JButton getCalculateButton(){return calculateButton;}
    public JTextArea getAnswerArea(){return answerArea;}
    public CustomerStorage getManager(){return manager;}

    public static void window(String windowName){
        JFrame jFrame = getFrame(windowName);
    }

    private static JFrame getFrame(String title){
        MyFrame jFrame = new MyFrame(title);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 500, 500);
        jFrame.setVisible(true);
        return  jFrame;
    }
}