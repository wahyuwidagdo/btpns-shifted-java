package Tugas2Day09;

public class PrintToScreen extends Thread {
    String data;

    public void run() {
        System.out.println(data);
    }

    PrintToScreen(String data) {
        this.data = data;
    }
}
