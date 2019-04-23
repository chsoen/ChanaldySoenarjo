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

public class TakeBook implements Initializable {
    public ChoiceBox<String> studentChoice;
    public ChoiceBox<String> bookChoice;
    private DatabaseHandler handler;

    public void takeBook() {
        String studentSelected = studentChoice.getSelectionModel().getSelectedItem();
        String bookSelected = bookChoice.getSelectionModel().getSelectedItem();
        String book = "";
        String taken = "";
        ResultSet rs = handler.execQuery("SELECT STUDENTS.book, BOOKS.taken FROM STUDENTS, BOOKS WHERE STUDENTS.name = " +
                "'" + studentSelected + "'" +
                "AND BOOKS.title = " +
                "'" + bookSelected + "'");

        try {
            while (rs.next()) {
                book = rs.getString("book");
                taken = rs.getString("taken");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (book.equals("None") && taken.equals("No one") ) {
            if (handler.execAction("UPDATE STUDENTS SET book = " +
                    "'" + bookSelected + "'" +
                    "WHERE name = " +
                    "'" + studentSelected + "'")
                    &&
                    handler.execAction("UPDATE BOOKS SET taken = " +
                    "'" + studentSelected + "'" +
                    "WHERE title = " +
                    "'" + bookSelected + "'")) {
                System.out.println(studentSelected + " has taken the book \"" + bookSelected + "\"");
            }
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
            rs = handler.execQuery("SELECT title FROM BOOKS");
            while(rs.next()) {
                listBooks.add(rs.getString("title"));
            }
            studentChoice.setItems(listStudents);
            bookChoice.setItems(listBooks);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
