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
	  Statement stmt = null;
	  private String query;

	  
	public Connessione(String JDBC_DRIVER, String DB_URL, String USER, String PASS, String query) { 
		
		setQuery(query);
		
	    try {
	      Class.forName(JDBC_DRIVER);
	      //System.out.println("va");
	      conn=DriverManager.getConnection(DB_URL, USER, PASS);
	      if(conn != null) {
	    	  System.out.println("Connessione effettuata");
	      }
	      stmt = conn.createStatement();
	     
	      ResultSet rs = stmt.executeQuery(query);
	      while (rs.next()) {
	        int id = rs.getInt("n_telaio");
	        int modello = rs.getInt("cod_modello");
	        String targa = rs.getString("targa");
	        String colore = rs.getString("colore");

	        System.out.print("ID: " + id);
	        System.out.print(", Cod_Modello: " + modello);
	        System.out.print(", Targa: " + targa);
	        System.out.println(", Colore: " + colore);
	      }
	      rs.close();
	      stmt.close();
	      
	     conn.close();
	    } catch (SQLException se) {
	      se.printStackTrace();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      try {
	    	  if (stmt != null)
		          stmt.close();
	        if (conn != null)
	          conn.close();
	      } catch (SQLException se) {
	        se.printStackTrace();
	      }
	    }
	}
	
	
	
	public void setQuery(String query) {
		this.query=query;
	}
}
	    
		

