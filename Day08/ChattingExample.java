// import java.io.*;
// import java.net.*;
// public class ChattingExample {
//     public static void main(String[] args) {
//         try {
//             ServerSocket ss = new ServerSocket(6666);
//             Socket s = ss.accept();
//             DataInputStream dis = new DataInputStream(s.getInputStream());
//             String str = (String)dis.readUTF();
//             System.out.println("Message = "+str);
//             ss.close();
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
// }

import java.io.*;
import java.net.*;
import java.util.*;
// import java.util.Properties;
public class ChattingExample {
    public static void main(String args []) {
        Scanner scan = new Scanner(System.in);
        Properties prop = new Properties();
        InputStream input = null;
        OutputStream output = null;
        try {
            output = new FileOutputStream(args[0]);
            prop.setProperty("server", "localhost");
            prop.setProperty("port", "666");
            prop.store(output, null);

            input = new FileInputStream(args[0]);
            prop.load(input);
            int port = Integer.parseInt(prop.getProperty("port"));
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String message = "";
            while(!message.equals("exit")) {
                String str = (String)dis.readUTF();
                System.out.println("Message from client : "+str);
                System.out.print("Message to client : ");
                message = scan.nextLine();
                dout.writeUTF(message);
                dout.flush();
            }
            dout.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
		    }
        }
    }
}