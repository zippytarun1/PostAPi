package MockServerService.PostApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class commondbmanager {

	public Connection initiateDbconnection(String DBdriver,String DBname,String username,String Password) throws SQLException, ClassNotFoundException
	
	{
		Connection conn=null;
		Class.forName(DBdriver);
		conn = DriverManager.getConnection(DBname,username,Password);
			
		return conn;
		
	}
	
	
	public void datafetchfromquery(Connection conn,String tablename,String columname,String columvalue) throws SQLException
	
	{
		Statement stmt=(Statement)conn.createStatement();
		String Query="Select * from"+tablename+"where" +columname + "='" + columvalue+"'";
		ResultSet rs = stmt.executeQuery(Query);
		System.out.println("data fetched successfully");
//System.out.println("tk"+rs.getString("name"));
		
	}
	
	
}
