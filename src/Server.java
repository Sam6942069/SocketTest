import java.net.*;
import java.io.*;

public class Server {

private ServerSocket serverSocket;
private Socket clientSocket;
private PrintWriter out;
private BufferedReader in;

    public void start(int port) {
        String greeting = null;
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            greeting = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Start failed!");
        }
        if("hello server".equals(greeting)) {
                out.println("hello client");
            }
            else {
                out.println("unrecognised greeting");
            }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(6666);
    }


}
