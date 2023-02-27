package modelo.bbdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;

import modelo.pojos.Proyeccion;
import modelo.pojos.Sala;
import utils.DBUtils;

public class SolicitaHorarios {
	
	public ArrayList<Proyeccion> getProyecciones(String sql) {
		ArrayList<Proyeccion> ret = null;

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Proyeccion>();

				Proyeccion proyeccion = new Proyeccion();
				Sala sala = new Sala();

				Date fecha = resultSet.getDate("fecha");
				java.sql.Time horaSql = resultSet.getTime("hora");
				LocalTime hora = horaSql.toLocalTime();
				int precio = resultSet.getInt("precio");
				String nombre = resultSet.getString("nombre");
				proyeccion.setFecha(fecha);
				proyeccion.setHora(hora);
				proyeccion.setPrecio(precio);
				sala.setNombre(nombre);
				proyeccion.setSala(sala);
				
				ret.add(proyeccion);
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;
	}
}
