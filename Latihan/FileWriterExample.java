import java.io.FileWriter;
public class FileWriterExample {
    public static void main(String args[]) {
        try {
            FileWriter fw = new FileWriter("./home/flathat/werukomu.txt");
            fw.write("Welcome Mamen");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Sukses. . . .");
    }
}