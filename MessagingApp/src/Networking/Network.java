package Networking;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
    public static final int port = 27960;

    public static void register(EndPoint endPoint) {
        Kryo kryo = endPoint.getKryo();
        kryo.register(ServerMessage.class);
        kryo.register(UserMessage.class);
    }

    public static class ServerMessage {
        String text;
    }

    public static class UserMessage {
        String user;
        String text;

        @Override
        public String toString() {
            return user + ": " + text;
        }
    }
}