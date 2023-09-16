package ar.edu.unlam.interfaz;

import java.util.ArrayList;
import java.util.Iterator;

public class AsignacionAlumnoACurso {
	private Cursada curso;
	private Alumno alumno;
	private Universidad unlam;
	private ArrayList<Nota> notas;
	private ArrayList<Materia> materiasCorrelaAprobadas;
	private Integer capacidadMaximaAlumnos;
	private static Integer id = 0;

	public AsignacionAlumnoACurso(Integer capacidadMaximaAlumnos, Cursada curso, Alumno alumno,
			Universidad universidad) {
		super();
		this.curso = curso;
		this.alumno = alumno;
		this.unlam = universidad;
		this.capacidadMaximaAlumnos = capacidadMaximaAlumnos;
		this.materiasCorrelaAprobadas = new ArrayList<Materia>();
		this.notas = new ArrayList<Nota>();
		id++;

	}

	public Integer getCapacidadMaximaAlumnos() {
		return capacidadMaximaAlumnos;
	}

	public void setCapacidadMaximaAlumnos(Integer capacidadMaximaAlumnos) {
		this.capacidadMaximaAlumnos = capacidadMaximaAlumnos;
	}

	public static Integer getId() {
		return id;
	}

	public static void setId(Integer id) {
		AsignacionAlumnoACurso.id = id;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasCorrelaAprobadas;
	}

	public Universidad getUnlam() {
		return unlam;
	}

	public void setUnlam(Universidad unlam) {
		this.unlam = unlam;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void AgregarNota(Nota notaNueva) {
		this.notas.add(notaNueva);
	}

	public ArrayList<Materia> getMateriasCorrelaAprobadas() {
		return materiasCorrelaAprobadas;
	}

	public void setMateriasCorrelaAprobadas(ArrayList<Materia> materiasCorrelaAprobadas) {
		this.materiasCorrelaAprobadas = materiasCorrelaAprobadas;
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

	public Boolean inscribirAlumno(Alumno alumnoAsignar, Cursada cursada) {
		boolean sePuedeInscribir = false;

		if (curso.cantidadAlumnosAnotados() <= curso.getCupoMaximoAlumnos()
				&& !curso.getAlumnos().contains(alumnoAsignar) && unlam.estaIngresadoALaUniversidadAlumno(alumnoAsignar)
				&& inscripcionDentroDeFecha()) {
			if (aproboCorrelativas() || adeudaCorrelativas() || !recursa()) {
				cursada.setAlumnos(alumnoAsignar);
				sePuedeInscribir = true;
			}
		}
		return sePuedeInscribir;
	}

	public Boolean apruebaPrimerParcial() {
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getValor() >= 7 && notas.get(i).getEvaluacion().equals(Evaluacion.PRIMER_PARCIAL)) {
				return true;
			}
		}
		return false;
	}

	public Boolean apruebaSegundoParcial() {
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getValor() >= 7 && notas.get(i).getEvaluacion().equals(Evaluacion.SEGUNDO_PARCIAL)) {
				return true;
			}
		}
		return false;
	}

	public Boolean recuperaPrimerParcial() {
		if (!apruebaPrimerParcial()) {
			return true;
		}
		return false;
	}

	public Boolean recuperaSegundoParcial() {
		if (!apruebaSegundoParcial()) {
			return true;
		}
		return false;
	}

	public Nota buscarNotas(Evaluacion evaluacionNota) {
		Nota notaBuscada = null;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getEvaluacion().equals(evaluacionNota)) {
				notaBuscada = notas.get(i);

			}
		}
		return notaBuscada;

	}

	public Boolean aprobarRecuperatorio() {

		Nota notaBuscada = buscarNotas(Evaluacion.RECUPERATORIO);

		// si la nota del recuperatorio es mayor a 7 se aprueba el 1ro o 2do parcial
		if (recuperaPrimerParcial()) {

			if (notaBuscada.getValor() >= 7) {

				asignarNotaRecuperatorio(Evaluacion.PRIMER_PARCIAL, notaBuscada);
				return true;
			}

			if (recuperaSegundoParcial()) {

				if (notaBuscada.getValor() >= 7) {

					asignarNotaRecuperatorio(Evaluacion.SEGUNDO_PARCIAL, notaBuscada);
					return true;
				}

			}
		}
		return false;
	}

	public void asignarNotaRecuperatorio(Evaluacion parcial, Nota notaDelRecuperatorio) {
		// TODO Auto-generated method stub
		Nota notaACambiar = buscarNotas(parcial);
		if (notaACambiar != null)
			notaACambiar.asignarValor(notaDelRecuperatorio.getValor());

	}

	public Integer obtenerNotaFinal(Nota primerParcial, Nota segundoParcial) {
		Integer notaFinal = ((primerParcial.getValor() + segundoParcial.getValor()) / 2);
		return notaFinal;
	}

	public Boolean promocionaMateria() {
		if (apruebaSegundoParcial() && apruebaPrimerParcial() && aproboCorrelativas()) {
			alumno.setMateriasAprobadas(curso.getMateria());
			return true;
		}
		return false;
	}

	public Boolean debeIrAFinal() {

		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getEvaluacion().equals(Evaluacion.PRIMER_PARCIAL) && notas.get(i).getValor() >= 4
					&& notas.get(i).getValor() <= 6 && notas.get(i).getEvaluacion().equals(Evaluacion.SEGUNDO_PARCIAL)
					&& notas.get(i).getValor() >= 4 && notas.get(i).getValor() <= 6) {
				alumno.setMateriasAFinal(curso.getMateria());
				return true;

			}
		}
		return false;

	}

	public Boolean recursa() {

		if (!debeIrAFinal() && !promocionaMateria()) {
			return true;
		}
		return false;

	}

	public Boolean aproboCorrelativas() {
		ArrayList<Integer> correlativasRequeridas = curso.getMateria().getCorrelativas();

		if (correlativasRequeridas == null) {
			return true; // No hay correlativas requeridas, por lo tanto, se considera aprobado
		}

		ArrayList<Materia> materiasAprobadasPorAlumno = alumno.getMateriasAprobadas();

		for (int i = 0; i < correlativasRequeridas.size(); i++) {
			Integer correlativaRequerida = correlativasRequeridas.get(i);
			boolean encontrada = false;

			for (int j = 0; j < materiasAprobadasPorAlumno.size(); j++) {
				Materia materiaAprobada = materiasAprobadasPorAlumno.get(j);
				if (materiaAprobada.getCodigoMateria().equals(correlativaRequerida)) {
					encontrada = true;
					break; // Salir del bucle interno si se encuentra la correlativa requerida
				}
			}

			if (!encontrada) {
				return false;
			}
		}

		return true; // Si todas las correlativas requeridas se encuentran, retornar true
	}

	public Boolean adeudaCorrelativas() {
		ArrayList<Integer> correlativasRequeridas = curso.getMateria().getCorrelativas();

		if (correlativasRequeridas == null) {
			return true; // No hay correlativas requeridas, por lo tanto, se considera aprobado
		}

		ArrayList<Materia> materiasAdeudaAlumno = alumno.getMateriasAFinal();

		for (int i = 0; i < correlativasRequeridas.size(); i++) {
			Integer correlativaRequerida = correlativasRequeridas.get(i);
			boolean encontrada = false;

			for (int j = 0; j < materiasAdeudaAlumno.size(); j++) {
				Materia materiasAdeuda = materiasAdeudaAlumno.get(j);
				if (materiasAdeuda.getCodigoMateria().equals(correlativaRequerida)) {
					encontrada = true;
					break; // Salir del bucle interno si se encuentra la correlativa requerida
				}
			}

			if (!encontrada) {
				return false;
			}
		}

		return true; // Si todas las correlativas requeridas se encuentran, retornar true
	}

	public Boolean inscripcionDentroDeFecha() {

		if (curso.getCicloElectivo().getFechaInicioInscripcion().compareTo(alumno.getFechaIngreso()) < 0
				&& curso.getCicloElectivo().getFechaFinalizacionInscripcion().compareTo(alumno.getFechaIngreso()) > 0) {
			return true;
		}
		return false;

	}
}