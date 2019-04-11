package UI.Controllers;

import Database.DatabaseHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBook implements Initializable {
    public TextField bookTitle;
    public TextField bookAuthor;
    private DatabaseHandler handler;


    public void addBook() {
        String title = bookTitle.getText();
        String author = bookAuthor.getText();

        boolean flag = title.isEmpty() || author.isEmpty();

        if (!flag) {
            String st = "INSERT INTO BOOKS VALUES (" +
                    "'" + title + "'," +
                    "'" + author + "'," +
                    "'" + false + "')";

            if (handler.execAction(st)) {
                System.out.println("Book added");
            } else {
                System.out.println("Book was not added");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = DatabaseHandler.getInstance();
    }
}
