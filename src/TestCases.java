import java.io.IOException;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestCases {



    @Test
    public void testConnection() {
        Server server = new Server();
        server.start(6666);
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
    }


    @Test
    public void testMultiClient() {
        Server server = new Server();
        server.start(6666);

        Client cl1 = new Client();
        cl1.startConnection("127.0.0.1", 6666);

        Client cl2 = new Client();
        cl2.startConnection("127.0.0.1", 6666);

        cl1.sendMessage("hey");
        cl2.sendMessage("stop");



    }

}
