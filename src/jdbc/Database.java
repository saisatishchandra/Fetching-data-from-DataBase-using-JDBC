package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			
		//query to be implemented in database:
			String query="select * from bookings";
			
		//url that contains jdbc as 1st part:: which database to be connected ::localhost:: port number of database::database name; 
			String url="jdbc:mysql://127.0.0.1:3306/airline_reservation_db";
			
		//using username of database (xampp)
			String user="root";
		
		//using password as empty string ""(default for xampp); 
			String pass="";
			
		//connection interface object creation with get connection method from drivermanager class.
		//passing url, user ,pass as parameters.
		//
			Connection cn=DriverManager.getConnection(url, user, pass);
			
		//create a statement with that 
			Statement s=cn.createStatement();
			
		//create an object for result set that stores the result of the query to be executed.
			ResultSet r=s.executeQuery(query);
		
		//until the result contains next run a while loop 
		//for each iteration get the desired data.Note :both column names should match in order to fetch data from database.
			
			while (r.next()) {
                int id = r.getInt("booking_id");
                int fid = r.getInt("flight_id");
                String seatno = r.getString("seat_number");
                System.out.println(id + " | " + fid + " | " + seatno);
            }
			
			cn.close();
			
	}

}
