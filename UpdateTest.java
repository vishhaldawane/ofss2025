import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//assignment : delete
//select all records
//consolidated records of dept and emp together using a equi-join

public class UpdateTest {

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
			 PreparedStatement pst = conn.prepareStatement("UPDATE DEPT3 SET DNAME=?, LOC=? WHERE DEPTNO=?");
			 pst.setString(1, "QUALITY");
			 pst.setString(2, "MUMBAI");
			 pst.setInt(3, 50);
			 
			 
			 PreparedStatement pst2 = conn.prepareStatement("UPDATE DEPT3 SET DEPTNO=?, LOC=? WHERE DNAME=?");
			 pst2.setInt(1, 30);
			 pst2.setString(2, "PUNE");
			 pst2.setString(3, "PURCHASE");
			 
			 System.out.println("PreparedStatement created..."+pst);
			 
			
			 
			 
			 //4
			 int rowsCreated= pst.executeUpdate(); //fire the insert query of pst
			 System.out.println("Row UPDATED : "+rowsCreated);
			 
			 
			 int rowsCreated2= pst2.executeUpdate(); //fire the insert query of pst
			 System.out.println("Row UPDATED : "+rowsCreated2);
			 
			 //6
			 pst.close();
			 pst2.close();
			 

			 conn.close();
			 System.out.println("DB resources are closed....");
			
		}
		catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}

}
