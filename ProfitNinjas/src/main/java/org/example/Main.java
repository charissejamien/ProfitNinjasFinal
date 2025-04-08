package org.example;

import org.example.Accounts.HomePage;

import javax.swing.*;

import static org.example.Databases.portfolioDatabase.createPortfolioBalanceTable;
import static org.example.Databases.usersDatabase.createUsersTable;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        new HomePage(frame);
        new API();

        createPortfolioBalanceTable();
        createUsersTable();
    }
}