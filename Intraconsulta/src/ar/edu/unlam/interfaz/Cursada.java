package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Cursada {

	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;
	private Profesor profesor;
	private Materia materia;
	private Integer comision;
	private Horario horarios;
	private Integer cupoMaximoAlumnos;
	private Dia dias;
	private Aula aula;
	private CicloElectivo cicloElectivo;

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
		this.profesor = profesor;
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	/*
	 * public void calificar(Integer valor) {
	 * 
	 * nota.asignarValor(valor);
	 * 
	 * 
	 * }
	 */

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

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
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
		Integer cantidadAlumnos = 0;
		for (int i = 0; i < alumnos.size(); i++) {
			cantidadAlumnos++;

		}
		return cantidadAlumnos;
	}
	
	public Integer cantidadDeProfesoresPorCursoRequerido() {
		Integer ProfesoresRequeridos=(cantidadAlumnosAnotados()/20)+1;
		return ProfesoresRequeridos;
		
	}
	

}
