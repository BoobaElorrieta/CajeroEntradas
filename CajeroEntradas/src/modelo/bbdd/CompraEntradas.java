package modelo.bbdd;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.pojos.Entrada;
import utils.DBUtils;

public class CompraEntradas {
	
		public void insertEntrada(Entrada entrada){
						
			Connection connection = null;
			
			Statement statement = null;
			
			try {
				Class.forName(DBUtils.DRIVER);
				
				connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
				
				statement = connection.createStatement();
				

				String sql = "INSERT INTO entradas (fechaDeCompra, dni_cliente, cod_proyeccion) "
						+ "VALUES ('" + 
						entrada.getFechaDeCompra() + "', '" +   
						entrada.getCliente() + "', '" +   
						entrada.getProyeccion() + "'" + 
						")";
				
				statement.executeUpdate(sql);
				
			} catch (SQLException sqle) {  
				System.out.println("Error con la BBDD - " + sqle.getMessage());
			} catch(Exception e){ 
				System.out.println("Error generico - " + e.getMessage());
			} finally {
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
		}

}
