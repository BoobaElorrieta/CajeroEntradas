package utils;

// Configuraciones necesarias para la Base de Datos de MySql
public class DBUtils {

	// La URL donde esta la Base de Datos. Se descompone en:
	// driver : bbd : // IP : Puerto / Schema
	public static final String URL = "jdbc:mysql://10.5.14.245:3306/cines_elorrieta";

	// El Driver que vamos a usar
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	// Nombre y Pass de acceso a la Base de Datos
	public static final String USER = "boobaelorrieta";
	public static final String PASS = "root";
	
}
