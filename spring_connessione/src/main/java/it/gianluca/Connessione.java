package it.gianluca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Connessione {

	  /*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	  static final String DB_URL = "jdbc:mysql://localhost/gestione_officina";
	  static final String USER = "gianluca";
	  static final String PASS = "gianluca";*/
	  Connection conn = null;
	

	  
	public Connessione(String JDBC_DRIVER, String DB_URL, String USER, String PASS) {  
	    try {
	      Class.forName(JDBC_DRIVER);
	      //System.out.println("va");
	      conn=DriverManager.getConnection(DB_URL, USER, PASS);
	      if(conn != null) {
	    	  System.out.println("Connessione effettuata");
	      }
    
	      
	     conn.close();
	    } catch (SQLException se) {
	      se.printStackTrace();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      try {
	       
	        if (conn != null)
	          conn.close();
	      } catch (SQLException se) {
	        se.printStackTrace();
	      }
	    }
	}
}
	    
		

