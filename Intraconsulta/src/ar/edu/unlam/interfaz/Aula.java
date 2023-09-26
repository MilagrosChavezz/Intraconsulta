package ar.edu.unlam.interfaz;

public class Aula {

	private static Integer capacidadMaximaAlumnos;
	private Integer numeroAula;
	private Integer id; 

    private static Integer nextId = 1;

	public Aula(Integer numeroAula, Integer capacidadMaximaAlumnos) {
		this.numeroAula = numeroAula;
		Aula.capacidadMaximaAlumnos = capacidadMaximaAlumnos;
		  this.id = nextId;
	        nextId++;
	}

	public Integer getId() {
		return id;
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