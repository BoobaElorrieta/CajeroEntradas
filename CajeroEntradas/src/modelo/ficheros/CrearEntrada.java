package modelo.ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CrearEntrada {
	private Scanner teclado = null;

	private static final String NOMBRE_FICHERO = "diario.txt";
	private static final String RUTA_FICHERO = "c://Descargas//";

	public CrearEntrada() {
		teclado = new Scanner(System.in);
	}

	public void crearFichero(String directorio) {

		System.out.println("Vamos a escribir en el fichero " + directorio + "" + " en la ruta " + RUTA_FICHERO);

		// Preparamos las clases necesarias para escribir un fichero
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {
			// Asignamos el fichero que vamos a escribir
			fileWriter = new FileWriter(directorio+".txt " + NOMBRE_FICHERO);

			// Si preferimos que el fichero se actualice a final...
			//fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO, true);

			printWriter = new PrintWriter(fileWriter);

			// Pedimos por teclado
			System.out.print("Texto a guardar: ");
			String texto = teclado.nextLine();

			// Lo mandamos al fichero
			printWriter.println("---Ticket---");
			printWriter.println("Pelicula: ");
			printWriter.println("Fecha: ");
			printWriter.println("Hora: ");
			printWriter.println("Sala: ");
			printWriter.println("Precio: ");

		} catch (IOException e) {
			System.out.println("IOException - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
	}
}
