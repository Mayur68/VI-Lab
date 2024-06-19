/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb2;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author mayur
 */
public class PartB2 {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/BankDB", "vcp", "vcp");
        Statement stmt = conn.createStatement();
        int choice;
        do {
            System.out.println("MENU");
            System.out.println("1. Add new Account Holder information");
            System.out.println("2. Amount Deposit");
            System.out.println("3. Amount Withdrawal (Maintain minimum balance 500 Rs)");
            System.out.println("4. Display all information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addNewAccountHolder(stmt, scanner);
                    break;
                case 2:
                    depositAmount(conn, scanner);
                    break;
                case 3:
                    withdrawAmount(conn, scanner);
                    break;
                case 4:
                    displayAllInformation(conn);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        conn.close();
        scanner.close();
    }

    static void addNewAccountHolder(Statement stmt, Scanner scanner) throws SQLException {
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accHolderName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        String sql = "INSERT INTO bank (accno, acname, adress, balance) " + "VALUES (" + accNo + ", '" + accHolderName + "', '" + address + "', '" + balance + "'";
        int result = stmt.executeUpdate(sql);
        if (result > 0) {
            System.out.println("New account holder information added successfully!");
        } else {
            System.out.println("Failed to add new account holder information.");
        }
    }

    static void depositAmount(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter Deposit Amount: ");
        double amount = scanner.nextDouble();
        String sql = "UPDATE bank SET balance = balance + ? WHERE accno = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setDouble(1, amount);
        preparedStatement.setInt(2, accNo);
        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("No account found with the given Account Number.");
        }
    }

    static void withdrawAmount(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Account Number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter Withdrawal Amount: ");
        double amount = scanner.nextDouble();
        String checkBalanceSql = "SELECT balance FROM bank WHERE accno = ?";
        PreparedStatement checkBalanceStmt = conn.prepareStatement(checkBalanceSql);
        checkBalanceStmt.setInt(1, accNo);
        ResultSet resultSet = checkBalanceStmt.executeQuery();
        if (resultSet.next()) {
            double balance = resultSet.getDouble("balance");
            if (balance - amount >= 500) {
                String updateSql = "UPDATE bank SET balance = balance - ? WHERE accno = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSql);
                updateStmt.setDouble(1, amount);
                updateStmt.setInt(2, accNo);
                int rowsUpdated = updateStmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Amount withdrawn successfully!");
                } else {
                    System.out.println("Failed to withdraw amount.");
                }
            } else {
                System.out.println("Insufficient balance! Minimum balance of 500 Rs should be maintained.");
            }
        } else {
            System.out.println("No account found with the given Account Number.");
        }
    }

    static void displayAllInformation(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM bank";
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("Account Number: " + resultSet.getInt("accno"));
            System.out.println("Account Name: " + resultSet.getString("acname"));
            System.out.println("Address: " + resultSet.getString("adress"));
            System.out.println("Balance: " + resultSet.getDouble("balance"));
            System.out.println("-----------------------------");
        }
    }
}
