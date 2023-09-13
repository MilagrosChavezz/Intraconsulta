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
		this.cursadas = new ArrayList<Cursada>();
		this.profesores = new ArrayList<Profesor>();
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

	public Boolean agregarAula(Aula nueva) {
		if (!aulas.contains(nueva) && nueva != null) {
			aulas.add(nueva);
			return true;
		}
		return false;
	}

	public Boolean agregarMateria(Materia nueva) {
		if (!materias.contains(nueva) && nueva != null) {
			materias.add(nueva);
			return true;
		}
		return false;
	}

	public Boolean agregarCurso(Cursada nuevo) {
		if (!cursadas.contains(nuevo) && nuevo != null) {
			cursadas.add(nuevo);
			return true;
		}
		return false;
	}

	public Boolean agregarAlumno(Alumno nuevo) {
		if (!alumnos.contains(nuevo) && nuevo != null) {
			alumnos.add(nuevo);
			return true;
		}
		return false;
	}

	public boolean ingresarProfesorALaUniversidad(Profesor profesoraAsignar) {
		if (!profesores.contains(profesoraAsignar) && profesoraAsignar != null) {
			profesores.add(profesoraAsignar);
			return true;
		}
		return false;
	}

	public Boolean estaIngresadoALaUniversidad(Profesor profesoraABuscar) {
		return profesoraABuscar != null && profesores.contains(profesoraABuscar);
	}

	public Boolean estaIngresadoALaUniversidadAlumno(Alumno alumno) {
		return alumno != null && alumnos.contains(alumno);
	}

	public Boolean estaIngresadaLaCursada(Cursada cursada) {
		return cursada != null && cursadas.contains(cursada);
	}

	public Boolean asignarMateria(Materia materiaAsignada, Integer codigoMateria) {
		Boolean seAsignoMateria = false;
		if (!materias.contains(materiaAsignada) && !materiaAsignada.getCodigoMateria().equals(codigoMateria)) {
				materias.add(materiaAsignada);
				seAsignoMateria = true;
			}
		return seAsignoMateria;
	}
}