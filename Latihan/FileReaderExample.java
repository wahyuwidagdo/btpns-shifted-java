import java.io.FileReader;
public class FileReaderExample {
    public static void main(String args[]) throws Exception {
        FileReader fr = new FileReader("./home/flathat/werukomu.txt");
        int i;

        while((i = fr.read()) != - 1 );

        fr.close();
    }
}