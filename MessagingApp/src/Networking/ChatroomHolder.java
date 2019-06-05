package Networking;

import UI.Controllers.Chatroom;

import java.util.ArrayList;

public class ChatroomHolder {
    public static ArrayList<Chatroom> chatrooms = new ArrayList<>();

    public static ArrayList<Chatroom> getChatrooms() {
        return chatrooms;
    }
}
