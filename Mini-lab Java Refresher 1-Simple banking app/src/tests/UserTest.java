package tests;

import model.User;

public class UserTest {

    public static void testUserConstructor() {

        //User testUser = new User("mike", "passwd", "Mike", "Smith", "07771234567");
        //System.out.println(testUser);

        String test_username = "mike";
        String test_password = "passwd";
        String test_first_name = "Mike";
        String test_last_name = "Smith";
        String test_mobile_number = "07771234567";

        User testUser = new User(test_username, test_password, test_first_name, test_last_name, test_mobile_number);

        System.out.println("Starting assertions of test method: testUserConstructor");

        if (testUser.getUsername() == test_username) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
        }

        if (testUser.getPassword() == test_password) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
        }

        if (testUser.getFirst_name() == test_first_name) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getFirstName-Passed" + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getFirstName-FAILED" + TestUtils.TEXT_COLOR_RESET);
        }

        if (testUser.getLast_name() == test_last_name) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getLastName-Passed" + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getLastName-FAILED" + TestUtils.TEXT_COLOR_RESET);
        }

        if (testUser.getMobile_number() == test_mobile_number) {
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getMobileNumber-Passed" + TestUtils.TEXT_COLOR_RESET);
        } else {
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getMobileNumber-FAILED" + TestUtils.TEXT_COLOR_RESET);
        }
    }

    public static void main(String[] args) {
        testUserConstructor();
    }
}