package lab8;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8071);
            System.out.println("initialized");
            while (true) {
                // waiting for client
                Socket socket = server. accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");
                //new tread
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
