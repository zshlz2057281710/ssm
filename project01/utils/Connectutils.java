package project01.utils;
import com.mysql.cj.jdbc.Driver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Connectutils {
    private static String url;
    private static String username;
    private static String password;
    static {
        FileInputStream fis=null;

        try {
            fis=new FileInputStream(new File("D:\\mypro\\src\\project01\\db.properties"));
            Properties properties=new Properties();
            properties.load(fis);
            url=properties.getProperty("jdbc.url");
            username=properties.getProperty("jdbc.username");
            password=properties.getProperty("jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static Connection getConnection(){
        Connection connection=null;
        try {
            DriverManager.registerDriver(new Driver());
             connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;
    }
    public static void closeff(PreparedStatement ps,Connection connection){
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void closeff(ResultSet rs, PreparedStatement ps, Connection connection){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeff(ps,connection);
    }
}
