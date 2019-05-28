package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class ServerThread extends Thread {
    private PrintStream os; // transfer
    private BufferedReader is; // reception
    private InetAddress address; // client's address
    private Calendar cal;

    public ServerThread(Socket s) throws IOException {
        os = new PrintStream(s.getOutputStream());
        is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        address = s.getInetAddress();
        cal = null;
    }

    public void run() {
        String str;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            while ((str = is.readLine()) != null) {
                if ("time".equals(str)) {
                    cal = Calendar.getInstance();
                    os.println(sdf.format(cal.getTime()));
                    System.out.println(address.getHostName() + " asked about time");
                }
            }
        } catch (IOException e) {
            System.err.println("Disconnect");
        }
    }
}