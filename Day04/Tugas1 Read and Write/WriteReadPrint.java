import java.io.FileInputStream;
import java.io.FileOutputStream;
public class WriteReadPrint {
    public static void main(String args[]) {
        try {
            FileOutputStream fout = new FileOutputStream("./home/flathat/nama.txt");
            FileInputStream fin = new FileInputStream("./home/flathat/nama.txt");
            String a = args[1];
            byte b[] = a.getBytes();
            fout.write(b);
            fout.close();

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