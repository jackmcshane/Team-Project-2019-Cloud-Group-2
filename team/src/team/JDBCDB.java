package team;

public interface JDBCDB
{
	   public abstract void createConnection(String dbUrl);
	   public abstract void createDatabase();
	   public abstract void closeConnection();
	   public abstract void insert(String sqlString); 
	   //public abstract void retrieve(String sqlString);   
}