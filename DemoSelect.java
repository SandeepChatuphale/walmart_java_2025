import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoSelect {

	public static void main(String[] args) {

		try(
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root", "root");
	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM smsapp_db.tbl_student");
	ResultSet rs = pstmt.executeQuery();
						
			)
		{
			while(rs.next())//check if there any record if yes return true 
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getDouble(3)+" "+rs.getInt(4));
			}
			
		}
		catch (Exception e) {
		}
	}

}
