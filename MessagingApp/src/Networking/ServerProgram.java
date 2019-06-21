package Networking;

import DatabaseHandler.DatabaseHandler;
import Networking.Network.ServerMessage;
import Networking.Network.UserMessage;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                    try {
                        PreparedStatement ps = handler.conn.prepareStatement("INSERT INTO MESSAGES VALUES ('" +  userMessage.getUser() + ": " + userMessage.getText() + "')");
                        ps.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    server.sendToAllTCP(userMessage);
                    System.out.println(userMessage);
                }
            }

            @Override
            public void connected(Connection c) {
                System.out.println("Received a connection from " + c.getRemoteAddressTCP().getHostString());

                ArrayList<String> list = new ArrayList<>();

                try {
                    ResultSet rs = handler.execQuery("SELECT * FROM MESSAGES");
                    while (rs.next()) {
                        String message = rs.getString("MESSAGES");
                        list.add(message);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

                for (String message : list) {
                    sendMessage(c, message);
                }

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
