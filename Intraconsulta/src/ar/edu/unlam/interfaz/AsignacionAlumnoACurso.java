package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class AsignacionAlumnoACurso {

	private Integer id;
	private Cursada curso;
	private Alumno alumno;

	private Universidad unlam;
	private Nota nota;

	public AsignacionAlumnoACurso(Integer id, Cursada curso, Alumno alumno, Universidad universidad, Nota nota) {
		super();
		this.id = id;
		this.curso = curso;
		this.alumno = alumno;
		this.unlam = universidad;
		this.nota = nota;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cursada getCurso() {
		return curso;
	}

	public void setCurso(Cursada curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/*
	 * public Boolean asignarAlumnoACurso(Profesor alumnoAsignar, Cursada cursada) {
	 * 
	 * if (estaDisponible(alumnoAsignar, cursada) &&
	 * unlam.estaIngresadaLaCursada(cursada) && alumnoAsignar != null &&
	 * unlam.estaIngresadoALaUniversidad(alumnoAsignar)) {
	 * alumno.seAgregaCursadaActual(cursada); cursada.setProfesores(alumnoAsignar);
	 * return true; } return false;
	 * 
	 * no se puede inscribir mas alumnos que la capacidad de aula }
	 */
	public Boolean inscribirAlumno(Alumno alumnoAsignar, Cursada cursada) {
		boolean sePuedeInscribir = false;

		if (curso.cantidadAlumnosAnotados() <= curso.getCupoMaximoAlumnos() && !curso.getAlumnos().contains(alumnoAsignar)) {
			cursada.setAlumnos(alumnoAsignar);
			sePuedeInscribir = true;
		}
		return sePuedeInscribir;
	}
}
