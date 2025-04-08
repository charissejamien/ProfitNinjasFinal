package org.example.Databases;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class portfolioDatabase {

    private static final String url = "jdbc:sqlite:database.db";

    // Create Portfolio table with balance and timestamp
    public static void createPortfolioBalanceTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Portfolio ("
                + "balanceId INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "availableBalance FLOAT, "
                + "lastUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

        try (Connection connection = getConnection(url);
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table Portfolio successfully created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a new balance record
    public static void addUSDT(float usdtAmount) {
        String insertSQL = "INSERT INTO Portfolio (availableBalance) VALUES (?)";

        try (Connection connection = getConnection(url);
             PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setFloat(1, usdtAmount);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("USDT added successfully!");
            } else {
                System.out.println("Failed to add USDT.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get total balance by summing all records
    public static float getTotalBalance() {
        String selectSQL = "SELECT SUM(availableBalance) AS totalBalance FROM Portfolio";

        try (Connection connection = getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            if (resultSet.next()) {
                return resultSet.getFloat("totalBalance");
            } else {
                return 0.0f;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    // Get timestamp of the latest update
    public static Timestamp getLastUpdated() {
        String selectSQL = "SELECT lastUpdated FROM Portfolio ORDER BY lastUpdated DESC LIMIT 1";

        try (Connection connection = getConnection(url);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {

            if (resultSet.next()) {
                return resultSet.getTimestamp("lastUpdated");
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}