package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Iterator;

public class Cursada {

	private Universidad unlam;
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
	private static Integer id = 0;
	private Integer cantidadAlumnosPromocionados;
	private Integer cantidadAlumnosAFinal;
	private Integer cantidadAlumnosReprobados;

	public Integer getCupoMaximoAlumnos() {
		return cupoMaximoAlumnos;
	}

	public void setCupoMaximoAlumnos(Integer cupoMaximoAlumnos) {
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
	}

	// constructor sin aula se le asigna luego
	public Cursada(Materia materia, Integer comision, Horario horarios, Dia dias, Integer cupoMaximoAlumnos,
			Universidad universidad,CicloElectivo cicloElectivo) {
		this.alumnos = new ArrayList<Alumno>();
		this.materia = materia;
		this.comision = comision;
		this.profesores = new ArrayList<Profesor>();
		this.dias = dias;
		this.horarios = horarios;
		this.cupoMaximoAlumnos = cupoMaximoAlumnos;
		this.cantidadAlumnosAnotados = 0;
		this.cantidadDeProfesoresEnCursada = 0;
		this.cantidadAlumnosPromocionados = 0;
		this.cantidadAlumnosReprobados = 0;
		this.cantidadAlumnosAFinal = 0;
		this.unlam = universidad;
		this.cicloElectivo=cicloElectivo;
		id++;

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
		if (!profesores.contains(profesor))
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

	public void AgregarCicloElectivo(CicloElectivo cicloElectivo) {

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

	public Integer cantidadAlumnosPromocionados() {

		for (int i = 0; i < alumnos.size(); i++) {

			ArrayList<Materia> alumnosMateriasAprobadas = alumnos.get(i).getMateriasAprobadas();

			for (int j = 0; j < alumnosMateriasAprobadas.size(); j++) {

				if (alumnos.get(j).getMateriasAprobadas().get(j).getNombre().equals(materia.getNombre())) {
					cantidadAlumnosPromocionados++;

				}
			}

		}
		return cantidadAlumnosPromocionados;
	}

	public Integer cantidadAlumnosAfinal() {

		for (int i = 0; i < alumnos.size(); i++) {

			ArrayList<Materia> alumnosMateriasAFinal = alumnos.get(i).getMateriasAFinal();

			for (int j = 0; j < alumnosMateriasAFinal.size(); j++) {

				if (alumnos.get(j).getMateriasAFinal().get(j).getNombre().equals(materia.getNombre())) {
					cantidadAlumnosAFinal++;

				}
			}

		}
		return cantidadAlumnosAFinal;
	}

	public Integer cantidadAlumnosReprobados() {

		cantidadAlumnosReprobados = cantidadAlumnosAnotados - cantidadAlumnosAfinal() - cantidadAlumnosPromocionados();
		return cantidadAlumnosReprobados;

	}
}
