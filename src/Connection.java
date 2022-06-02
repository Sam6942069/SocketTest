import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection extends Thread{
    
    private Socket clientSocket;
    private Server server;
    private PrintWriter out;
    private BufferedReader in;

    public Connection(Socket socket, Server server) {
        this.clientSocket = socket;
        this.server = server;
        try {
            running();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't run client!");
        }
    }

    public void running() throws IOException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String input;
        while ((input = in.readLine()) != null) {
            if ("stop".equals(input)) {
                server.setRunning(false);
                break;
            }
            if ("hello".equals(input)) {
                out.println("zhelloolefleflelf");
            }
            else out.println(input);
        }

        stopClient();

    }

    public void stopClient() {
        System.out.println("Client down!");
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while shutting down client!");
        }
    }

}
