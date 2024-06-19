/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author mayur
 */
public class PartB1 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner in = new Scanner(System.in);
        int choice;
        int Sregno;
        String Sname, Sdob, Sadd, Sclass, Scourse, sql;
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/init", "abc", "123");
        Statement stmt = con.createStatement();
        ResultSet rs;
        do {
            System.out.println(" MENU ");
            System.out.println(".......................................");
            System.out.println("1.Add student: ");
            System.out.println("2.Delete student: ");
            System.out.println("3.Update student: ");
            System.out.println("4.Search student: ");
            System.out.println("5.Exit ");
            System.out.println(".......................................");
            System.out.println("enter the Your choice -> ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("enter the student details ");
                    System.out.println("REg no. : ");
                    in.nextLine();
                    Sregno = in.nextInt();
                    System.out.println("name:");
                    in.nextLine();
                    Sname = in.nextLine();
                    in.nextLine();
                    System.out.println("DOB[yyyy-mm-dd]: ");
                    Sdob = in.nextLine();
                    System.out.println("Adress: ");
                    Sadd = in.nextLine();
                    System.out.println("Class: ");
                    Sclass = in.nextLine();
                    System.out.println("course: ");
                    Scourse = in.nextLine();
                    sql = "INSERT INTO Studentinfo (SRegNo, SName, Sdob, SAdd, SClass, SCourse) "
                            + "VALUES (" + Sregno + ", '" + Sname + "', '" + Sdob + "', '" + Sadd + "', '" + Sclass + "', '"
                            + Scourse + "')";
                    int result = stmt.executeUpdate(sql);
                    if (result == 1) {
                        System.out.println("student details are saved ");
                    } else {
                        System.out.println("student details are not saved ");

                    }
                    break;
                case 2:
                    System.out.println("enter the student reg no. ");
                    Sregno = in.nextInt();
                    sql = "DELETE FROM ASS.STUDENTINFO WHERE SREGNO=" + Sregno;
                    int res = stmt.executeUpdate(sql);
                    if (res == 1) {
                        System.out.println("Record is deleted");
                    } else {
                        System.out.println("error ! while deleting the student record");
                    }
                    break;
                case 3:
                    System.out.println("enter the student reg no. ");
                    Sregno = in.nextInt();
                    sql = "SELECT COUNT(*) FROM ASS.STUDENTINFO WHERE SREGNO=" + Sregno;
                    rs = stmt.executeQuery(sql);
                    rs.next();
                    if (rs.getInt(1) == 1) {
                        sql = "SELECT SADD FROM ASS.STUDENTINFO WHERE SREGNO=" + Sregno;
                        rs = stmt.executeQuery(sql);
                        rs.next();
                        System.out.println(" old address is : " + rs.getString("Sadd") + " ");
                        System.out.println("enter the new address ");
                        in.nextLine(); // consume the newline character
                        String add = in.nextLine(); // take input for new address
                        sql = "UPDATE ASS.STUDENTINFO SET SADD='" + add + "'WHERE SREGNO=" + Sregno;
                        if (stmt.executeUpdate(sql) == 1) {
                            System.out.println("address is updated");
                        } else {
                            System.out.println("error! while updating the address");
                        }
                    } else {
                        System.out.println("student record is not found");
                    }
                    break;
                case 4:
                    System.out.println("enter the student reg no. ");
                    Sregno = in.nextInt();
                    sql = "SELECT * FROM ASS.STUDENTINFO WHERE SREGNO=" + Sregno;
                    rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        System.out.println("student detail...");
                        System.out.println("...........");
                        System.out.println("reg no :" + rs.getInt("Sregno"));
                        System.out.println("Name :" + rs.getString("Sname"));
                        System.out.println("DOB :" + rs.getString("Sdob"));
                        System.out.println("Address :" + rs.getString("Sadd"));
                        System.out.println("Class :" + rs.getString("Sclass"));
                        System.out.println("Course :" + rs.getString("Scourse"));
                        System.out.println("...............");
                    } else {
                        System.out.println("No student found with the given Reg No.");
                    }
                    break;
                case 5:
                    stmt.close();
                    con.close();
                    System.out.println("thank you ");
                    return;

                default:
                    System.out.println("Wrong chioce....\n Try again! ");

            }

        } while (true);

    }

}
