import java.io.IOException;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class TestCases {

    @Test
    public void testConnection() throws IOException {
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);
        String resp = client.sendMessage("hello server");
        assertEquals("hello client", resp);
    }


}
