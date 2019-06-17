package Networking;

import DatabaseHandler.DatabaseHandler;
import Networking.Network.ServerMessage;
import Networking.Network.UserMessage;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

public class ServerProgram {
    private static Server server;

    public static void main(String[] args) throws IOException {
        DatabaseHandler handler = DatabaseHandler.getInstance();
        handler.createTable();

        System.out.println("Creating Server");
        server = new Server();
        server.bind(Network.port);
        server.start();
        Network.register(server);

        server.addListener(new Listener() {
            @Override
            public void disconnected(Connection connection) {

            }

            @Override
            public void received(Connection connection, Object o) {
                if (o instanceof UserMessage) {
                    UserMessage userMessage = (UserMessage) o;
                    handler.execAction("INSERT INTO MESSAGES (MESSAGES)\n" +
                            "VALUES(" + userMessage.getUser() + ": " + userMessage.getText() +
                            ")");
                    server.sendToAllTCP(userMessage);
                    System.out.println(userMessage);
                }
            }

            @Override
            public void connected(Connection c) {
                System.out.println("Received a connection from " + c.getRemoteAddressTCP().getHostString());
                sendMessage(c, "Welcome to the Chatroom!");
            }
        });

        System.out.println("Server is operational!");
    }

    private static void sendMessage(Connection c, String message) {
        ServerMessage serverMessage = new ServerMessage();
        serverMessage.message = message;
        c.sendTCP(serverMessage);
    }
}
