package UI.Controllers;

import Networking.ClientHolder;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Controller {
    public TextField txtfldUsername;
    public ClientHolder clientHolder;

    public void login(ActionEvent actionEvent) throws IOException, InterruptedException {
        clientHolder = new ClientHolder();
        clientHolder.createClient(txtfldUsername.getText());
        loadWindow("../Layouts/Chatroom.fxml", "Chatroom");
        Stage stage = (Stage) txtfldUsername.getScene().getWindow();
        stage.close();
    }

}
