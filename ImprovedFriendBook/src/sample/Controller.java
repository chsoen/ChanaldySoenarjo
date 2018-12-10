package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;

public class Controller {
    public ListView<Friend> listFriends = new ListView<>();
    public TextField txtName;
    public TextField txtAge;
    public TextField txtGender;
    public Label Name;
    public Label Age;
    public Label Gender;
    public TextField txtNameFriendList;
    public ListView listGroups;

    public ArrayList<String> getFiles(){
        String dir = System.getProperty("user.dir");
        File mydir = new File(dir);

        File[] files = mydir.listFiles();
        ArrayList<String> temp = new ArrayList<>();

        for(File f : files){
            if(f.getName().endsWith(".txt")){
                temp.add(f.getName().substring(0, f.getName().indexOf(".")));
                System.out.println(f.getName().substring(0, f.getName().indexOf(".")));
            }
        }

        return temp;
    }

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

    public void saveListFriends(ActionEvent actionEvent)throws IOException {
        if(!txtNameFriendList.getText().equals("")) {
            FileWriter fw = new FileWriter(txtNameFriendList.getText() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Friend temp : listFriends.getItems()) {
                bw.write(temp.name + ";" + temp.age + ";" + temp.gender + ";");
                bw.newLine();
            }
            bw.close();
            txtNameFriendList.setText("");
            txtNameFriendList.setPromptText("Friend list saved!");
        } else {
            txtNameFriendList.setPromptText("Invalid name");
        }
    }


    public void loadGroup(ActionEvent actionEvent)throws IOException {
        FileReader fr = new FileReader
    }
}
