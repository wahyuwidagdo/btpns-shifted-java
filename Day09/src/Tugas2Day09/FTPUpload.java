package Tugas2Day09;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import javax.imageio.IIOException;
import java.io.*;
import java.net.SocketException;

public class FTPUpload extends Thread {
    static String data;

    public void run() {
        String server = "ftp.myth.co.id";
        int port = 21;
        String user = "ftpuser@myth.co.id";
        String pass = "password";

        FTPClient ftpClient = new FTPClient();
        try {
            FileWriter fr = new FileWriter("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas2Day09\\fileToUpload.txt");
            fr.write(data);
            fr.flush();
            fr.close();
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            File firstLocalFile = new File("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas2Day09\\fileToUpload.txt");
            String firstRemoteFile = "FileProses_Edo.txt";
            InputStream inputStream = new FileInputStream(firstLocalFile);
            System.out.println("Start uploading file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("file is uploaded successfully.");
            }
        } catch (IIOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
    }

    public FTPUpload(String data) {
        this.data = data;
    }
}
