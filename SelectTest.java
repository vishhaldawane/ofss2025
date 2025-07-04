import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectTest {

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
			 
			 //3 - java.sql.Statement;  and not the java.beans.Statement
			 Statement statement = conn.createStatement();
			 System.out.println("Statement created..."+statement);
			 
			 //4
			 ResultSet result= statement.executeQuery("SELECT * FROM DEPT3 where deptno=10");
			 System.out.println("Result created..."+result);
			 
			 //5
			 while(result.next()) {
				 System.out.println("DEPTNO : "+result.getInt(1));
				 System.out.println("DNAME  : "+result.getString(2));
				 System.out.println("LOC    : "+result.getString(3));
				 System.out.println("--------------------------");
			 }
			 
			 //6
			 result.close();
			 statement.close();
			 conn.close();
			 System.out.println("DB resources are closed....");
			
		}
		catch(Exception e) {
			System.out.println("Exception : "+e);
		}
	}

}
