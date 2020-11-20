import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.Properties;
public class Client2 {
    static Scanner scan = new Scanner(System.in);
    static Properties prop = new Properties();
    static InputStream input = null;
    static Socket s;
    public static void main(String args []) {
        try {
            // Printout input login
            System.out.print("Username : ");
            String username = scan.nextLine();
            System.out.print("Password : ");
            String password = scan.nextLine();
            // Validasi menggunakan regex
            Boolean usernameRegex = Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", username);
            Boolean passwordRegex = Pattern.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", password);
            if(usernameRegex && passwordRegex) {
                menu();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void menu() {
        String menu = "0";
        try {
            while(!menu.equals("4")) {
                System.out.println("");
                System.out.println("======================");
                System.out.println("*********Menu*********");
                System.out.println("======================");
                System.out.println("");
                System.out.println("1. Connect Socket");
                System.out.println("2. Send Data to Server");
                System.out.println("3. Close Socket");
                System.out.println("4. Exit");
                System.out.println("");
                System.out.print("Pilih Menu [1/2/3/4] : ");
                menu = scan.nextLine();
                switch(Integer.parseInt(menu)) {
                    case 1:
                        connectToSocket();
                    break;
                    case 2:
                        sendData();
                    break;
                    case 3:
                        closeSocket();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void connectToSocket() {
        try {
            // Properties prop = new Properties();
            input = new FileInputStream("config.properties");
            prop.load(input);
            String ip = prop.getProperty("IP");
            int port = Integer.parseInt(prop.getProperty("PORT"));
            s = new Socket(ip, port);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void sendData() {
        try {
            FileReader fr = new FileReader(".\\data.txt");
            int i;
            String data = "";
            while((i = fr.read()) !=-1) {
                data += (char)i;
            }
            fr.close();
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(data);
            dout.flush();
            DataInputStream din = new DataInputStream(s.getInputStream());
            String res = din.readUTF();
            System.out.println(res);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void closeSocket() {
        try {
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}