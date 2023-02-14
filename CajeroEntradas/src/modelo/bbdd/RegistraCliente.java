package modelo.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.pojos.Cliente;
import utils.DBUtils;


public class RegistraCliente {

	// Inserta un alumno
		public void insertCliente(Cliente cliente){
			
			// La conexion con BBDD
			Connection connection = null;
			
			// Vamos a lanzar una sentencia SQL contra la BBDD
			Statement statement = null;
			
			try {
				// El Driver que vamos a usar
				Class.forName(DBUtils.DRIVER);
				
				// Abrimos la conexion con BBDD
				connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
				
				// Vamos a lanzar la sentencia...
				statement = connection.createStatement();
				
				// Montamos la SQL 
				String sql = "insert into clientes (dni, nombre, apellidos, sexo, contrasena, tfno, direccion, email) VALUES ('" +  
						cliente.getDni() + "', '" + 
						cliente.getNombre() + "', '" +  
						cliente.getApellidos() + "', '" +  
						cliente.getSexo() + "', '" +  
						cliente.getContrasena() + "', '" +  
						cliente.getTfno() + "', '" +  
						cliente.getDireccion() + "', '" + 
						cliente.getEmail() + "')";
				
				// La ejecutamos...
				statement.executeUpdate(sql);
				
			} catch (SQLException sqle) {  
				System.out.println("Error con la BBDD - " + sqle.getMessage());
			} catch(Exception e){ 
				System.out.println("Error generico - " + e.getMessage());
			} finally {
				// Cerramos al reves de como las abrimos
				try {
					if (statement != null) 
						statement.close(); 
				} catch(Exception e){ 
					// No hace falta				
				};
				try {
					if (connection != null) 
						connection.close(); 
				} catch(Exception e){ 
					// No hace falta
				};					
			}
		}
}
