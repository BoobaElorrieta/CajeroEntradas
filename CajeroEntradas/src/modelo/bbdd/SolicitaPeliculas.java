package modelo.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.pojos.Pelicula;
import utils.DBUtils;

public class SolicitaPeliculas {

	
	public ArrayList <Pelicula> getPeliculas(String sql){
		ArrayList <Pelicula> ret = null;

		
		// La conexion con BBDD
		Connection connection = null;
		
		// Vamos a lanzar una sentencia SQL contra la BBDD
		// Result set va a contener todo lo que devuelve la BBDD
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			// El Driver que vamos a usar
			Class.forName(DBUtils.DRIVER);
			
			// Abrimos la conexion con BBDD
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			
			// Vamos a lanzar la sentencia...
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			// No es posible saber cuantas cosas nos ha devuelto el resultSet.
			// Hay que ir 1 por 1 y guardandolo todo en su objeto Ejemplo correspondiente
			while(resultSet.next()) {
				
				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList <Pelicula> ();
				
				Pelicula pelicula = new Pelicula ();
				
				// Sacamos las columnas del RS
                String titulo = resultSet.getString("titulo");           
                // Metemos los datos a Ejemplo
                pelicula.setTitulo(titulo);

                
                // Lo guardamos en ret
                ret.add(pelicula);
			}
		} catch (SQLException sqle) {  
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch(Exception e){ 
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null) 
					resultSet.close(); 
			} catch(Exception e){ 
				// No hace falta 
			};
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
		return ret;
	}
	
//	QUITAR MAIN

	public static void main(String[] args) {

		SolicitaPeliculas dBAccessExample = new SolicitaPeliculas();
		ArrayList<Pelicula> pelis = dBAccessExample.getPeliculas("Select Titulo From Peliculas Pe join Proyecciones Pr on Pe.cod = Pr.codPeli join Salas S on Pr.codSala = S.cod join Cines C on S.codCine = C.cod Where C.Nombre = “CineIbai” Order by Fecha, Horas ASC");
		for (int i = 0; i < pelis.size(); i++) {
		System.out.println(pelis.get(i).getTitulo());

		}

		}
}
