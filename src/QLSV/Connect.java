/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Connect {

    public static Connection Connect() {
        Connection con = null;

        String user = "thanhduy";
        String pass = "1234";
        String url = "jdbc:sqlserver://DESKTOP-808OLHB\\SQLEXPRESS:1433;databaseName=DTB_assjava3";

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Thanh cong");
            return con;

        } catch (Exception e) {
            System.out.println("Loi ket noi sql: " + e);
            return con = null;

        }

    }

}
