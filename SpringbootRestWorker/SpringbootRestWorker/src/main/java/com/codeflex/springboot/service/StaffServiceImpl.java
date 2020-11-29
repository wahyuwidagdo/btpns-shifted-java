package com.codeflex.springboot.service;

import com.codeflex.springboot.model.Staff;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("staffService")
public class StaffServiceImpl implements StaffService {


    //  Using two hashmaps in order to provide performance of O(1) while fetching products
    private static HashMap<Long, Staff> staffs = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String connectionLink = "jdbc:mysql://localhost:3306/sonoo\",\"root\",\"MySQL@31";
    private static String username = "root";
    private static String password = "MySQL@31";
    private static Connection conn = null;
    private static Statement statement = null;


    public List<Staff> findAllStaffs() {
        // Pagination should be added...
        return new ArrayList<>(staffs.values());
    }

    public Staff findById(long id) {
        return staffs.get(id);
    }

    public Staff findByName(String name) {

        if (idNameHashMap.get(name) != null){
            return staffs.get(idNameHashMap.get(name));
        }

        return null;
    }

    public void saveStaff(Staff staff) {
        synchronized (this) {    //  Critical section synchronized
            staffs.put(staff.getId(), staff);
            idNameHashMap.put(staff.getName(), staff.getId());
            try {
                statement = conn.createStatement();
                statement.executeUpdate("INSERT INTO ");
            }
        }
    }

    public void updateStaff(Staff staff) {
        synchronized (this) {    //  Critical section synchronized
            staffs.put(staff.getId(), staff);
            idNameHashMap.put(staff.getName(), staff.getId());
        }
    }

    public void deleteStaffById(long id) {
        synchronized (this) {    //  Critical section synchronized
            idNameHashMap.remove(staffs.get(id).getName());
            staffs.remove(id);
        }
    }

    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getName()) != null;
    }

    public void deleteAllStaffs() {
        staffs.clear();
    }

    public void ConnectionToDB() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/sonoo?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC","root","MySQL@31");
//            statement = conn.createStatement();
//            System.out.println("Connected to Database");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(connectionLink, username, password);
            statement = conn.createStatement();
            System.out.println("Connected to Database");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void closeConnection() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
