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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Layouts/Chatroom.fxml"));
            Parent parent = loader.load();
            Chatroom chatroom = loader.getController();
            chatroom.setClientProgram();
            chatroom.setUser(txtfldUsername.getText());


            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Chatroom");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) txtfldUsername.getScene().getWindow();
        stage.close();
    }

}
