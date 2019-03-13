//package team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.ResultSet;

public class ClassroomDB implements JDBCDB
{
   // JDBC Driver name, database URL, user name and password
   private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   private final String USER_NAME = "root";
   private final String PASSWORD = "Rnidal.76";
   
   private Connection conn;
   private Statement stmt;
   
   // Constructor
   public ClassroomDB(){
   }   
   // createConnection() - Registers JDBC Driver, and opens a connection to dbUrl
   public void createConnection(String dbUrl)
   {
	try{
		   // STEP 1 - Load the JDBC driver
	   Class.forName(JDBC_DRIVER);
	   System.out.println("STEP 1 COMPLETE - Driver Registered...");
     
		// STEP 2 - Open a connection
	   conn = DriverManager.getConnection(dbUrl, USER_NAME, PASSWORD);
	   System.out.println("STEP 2 COMPLETE - Connection obtained...");
   }
   catch (ClassNotFoundException e)
   {
	   System.out.println("Could not load driver.\n" + e.getMessage());
   }
   catch (SQLException e) 
   {
	   System.out.println("Problem with SQL.\n" + e.getMessage());
	   }
   }
   
   // createDatabase() - Calls createConnection(), creates a database called class with a table called room
   public void createDatabase()
   {
	try{
          // createConnection() to localhost
      createConnection("jdbc:mysql://localhost/");

      // Create Statement object		    
      stmt = conn.createStatement();
      System.out.println("COMPLETE - Statement object created...");
      
      // Execute Update to Create a Database called class
	  String createDatabase = "CREATE DATABASE IF NOT EXISTS timetable"; 
	  stmt.executeUpdate(createDatabase);
	  System.out.println("COMPLETE - Update executed and timetable database created...");
      
	   // Execute Update to Create a Table called room
	   String createRoomTable = "CREATE TABLE IF NOT EXISTS rooms " +
                            "(roomNo INT(11) not NULL, " +
                            " capacity VARCHAR(18), " + 
                            " subject VARCHAR(20), " + 
                            " lectNoFK INT(11), " + 
                            " PRIMARY KEY (roomNo))" ;
	   
	   String createLectTable = "CREATE TABLE IF NOT EXISTS lecturer " +
               "(lectNo INT(11) not NULL, " +
               " name VARCHAR(18), " + 
               " subject VARCHAR(20), " + 
               " PRIMARY KEY (lectNo))"; 

	   stmt.executeUpdate("USE timetable");
	   stmt.executeUpdate(createRoomTable);
	   stmt.executeUpdate(createLectTable);
	   System.out.println("COMPLETE - Update executed and tables added to class database...");
     
     // closeConnection()
     closeConnection();
  }
  catch (SQLException e)
  {
	  System.out.println("Problem with SQL.\n" + e.getMessage());
	  }
   }

   //Closes the connection
   public void closeConnection()
   {   
			try{
				if(conn != null)
				{
					conn.close();
					System.out.println("COMPLETE - Connection closed.");				
			}
		}
		catch (SQLException e)
		{
			System.out.println("Could not close connection.\n" + e.getMessage());
		}
   }
   
   //insert method
   @Override
   public void insert(String sqlString)
   {
	   try{
		   
	   // Create Statement object
	   createConnection("jdbc:mysql://localhost/");
	   stmt = conn.createStatement();
	   
	   stmt.executeUpdate("USE timetable;");
	   stmt.executeUpdate(sqlString);
	   closeConnection();
	   
	   }
	   catch(SQLException e)
	   {
		   System.out.print(e.getMessage());
	   }    
   }

   public String retrieve(String sqlString) 
   {
	   try{
		   createConnection("jdbc:mysql://localhost/");
		   stmt = conn.createStatement();
		   stmt.executeUpdate("USE timetable;");
		    ResultSet RS = stmt.executeQuery(sqlString);

		    while (RS.next()) 
		    {
		      System.out.println(RS.getString(1) + ", " + RS.getString(2) + ", "
		          + RS.getString(3)+ RS.getString(4));
		    }
		    
		    closeConnection();
		   
	   }
	   
	   catch(SQLException e)
	   {
		   System.out.print(e.getMessage());
	   }
	return "";  
   }
   
   public boolean checkAv(String start, int roomNo, String day) 
   {
	   try{
		   createConnection("jdbc:mysql://localhost/");
		   stmt = conn.createStatement();
		   stmt.executeUpdate("USE timetable;");
		   // check permanent timetable slots for room availability
		   	String query = "SELECT slot.moduleFK, startTime, day from slot WHERE "+start +"  AND roomFK = "+roomNo +" AND day = "+day;
		    ResultSet RS = stmt.executeQuery(query);
		    
		    while(RS.next()){
		    String result = RS.getString(1);
		    
		    //if a result is returned the room is unavailable
		    if(result != null) {
		    	System.out.print("room unavailable");
		    	return false;
		    }
		    
		    	System.out.print("room available");
		    	
		    //check booked slots for availability, if a record is found the slot has been booked and will return false, if not then the method returns true	
		    query = "SELECT slot.moduleFK, startTime, day from slot WHERE "+start +"  AND roomFK = "+roomNo +" AND day = "+day;
		     RS = stmt.executeQuery(query);
		    
		    while(RS.next()){
		    result = RS.getString(1);
		    
		    if(result != null) {
		    	System.out.print("room unavailable");
		    	return false;
		    }
		    else
		    	System.out.print("room available");
		    return true;
		    }
		    return true;
		    }

		    
		//    query = "SELECT slot.moduleFK, startTime, endTime, day from slot WHERE "+startFin +"  AND roomFK = "+roomNo +" AND day = "+day;
//			System.out.print("checking timetable");
//			if(database.checkAv(query)) {
//				query = "SELECT slot_id from slot WHERE "+startFin +"  AND roomFK = "+roomNo +" AND day = "+day;
//				slotRef = database.getSlotID(query);
//				
//				query = "SELECT * from bookings where slotFK = "+slotRef +" AND referenceNo like '"+refLetter +"%'";
//				System.out.print("checking bookings");
//				
//				//boolean check = false;
//				//check = database.checkAv(query);
//				System.out.print("checking bookings done");
//				
//				if(database.checkAv(query)) {
//				
//				System.out.print("Create booking? [y/n]");
//				 book = keyIn.next().charAt(0);
    closeConnection();
		   
	   }
	   
	   catch(SQLException e)
	   {
		   System.out.print(e.getMessage());
	   }
	return true;  
   }
   
   public boolean checkBookings(String start, int roomNo, String day, int week) 
   {
	   if(checkAv(start, roomNo, day)) {
	   try{
		   createConnection("jdbc:mysql://localhost/");
		   stmt = conn.createStatement();
		   stmt.executeUpdate("USE timetable;");
		   // check permanent timetable slots for room availability
		   char weekRef = (char)(week+64);
		   int slotRef = getSlotID(start, roomNo, day);
		   String  query = "SELECT * from bookings where slotFK = "+slotRef +" AND referenceNo like '"+weekRef +"%'";
		    ResultSet RS = stmt.executeQuery(query);
		    
		    while(RS.next()){
		    String result = RS.getString(1);
		    
		    //if a result is returned the room is unavailable
		    if(result != null) {
		    	System.out.print("room unavailable");
		    	return false;
		    }
		    
		    	System.out.print("room available");
		    	
		    //check booked slots for availability, if a record is found the slot has been booked and will return false, if not then the method returns true	
		    query = "SELECT slot.moduleFK, startTime, day from slot WHERE "+start +"  AND roomFK = "+roomNo +" AND day = "+day;
		     RS = stmt.executeQuery(query);
		    
		    while(RS.next()){
		    result = RS.getString(1);
		    
		    if(result != null) {
		    	System.out.print("room unavailable");
		    	return false;
		    }
		    else
		    	System.out.print("room available");
		    return true;
		    }
		    return true;
		    }
		    
		    closeConnection();
			   
		   }
		   
		   catch(SQLException e)
		   {
			   System.out.print(e.getMessage());
		   }
		return true;
		}
	   else
		   return false; 
	   
	   }

   
   public int getSlotID(String start, int roomNo, String day) 
   {
	
	   try{
		   createConnection("jdbc:mysql://localhost/");
		   stmt = conn.createStatement();
		   stmt.executeUpdate("USE timetable;");
		 String  query = "SELECT slot_id from slot WHERE startTime ="+start +"  AND roomFK = "+roomNo +" AND day = "+day;
		    ResultSet RS = stmt.executeQuery(query);
		    
		    while(RS.next()){
		    int id = RS.getInt(1);
		    
		   return id;
		   

		    }
    closeConnection();
		   
	   }
	   
	   catch(SQLException e)
	   {
		   System.out.print(e.getMessage());
	   }
	return 0;  
   }
   
   public int getSlotID(String reference) 
   {
	
	   try{
		   createConnection("jdbc:mysql://localhost/");
		   stmt = conn.createStatement();
		   stmt.executeUpdate("USE timetable;");
		   String  query = "SELECT slotFK from bookings WHERE referenceNo = '"+reference+"';";
		    ResultSet RS = stmt.executeQuery(query);
		    int id=0;
		    
		    while(RS.next()){
		    id = RS.getInt(1);
		    

		    }
    closeConnection();
    return id;
		   
	   }
	   
	   catch(SQLException e)
	   {
		   System.out.print(e.getMessage());
	   }
	return 0;  
   }
   
   public String getBookingDetails(String reference) 
   {
	   int id= getSlotID(reference);
	   try{
		   createConnection("jdbc:mysql://localhost/");
		   stmt = conn.createStatement();
		   stmt.executeUpdate("USE timetable;");
		  
		   
		   
		   String  query = " select startTime, endTime, day, roomFK from slot WHERE slot_id = " +id+";";
		   System.out.print(query);
		   
		    ResultSet RS = stmt.executeQuery(query);
		    String result="";
		    while(RS.next()){
		    result += RS.getString(1) +" ";
		    result += RS.getString(2)+" ";
		    result += RS.getString(3)+" ";
		    result += RS.getString(4)+" ";
		    

		    }
		      query = " select moduleTitle from module join bookings on bookings.moduleFK = module.module_id where bookings.referenceNo = '"+reference +"';";
			     RS = stmt.executeQuery(query);
			     
			    while(RS.next()){
			    result += RS.getString(1);
			    

			    }
			    closeConnection();
		    return result;
   
		   
	   }
	   
	   catch(SQLException e)
	   {
		   System.out.print(e.getMessage());
	   }
	return "";  
   }
   
   
   public int  addRoom(int newRoom, String roomType, int capacity)  
   {
	  int oldNo=0;
	   try{
		   createConnection("jdbc:mysql://localhost/");
		   stmt = conn.createStatement();
		   stmt.executeUpdate("USE timetable;");
		    ResultSet RS = stmt.executeQuery("Select roomFK FROM slot;");
		    
		    while(RS.next()){
		    
		    oldNo=RS.getInt(1);
		    //System.out.print("room no is " +oldNo);
		   break;

		    }
		    
		   insert("INSERT INTO rooms(roomNo, capacity, roomType) VALUES("+newRoom+","+capacity+","+roomType+");");
		   insert("INSERT INTO slot( roomFK, startTime, endTime, day) SELECT "+newRoom+", startTime, endTime, day FROM slot WHERE roomFK = "+oldNo+";");
		 
		    
    closeConnection();
		   
	   }
	   
	   catch(SQLException e)
	   {
		   System.out.print(e.getMessage());
	   }
	return 0;  
   }
} 