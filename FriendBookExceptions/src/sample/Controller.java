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

    private static class NameException extends Throwable {
        String name;

        private NameException(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            if (name.matches("[^a-zA-Z]+")) {
                return "Please use letters";
            }
            if (!name.contains(" ") && name.split(" ").length < 2) {
                return "Please type full name";
            }
            return "How could you mess that up? Wow.";
        }
    }

    private static class AgeException extends Throwable {
        int ageNum;
        String age = "";

        private AgeException(int age) {
            this.ageNum = age;
        }

        private AgeException(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            if (age.isEmpty() && ageNum < 18) {
                return "Please put an age greater than 18";
            } else {
                return "Please use numbers";
            }
        }
    }

    private static class Checker {
        private static void checkName(String name) throws NameException {
            if (name.matches("[^a-zA-Z]2+") || !name.contains(" ") && name.split(" ").length < 2) {
                throw new NameException(name);
            }
        }

        private static void checkAge(String age) throws AgeException {
            if (age.matches("[0-9]+")) {
                int numAge = Integer.parseInt(age);
                if (numAge < 18) {
                    throw new AgeException(numAge);
                }
            } else {
                throw new AgeException(age);
            }

        }
    }

    public void createFriend() {
        boolean error = false;

        try {
            String name = txtName.getText();
            Checker.checkName(name);
        } catch (NameException e) {
            txtName.setPromptText(e.toString());
            txtName.clear();
            error = true;
        }

        try {
            String age = txtAge.getText();
            Checker.checkAge(age);
        } catch (AgeException e) {
            txtAge.setPromptText(e.toString());
            txtAge.clear();
            error = true;
        }

        if (error) return;

        Friend temp = new Friend(txtName.getText(), Integer.parseInt(txtAge.getText()), txtGender.getText());
        listFriends.getItems().add(temp);
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

    public void getFiles() {
        listGroups.getItems().clear();
        for (String groupNames : Objects.requireNonNull(new File(System.getProperty("user.dir")).list())) {
            if (groupNames != null && groupNames.endsWith(".txt"))
                listGroups.getItems().add(groupNames.substring(0, groupNames.indexOf(".")));
        }
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
