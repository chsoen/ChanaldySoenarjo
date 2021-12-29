package Networking;

import Model.ChatroomList;
import Networking.Network.ServerMessage;
import Networking.Network.UserMessage;
import UI.Controllers.Chatroom;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

public class ClientProgram {
    private static Client client;
    static String ip = "25.18.134.239";

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
                    ServerMessage serverMessage = (ServerMessage) o;
                    for (Chatroom chatroom : ChatroomList.chatroomList){
                        chatroom.displayMessage(String.valueOf(serverMessage));
                    }
                    System.out.println(serverMessage.message + "\n");

                }
                if (o instanceof UserMessage) {
                    UserMessage userMessage = (UserMessage) o;
                    for (Chatroom chatroom : ChatroomList.chatroomList){
                        chatroom.displayMessage(String.valueOf(userMessage));
                    }

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
