package UI.Controllers;

import Database.DatabaseHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddStudent implements Initializable {
    public TextField studentName;
    public TextField studentGrade;
    private DatabaseHandler handler;

    public void addStudent() {
        String name = studentName.getText();
        String grade = studentGrade.getText();

        boolean flag = name.isEmpty() || grade.isEmpty();

        if (!flag) {
            String st = "INSERT INTO STUDENTS VALUES (" +
                    "'" + name + "'," +
                    "'" + grade + "'," +
                    "'None')";

            if (handler.execAction(st)) {
                System.out.println("Student added");
            } else {
                System.out.println("Student was not added");
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = DatabaseHandler.getInstance();
    }
}
