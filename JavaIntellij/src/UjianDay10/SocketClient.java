package UjianDay10;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class SocketClient {
    static Scanner scan = new Scanner(System.in);
    static Socket s;
    static String data;

    public static void main(String[] args) {
        try {
                Properties prop = new Properties();
                InputStream input = null;
                input = new FileInputStream("C:\\Users\\btpnshifted\\Java\\JavaIntellij\\src\\UjianDay10\\config.properties");
                prop.load(input);
                String ip = prop.getProperty("IP");
                int port = Integer.parseInt(prop.getProperty("PORT"));
                s = new Socket(ip, port);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                dout.writeUTF("Request Data");
                dout.flush();
                DataInputStream din = new DataInputStream(s.getInputStream());
                data = din.readUTF();
                System.out.println(data);
                System.out.println("Connected");
                if (s != null) {
                    readFile();
                }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void readFile() {
        try {
            FileReader fin = new FileReader("C:\\Users\\btpnshifted\\Java\\JavaIntellij\\src\\UjianDay10\\mahasiswa2_edo");
            String data = "";
            int i;
            while ((i = fin.read()) !=-1) {
                data += (char)i;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
