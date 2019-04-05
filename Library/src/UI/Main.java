package UI;

import Database.DatabaseHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Layouts/MainWindow.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        DatabaseHandler handler = DatabaseHandler.getInstance();
        handler.createTable("Books",
                "id varchar(200) primary key, \n" +
                        "title varchar(200), \n" +
                        "author varchar(200), \n" +
                        "quantity varchar(200)");
        handler.createTable("Students",
                "id varchar(200) primary key, \n" +
                        "name varchar(200), \n" +
                        "grade varchar(200), \n" +
                        "books varchar(200)");
        launch(args);
    }
}
