package modelo.bbdd;

public class SolicitaPeliculas {
	public static void main(String[] args) {

		DBAccessExampleForSelect dBAccessExample = new DBAccessExampleForSelect();
		ArrayList<Alumno> alumno = dBAccessExample.getAllEjemplos("SELECT * FROM t_alumno a join t_coche c on a.id = c.idAlumno WHERE matricula like \'1234RDF\'");
		Menu menu = new Menu();

		for (int i = 0; i < alumno.size(); i++) {
		menu.mostrarAlumno (alumno.get(i));


		}

		}
}
