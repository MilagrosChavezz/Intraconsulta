package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class AsignacionAlumnoACurso {

	private Integer id;
	private Cursada curso;
	private Alumno alumno;
	private Universidad unlam;
	private ArrayList<Nota> notas;
	private Materia materia;
	private ArrayList<Materia> materiasCorrelaAprobadas;

	public AsignacionAlumnoACurso(Integer id, Cursada curso, Alumno alumno, Universidad universidad, Nota nota) {
		super();
		this.id = id;
		this.curso = curso;
		this.alumno = alumno;
		this.unlam = universidad;
		this.materiasCorrelaAprobadas = new ArrayList<Materia>();
		this.notas = new ArrayList<Nota>();
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

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
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
				&& !curso.getAlumnos().contains(alumnoAsignar)) {
			cursada.setAlumnos(alumnoAsignar);
			sePuedeInscribir = true;
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

	public Boolean aprobarRecuperatorio() {
		Boolean recuperaPrimerParcial = recuperaPrimerParcial();
		Boolean recuperaSegundoParcial = recuperaSegundoParcial();

		if (recuperaPrimerParcial || recuperaSegundoParcial) {
			for (int i = 0; i < notas.size(); i++) {
				if (notas.get(i).getValor() >= 7 && notas.get(i).getEvaluacion().equals(Evaluacion.RECUPERATORIO)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean promocionaMateria() {
		if (apruebaSegundoParcial() && apruebaPrimerParcial() || aprobarRecuperatorio()) {
			alumno.setMateriasAprobadas(curso.getMateria());
			return true;
		}
		return false;
	}
<<<<<<< Updated upstream
}
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

	public Boolean apruebaFinal() {
		if (debeIrAFinal() && buscarNota(Evaluacion.FINAL) != null && buscarNota(Evaluacion.FINAL).getValor() >= 4) {

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
					break;
				}
			}

			if (!encontrada) {
				return false;
			}
		}

		return true;
	}

	public Boolean adeudaCorrelativas() {
		ArrayList<Integer> correlativasRequeridas = curso.getMateria().getCorrelativas();

		if (correlativasRequeridas == null) {
			return false;
		}

		ArrayList<Materia> materiasAdeudaAlumno = alumno.getMateriasAFinal();

		for (int i = 0; i < correlativasRequeridas.size(); i++) {
			Integer correlativaRequerida = correlativasRequeridas.get(i);
			boolean encontrada = false;

			for (int j = 0; j < materiasAdeudaAlumno.size(); j++) {
				Materia materiasAdeuda = materiasAdeudaAlumno.get(j);
				if (materiasAdeuda.getCodigoMateria().equals(correlativaRequerida)) {
					encontrada = true;
					break;
				}
			}

			if (!encontrada) {
				return false;
			}
		}

		return true;
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
