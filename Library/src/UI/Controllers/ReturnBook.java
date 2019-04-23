package UI.Controllers;

import Database.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReturnBook implements Initializable {
    public ChoiceBox<String> studentChoice;
    private DatabaseHandler handler;

    public void returnBook(ActionEvent actionEvent) {
        String studentSelected = studentChoice.getSelectionModel().getSelectedItem();
        if (handler.execAction("UPDATE STUDENTS SET book = " +
                "'None'" +
                "WHERE name = " +
                "'" + studentSelected + "'")
                &&
                handler.execAction("UPDATE BOOKS SET taken = " +
                "'No one'" +
                "WHERE taken = " +
                "'" + studentSelected + "'")) {
            System.out.println(studentSelected + " has returned their book");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)  {
        handler = DatabaseHandler.getInstance();
        ObservableList<String> listStudents = FXCollections.observableArrayList();
        ObservableList<String> listBooks = FXCollections.observableArrayList();
        try {
            ResultSet rs = handler.execQuery("SELECT name FROM STUDENTS");
            while (rs.next()) {
                listStudents.add(rs.getString("name"));
            }
            studentChoice.setItems(listStudents);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
