package Networking;

import Networking.Network.ServerMessage;
import Networking.Network.UserMessage;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

public class ClientProgram {
    private static Client client;
    static String ip = "localHost";

    public ClientProgram() throws IOException {
        System.out.println("Connecting to the server...");
        client = new Client();
        client.start();
        Network.register(client);
        client.connect(5000, ip, Network.port);

        client.addListener(new Listener() {
            @Override
            public void received(Connection c, Object o) {
                if (o instanceof ServerMessage) {
                    ServerMessage packet = (ServerMessage) o;
                    System.out.println("received a text from the host: " + packet.text + "\n");

                }
                if (o instanceof UserMessage) {
                    UserMessage userMessage = (UserMessage) o;
                    System.out.println(userMessage);
                }
            }
        });

        System.out.println("Connected!\n");
    }

    public void sendMessage(String user, String message) {
        UserMessage userMessage = new UserMessage();
        userMessage.user = user;
        userMessage.text = message;
        client.sendTCP(userMessage);
    }
}
