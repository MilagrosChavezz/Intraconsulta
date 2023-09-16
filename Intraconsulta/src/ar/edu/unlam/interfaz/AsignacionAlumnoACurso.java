package ar.edu.unlam.interfaz;

import java.time.LocalDate;
import java.util.ArrayList;

public class AsignacionAlumnoACurso {

	private static Integer id;
	private Cursada curso;
	private Alumno alumno;
	private Universidad unlam;
	private ArrayList<Nota> notas;
	private ArrayList<Materia> materiasCorrelaAprobadas;
	private LocalDate diaDeInscripcion;

	public AsignacionAlumnoACurso(Integer id, Cursada curso, Alumno alumno, Universidad universidad) {
		super();
		id++;
		this.curso = curso;
		this.alumno = alumno;
		this.unlam = universidad;
		this.materiasCorrelaAprobadas = new ArrayList<Materia>();

		this.notas = new ArrayList<Nota>();

	}

	public ArrayList<Materia> getMateriasAprobadas() {
		return materiasCorrelaAprobadas;
	}

	public void setMateriasAprobadas(ArrayList<Materia> materiasAprobadas) {
		this.materiasCorrelaAprobadas = materiasAprobadas;
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

<<<<<<< Updated upstream
	public void AgregarNota(Nota notaNueva) {
		if (notaNueva != null)
			notas.add(notaNueva);

=======
	public Boolean AgregarNota(Nota notaNueva) {
		if (aproboCorrelativas()) {
			this.notas.add(notaNueva);
			return true;
		}
		return false;
>>>>>>> Stashed changes
	}

	public ArrayList<Materia> getMateriasCorrelaAprobadas() {
		return materiasCorrelaAprobadas;
	}

	public void setMateriasCorrelaAprobadas(ArrayList<Materia> materiasCorrelaAprobadas) {
		this.materiasCorrelaAprobadas = materiasCorrelaAprobadas;
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


	public Boolean inscribirAlumno(Alumno alumnoAsignar, Cursada cursada) {
		boolean sePuedeInscribir = false;

		if (curso.cantidadAlumnosAnotados() <= curso.getCupoMaximoAlumnos()
<<<<<<< Updated upstream
				&& !curso.getAlumnos().contains(alumnoAsignar) && aproboCorrelativas() && unlam.estaIngresadoALaUniversidadAlumno(alumnoAsignar)) {
			cursada.setAlumnos(alumnoAsignar);
			sePuedeInscribir = true;
=======
				&& !curso.getAlumnos().contains(alumnoAsignar)
				&& unlam.estaIngresadoALaUniversidadAlumno(alumnoAsignar) && inscripcionDentroDeFecha()) {
			if (aproboCorrelativas() || adeudaCorrelativas() || !recursa()) {
				cursada.setAlumnos(alumnoAsignar);
				sePuedeInscribir = true;
			}
>>>>>>> Stashed changes
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
				break;
			}
		}

		return notaBuscada;
	}

	public Boolean aprobarRecuperatorio(/* Evaluacion evaluacionNota */) {
		Boolean recuperaPrimerParcial = recuperaPrimerParcial();
		Boolean recuperaSegundoParcial = recuperaSegundoParcial();
		// Nota notaBuscada= buscarNotas( evaluacionNota);
		 Nota notaACambiar=buscarNotas(Evaluacion.PRIMER_PARCIAL);
		 Nota notaACambiarSegundo=buscarNotas(Evaluacion.SEGUNDO_PARCIAL);

		 //si la nota del recuperatorio es mayor a 7 se aprueba el 1ro o 2do parcial
		if (recuperaPrimerParcial) {
			for (int i = 0; i < notas.size(); i++) {
				if (notas.get(i).getValor() >= 7 && notas.get(i).getEvaluacion().equals(Evaluacion.RECUPERATORIO)) {

					notaACambiar = notas.get(i);
					return true;
				}
			}
		} else {
			for (int i = 0; i < notas.size(); i++) {
				if (notas.get(i).getValor() >= 7 && notas.get(i).getEvaluacion().equals(Evaluacion.RECUPERATORIO)) {

					notaACambiarSegundo = notas.get(i);
					return true;
				}
			}
		}
		return false;
	}

<<<<<<< Updated upstream
=======
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

>>>>>>> Stashed changes
	public Boolean promocionaMateria() {
		if (apruebaSegundoParcial() && apruebaPrimerParcial() && aproboCorrelativas()) {
			alumno.setMateriasAprobadas(curso.getMateria());
			return true;
		}
		return false;
	}

<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes

	public Boolean aproboCorrelativas() {
		ArrayList<Integer> correlativasRequeridas = curso.getMateria().getCorrelativas();
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

		if (correlativasRequeridas.equals(null)) {
			return true; // Si todas las correlativas requeridas se encuentran, retornar true
		}
		return true;
	}

<<<<<<< Updated upstream

}
=======
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
>>>>>>> Stashed changes
