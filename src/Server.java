import java.net.*;
import java.io.*;

public class Server {

private ServerSocket serverSocket;
private Socket clientSocket;
private PrintWriter out;
private BufferedReader in;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
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

    public static void main(String[] args) {
        Server server = new Server();
        server.start(6666);
    }


}
