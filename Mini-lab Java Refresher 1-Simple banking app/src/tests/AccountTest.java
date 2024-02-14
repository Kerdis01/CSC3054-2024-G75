package tests;

import model.Account;

import java.util.Date;

public class AccountTest {

    public static void testConstructor() {
        String test_account_number = "1234567";
        String test_username_of_account_holder = "user1";
        String test_account_type = "standard";
        @SuppressWarnings("deprecation")
        Date test_account_opening_date = new Date("2001/01/01");

        Account testAccount = new Account(test_account_number, test_username_of_account_holder, test_account_type,
                test_account_opening_date);

        System.out.println("Starting assertions of test method: testUserConstructor");

        assert testAccount.getAccount_number() == test_account_number;
        assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
        assert testAccount.getAccount_type() == test_account_type;
        assert testAccount.getAccount_opening_date() == test_account_opening_date;

        System.out.println("All Java assertions in the test suite passed (none failed).");
    }

    @SuppressWarnings("deprecation")
    public static void testSetters() {
        String test_account_number = "";
        String test_username_of_account_holder = "";
        String test_account_type = "";
        Date test_account_opening_date = new Date();

        Account testAccount2 = new Account(test_account_number, test_username_of_account_holder, test_account_type,
                test_account_opening_date);

        testAccount2.setAccount_number("12345");
        testAccount2.setUsername_of_account_holder("user2");
        testAccount2.setAccount_type("standard");
        testAccount2.setAccount_opening_date(new Date("2001/01/01"));

        assert testAccount2.getAccount_number() == "12345";
        assert testAccount2.getUsername_of_account_holder() == "user2";
        assert testAccount2.getAccount_type() == "standard";
        assert testAccount2.getAccount_opening_date() == new Date("2001/01/01");

    }

    public static void main(String[] args) {
        testConstructor();
        testSetters();
    }

}