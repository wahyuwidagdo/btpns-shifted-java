import java.io.*;
import java.net.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.Properties;
public class Server2 {
    static Scanner scan = new Scanner(System.in);
    static Properties prop = new Properties();
    // static InputStream input = null;
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
                // Properties prop = new Properties();
                OutputStream output = null;
                int socket = 4444;
                output = new FileOutputStream("config.properties");
                prop.setProperty("IP", "localhost");
                prop.setProperty("PORT", String.valueOf(socket));
                prop.store(output, null);
                ServerSocket ss = new ServerSocket(socket);
                System.out.println("Loading socket....");
                Socket s = ss.accept();
                System.out.println("Loading data....");
                String data = "";
                while(!data.equals("exit")) {
                    DataInputStream din = new DataInputStream(s.getInputStream());
                    data = (String)din.readUTF();
                    String[] data1 = data.split("\\n");
                    for (String string : data1) {
                        String[] data2 = string.split("\\,");
                        System.out.println(String.join("\n", "Nama : " + data2[0], "Nilai Fisika : " + data2[1], "Nilai Biologi : " + data2[2], "Nilai Kimia : " + data2[3]));
                    }
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    dout.writeUTF("Processing Data is Done");
                    dout.flush();
                }
            } else {
                System.out.println("Wrong Username and Password FORMAT");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}