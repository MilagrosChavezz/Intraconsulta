package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Universidad {
	private String nombre;
	private ArrayList<Aula> aulas;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Cursada> cursadas;
	private ArrayList<Profesor> profesores;
	
	public Universidad(String nombre) {
		super();
		this.nombre = nombre;
		this.aulas = new ArrayList<Aula>();
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
		this.cursadas=new ArrayList<Cursada>();
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
	
	private Boolean agregarCurso(Cursada nuevo) {
		if (!cursadas.contains(nuevo)) {
			cursadas.add(nuevo);
			return true;
		}
		return false;
	}
	
	private Boolean agregarAlumno(Alumno nuevo) {
		if (!alumnos.contains(nuevo)) {
			alumnos.add(nuevo);
			return true;
		}
		return false;
	}

	private boolean ingresarProfesorALaUniversidad(Profesor profesoraAsignar) {
		if (!profesores.contains(profesoraAsignar)) {
			profesores.add(profesoraAsignar);
			return true;
		}
		return false;
	}
	
	private boolean estaIngresadoALaUniversidad(Profesor profesoraAsignar) {
		Boolean seIngreso = false; 
		
		if(alumnos.contains(profesoraAsignar)) {
			seIngreso = true;
		}
		return seIngreso;
	}
}
