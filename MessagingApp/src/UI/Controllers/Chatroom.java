package UI.Controllers;

import Networking.ClientProgram;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Chatroom implements Initializable {
    public TextField message;
    public ArrayList<Label> messageList = new ArrayList<>();
    public ScrollPane chat;
    private String userName;
    private ClientProgram clientProgram;
    private final VBox messageBox = new VBox(5);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> System.out.println(userName));

    }

    public void onEnter(ActionEvent actionEvent) {
        clientProgram.sendMessage(userName, message.getText());
        message.clear();
    }

    void setUser(String user) {
        userName = user;
    }

    void setClientProgram() {
        try {
            clientProgram = new ClientProgram();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //https://stackoverflow.com/questions/41851501/how-to-design-chatbox-gui-using-javafx

    public void displayMessage(String message) {
        chat.setContent(messageBox);
        messageBox.getChildren().add(new Label(message));


    }


}
