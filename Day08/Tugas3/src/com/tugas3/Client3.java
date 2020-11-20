package com.tugas3;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Properties;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Client3 {
    static Scanner scan = new Scanner(System.in);
    static Socket s;
    static String data = "";

    public static void main(String args []) {
        menu();
    }

    public static void menu() {
        try {
            int menu = 0;
            while(menu != 99){
                System.out.println("");
                System.out.println("======================");
                System.out.println("*********Menu*********");
                System.out.println("======================");
                System.out.println("");
                System.out.println("1. Connect Socket");
                System.out.println("2. Create FileProses.txt");
                System.out.println("3. Tampil Dilayar, Tulis Ke File, Kirim FTP (Multi Threading)");
                System.out.println("4. Download average.txt dari FTP Server");
                System.out.println("5. Close All Connection");
                System.out.println("99. Exit");
                System.out.println("");
                System.out.print("Pilih Menu [1/2/3/4/5/99] : ");
                menu = Integer.parseInt(scan.nextLine());
                switch(menu) {
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
                        download();
                    break;
                    case 5:
                        closeConnection();
                    break;
                    default:
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void connectSocket() {
        try {
            Properties prop = new Properties();
            InputStream input = null;
            input = new FileInputStream("C:\\Users\\btpnshifted\\Java\\Day08\\Tugas3\\src\\com\\tugas3\\config.properties");
            prop.load(input);
            String ip = prop.getProperty("IP");
            int port = Integer.parseInt(prop.getProperty("PORT"));
            s = new Socket(ip, port);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Request Data");
            dout.flush();
            DataInputStream din = new DataInputStream(s.getInputStream());
            data = din.readUTF();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createFile() {
        try {
            String output = "";
            String[] split1 = data.split("\\n");
            for(String string : split1) {
                String[] split2 = string.split("\\,");
                for(int i = 0; i < split2.length; i++) {
                    if(i == 0) {
                        output += "Nama : " + split2[i] + "\n";
                    } else if(i == 1) {
                        output += "Nilai Fisika : " + split2[i] + "\n";
                    } else if(i == 2) {
                        output += "Nilai Biologi : " + split2[i] + "\n";
                    } else if(i == 3) {
                        output += "Nilai Kimia : " + split2[i] + "\n";
                    }
                }
            }
            FileWriter fr = new FileWriter("C:\\Users\\btpnshifted\\Java\\Day08\\Tugas3\\src\\com\\tugas3\\FileProses.txt");
            fr.write(output);
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void multiThreading() {
        try {
            String output = "";
            String[] split1 = data.split("\\n");
            for(String string : split1) {
                String[] split2 = string.split("\\,");
                for(int i = 0; i < split2.length; i++) {
                    if (i == 0) {
                        output += "Nama : " + split2[i] + "\n";
                    } else if (i == 1) {
                        output += "Nilai Fisika : " + split2[i] + "\n";
                    } else if (i == 2) {
                        output += "Nilai Biologi : " + split2[i] + "\n";
                    } else if (i == 3) {
                        output += "Nilai Kimia : " + split2[i] + "\n";
                    }
                }
            }
            PrintToScreen thread1 = new PrintToScreen(output);
            Average thread2 = new Average(data);
            FTPUpload thread3 = new FTPUpload();
            thread1.start();
            thread2.start();
            thread3.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void download() {
        try {
            String server = "ftp.myth.co.id";
            int port = 21;
            String user = "ftpuser@myth.co.id";
            String pass = "password";

            FTPClient ftpClient = new FTPClient();
            try {
                ftpClient.connect(server, port);
                ftpClient.login(user, pass);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                String remoteFile1 = "/download/average.txt";
                File downloadFile1 = new File("C:\\Download\\average.txt");
                OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
                outputStream1.close();

                if(success) {
                    System.out.println("File has been downloaded successfully.");
                }
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                try {
                    if (ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void closeConnection() {
        try {
            s.close();
            System.out.println("Success!!!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}