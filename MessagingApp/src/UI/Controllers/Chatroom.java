package UI.Controllers;

import Model.ChatroomList;
import Networking.ClientProgram;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Chatroom implements Initializable {
    private final VBox messageBox = new VBox(5);
    public TextField message;
    public ScrollPane chat;
    private String userName;
    private ClientProgram clientProgram;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            System.out.println(userName);

            /*
            https://stackoverflow.com/q/26619566
            Runs ChatroomList.remove method when stage closes
             */
            Stage stage = (Stage) chat.getScene().getWindow();
            stage.setOnCloseRequest(event -> {
                ChatroomList.remove(this);

            });
        });


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

    /*
    https://stackoverflow.com/a/41851855
    Scrollpane chat sets its content to VBox messageBox and a label is created in messageBox

    https://stackoverflow.com/a/17851019
    Updates the fx using Platform.runlater method
     */
    public void displayMessage(String message) {
        Platform.runLater(() -> {
                    chat.setContent(messageBox);
                    messageBox.getChildren().add(new Label(message));
                }
        );
    }


}
