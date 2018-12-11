import java.sql.*;

public class AutoJavaSql
{
	String dataTable="authors";
	AutoJavaSql(String tab)
	{
		dataTable=tab;	//"authors";
	}
	
	public String getJava()
	{
	  String str="";
	// Load the driver
    try
    {
      // Load the driver class
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      // Define the data source for the driver
      String sourceURL = "jdbc:odbc:technical_library";

      // Create a connection through the DriverManager 
      Connection conn
		  = DriverManager.getConnection(sourceURL);

      Statement statement
		  = conn.createStatement();

      ResultSet rs
		  = statement.executeQuery(
		  "SELECT * FROM "+dataTable);

	  ResultSetMetaData mta = rs.getMetaData();
      int columns = mta.getColumnCount();                 // Get number of columns

		str+="import java.sql.*;\npublic class "+dataTable+"\n{\n";
		for(int i = 1 ; i<= columns ; i++){
			str+=(mta.getColumnClassName(i)+"\t"+
				mta.getColumnName(i)+";\n");
		}
    }catch(Exception sqle){
      System.err.println(sqle);
    }
		return str;
  }

//   public static void main(String[] args)
//   {
// 	AutoJavaSql w = new	AutoJavaSql("authors");
// 	System.out.println(w.getJava());
//   }
}