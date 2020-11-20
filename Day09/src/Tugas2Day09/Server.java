package Tugas2Day09;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Server {
    static Scanner scan = new Scanner(System.in);
    static Properties prop = new Properties();
    static Socket s;
    static  String arrData;

    public static void main(String[] args) {
        Boolean active = true;
        try {
            ReadFile();
            Properties prop = new Properties();
            InputStream input = null;
            input = new FileInputStream("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas2Day09\\config.properties");
            prop.load(input);
            ServerSocket ss = new ServerSocket(Integer.parseInt(prop.getProperty("PORT")));
            System.out.println("Waiting for Socket....");
            String reqs = "";
            while (active) {
                s = ss.accept();
                DataInputStream req = new DataInputStream(s.getInputStream());
                reqs = req.readUTF();
                System.out.println(reqs);
                DataOutputStream res = new DataOutputStream(s.getOutputStream());
                res.writeUTF(arrData);
                res.flush();
            }
        } catch (Exception e) {
            active = false;
        }
    }

    public static void ReadFile() {
        try {
            FileReader fin = new FileReader("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas2Day09\\file.txt");
            String data = "";
            int i;
            while ((i = fin.read()) !=-1) {
                data += (char)i;
            }
            String output = "";
            String[] split1 = data.split("\\n");
            JSONArray arr = new JSONArray();
            for (String string : split1) {
                JSONObject tempObj = new JSONObject();
                String[] data2 = string.split("\\,");
                Integer Fisika = Integer.parseInt(data2[1]);
                Integer Kimia = Integer.parseInt(data2[2]);
                tempObj.put("nama", data2[0]);
                tempObj.put("fisika", Fisika);
                tempObj.put("kimia", Kimia);
                String[] biologi = data2[3].split("\r");
                Integer Biologi = Integer.parseInt(biologi[0]);
                tempObj.put("biologi", Biologi);
                arr.add(tempObj);
            }
            arrData = arr.toJSONString();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
