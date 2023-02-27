package modelo.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.pojos.Cliente;
import utils.DBUtils;


public class RegistraCliente {

		public void insertCliente(Cliente cliente){
			
			Connection connection = null;
			
			Statement statement = null;
			
			try {
				Class.forName(DBUtils.DRIVER);
				
				connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
				
				statement = connection.createStatement();
				
				String sql = "insert into clientes (dni, nombre, apellidos, sexo, contrasena, tfno, direccion, email) VALUES ('" +  
						cliente.getDni() + "', '" + 
						cliente.getNombre() + "', '" +  
						cliente.getApellidos() + "', '" +  
						cliente.getSexo() + "', '" +  
						cliente.getContrasena() + "', '" +  
						cliente.getTfno() + "', '" +  
						cliente.getDireccion() + "', '" + 
						cliente.getEmail() + "')";
				
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
