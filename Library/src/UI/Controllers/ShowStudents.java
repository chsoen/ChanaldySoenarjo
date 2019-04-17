package UI.Controllers;

import Database.DatabaseHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowStudents implements Initializable {
    private ObservableList<Student> students = FXCollections.observableArrayList();
    public TableView tableStudents;
    public TableColumn nameCol;
    public TableColumn gradeCol;
    public TableColumn bookCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initiCol();
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class Student {
        private final SimpleStringProperty name;
        private final SimpleStringProperty grade;
        private final SimpleStringProperty book;

        public Student(String name, String grade, String book) {
            this.name = new SimpleStringProperty(name);
            this.grade = new SimpleStringProperty(grade);
            this.book = new SimpleStringProperty(book);
        }

        public String getName() {
            return name.get();
        }

        public String getGrade() {
            return grade.get();
        }

        public String getBook() {
            return book.get();
        }
    }


    private void initiCol() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
        bookCol.setCellValueFactory(new PropertyValueFactory<>("book"));
    }

    private void loadData() throws SQLException {
        DatabaseHandler handler = DatabaseHandler.getInstance();
        String qu = "SELECT * FROM STUDENTS";
        ResultSet rs = handler.execQuery(qu);
        while (rs.next()) {
            String name = rs.getString("name");
            String grade = rs.getString("grade");
            String book = rs.getString("book");

            students.add(new Student(name, grade, book));
        }
        tableStudents.getItems().setAll(students);
    }

}
