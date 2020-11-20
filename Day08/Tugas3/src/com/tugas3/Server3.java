/**Dokumentasi untuk server
- Class server ini dijalankan melalui terminal, dengan java commandline/argument. ex : java Server3 config.properties file.txt
- Pastikan file config.properties dan file.txt sudah ada agar program dapat dijalankan dengan benar.
- Alur program ini ialah :
    - Jalankan server, dan server akan menset property IP dan PORT ke config.properties, lalu server akan membaca file.txt dan di convert ke string
    - Jalankan client, lalu pilih menu connect socket agar server dan client terkoneksi
    - Jika sudah terhubung client dapat melakukan beberapa request sesuai dengan menu yang ada di client
    - Server akan merespon request dari client sesuai dengan menu yang dipilih
 */

import java.io.*;
import java.net.*;
import java.io.FileOutputStream;
import java.util.Properties;

public class Server3 {
    static String data = "";
    static Socket s;
    
    public static void main(String args []) {
        Boolean aktif = true;
        try {
            connect(args[0], 4000);
            ReadFile(args[1]);
            String data = "";
            while (aktif) {
                DataInputStream req = new DataInputStream(s.getInputStream());
                data = req.readUTF();
                System.out.println(data);
                DataOutputStream res = new DataOutputStream(s.getOutputStream());
                res.writeUTF(data);
                res.flush();
            }
        } catch (Exception e) {
            aktif = false;
        }
    }

    public static void connect(String config, int port) {
        try {
            Properties prop = new Properties();
            OutputStream output = null;
            output = new FileOutputStream(config);
            prop.setProperty("IP", "localhost");
            prop.setProperty("PORT", String.valueOf(port));
            prop.store(output, null);
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Waiting for Socket....");
            s = ss.accept();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void ReadFile(String path) {
        try {
            FileReader fin = new FileReader(path);
            int i;
            while((i = fin.read()) !=-1) {
                data += (char)i;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}