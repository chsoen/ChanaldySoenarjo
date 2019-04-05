package UI.Controllers;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBook implements Initializable {
    public TextField bookTitle;
    public TextField bookAuthor;
    public TextField bookQuantity;
    public DatabaseHandler handler;


    public void addBook(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = new DatabaseHandler();
    }
}
