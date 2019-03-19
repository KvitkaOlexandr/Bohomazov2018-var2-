package task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MyFrame extends JFrame {

    private JTextField numberField;
    private JButton calculateButton;
    private JTextArea answerArea;
    private Calculator calculator;

    public MyFrame(String title){
        super(title);
        numberField = new JTextField("Example: 1.2 0.34 5.4 2.0...", 15);
        numberField.setForeground(Color.GRAY);
        numberField.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if (numberField.getText().equals("Example: 1.2 0.34 5.4 2.0...")) {
                    numberField.setText("");
                    numberField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (numberField.getText().isEmpty()) {
                    numberField.setForeground(Color.GRAY);
                    numberField.setText("Example: 1.2 0.34 5.4 2.0...");
                }
            }
        });
        calculateButton = new JButton("Calculate");
        answerArea = new JTextArea(10, 20);
        JLabel label = new JLabel("Input numbers:");
        JPanel panel1 = new JPanel();
        panel1.add(label);
        panel1.add(numberField);
        panel1.add(calculateButton);
        add(panel1, BorderLayout.NORTH);
        answerArea = new JTextArea(6,30);
        JPanel panel2 = new JPanel();
        panel2.add(answerArea);
        add(panel2, BorderLayout.CENTER);
        calculateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String string = numberField.getText();
                if(!ArrayUtils.validateString(string)){
                    answerArea.setForeground(Color.RED);
                    answerArea.setText("WRONG INPUT. In should be like '1.2 0.34 5.4 2.0...'");
                }
                else {
                    answerArea.setForeground(Color.BLACK);
                    double[] numbers = ArrayUtils.stringToDouble(string);
                    calculator = new Calculator(numbers);
                    answerArea.setText("Sum of positive elements - " + calculator.sumPositive() + "\n" +
                            "Division of elements between absolute maximal and absolute minimal - " +
                            calculator.prodBetweenAsbMinAndAbsMax() + "\n" +
                            "Sorted elements - " + Arrays.toString(calculator.descOrder()) + "\n");
                }
            }
        });
    }

    public static void window(String windowName){
        JFrame jFrame = getFrame(windowName);
    }

    private static JFrame getFrame(String title){
        MyFrame jFrame = new MyFrame(title);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 100, 500, 200);
        jFrame.setVisible(true);
        return  jFrame;
    }
}