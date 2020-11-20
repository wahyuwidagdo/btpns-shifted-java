package Tugas2Day09;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    static Scanner scan = new Scanner(System.in);
    static Socket s;
    static String data;

    public static void main(String[] args) {
        menu();
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
                System.out.println("1. Connect Socket");
                System.out.println("2. Create FileProses.txt");
                System.out.println("3. Tampil Dilayar, Kirim File JSON via FTP (Multi Threading)");
                System.out.println("4. Close All Connection");
                System.out.println("99. Exit");
                System.out.println("===============================");
                System.out.print("Pilih menu [1/2/3/4] = ");
                menu = Integer.parseInt(scan.nextLine());
                System.out.println("===============================");
                System.out.println(" ");
                switch (menu) {
                    case 1:
                        connectSocket();
                    break;
                    case 2:
                        createFile();
                    break;
                    case 3:
                        multiThreading();
                    break;
                    case 4:
                        closeConnection();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void connectSocket() {
        try {
            if (s == null || s.isClosed()) {
                Properties prop = new Properties();
                InputStream input = null;
                input = new FileInputStream("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas2Day09\\config.properties");
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
            } else {
                System.out.println("Already Connected");
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void createFile() {
        try {
            String output = "";
            JSONArray arr = (JSONArray) JSONValue.parse(data);
            for (int i = 0; i < arr.size(); i++) {
                JSONObject objData = (JSONObject) arr.get(i);
                output += "Nama : " + objData.get("nama") + "\n";
                output += "Nilai Fisika : " + objData.get("fisika") + "\n";
                output += "Nilai Kimia : " + objData.get("kimia") + "\n";
                output += "Nilai Biologi : " + objData.get("biologi") + "\n\n";
//                System.out.print(objData);
            }
            FileWriter fr = new FileWriter("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas2Day09\\FileProses.txt");
            fr.write(output);
            fr.flush();
            fr.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    /*Method multi threading dengan 3 thread
        1. thread1 = thread print data ke layar (FileProses.txt);
        2. thread2 = thread mencari nilai rata2
        3. thread3 = thread Upload FileProses.txt ke FTP Server
     */
    public static void multiThreading() {
        try {
            String output = "";
            JSONArray arr = (JSONArray) JSONValue.parse(data);
            for (int i = 0; i < arr.size(); i++) {
                JSONObject objData = (JSONObject) arr.get(i);
                output += "Nama : " + objData.get("nama") + "\n";
                output += "Nilai Fisika : " + objData.get("fisika") + "\n";
                output += "Nilai Kimia : " + objData.get("kimia") + "\n";
                output += "Nilai Biologi : " + objData.get("biologi") + "\n\n";
//                System.out.print(objData);
            }
            PrintToScreen thread1 = new PrintToScreen(output);
            FTPUpload thread2 = new FTPUpload(data);
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void closeConnection() {
        try {
            if (!s.isClosed()) {
                s.close();
                System.out.println("Disconnected from server!");
            } else {
                System.out.println("You Are Not Connected Yet");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
