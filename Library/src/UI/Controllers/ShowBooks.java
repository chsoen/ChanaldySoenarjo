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

public class ShowBooks implements Initializable {
    private ObservableList<Student> books = FXCollections.observableArrayList();
    public TableView tableBooks;
    public TableColumn titleCol;
    public TableColumn authorCol;
    public TableColumn takenCol;

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
        private final SimpleStringProperty title;
        private final SimpleStringProperty author;
        private final SimpleStringProperty taken;

        public Student(String title, String author, String taken) {
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


    private void initiCol() {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        takenCol.setCellValueFactory(new PropertyValueFactory<>("taken"));
    }

    private void loadData() throws SQLException {
        DatabaseHandler handler = DatabaseHandler.getInstance();
        String qu = "SELECT * FROM BOOKS";
        ResultSet rs = handler.execQuery(qu);
        while (rs.next()) {
            String title = rs.getString("title");
            String author = rs.getString("author");
            String taken = rs.getString("taken");

            books.add(new Student(title, author, taken));
        }
        tableBooks.getItems().setAll(books);
    }

}
