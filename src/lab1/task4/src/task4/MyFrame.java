package task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {

    private JTextField carField;
    private JTextField costField;
    private JButton calculateButton;
    private JTextArea answerArea;
    private Payment payment;

    public MyFrame(String title){
        super(title);
        carField = new JTextField(15);
        costField = new JTextField(15);
        calculateButton = new JButton("Calculate");
        answerArea = new JTextArea(10, 30);
        JLabel label1 = new JLabel("Car's name:");
        JLabel label2 = new JLabel("Car's cost:");
        JPanel labels = new JPanel(new GridLayout(0, 2));
        labels.add(label1);
        labels.add(carField);
        labels.add(label2);
        labels.add(costField);
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
        calculateButton.addActionListener(new ButtonListener());
        payment = new Payment();
    }

    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            try{
                payment.addItem(carField.getText(), Double.parseDouble(costField.getText()));
                answerArea.setText("\nitems:\n" + payment.getAllItems());
                answerArea.insert("total cost " + payment.getTotalCost(), 0);
            }
            catch (Exception ex){
                System.out.println(ex);
                answerArea.setText("Validate input");
            }
        }

    }

    public static void window(String windowName){
        JFrame jFrame = getFrame(windowName);
    }

    private static JFrame getFrame(String title){
        MyFrame jFrame = new MyFrame(title);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 220, 500, 440);
        jFrame.setVisible(true);
        return  jFrame;
    }
}
