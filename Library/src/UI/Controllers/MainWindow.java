package UI.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    public TableView tableStudent;
    public TableView tableBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("MainWindow initialized");
    }

    private void loadWindow(String location, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddStudentWindow() {
        loadWindow("../Layouts/AddStudent.fxml", "AddStudent");
    }

    public void showAddBookWindow() {
        loadWindow("../Layouts/AddBook.fxml", "AddBook");
    }
}
