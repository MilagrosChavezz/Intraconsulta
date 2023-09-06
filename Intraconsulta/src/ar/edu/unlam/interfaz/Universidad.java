package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Universidad {
	private ArrayList<Aula> aulas;
	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;

	public Universidad(String nombre) {
		super();
		this.aulas = new ArrayList<Aula>();
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
	}

	public ArrayList<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(ArrayList<Aula> aulas) {
		this.aulas = aulas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	private Boolean agregarAula(Aula nueva) {
		if (!aulas.contains(nueva)) {
			aulas.add(nueva);
			return true;
		}
		return false;
	}

	private Boolean agregarMateria(Materia nueva) {
		if (!materias.contains(nueva)) {
			materias.add(nueva);
			return true;
		}
		return false;
	}

}
