package task3;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private JTextField aSideField;
    private JTextField bSideField;
    private JTextField cSideField;
    private JButton calculateButton;
    private JTextArea answerArea;

    public MyFrame(String title){
        super(title);
        aSideField = new JTextField(20);
        bSideField = new JTextField(20);
        calculateButton = new JButton("Calculate");
        cSideField = new JTextField(20);
        JLabel label1 = new JLabel("A side:");
        JLabel label2 = new JLabel("B side:");
        JLabel label3 = new JLabel("C side:");


        JPanel labels = new JPanel(new GridLayout(0, 2));
        labels.add(label1);
        labels.add(aSideField);
        labels.add(label2);
        labels.add(bSideField);
        labels.add(label3);
        labels.add(cSideField);
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
    }

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

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String aSideFieldText = aSideField.getText();
            String bSideFieldText = bSideField.getText();
            String cSideFieldText = cSideField.getText();

            try {
                double aSide = Double.parseDouble(aSideFieldText);
                double bSide = Double.parseDouble(bSideFieldText);
                double cSide = Double.parseDouble(cSideFieldText);
                double perimeter = PerimeterCalculator.CalculateTrianglePerimeter(aSide, bSide, cSide);
                answerArea.setText("Perimeter is " + perimeter);
            } catch (NumberFormatException numberFormatException){
                answerArea.setText("");
                JOptionPane.showMessageDialog(new JFrame(), numberFormatException.getMessage(),
                        "format exception", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException arithmeticException){
                answerArea.setText("");
                JOptionPane.showMessageDialog(new JFrame(), arithmeticException.getMessage(),
                        "arithmetic exception", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}