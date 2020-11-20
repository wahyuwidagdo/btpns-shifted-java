import java.io.*;
import java.net.*;
import java.util.*;
public class ClientExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(args[0]);
            prop.load(input);
            int port = Integer.parseInt(prop.getProperty("port"));
            String host = prop.getProperty("server");
            Socket s = new Socket(host, port);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            String message = "";
            while(!message.equals("exit")) {
                System.out.print("Message to server : ");
                message = scan.nextLine();
                dout.writeUTF(message);
                dout.flush();
                String str = (String)din.readUTF();
                System.out.println("New message from server : "+str);
            }
            // dout.writeUTF("Exit");
            // dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}