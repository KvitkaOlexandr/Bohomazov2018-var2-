package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberStorageFrame extends JFrame {

    private JTextField numberField;
    private JButton calculateButton;
    private JTextArea answerArea;
    private NumberStorage storage;

    public NumberStorageFrame(String title){
        super(title);
        numberField = new JTextField("Example: 3 6 9...", 15);
        numberField.setForeground(Color.GRAY);
        numberField.addFocusListener(new MyFocusListener());
        calculateButton = new JButton("Calculate");
        answerArea = new JTextArea(10, 30);
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
        calculateButton.addActionListener(new ButtonListener());
    }

    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            String string = numberField.getText();
            if(!CmpUtils.validateString(string)){
                answerArea.setForeground(Color.RED);
                answerArea.setText("WRONG INPUT. In should be like '12 34 54 2 453...'");
            }
            else {
                answerArea.setForeground(Color.BLACK);
                int[] numbers = CmpUtils.stringToIntegers(string);
                storage = new NumberStorage(numbers);
                answerArea.setText("dividable by 3 \r\n" + storage.findDividableIntegers(3) + "\r\n" +
                        "dividable by 9 \r\n" + storage.findDividableIntegers(9));
            }
        }

    }

    private class MyFocusListener implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            if (numberField.getText().equals("Example: 3 6 9...")) {
                numberField.setText("");
                numberField.setForeground(Color.BLACK);
            }
        }
        @Override
        public void focusLost(FocusEvent e) {
            if (numberField.getText().isEmpty()) {
                numberField.setForeground(Color.GRAY);
                numberField.setText("Example: 3 6 9...");
            }
        }

    }

    public static void window(String windowName){
        JFrame jFrame = getFrame(windowName);
    }

    private static JFrame getFrame(String title){
        NumberStorageFrame jFrame = new NumberStorageFrame(title);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 100, 400, 200);
        jFrame.setVisible(true);
        return  jFrame;
    }
}
