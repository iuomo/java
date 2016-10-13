import java.util.Date;
import java.sql.*;

class InsertData{
	Connection conn = null;
	Statement stmt = null;
void insert(){
		//***************************************************
		Date date = new Date();
		String dateString = ""+ date;
				try
				{
		String url = "jdbc:mysql://127.0.0.1:3306/web?user=webuser&password=w0506r";

String sqlInsert = "INSERT INTO maze VALUES ('','testcommand','testmaze',777,'"+dateString+"');";
			System.out.println(sqlInsert);
			
					
			System.out.println (url);
			
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
          conn = DriverManager.getConnection (url);                     
					//cwc added this
					stmt = conn.createStatement();
						stmt.executeUpdate(sqlInsert);
					// i added this 
					conn.close ();
		                  
		
				
				}
        	catch (Exception e)
        {
           System.err.println ("Cannot connect to database server.");
         }
							 
           finally
           {
               if (conn != null)
               {
                   try
                   {
                       conn.close ();
                       System.out.println ("Database connection terminated");
                   }
                   catch (Exception e) { /* ignore close errors */ }
               }
           }
			 
		}
		}


		class HitTest{
	public static void main (String args[]){ 
	InsertData s = new InsertData();
			s.insert();
		}}
