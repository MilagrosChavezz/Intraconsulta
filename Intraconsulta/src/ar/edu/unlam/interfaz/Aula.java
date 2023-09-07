package ar.edu.unlam.interfaz;

public class Aula {

	private static Integer capacidadMaximaAlumnos;
	private Integer numeroAula;

	public Aula(Integer numeroAula) {
		super();
		this.numeroAula = numeroAula;
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
