package UI.Controllers;

import Database.DatabaseHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {
    private ObservableList<Student> students = FXCollections.observableArrayList();
    public TableView<Student> tableStudents;
    public TableColumn<Object, Object> nameCol;
    public TableColumn<Object, Object> gradeCol;
    public TableColumn<Object, Object> bookCol;

    private ObservableList<Book> books = FXCollections.observableArrayList();
    public TableView<Book> tableBooks;
    public TableColumn<Object, Object> titleCol;
    public TableColumn<Object, Object> authorCol;
    public TableColumn<Object, Object> takenCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("MainWindow initialized");
        initiCol();
        try {
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadWindow(String location, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
            stage.setOnCloseRequest(event -> {
                try {
                    loadData();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Book {
        private final SimpleStringProperty title;
        private final SimpleStringProperty author;
        private final SimpleStringProperty taken;

        public Book(String title, String author, String taken) {
            this.title = new SimpleStringProperty(title);
            this.author = new SimpleStringProperty(author);
            this.taken = new SimpleStringProperty(taken);
        }

        public String getTitle() {
            return title.get();
        }

        public String getAuthor() {
            return author.get();
        }

        public String getTaken() {
            return taken.get();
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

        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        takenCol.setCellValueFactory(new PropertyValueFactory<>("taken"));
    }

    private void loadData() throws SQLException {
        students.clear();
        books.clear();
        tableStudents.getItems().clear();
        tableBooks.getItems().clear();
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

        qu = "SELECT * FROM BOOKS";
        rs = handler.execQuery(qu);
        while (rs.next()) {
            String title = rs.getString("title");
            String author = rs.getString("author");
            String taken = rs.getString("taken");

            books.add(new Book(title, author, taken));
        }
        tableBooks.getItems().setAll(books);
    }

    public void showAddStudentWindow() {
        loadWindow("../Layouts/AddStudent.fxml", "AddStudent");
    }

    public void showAddBookWindow() {
        loadWindow("../Layouts/AddBook.fxml", "AddBook");
    }

    public void showTakeBookWindow() {
        loadWindow("../Layouts/TakeBook.fxml", "TakeBook");
    }

    public void showReturnBookWindow() {
        loadWindow("../Layouts/ReturnBook.fxml", "ReturnBook");
    }
}
