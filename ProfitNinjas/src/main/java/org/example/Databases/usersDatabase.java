package org.example.Databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usersDatabase{

    private static final String url = "jdbc:sqlite:database.db";

    public static void createUsersTable() {
        String usersSQL = "CREATE TABLE IF NOT EXISTS Users (" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL, " +
                "password TEXT NOT NULL);";

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {
            if (connection != null) {
                statement.execute(usersSQL);
                System.out.println("User table created successfully");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Add a new User
    public static void registerUser(String username, String password) {
        String insertSQL = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //Authenticate the credentials of User
    public static boolean authenticateUser(String username, String password) {
        String query = "SELECT password FROM users WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                // Compare the stored password with the input password
                if (storedPassword.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    //Check if the username is already registered
    public static boolean isUsernameAvailable(String username) {
        String checkSQL = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement preparedStatement = connection.prepareStatement(checkSQL)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            return !resultSet.next();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
            return false;
        }
    }
}
