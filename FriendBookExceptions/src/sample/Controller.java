package sample;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Objects;

public class Controller {
    public ListView<Friend> listFriends = new ListView<>();
    public TextField txtName;
    public TextField txtAge;
    public TextField txtGender;
    public Label Name;
    public Label Age;
    public Label Gender;
    public TextField txtNameFriendList;
    public ListView<String> listGroups = new ListView<>();

    private class NameException extends Throwable {
        String name = "";

        private NameException(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return ;
        }
    }

    public void getFiles() {
        listGroups.getItems().clear();
        for (String groupNames : Objects.requireNonNull(new File(System.getProperty("user.dir")).list())) {
            if (groupNames != null && groupNames.endsWith(".txt"))
                listGroups.getItems().add(groupNames.substring(0, groupNames.indexOf(".")));
        }
    }

    public void createFriend() {
        try {
            if (txtName.getText().matches("[^a-zA-Z]+") || !txtName.getText().contains(" ")) {
                throw new NameException(txtName.getText());
            }

            Friend temp = new Friend(txtName.getText(), Integer.parseInt(txtAge.getText()), txtGender.getText());
            listFriends.getItems().add(temp);
        } catch (NumberFormatException e) {
            txtAge.setPromptText("Invalid Age");
        } catch (NameException e) {
            txtName.setPromptText("Invalid Name");
        }
        txtName.clear();
        txtGender.clear();
        txtAge.clear();
    }

    public void deleteFriend() {
        Friend temp = listFriends.getSelectionModel().getSelectedItem();
        listFriends.getItems().remove(temp);
    }

    public void displayFriend() {
        Friend temp = listFriends.getSelectionModel().getSelectedItem();
        Name.setText(temp.name);
        Age.setText(Integer.toString(temp.age));
        Gender.setText(temp.gender);
    }

    public void saveListFriends() throws IOException {
        if (!txtNameFriendList.getText().equals("")) {
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


    public void loadGroup() throws IOException {
        listFriends.getItems().clear();
        FileReader fr = new FileReader(listGroups.getSelectionModel().getSelectedItem() + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(";");
            Friend temp = new Friend(fields[0], Integer.parseInt(fields[1]), fields[2]);
            listFriends.getItems().add(temp);
        }
        br.close();
    }
}
