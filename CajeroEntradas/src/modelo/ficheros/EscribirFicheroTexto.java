package ficheros.ficherosDeTexto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase de ejemplo. Pide al usuario un texto y lo escribe en el fichero. Si el
 * fichero no existe, lo crea.
 * 
 * Por defecto, cada vez que se abre el fichero para escribir, borra su
 * contenido. Si queremos que en vez de eso lo que escribamos se ponga al final,
 * debemos de indicarselo (ver linea 30)
 */
public class EscribirFicheroTexto {

	private Scanner teclado = null;

	private static final String NOMBRE_FICHERO = "diario.txt";
	private static final String RUTA_FICHERO = "c://Trastero//";

	public EscribirFicheroTexto() {
		teclado = new Scanner(System.in);
	}

	private void run() {

		System.out.println("Vamos a escribir en el fichero " + NOMBRE_FICHERO + " en la ruta " + RUTA_FICHERO);

		// Preparamos las clases necesarias para escribir un fichero
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {
			// Asignamos el fichero que vamos a escribir
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO);

			// Si preferimos que el fichero se actualice a final...
			//fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO, true);

			printWriter = new PrintWriter(fileWriter);

			// Pedimos por teclado
			System.out.print("Texto a guardar: ");
			String texto = teclado.nextLine();

			// Lo mandamos al fichero
			printWriter.println(texto);

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

	public static void main(String[] args) {
		(new EscribirFicheroTexto()).run();
	}
}
