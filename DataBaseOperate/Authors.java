import java.sql.*;

public class Authors
{
    int id;
	String	firstname;
	String	lastname;

	Connection	connec;
	Statement	stat;

    String driverName = "com.mysql.jdbc.Driver";
    String sourceURL = "jdbc:mysql://localhost:3306/database1";
    String userName = "root";
    String passWord = "123456";
    //String sql = "select * from authors";

	Authors(String sql)
	{
		try {
            //加载驱动程序
	        Class.forName(driverName);
            //根据路径建立连接
            connec = DriverManager.getConnection(sourceURL, userName, passWord);

            if (!connec.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
            }else {
                System.out.println("Falled connecting to the Database!");
            }
            //建立容器
            stat = connec.createStatement();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

	// Authors(int id)
	// {
	// 	this();
	// 	try{
    //         ResultSet rs = stat.executeQuery( "SELECT * FROM authors where authid=" + id);
    //         if(rs.next()) init(rs);
	// 	} catch(Exception e){
	// 		e.printStackTrace();
	// 	}
    // }
    
	// void insert()
	// {
    //     String sql = "insert into authors ";
    //     stat.executeQuery(sql);
    //     return;
    // }
    
	// void update()
	// {
    // }
    
    //删除序列号为authid的数据
	// void delete(int authid)
	// {
	// 	String sql = "delete from where authid="+authid;
    //     stat.execteUpdate(sql);
    //     return;
    // }
    
	// void init(ResultSet rs)
	// {
	// 	try{
    //         authid = rs.getString(1);
	// 	    firstname = rs.getString(2);
	// 	    lastname = rs.getString(3);
	// 	} catch(Exception e){
	// 		e.printStackTrace();
    //     }
    //     return;
    // }
    
    //
	// void init(int authid, String firstname, String lastname)
	// {
	// 	try{
    //         this.authid = authid;
    //         this.firstname = firstname;
    //         this.lastname = lastname;
	// 	} catch(Exception e){
	// 		e.printStackTrace();
	// 	}
    // }
    
    //显示序列号为authid的数据
	void disp(int authid)
	{
		try{
            ResultSet rs = stat.executeQuery("select * from authors authid=" + authid);
            if(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }
		} catch(Exception e){
			e.printStackTrace();
		}
    }

    //根据sql指令输出满足条件的数据
	void disp(String sql)
	{
		try{
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next())
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		} catch(Exception e){
			e.printStackTrace();
        }
	}

    // public static void main(String[] args)
    // {
    //     Authors w = new Authors();
    //     //显示全部数据
    //     w.disp("select * from authors");
    //     //显示序列号为3的数据
    //     w.disp(3);
    // }
}