package UI.Controllers;

import Networking.ClientProgram;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Login extends Controller {
    public TextField txtfldUsername;

    public void login(ActionEvent actionEvent) throws IOException, InterruptedException {
        loadWindow("../Layouts/Chatroom.fxml", "Chatroom");
        ClientProgram.runClient();
    }
}
