package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Iterator;

public class Cursada {

	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private ArrayList<AsignacionAlumnoACurso> asignacionAlumnos;
	private Profesor profesor;
	private Materia materia;
	private Integer comision;
	private Horario horarios;
	private Integer cupoMaximoAlumnos;
	private Dia dias;
	private Aula aula;
	private CicloElectivo cicloElectivo;
	private AsignacionProfeACurso profesorAAgregar;
	private Integer cantidadAlumnosAnotados;
	private Integer cantidadDeProfesoresEnCursada;

	public Integer getCupoMaximoAlumnos() {
		return cupoMaximoAlumnos;
	}

	public void setCupoMaximoAlumnos(Integer cupoMaximoAlumnos) {
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
	}

	public Cursada(Materia materia, Integer comision, Horario horarios, Dia dias, Aula aula,
			CicloElectivo cicloElectivo, Integer cupoMaximoAlumnos) {
		this.alumnos = new ArrayList<Alumno>();
		this.materia = materia;
		this.comision = comision;
		this.profesores = new ArrayList<Profesor>();
		this.aula = aula;
		this.cicloElectivo = cicloElectivo;
		this.dias = dias;
		this.horarios = horarios;
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
		this.cantidadAlumnosAnotados = 0;
		this.cantidadDeProfesoresEnCursada = 0;
	}

//constructor sin aula
	public Cursada(Materia materia, Integer comision, Horario horarios, Dia dias, CicloElectivo cicloElectivo,
			Integer cupoMaximoAlumnos) {
		this.alumnos = new ArrayList<Alumno>();
		this.materia = materia;
		this.comision = comision;
		this.profesores = new ArrayList<Profesor>();
		this.cicloElectivo = cicloElectivo;
		this.dias = dias;
		this.horarios = horarios;
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
		this.cantidadAlumnosAnotados = 0;
		this.cantidadDeProfesoresEnCursada = 0;

	}

	public Integer getCantidadAlumnosAnotados() {
		return cantidadAlumnosAnotados;
	}

	public void setCantidadAlumnosAnotados(Integer cantidadAlumnosAnotados) {
		this.cantidadAlumnosAnotados = cantidadAlumnosAnotados;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Integer getComision() {
		return comision;
	}

	public void setComision(Integer comision) {
		this.comision = comision;
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Profesor profesor) {
		profesores.add(profesor);
	}

	public void setAlumnos(Alumno alumnoAsignar) {
		alumnos.add(alumnoAsignar);
	}

	public Horario getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario horarios) {
		this.horarios = horarios;
	}

	public Dia getDias() {
		return dias;
	}

	public void setDias(Dia dias) {
		this.dias = dias;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public CicloElectivo getCicloElectivo() {
		return cicloElectivo;
	}

	public void setCicloElectivo(CicloElectivo cicloElectivo) {
		this.cicloElectivo = cicloElectivo;
	}

	public Integer cantidadAlumnosAnotados() {

		cantidadAlumnosAnotados = alumnos.size();
		return cantidadAlumnosAnotados;
	}

	public Integer cantidadDeProfesoresPorCursoRequerido() {
		Integer ProfesoresRequeridos = (cantidadAlumnosAnotados() / 20) + 1;
		return ProfesoresRequeridos;

	}

	public Integer cantidadDeProfesoresActuales() {

		cantidadDeProfesoresEnCursada = profesores.size();

		return cantidadDeProfesoresEnCursada;
	}

	public void AgregarAula(Aula aula) {
		if (cupoMaximoAlumnos <= Aula.getCapacidadMaximaAlumnos())
			this.aula = aula;
	}

	public Alumno buscarAlumnoPorDni(Integer dniAlumno) {
		Alumno alumnosBuscado = null;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni().equals(dniAlumno) && alumnos.get(i) != null) {
				alumnosBuscado = alumnos.get(i);
			}

		}
		return alumnosBuscado;

	}
}