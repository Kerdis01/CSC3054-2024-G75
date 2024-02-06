package tests;

import model.User;

public class UserTest {

    public static void main(String[] args) {
        User testUser = new User("mike", "passwd", "Mike", "Smith", "07771234567");

        System.out.println(testUser);
    }
}