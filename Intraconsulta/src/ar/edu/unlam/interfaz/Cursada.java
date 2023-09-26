package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Cursada {

	private ArrayList<AsignacionProfeACurso> asignacionProfesor;
	private Universidad unlam;
	private Materia materia;
	private Integer comision;
	private Horario horarios;
	private Integer cupoMaximoAlumnos;
	private Dia dias;
	private Aula aula;
	private CicloElectivo cicloElectivo;
	private Integer cantidadAlumnosAnotados;
	private static Integer id = 0;

	public Cursada(Materia materia, Integer comision, Horario horarios, Dia dias, Integer cupoMaximoAlumnos,
			Universidad universidad, CicloElectivo cicloElectivo) {

		this.asignacionProfesor = new ArrayList<AsignacionProfeACurso>();
		this.materia = materia;
		this.comision = comision;
		this.dias = dias;
		this.horarios = horarios;
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
		this.cantidadAlumnosAnotados = 0;
		this.unlam = universidad;
		this.cicloElectivo = cicloElectivo;
		id++;
	}

	public Integer getCupoMaximoAlumnos() {
		return cupoMaximoAlumnos;
	}

	public void setCupoMaximoAlumnos(Integer cupoMaximoAlumnos) {
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
	}

	public Integer getCantidadAlumnosAnotados() {
		return cantidadAlumnosAnotados;
	}

	public Universidad getUnlam() {
		return unlam;
	}

	public void setUnlam(Universidad unlam) {
		this.unlam = unlam;
	}

	public void setCantidadAlumnosAnotados(Integer cantidadAlumnosAnotados) {
		this.cantidadAlumnosAnotados = cantidadAlumnosAnotados;
	}

	public Materia getMateria() {
		return materia;
	}

	public Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		Cursada.id = id;
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



	public ArrayList<AsignacionProfeACurso> getAsignacionProfesor() {
		return asignacionProfesor;
	}

	public void setAsignacionProfesor(AsignacionProfeACurso asignacionProfesor) {
		this.asignacionProfesor.add(asignacionProfesor);
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

	public void AgregarCicloElectivo(CicloElectivo cicloElectivo) {

		this.cicloElectivo = cicloElectivo;

	}


	public void AgregarAula(Aula aula) {
		if (cupoMaximoAlumnos <= Aula.getCapacidadMaximaAlumnos())
			this.aula = aula;
	}

	
}