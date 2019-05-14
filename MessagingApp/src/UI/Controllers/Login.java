package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class Login extends Controller {
    public TextField txtfldUsername;

    public void login(ActionEvent actionEvent) {
        loadWindow("../Layouts/Chatroom.fxml", "Chatroom");

    }
}
