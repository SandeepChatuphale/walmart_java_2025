import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoUpdate {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root", "root");
			
			String query = "UPDATE smsapp_db.tbl_student SET percentage = ? WHERE rollNumber = ?";
			pstmt = con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter RollNumber");
			int rollNumber = sc.nextInt();
			System.out.println("Enter Percentage");
			double percentage = sc.nextDouble();
			
			//set the values to ? placeholder
			pstmt.setDouble(1, percentage);
			pstmt.setInt(2, rollNumber);
			
			int numberOfRowsAffected = pstmt.executeUpdate();//
			
			
			System.out.println("Rows inserted are " + numberOfRowsAffected);
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			try {
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
