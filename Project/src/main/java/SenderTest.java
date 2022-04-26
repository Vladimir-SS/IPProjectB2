import Connectivity.Peer;

import java.io.IOException;
import java.net.URL;

public class SenderTest {

    public static void main(String[] args) {
        try {
            System.out.println("Making Peer...");
            Peer peer = new Peer(7337);
            var localIpList = peer.getDevices();
            System.out.println(localIpList);
            System.out.println("Connecting...");
            peer.connectDevice(4,4444);
            System.out.println("Sending...");
            URL resource = ReceiverTest.class.getClassLoader().getResource("message.txt");
            peer.get(0).sendFile(resource.getPath());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
