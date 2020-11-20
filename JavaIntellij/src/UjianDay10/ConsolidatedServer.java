package UjianDay10;

import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsolidatedServer {
    static Scanner scan = new Scanner(System.in);
    static Socket s;
    static Connection conn;
    static Statement statement;

    public static void main(String[] args) {
        try {
            System.out.println(" ");
            System.out.println("===========================");
            System.out.println("***********LOGIN***********");
            System.out.println("===========================");
            System.out.println(" ");
            System.out.print("Username : ");
            String username = scan.nextLine();
            System.out.print("Password : ");
            String password = scan.nextLine();
            // Validasi menggunakan regex
            Boolean usernameRegex = Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", username);
            Boolean passwordRegex = Pattern.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", password);
            if(usernameRegex && passwordRegex) {
                menu();
            } else {
                System.out.println("Masukan username dengan format seperti email. ex : sayaganteng@gantengbanget.com");
                System.out.println(("Masukan format password dengan benar. Ada uppercase, lowecase, angka, dan spesial karakter ex : AkuG@t3ngB4ngeT$"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        menu();
    }

    public static void menu() {
        try {
            int menu = 0;
            while (menu != 99) {
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("************MENU************");
                System.out.println("============================");
                System.out.println(" ");
                System.out.println("1. Start Socket and Client DB");
                System.out.println("2. Start FTP and DB Connection");
                System.out.println("3. Get Data from FTP Server");
                System.out.println("4. Send Data to DB");
                System.out.println("5. Input, Edit, and Delete Data from DB");
                System.out.println("6. Send Report to FTP Server");
                System.out.println("7. Exit - Close All Connection");
                System.out.println("===============================");
                System.out.print("Pilih menu [1/2/3/4/5/6/7] = ");
                menu = Integer.parseInt(scan.nextLine());
                System.out.println("===============================");
                System.out.println(" ");
                switch (menu) {
                    case 1:
                        startSocketClientDB();
                    break;
                    case 2:
                        startConnectionFTPDB();
                    break;
                    case 3:
                        getDataFTP();
                    break;
                    case 4:
                        sendDataToDB();
                    break;
                    case 5:
                        crudDataToDB();
                    break;
                    case 6:
                        sendReportToFTP();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void startSocketClientDB() {

    }

    public static void startConnectionFTPDB() {

    }

    public static void getDataFTP() {

    }

    public static void sendDataToDB() {

    }

    public static void crudDataToDB() {
        try {
            String menu = "";
            while (!menu.equals("4")) {
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("************CRUD************");
                System.out.println("============================");
                System.out.println(" ");
                System.out.println("1. Input Data");
                System.out.println("2. Edit Data");
                System.out.println("3. Delete Data");
                System.out.println("4. Back");
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

    private static void inputData() {
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
            int res = statement.executeUpdate(query);
            if (res == 1) {
                System.out.println("Sukses Input Data");
            } else {
                System.out.println("Gagal Input Data!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void editData() {
        listData();
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
            int res = statement.executeUpdate(query);
            if (res == 1) {
                System.out.println("Sukses Update Data!");
            } else {
                System.out.println("Gagal Update Data!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void deleteData() {
        listData();
        try {
            System.out.println(" ");
            System.out.println("=============================");
            System.out.println("*********DELETE DATA*********");
            System.out.println("=============================");
            System.out.println(" ");
            System.out.print("Input ID : ");
            String id = scan.nextLine();
            String query = "DELETE FROM user WHERE id= '" + id + "'";
            int res = statement.executeUpdate(query);
            if (res == 1) {
                System.out.println("Sukses Delete Data!");
            } else {
                System.out.println("Gagal Delete Data!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void listData() {
        try {
            String query = "SELECT * FROM user";
            ResultSet rs = statement.executeQuery(query);
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

    public static void sendReportToFTP() {

    }
}
