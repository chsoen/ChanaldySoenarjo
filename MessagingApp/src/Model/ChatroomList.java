package Model;

import UI.Controllers.Chatroom;

import java.util.ArrayList;

public class ChatroomList {
    public static ArrayList<Chatroom> chatroomList = new ArrayList<>();

    public static void add(Chatroom chatroom) {
        chatroomList.add(chatroom);
    }
}
