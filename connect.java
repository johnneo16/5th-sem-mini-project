import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connect
{
	
	public Statement con()
	{
		try
		{
			Connection conn;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "cherry");
			Statement st=conn.createStatement();
			return st;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
