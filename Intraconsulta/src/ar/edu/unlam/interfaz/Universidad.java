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
	private ArrayList<AsignacionProfeACurso> asignacionesProfesores;
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
		this.asignacionesProfesores = new ArrayList<AsignacionProfeACurso>();
	}

	public ArrayList<AsignacionProfeACurso> getAsignacionesProfesores() {
		return asignacionesProfesores;
	}

	public void setAsignacionesProfesores(AsignacionProfeACurso asignacionesProfesores) {
		this.asignacionesProfesores.add(asignacionesProfesores);
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
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
		if (buscarAula(nueva.getId()) == null) {
			aulas.add(nueva);
			return true;
		}
		return false;
	}

	public Aula buscarAula(Integer codigoAula) {
		Aula aulaBuscada = null;
		for (int i = 0; i < aulas.size(); i++) {
			if (aulas.get(i).getId().equals(codigoAula)) {
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

		if (alumnoBuscado != null && comisionBuscada != null
				&& cantidadAlumnosAnotados(idComision) <= comisionBuscada.getCupoMaximoAlumnos()
				&& buscarAlumno(dni) != null && inscripcionDentroDeFecha(dni, idComision)
				&& aproboCorrelativas(dni, comisionBuscada.getMateria().getCodigoMateria())
				&& BuscarasignacionesDeUnAlumno(dni, idComision) == null) {
			AsignacionAlumnoACurso asignacion = new AsignacionAlumnoACurso(comisionBuscada, alumnoBuscado);
			agregarAsignacion(asignacion);
			return true;

		}
		return false;
	}

	public Integer cantidadDeProfesoresPorCursoRequerido(Integer idCursada) {
		Integer ProfesoresRequeridos = (cantidadAlumnosAnotados(idCursada) / 20) + 1;
		return ProfesoresRequeridos;
	}

	public Boolean aproboCorrelativas(Integer dni, Integer idMateria) {
		AsignacionAlumnoACurso asignacion = BuscarasignacionesDeUnAlumno(dni, idMateria);

		if (asignacion != null && asignacion.aproboCorrelativas()) {
			return true;
		}

		Materia materia = buscarMateria(idMateria);
		if (materia != null && (materia.getCorrelativas() == null || materia.getCorrelativas().isEmpty())) {
			return true;
		}

		return false;
	}

	public AsignacionAlumnoACurso BuscarasignacionesDeUnAlumno(Integer dni, Integer idMateria) {

		for (AsignacionAlumnoACurso alumno : asignaciones) {
			if (alumno.getAlumno().getDni().equals(dni) && alumno.getCurso().getMateria().getId().equals(idMateria)) {
				return alumno;
			}
		}
		return null;
	}

	public Boolean inscripcionDentroDeFecha(Integer dni, Integer idComision) {

		if (BuscarCursada(idComision).getCicloElectivo().getFechaInicioInscripcion()
				.compareTo(buscarAlumno(dni).getFechaIngreso()) < 0
				&& BuscarCursada(idComision).getCicloElectivo().getFechaFinalizacionInscripcion()
						.compareTo(buscarAlumno(dni).getFechaIngreso()) > 0) {
			return true;
		}
		return false;
	}

	public Integer cantidadAlumnosAnotados(Integer idCursada) {
		Integer cantidadAlumnosAnotados = 0;
		for (AsignacionAlumnoACurso alumnosEnCursada : asignaciones) {
			if (alumnosEnCursada.getCurso().getId().equals(idCursada)) {
				cantidadAlumnosAnotados++;
			}

		}
		return cantidadAlumnosAnotados;
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
				&& cantidadDeProfesoresPorCursoRequerido(idComision) > cantidadProfesoresEnAsignacion(idComision)
				&& nueva.asignarProfesorACurso()) {
			profesorBuscado.seAgregaCursadaActual(cursadaBuscada);

			setAsignacionesProfesores(nueva);

			return true;
		}
		return false;

	}

	public Integer cantidadProfesoresEnAsignacion(Integer idComision) {
		Integer cantidadProfesoresEnUnaComison = 0;
		for (AsignacionProfeACurso profesor : asignacionesProfesores) {
			if (profesor.getCurso().getId().equals(idComision)) {
				cantidadProfesoresEnUnaComison++;
			}
		}
		return cantidadProfesoresEnUnaComison;
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

	public Boolean promociono(Integer dni, Integer idCursada) {
		AsignacionAlumnoACurso asignacion = buscarAsignacion(idCursada, dni);
		Boolean asignacionResultado = asignacion.promocionaMateria();
		if (asignacionResultado) {

			return true;
		}
		return false;
	}

	public Boolean recurso(Integer dni, Integer idCursada) {

		AsignacionAlumnoACurso asignacion = buscarAsignacion(idCursada, dni);
		if (asignacion.recursa()) {
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

	public Integer cantidadAlumnosPromocionados(Integer idComision) {
		Integer cantidadAlumnosPromocionados = 0;
		Cursada cursadaBuscada = BuscarCursada(idComision);

		for (AsignacionAlumnoACurso alumno : asignaciones) {

			if (cursadaBuscada != null && alumno.promocionaMateria())
				cantidadAlumnosPromocionados++;
		}

		return cantidadAlumnosPromocionados;
	}

	public Integer cantidadAlumnosReprobados(Integer idComision) {

		Integer cantidadAlumnosReprobados = 0;
		Cursada cursadaBuscada = BuscarCursada(idComision);

		for (AsignacionAlumnoACurso alumno : asignaciones) {

			if (cursadaBuscada != null && alumno.recursa())
				cantidadAlumnosReprobados++;
		}

		return cantidadAlumnosReprobados;
	}

	public Integer cantidadAlumnosAFinal(Integer idComision) {

		Integer cantidadAlumnosAFinal = 0;
		Cursada cursadaBuscada = BuscarCursada(idComision);

		for (AsignacionAlumnoACurso alumno : asignaciones) {

			if (cursadaBuscada != null && alumno.debeIrAFinal())
				cantidadAlumnosAFinal++;
		}

		return cantidadAlumnosAFinal;
	}

	public ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer dniAlumno) {
		Alumno alumnoBuscado = buscarAlumno(dniAlumno);

		ArrayList<Materia> materiasAprobadas = alumnoBuscado.getMateriasAprobadas();
		ArrayList<Materia> todasLasMaterias = getMaterias();

		ArrayList<Materia> materiasQueFaltanCursar = new ArrayList<>(todasLasMaterias);
		if (alumnoBuscado != null) {
			materiasQueFaltanCursar.removeAll(materiasAprobadas);
		}

		return materiasQueFaltanCursar;
	}
}