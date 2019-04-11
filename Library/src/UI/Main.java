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
        handler.createTable("BOOKS",
                        "title varchar(200), \n" +
                        "author varchar(200), \n" +
                        "taken varchar(200)");
        handler.createTable("STUDENTS",
                        "name varchar(200), \n" +
                        "grade varchar(200), \n" +
                        "book varchar(200)");
        launch(args);
    }
}
