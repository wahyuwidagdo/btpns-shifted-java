package com.tugas3;

import java.io.FileWriter;
public class Average extends Thread{
    String output = "";
    public void run(){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\btpnshifted\\Java\\Day08\\Tugas3\\src\\com\\tugas3\\FileRata2.txt");
            fw.write(output);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    Average(String data){
        String[] split1 = data.split("\\n");
        for (String string : split1) {
            String[] data2 = string.split("\\,");
            Double fisika = Double.parseDouble(data2[1]);
            Double biologi = Double.parseDouble(data2[2]);
            Double kimia = Double.parseDouble(data2[3]);
            output += data2[0] + "," + ((fisika+biologi+kimia)/3) + "\n";
        }
    }
}