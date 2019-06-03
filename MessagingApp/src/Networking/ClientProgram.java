package Networking;

import Networking.Network.PacketMessage;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

public class ClientProgram {
    private static Client client;
    String username;
    static String ip = "localHost";
    static boolean messageReceived = false;

    public ClientProgram(String username) throws IOException, InterruptedException {
        System.out.println("Connecting to the server...");
        this.username = username;
        client = new Client();
        client.start();
        Network.register(client);
        client.connect(5000, ip, Network.port);

        client.addListener(new Listener() {
            @Override
            public void received(Connection c, Object o) {
                if (o instanceof PacketMessage) {
                    PacketMessage packet = (PacketMessage) o;
                    System.out.println("received a text from the host: " + packet.text);

                    messageReceived = true;
                }
            }
        });

        System.out.println("Connect! The client program is now waiting for a packet...\n");

        while (!messageReceived) {
            Thread.sleep(1000);
        }
    }

    public void sendMessage(String message) {
        PacketMessage packetMessage = new PacketMessage();
        packetMessage.text = username + message;
        client.sendTCP(packetMessage);
    }
}
