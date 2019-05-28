package lab8;

import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        BufferedReader br = null;
        try{
            //connection
            socket = new Socket(InetAddress.getLocalHost(), 8071);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ClientFrame.window("lab8", br, ps);
            while(true){}
        } catch (UnknownHostException e) {
            System. err.println("address unavailable: " + e);
        } catch (IOException e) {
            System. err.println("IO tread error: " + e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

