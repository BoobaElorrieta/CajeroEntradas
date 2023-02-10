package modelo.bbdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import modelo.pojos.Cine;
import modelo.pojos.Pelicula;
import modelo.pojos.Proyeccion;
import modelo.pojos.Sala;
import utils.DBUtils;

public class SolicitaHorarios {
	
	public ArrayList<Proyeccion> getProyecciones(String sql) {
		ArrayList<Proyeccion> ret = null;

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
			while (resultSet.next()) {

				// Si es necesario, inicializamos la lista
				if (null == ret)
					ret = new ArrayList<Proyeccion>();

				Proyeccion proyeccion = new Proyeccion();
				Sala sala = new Sala();

				// Sacamos las columnas del RS
				Date fecha = resultSet.getDate("fecha");
				java.sql.Time horaSql = resultSet.getTime("hora");
				LocalTime hora = horaSql.toLocalTime();
				int precio = resultSet.getInt("precio");
				String nombre = resultSet.getString("nombre");
				// Metemos los datos a Ejemplo
				proyeccion.setFecha(fecha);
				proyeccion.setHora(hora);
				proyeccion.setPrecio(precio);
				sala.setNombre(nombre);
				proyeccion.setSala(sala);
				
				// Lo guardamos en ret
				ret.add(proyeccion);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
			;
		}
		return ret;
	}
}
