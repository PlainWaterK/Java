import java.util.Scanner;
import java.sql.*;

public class Test{
    public static void main(String[] args)throws Exception{
        String driverName = "com.mysql.jdbc.Driver";
        String sourceURL = "jdbc:mysql://localhost:3306/database1";
        String userName = "root";
        String passWord = "123456";
        Statement stat;
        Connection connec;
        //加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //根据路径建立连接
        connec = DriverManager.getConnection(sourceURL, userName, passWord);
        
        if (!connec.isClosed()){
            System.out.println("Succeeded connecting to the Database!");
        }else {
            System.out.println("Falled connecting to the Database!");
        }
        //建立容器
        stat = connec.createStatement();

        ResultSet rs = stat.executeQuery("select * from authors");
        while(rs.next()){
            int id = rs.getInt("authid");
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            System.out.println("id: "+id+"  name: "+firstname);
        }
        rs.close();
        connec.close();
        return;
    }
}