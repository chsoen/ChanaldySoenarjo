package sample;

import java.util.Objects;

public class Friend {
    public String name;
    public int age;
    public String gender;

    public Friend(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name;
    }
}
