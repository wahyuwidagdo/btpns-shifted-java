import java.io.FileInputStream;
public class DataStreamExample {
    public static void main(String args[]) {
        try {
            FileInputStream fin = new FileInputStream("./home/flathat/namaSaya.txt");
            // Read single character
            int i = fin.read();
            System.out.print((char)i);

            fin.close();

            // Read all character
            int i = 0;
            while((i = fin.read()) != -1) {
                System.out.print((char)i);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}