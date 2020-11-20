package Tugas1Day09;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Staff> stf = new ArrayList<Staff>();
    static ArrayList<Manager> mnj = new ArrayList<Manager>();

    public static void main(String[] args) {
        try {
            String menu = "0";
            while ((Integer.parseInt(menu) < 4)) {
                System.out.println(" ");
                System.out.println("============================");
                System.out.println("************MENU************");
                System.out.println("============================");
                System.out.println(" ");
                System.out.println("1. Create Worker");
                System.out.println("2. Create JSON Format and Write to File");
                System.out.println("3. Read JSON Format from a File");
                System.out.println("4. Exit");
                System.out.println("===============================");
                System.out.print("Pilih menu [1/2/3/4] = ");
                menu = scan.nextLine();
                System.out.println("===============================");
                System.out.println(" ");
                switch (Integer.parseInt(menu)) {
                    case 1:
                        createWorker();
                        break;
                    case 2:
                        createJson();
                        break;
                    case 3:
                        readJson();
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createWorker() {
        String nama, menu = "0";
        int id = 0;
        while(Integer.parseInt(menu) < 3) {
            try {
                System.out.println(" ");
                System.out.println("===========================");
                System.out.println("*******Create Worker*******");
                System.out.println("===========================");
                System.out.println(" ");
                System.out.println("1. Tambah Manager");
                System.out.println("2. Tambah Staff");
                System.out.println("3. Back\n");
                System.out.println("===============================");
                System.out.print("Pilih menu [1/2/3] = ");
                menu = scan.nextLine();
                System.out.println("===============================");
                System.out.println(" ");
                switch (Integer.parseInt(menu)) {
                    case 1:
                        System.out.println(" ");
                        System.out.print("Input ID Karyawan : ");
                        id = Integer.parseInt(scan.nextLine());
                        System.out.print("Input Nama : ");
                        nama = scan.nextLine();
                        String tel = "";
                        ArrayList telps = new ArrayList();
                        while ((!tel.equals("ok"))) {
                            System.out.println("Input \"ok\" ketika selesai");
                            System.out.print("Input Nomor Telp : ");
                            String telp = scan.nextLine();
                            if (telp.equals("ok")) {
                                break;
                            } else {
                                telps.add(telp);
                            }
                        }
                        Manager manager = new Manager(id, nama, telps);
                        mnj.add(manager);
                        break;
                    case 2:
                        System.out.println(" ");
                        System.out.print("Input ID Karyawan : ");
                        id = Integer.parseInt(scan.nextLine());
                        System.out.print("Input Nama : ");
                        nama = scan.nextLine();
                        String eml = "";
                        ArrayList emails = new ArrayList();
                        while (!eml.equals("ok")) {
                            System.out.println("Input \"ok\" ketika selesai");
                            System.out.print("Input Email : ");
                            String email = scan.nextLine();
                            if (email.equals("ok")) {
                                break;
                            } else {
                                emails.add(email);
                            }
                        }
                        Staff staff = new Staff(id, nama, emails);
                        stf.add(staff);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void createJson() {
        JSONArray arrManager = new JSONArray();
        for (Manager mng : mnj) {
            JSONObject tempManager = new JSONObject();
            tempManager.put("ID", mng.getIDKaryawan());
            tempManager.put("Nama", mng.getNama());
            tempManager.put("Tunjangan Pulsa", mng.getTunjanganPulsa());
            tempManager.put("Gaji Pokok", mng.getGajiPokok());
            tempManager.put("Absensi Hari", mng.getAbsensiHari());
            tempManager.put("Tunjangan Transport", mng.getTunjanganTransport());
            tempManager.put("Tunjangan Entertaint", mng.getTunjanganEntertaint());
            JSONArray tempTelp = new JSONArray();
            for(String data : mng.getTelp()) {
                tempTelp.add(data);
            }
            tempManager.put("No Telepon", tempTelp);
            arrManager.add(tempManager);
        }

        JSONArray arrStaff = new JSONArray();
        for (Staff staf : stf) {
            JSONObject tempStaff = new JSONObject();
            tempStaff.put("ID", staf.getIDKaryawan());
            tempStaff.put("Nama", staf.getNama());
            tempStaff.put("Tunjangan Pulsa", staf.getTunjanganPulsa());
            tempStaff.put("Gaji Pokok", staf.getGajiPokok());
            tempStaff.put("Absensi Hari", staf.getAbsensiHari());
            tempStaff.put("Tunjangan Makan", staf.getTunjanganMakan());
            JSONArray tempEmail = new JSONArray();
            for (String data : staf.getEmail()) {
                tempEmail.add(data);
            }
            tempStaff.put("Email", tempEmail);
            arrStaff.add(tempStaff);
        }
        try {
            String outputMnj = arrManager.toJSONString();
            String outputStf = arrStaff.toString();
            FileWriter fwMnj = new FileWriter("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas1Day09\\manager.txt");
            FileWriter fwStf = new FileWriter("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas1Day09\\staff.txt");
            fwMnj.write(outputMnj);
            fwMnj.flush();
            fwMnj.close();
            fwStf.write(outputStf);
            fwStf.flush();
            fwStf.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void readJson() {
        try {
            System.out.println("Input Nama File : ");
            String file = scan.nextLine();
            FileReader fr = new FileReader("C:\\Users\\btpnshifted\\Java\\Day09\\src\\Tugas1Day09\\" + file);
            int i;
            String input = "";
            while ((i = fr.read()) !=-1) {
                input += (char)i;
            }
            JSONArray arr = (JSONArray) JSONValue.parse(input);
            for (int j = 0; j < arr.size(); j++) {
                JSONObject tempData = (JSONObject) arr.get(j);
                System.out.println("ID : " + tempData.get("ID"));
                System.out.println("Nama : " + tempData.get("Nama"));
                System.out.println("Tunjangan Pulsa : " + tempData.get("Tunjangan Pulsa"));
                System.out.println("Gaji Pokok : " + tempData.get("Gaji Pokok"));
                System.out.println("Absensi Hari : " + tempData.get("Absensi Hari"));
                if (file.equals("staff.txt")) {
                    System.out.println("Tunjangan Makan : " + tempData.get("Tunjangan Makan"));
                    JSONArray email = (JSONArray) tempData.get("Email");
                    System.out.print("Email : ");
                    for (int k = 0; k < email.size(); k++) {
                        System.out.print(email.get(k) + ", ");
                    }
                    System.out.print("\n\n");
                } else {
                    System.out.println("Tunjangan Transport : " + tempData.get("Tunjangan Transport"));
                    System.out.println("Tunjangan Entertaint : " + tempData.get("Tunjangan Entertaint"));
                    JSONArray email = (JSONArray) tempData.get("No Telepon");
                    System.out.print("No Telepon : ");
                    for (int k = 0; k < email.size(); k++) {
                        System.out.print(email.get(k) + ", ");
                    }
                    System.out.print("\n\n");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
