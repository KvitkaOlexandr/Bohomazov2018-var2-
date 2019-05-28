package lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.UnknownHostException;

public class ClientFrame extends JFrame {

    private JButton button;
    private JTextArea answerArea;
    private BufferedReader br;
    private PrintStream ps;

    public ClientFrame(String title, BufferedReader br, PrintStream ps){
        super(title);
        this.br = br;
        this.ps = ps;
        button = new JButton("Get time");
        answerArea = new JTextArea(1,10);
        JPanel panel1 = new JPanel();
        panel1.add(button);
        add(panel1, BorderLayout.CENTER);
        JPanel panel2 = new JPanel();
        panel2.add(answerArea);
        add(panel2, BorderLayout.PAGE_END);
        button.addActionListener(new ButtonListener());
    }

    public static void window(String windowName, BufferedReader br, PrintStream ps){
        JFrame jFrame = getFrame(windowName, br, ps);
    }

    private static JFrame getFrame(String title, BufferedReader br, PrintStream ps){
        ClientFrame jFrame = new ClientFrame(title, br, ps);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 100, dimension.height / 2 - 50, 200, 100);
        jFrame.setVisible(true);
        return  jFrame;
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                ps.println("time");
                String time = br.readLine();
                System.out.println(time);
                answerArea.setText(time);
            } catch (UnknownHostException ex) {
                System. err.println("address unavailable: " + ex);
            } catch (IOException ex) {
                System.err.println("IO tread error: " + ex);
            }
        }

    }
}