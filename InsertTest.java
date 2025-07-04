import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		try
		{
		//for oracle database
		//DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());
		//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
		//System.out.println("Connected to the DB : "+conn);
		
		  //for hsql database
			//1
			DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
			System.out.println("Driver is loaded");
			
			
			//2
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb","SA","");
			 System.out.println("Connected to the DB : "+conn);
			 
			 //3 - 
			 PreparedStatement pst = conn.prepareStatement("INSERT INTO DEPT3 VALUES (?,?,?)");
			 System.out.println("PreparedStatement created..."+pst);
			 
			 pst.setInt(1, 50);
			 pst.setString(2, "QMS");
			 pst.setString(3, "NM");
			 
			 //4
			 int rowsCreated= pst.executeUpdate(); //fire the insert query of pst
			 System.out.println("Row created : "+rowsCreated);
			 
			 
			 //6
			 pst.close();

			 conn.close();
			 System.out.println("DB resources are closed....");
			
		}
		catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}

}
