package modelo.ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CrearEntrada {


	public void crearFichero() throws IOException {
		FileWriter fichero = null;
		PrintWriter pw = null;
		fichero = new FileWriter("alfa.txt" + "C:\\Users\\ibaiv\\Escritorio");
		pw = new PrintWriter(fichero);
		pw.println("---Ticket---");
		pw.println("Pelicula: ");
		pw.println("Fecha: ");
		pw.println("Hora: ");
		pw.println("Sala: ");
		pw.println("Precio: ");
		fichero.close();
			
	}
}
