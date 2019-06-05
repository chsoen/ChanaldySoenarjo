package UI.Controllers;

import Networking.ClientProgram;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Chatroom implements Initializable {
    public TextField message;
    private String userName;
    private ClientProgram clientProgram;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> System.out.println(userName));
        try {
            clientProgram = new ClientProgram();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onEnter(ActionEvent actionEvent) {
        clientProgram.sendMessage(userName,message.getText());
        message.clear();
    }

    void setUser(String user) {
        userName = user;
    }
}
