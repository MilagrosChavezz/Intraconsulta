package ar.edu.unlam.interfaz;

public class Aula {

	private static Integer capacidadMaximaAlumnos;
	private Integer numeroAula;
	private static Integer id = 0;

	public Aula(Integer numeroAula, Integer capacidadMaximaAlumnos) {
		super();
		this.numeroAula = numeroAula;
		Aula.capacidadMaximaAlumnos = capacidadMaximaAlumnos;
		id++;
	}

	public static Integer getCapacidadMaximaAlumnos() {
		return capacidadMaximaAlumnos;
	}

	public static void setCapacidadMaximaAlumnos(Integer capacidadMaximaAlumnos) {
		Aula.capacidadMaximaAlumnos = capacidadMaximaAlumnos;
	}

	public Integer getNumeroAula() {
		return numeroAula;
	}

	public void setNumeroAula(Integer numeroAula) {
		this.numeroAula = numeroAula;
	}

}