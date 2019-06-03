package UI.Controllers;

import Networking.ClientProgram;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Chatroom {
    public TextField message;
    private ClientProgram clientProgram;

    public void onEnter(ActionEvent actionEvent) {
        clientProgram.sendMessage(message.getText());
    }
}
