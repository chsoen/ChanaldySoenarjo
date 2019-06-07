package UI.Controllers;

import Networking.ClientProgram;
import Networking.Network;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Chatroom implements Initializable {
    public TextField message;
    public static ListView<String> messagesList;
    public ObservableList<String> messages = FXCollections.observableArrayList();
    private String userName;
    private ClientProgram clientProgram;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> System.out.println(userName));
        messagesList.setItems(messages);
    }

    public void onEnter(ActionEvent actionEvent) {
        clientProgram.sendMessage(userName,message.getText());
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

    public static void displayMessage(Network.UserMessage userMessage) {
        messagesList.getItems().add(String.valueOf(userMessage));
        System.out.println("------------Messages-----------");
        for (String m : messagesList.getItems()) {
            System.out.println(m);
        }
    }
}
