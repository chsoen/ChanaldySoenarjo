package Networking;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

public class ClientProgram {
    private static Client client;
    static String ip = "localHost";
    static boolean messageReceived = false;

    public static void runClient() throws IOException, InterruptedException {
        System.out.println("Connecting to the server...");
        client = new Client();
        client.start();
        Network.register(client);
        client.connect(5000, ip, Network.port);

        client.addListener(new Listener() {
            @Override
            public void received(Connection c, Object p) {
                if (p instanceof Network.PacketMessage) {
                    Network.PacketMessage packet = (Network.PacketMessage) p;
                    System.out.println("received a message from the host: " + packet.message);

                    messageReceived = true;
                }
            }
        });

        System.out.println("Connect! The client program is now waiting for a packet...\n");

        while (!messageReceived) {
            Thread.sleep(1000);
        }
    }
}
