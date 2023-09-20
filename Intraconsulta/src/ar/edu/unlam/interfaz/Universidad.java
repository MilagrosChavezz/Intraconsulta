package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class Universidad {
	private String nombre;
	private ArrayList<Aula> aulas;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Cursada> cursadas;
	private ArrayList<Profesor> profesores;
	private ArrayList<AsignacionAlumnoACurso> asignaciones;
	private ArrayList<CicloElectivo> ciclosElectivos;

	public Universidad(String nombre) {
		super();
		this.nombre = nombre;
		this.aulas = new ArrayList<Aula>();
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
		this.cursadas = new ArrayList<Cursada>();
		this.profesores = new ArrayList<Profesor>();
		this.ciclosElectivos = new ArrayList<CicloElectivo>();
		this.asignaciones = new ArrayList<AsignacionAlumnoACurso>();
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
		if (buscarAula(nueva.getNumeroAula()) == null) {
			aulas.add(nueva);
			return true;
		}
		return false;
	}

	public Aula buscarAula(Integer codigoAula) {
		Aula aulaBuscada = null;
		for (int i = 0; i < aulas.size(); i++) {
			if (aulas.get(i).getNumeroAula().equals(codigoAula)) {
				aulaBuscada = aulas.get(i);
			}
		}
		return aulaBuscada;
	}

	public Boolean mismaCursada(Cursada curso) {

		for (int i = 0; i < cursadas.size(); i++) {
			if (cursadas.get(i).getComision().equals(curso.getComision())
					&& cursadas.get(i).getHorarios().equals(curso.getHorarios())
					&& cursadas.get(i).getMateria().equals(curso.getMateria())
					&& cursadas.get(i).getDias().equals(curso.getDias())) {

				return true;

			}
		}
		return false;

	}

	public Boolean agregarCurso(Cursada nuevo) {
		if (!cursadas.contains(nuevo) && nuevo != null && !mismaCursada(nuevo)) {
			cursadas.add(nuevo);
			return true;
		}
		return false;
	}

	public Boolean existeAlumno(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}

	public Alumno buscarAlumno(Integer dni) {
		Alumno alumnoBuscado = null;
		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni().equals(dni)) {
				alumnoBuscado = alumnos.get(i);
			}

		}
		return alumnoBuscado;
	}

	public Boolean agregarAlumno(Alumno nuevo) {
		if (!existeAlumno(nuevo.getDni()) && nuevo != null) {
			alumnos.add(nuevo);
			return true;
		}
		return false;
	}

	public Profesor existeProfesor(Integer codigoProfesor) {
		Profesor profesor = null;
		for (int i = 0; i < profesores.size(); i++) {

			if (profesores.get(i).getCodigoProfesor().equals(codigoProfesor)) {
				profesor = profesores.get(i);
			}
		}
		return profesor;
	}

	public boolean ingresarProfesorALaUniversidad(Profesor profesoraAsignar) {
		if (existeProfesor(profesoraAsignar.getCodigoProfesor()) == null) {
			profesores.add(profesoraAsignar);
			return true;
		}
		return false;
	}

	public Boolean existeMateria(Integer codigoMateria) {
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getCodigoMateria().equals(codigoMateria)) {
				return true;
			}
		}
		return false;
	}

	public Boolean agregarMateria(Materia materiaAsignada) {
		Boolean seAsignoMateria = false;
		if (!existeMateria(materiaAsignada.getCodigoMateria()) && materiaAsignada != null) {
			materias.add(materiaAsignada);
			seAsignoMateria = true;
		}
		return seAsignoMateria;
	}

	public Boolean existeCursada(Integer idCursada) {
		for (int i = 0; i < cursadas.size(); i++) {

			if (cursadas.get(i).getId().equals(idCursada)) {
				return true;
			}
		}
		return false;

	}

	public Boolean existeCicloElectivo(Integer IdCicloElectivo) {
		for (int i = 0; i < ciclosElectivos.size(); i++) {

			if (ciclosElectivos.get(i).getId().equals(IdCicloElectivo)) {
				return true;
			}
		}
		return false;

	}

	public Boolean existeCicloElectivoConLaMismaFecha(CicloElectivo nuevo) {
		for (int i = 0; i < ciclosElectivos.size(); i++) {

			if (ciclosElectivos.get(i).getfechaInicioCicloLectivo().compareTo(nuevo.getfechaInicioCicloLectivo()) == 0
					&& ciclosElectivos.get(i).getFechaFinalizacionCicloLectivo()
							.compareTo(nuevo.getFechaFinalizacionCicloLectivo()) == 0) {
				return true;
			}
		}

		return false;
	}

	public Boolean agregarCicloElectivo(CicloElectivo nuevo) {
		if (!existeCicloElectivo(nuevo.getId()) && nuevo != null && !existeCicloElectivoConLaMismaFecha(nuevo)) {
			ciclosElectivos.add(nuevo);
			return true;
		}
		return false;

	}

	public Materia buscarMateria(Integer idMateria) {
		Materia materiaBuscada = null;
		for (int i = 0; i < materias.size(); i++) {
			if (materias.get(i).getCodigoMateria().equals(idMateria)) {
				materiaBuscada = materias.get(i);
			}
		}
		return materiaBuscada;
	}

	public Boolean agregarCorrelatividad(Integer idMateria, Integer idCorrelativa) {

		if (existeMateria(idMateria) && existeMateria(idCorrelativa)) {
			Materia materiaDeCorrelativa = buscarMateria(idMateria);
			materiaDeCorrelativa.agregarMateriasCorrelativas(idCorrelativa);
			return true;
		}
		return false;

	}

	public Boolean eliminarCorrelatividad(Integer idMateria, Integer idCorrelativaAELiminar) {
		if (existeMateria(idMateria) && existeMateria(idCorrelativaAELiminar)) {
			Materia materiaDeCorrelativaAEliminar = buscarMateria(idMateria);
			materiaDeCorrelativaAEliminar.eliminarCorrelatividad(idCorrelativaAELiminar);
			return true;
		}
		return false;
	}

	public Boolean inscribirAlumnoACursada(Integer dni, Integer idComision) {
		Alumno alumnoBuscado = buscarAlumno(dni);
		Cursada comisionBuscada = BuscarCursada(idComision);
		AsignacionAlumnoACurso asignacion = buscarAsignacion(idComision, dni);

		if (alumnoBuscado != null && comisionBuscada != null && asignacion != null) {

			return asignacion.inscribirAlumno(alumnoBuscado, comisionBuscada);
		}
		return false;
	}

	public Boolean agregarAsignacion(AsignacionAlumnoACurso nueva) {
		if (nueva != null) {
			asignaciones.add(nueva);
			return true;
		}
		return false;
	}

	public Cursada BuscarCursada(Integer idComision) {
		Cursada comisionBuscada = null;
		for (int i = 0; i < cursadas.size(); i++) {

			if (cursadas.get(i).getId().equals(idComision)) {
				comisionBuscada = cursadas.get(i);
			}
		}
		return comisionBuscada;
	}

	public Boolean asignarProfesorAlaComision(Integer idComision, Integer codigoDocente) {
		Profesor profesorBuscado = existeProfesor(codigoDocente);
		Cursada cursadaBuscada = BuscarCursada(idComision);
		AsignacionProfeACurso nueva = new AsignacionProfeACurso(profesorBuscado, cursadaBuscada);
		if (profesorBuscado != null && cursadaBuscada != null
				&& nueva.asignarProfesorACurso(profesorBuscado, cursadaBuscada)) {
			return true;
		}
		return false;

	}

	public void asignarAulaAlaComision(Integer idComision, Integer idAula) {
		Cursada cursadaBuscada = BuscarCursada(idComision);
		Aula aulaBuscada = buscarAula(idAula);

		cursadaBuscada.AgregarAula(aulaBuscada);
	}

	public AsignacionAlumnoACurso buscarAsignacion(Integer idComision, Integer dniAlumno) {
		for (int i = 0; i < asignaciones.size(); i++) {
			AsignacionAlumnoACurso asignacion = asignaciones.get(i);
			if (asignacion.getCurso().getId().equals(idComision) && asignacion.getAlumno().getDni().equals(dniAlumno)) {
				return asignacion;
			}
		}
		return null;
	}

	public Boolean registrarNota(Integer idComision, Integer dniAlumno, Nota nota) {
		Cursada cursadaBuscada = BuscarCursada(idComision);
		Alumno alumnoBuscado = buscarAlumno(dniAlumno);

		if (buscarAsignacion(idComision, dniAlumno) != null) {
			AsignacionAlumnoACurso asignarNota = buscarAsignacion(idComision, dniAlumno);

			return asignarNota.AgregarNota(nota);
		}
		return false;
	}

	public ArrayList<Materia> materiasAprobadas(Integer dniAlumno) {
		Alumno alumnoBuscado = buscarAlumno(dniAlumno);
		ArrayList<Materia> materiasAprobadas = null;

		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnoBuscado != null) {
				materiasAprobadas = alumnos.get(i).getMateriasAprobadas();
			}
		}
		return materiasAprobadas;
	}

	public Integer obtenerNota(Integer dniAlumno, Integer idMateria, Integer idComision) {
		Materia materiaBuscada = BuscarMateria(idMateria);
		Alumno alumnoBuscado = buscarAlumno(dniAlumno);
		AsignacionAlumnoACurso asignacion = buscarAsignacion(idComision, dniAlumno);
		Integer notaFinal = null;

		if (asignacion != null && materiaBuscada != null && alumnoBuscado != null
				&& asignacion.getCurso().getMateria().getId().equals(idMateria)) {

			notaFinal = asignacion.obtenerNotaFinal();
		}
		return notaFinal;

	}
	
	public Boolean promociono(Integer dni ,Integer idCursada ) {
		AsignacionAlumnoACurso asignacion = buscarAsignacion(idCursada, dni);
		Boolean asignacionResultado=asignacion.promocionaMateria();
		if(asignacionResultado) {
			
			return true;
		}
		return false;
	}

	

	public Boolean recurso(Integer dni ,Integer idCursada ) {
		AsignacionAlumnoACurso asignacion = buscarAsignacion(idCursada, dni);
		if(asignacion.recursa()) {
			return true;
		}
		return false;
	}
	public Boolean adeudaMateria(Integer dni ,Integer idCursada ) {
		AsignacionAlumnoACurso asignacion = buscarAsignacion(idCursada, dni);
		if(asignacion.adeudaCorrelativas()) {
			return true;
		}
		return false;
	}

	private Materia BuscarMateria(Integer idMateria) {
		Materia materiaBuscada = null;
		for (int i = 0; i < materias.size(); i++) {

			if (materias.get(i).getId().equals(idMateria)) {
				materiaBuscada = materias.get(i);
			}
		}
		return materiaBuscada;
	}

public Integer cantidadAlumnosPromocionados( Integer idComision) {
		
		Cursada cursadaBuscada = BuscarCursada(idComision);
		Integer alumnosPromocionados = null;

		if (cursadaBuscada != null) {
			
		
			alumnosPromocionados = cursadaBuscada.cantidadAlumnosPromocionados();
		}

		return alumnosPromocionados;
	}


	public Integer cantidadAlumnosReprobados( Integer idComision) {
		
		Cursada cursadaBuscada = BuscarCursada(idComision);
		Integer alumnosReprobados = null;

		if (cursadaBuscada != null) {
			cursadaBuscada.cantidadAlumnosAnotados();
			alumnosReprobados = cursadaBuscada.cantidadAlumnosReprobados();
		}

		return alumnosReprobados;
	}

	public Integer cantidadAlumnosAFinal( Integer idComision) {
		
		Cursada cursadaBuscada = BuscarCursada(idComision);
		Integer alumnosAFinal = null;

		if (cursadaBuscada != null) {
			alumnosAFinal = cursadaBuscada.cantidadAlumnosAfinal();

		}
		return alumnosAFinal;
	}

	/*
	 * public ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer
	 * dniAlumno) { Alumno alumnoBuscado = buscarAlumno(dniAlumno);
	 * ArrayList<Materia> materiasQueFaltanCursar = null;
	 * 
	 * for (int i = 0; i < materias.size(); i++) { if (alumnoBuscado != null &&
	 * buscar) {
	 * materiasQueFaltanCursar.add(asignaciones.get(i).getCurso().getMateria()); } }
	 * return materiasQueFaltanCursar; }
	 */

}