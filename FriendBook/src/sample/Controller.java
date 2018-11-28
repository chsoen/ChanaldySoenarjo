package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    public ListView<Friend> listFriends = new ListView<>();
    public TextField txtName;
    public TextField txtAge;
    public TextField txtGender;
    public Label Name;
    public Label Age;
    public Label Gender;

    public void createFriend(ActionEvent actionEvent) {
        Friend temp = new Friend(txtName.getText(), Integer.parseInt(txtAge.getText()), txtGender.getText());
        listFriends.getItems().add(temp);
        txtName.clear();
        txtGender.clear();
        txtAge.clear();
    }


    public void deleteFriend(ActionEvent actionEvent) {
        Friend temp = listFriends.getSelectionModel().getSelectedItem();
        listFriends.getItems().remove(temp);
    }

    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp = listFriends.getSelectionModel().getSelectedItem();
        Name.setText(temp.name);
        Age.setText(Integer.toString(temp.age));
        Gender.setText(temp.gender);
    }
}
