package Tugas3Day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);
    static Connection conn;
    static Statement state;

    public static void main(String[] args) {
        connect(); //memanggil method untuk set koneksi ke DB
        printMenu(); //memanggil method untuk print menu program
    }

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","MySQL@31");
            state = conn.createStatement();
            System.out.println("Connected to Database");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printMenu() {
        try {
            String menu = "";
            while (!menu.equals("4")) {
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("************MENU************");
                System.out.println("============================");
                System.out.println(" ");
                System.out.println("1. Input Data");
                System.out.println("2. Edit Data");
                System.out.println("3. Delete Data");
                System.out.println("4. Exit");
                System.out.println("===============================");
                System.out.print("Pilih menu [1/2/3/4] = ");
                menu = scan.nextLine();
                System.out.println("===============================");
                System.out.println(" ");
                switch (Integer.parseInt(menu)) {
                    case 1:
                        inputData();
                        break;
                    case 2:
                        editData();
                        break;
                    case 3:
                        deleteData();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void inputData() {
        try {
            System.out.println(" ");
            System.out.println("============================");
            System.out.println("*********INPUT DATA*********");
            System.out.println("============================");
            System.out.println(" ");
            System.out.print("Fullname : ");
            String Fullname = scan.nextLine();
            System.out.print("Address : ");
            String Address = scan.nextLine();
            System.out.print("Status : ");
            String Status = scan.nextLine();
            System.out.println("Grades...");
            System.out.print("Physics : ");
            String Physics = scan.nextLine();
            System.out.print("Calculus : ");
            String Calculus = scan.nextLine();
            System.out.print("Biologi : ");
            String Biologi = scan.nextLine();
            String query = "INSERT INTO user(fullname, address, status, physics, calculus, biologi) VALUES('" +
                    Fullname + "','" +
                    Address + "','" +
                    Status + "','" +
                    Physics + "','" +
                    Calculus + "','" +
                    Biologi + "')";
            int res = state.executeUpdate(query);
            if (res == 1) {
                System.out.println("Sukses Input Data");
            } else {
                System.out.println("Gagal Input Data!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void editData() {
        allData();
        try {
            System.out.println(" ");
            System.out.println("===========================");
            System.out.println("*********EDIT DATA*********");
            System.out.println("===========================");
            System.out.println(" ");
            System.out.print("Input ID : ");
            String id = scan.nextLine();
            System.out.print("Fullname : ");
            String Fullname = scan.nextLine();
            System.out.print("Address : ");
            String Address = scan.nextLine();
            System.out.print("Status : ");
            String Status = scan.nextLine();
            System.out.println("Grades...");
            System.out.print("Physics : ");
            String Physics = scan.nextLine();
            System.out.print("Calculus : ");
            String Calculus = scan.nextLine();
            System.out.print("Biologi : ");
            String Biologi = scan.nextLine();
            String query = "UPDATE user SET " +
                    "fullname = '" + Fullname + "'," +
                    "address = '" + Address + "'," +
                    "status = '" + Status + "'," +
                    "physics = '" + Physics + "'," +
                    "calculus = '" + Calculus + "'," +
                    "biologi = '" + Biologi + "' " +
                    "WHERE id = '"+ id +"'";
            int res = state.executeUpdate(query);
            if (res == 1) {
                System.out.println("Sukses Update Data!");
            } else {
                System.out.println("Gagal Update Data!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void deleteData() {
        allData();
        try {
            System.out.println(" ");
            System.out.println("=============================");
            System.out.println("*********DELETE DATA*********");
            System.out.println("=============================");
            System.out.println(" ");
            System.out.print("Input ID : ");
            String id = scan.nextLine();
            String query = "DELETE FROM user WHERE id= '" + id + "'";
            int res = state.executeUpdate(query);
            if (res == 1) {
                System.out.println("Sukses Delete Data!");
            } else {
                System.out.println("Gagal Delete Data!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void allData() {
        try {
            String query = "SELECT * FROM user";
            ResultSet rs = state.executeQuery(query);
            String format = "| %-2d | %-15s | %-10s | %-10s | %-2d      | %-2d       | %-2d      |%n";
            System.out.printf("+----+-----------------+------------+------------+---------+----------+---------+%n");
            System.out.printf("| ID |  Fullname       |   Adress   |   Status   | Physics | Calculus | Biologi |%n");
            System.out.printf("+----+-----------------+------------+------------+---------+----------+---------+%n");
            while (rs.next()) {
                System.out.printf(format,
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }
            System.out.printf("+----+-----------------+------------+------------+---------+----------+---------+%n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
