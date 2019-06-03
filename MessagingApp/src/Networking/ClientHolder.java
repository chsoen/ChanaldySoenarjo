package Networking;

import java.io.IOException;
import java.util.ArrayList;

public class ClientHolder {
    public static ArrayList<ClientProgram> clients;

    public ClientHolder() {
        clients = new ArrayList<>();
    }

    public static void createClient(String username) throws IOException, InterruptedException {
        clients.add(new ClientProgram(username));
    }

    public static ClientProgram getClient(String username) throws IOException, InterruptedException {
        return new ClientProgram(username);
    }
}
