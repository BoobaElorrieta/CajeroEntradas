package modelo.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.pojos.Cine;
import utils.DBUtils;

public class SolicitaCines {

	public ArrayList <Cine> getCines(String sql){
		ArrayList <Cine> ret = null;

		
		Connection connection = null;
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(DBUtils.DRIVER);
			
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				if (null == ret)
					ret = new ArrayList<Cine> ();
				
				Cine cine = new Cine ();
				
                String nombre = resultSet.getString("nombre");           
                cine.setNombre(nombre);

                
                ret.add(cine);
			}
		} catch (SQLException sqle) {  
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch(Exception e){ 
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null) 
					resultSet.close(); 
			} catch(Exception e){ 
			};
			try {
				if (statement != null) 
					statement.close(); 
			} catch(Exception e){ 
			};
			try {
				if (connection != null) 
					connection.close(); 
			} catch(Exception e){ 
			};					
		}
		return ret;
	}
}
