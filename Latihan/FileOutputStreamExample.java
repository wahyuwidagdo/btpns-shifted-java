import java.io.FileOutputStream;
public class FileOutputStreamExample {
    public static void main(String args []) {
        try {
            FileOutputStream fout = new FileOutputStream("./home/flathat/stringToBytes.txt");
            // String s = args[0]; // untuk parameter commandline java
            String s = "Edo";
            byte b[] = s.getBytes(); //Converting string into byte array
            fout.write(b);
            // fout.write(69);
            // fout.write(68);
            // fout.write(79);
            fout.close();
            System.out.println("Sukses");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}