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

	public Boolean estaIngresadaLaCursada(Cursada cursada) {
		return cursada != null && cursadas.contains(cursada);
	}

<<<<<<< Updated upstream
=======
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

	public Materia BuscarMateria(Integer idMateria) {
		Materia materiaBuscada = null;

		for (int i = 0; i < materias.size(); i++) {

			if (materias.get(i).getId().equals(idMateria)) {
				materiaBuscada = materias.get(i);
			}
		}
		return materiaBuscada;
	}

	public Integer cantidadAlumnosPromocionados(Integer dniAlumno, Integer idComision) {
		Alumno alumnoBuscado = buscarAlumno(dniAlumno);
		Cursada cursadaBuscada = BuscarCursada(idComision);
		Integer alumnosPromocionados = null;

		if (cursadaBuscada != null && alumnoBuscado != null) {
			alumnosPromocionados = cursadaBuscada.cantidadAlumnosPromocionados();
		}

		return alumnosPromocionados;
	}

	public Integer cantidadAlumnosReprobados(Integer dniAlumno, Integer idComision) {
		Alumno alumnoBuscado = buscarAlumno(dniAlumno);
		Cursada cursadaBuscada = BuscarCursada(idComision);
		Integer alumnosReprobados = null;

		if (cursadaBuscada != null && alumnoBuscado != null) {
			alumnosReprobados = cursadaBuscada.cantidadAlumnosReprobados();
		}

		return alumnosReprobados;
	}

	public Integer cantidadAlumnosAFinal(Integer dniAlumno, Integer idComision) {
		Alumno alumnoBuscado = buscarAlumno(dniAlumno);
		Cursada cursadaBuscada = BuscarCursada(idComision);
		Integer alumnosAFinal = null;

		if (cursadaBuscada != null && alumnoBuscado != null) {
			alumnosAFinal = cursadaBuscada.cantidadAlumnosReprobados();

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

>>>>>>> Stashed changes
}
