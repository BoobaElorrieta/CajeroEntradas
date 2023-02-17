package modelo.bbdd;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import modelo.pojos.Entrada;
import utils.DBUtils;

public class CompraEntradas {
	
	// Inserta un alumno
		public void insertEntrada(Entrada entrada){
			
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
				String sql = "INSERT INTO entradas (fechaDeCompra, dni_cliente, cod_proyeccion) "
						+ "VALUES ('" + 
						entrada.getFechaDeCompra() + "', '" +   
						entrada.getCliente() + "', '" +   
						entrada.getProyeccion() + "'" + 
						")";
				
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

//		public static void main(String[] args) {
//			DBAccessExampleForInsert dBAccessExample = new DBAccessExampleForInsert();
//			
//			// Nuevo alumno a insertar...
//			Alumno alumno = new Alumno ();
//			alumno.setNombre("Andres");
//			alumno.setApellidos("Dominguez");
//			alumno.setEdad(25);
//			
//			dBAccessExample.insertEjemplo(alumno);
//		}
	

}
