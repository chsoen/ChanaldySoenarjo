package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Login {
    public TextField txtfldUsername;

    public void login(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Layouts/Chatroom.fxml"));
        Parent parent = null;

        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Chatroom chatroom = loader.getController();

        try {
            if (chatroom.setClientProgram()) {
                loadChatroom(parent, chatroom);
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.txtfldUsername.setText("Login failure.");
        }
    }

    private void loadChatroom(Parent parent, Chatroom chatroom) {
        chatroom.setUser(txtfldUsername.getText());

        Stage stage = (Stage) txtfldUsername.getScene().getWindow();
        stage.close();

        stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Chatroom");
        stage.setScene(new Scene(parent));
        stage.show();
    }

}
