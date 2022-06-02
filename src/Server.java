import java.net.*;
import java.io.*;

public class Server {

private ServerSocket serverSocket;
private Socket clientSocket;
private PrintWriter out;
private BufferedReader in;
private boolean running = true;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            while (running) {
                new Connection(serverSocket.accept(), this).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Start failed!");
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while Shutdown!");
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
