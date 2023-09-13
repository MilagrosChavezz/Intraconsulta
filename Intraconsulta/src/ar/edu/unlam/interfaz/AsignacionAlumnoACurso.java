package ar.edu.unlam.interfaz;

import java.util.ArrayList;

public class AsignacionAlumnoACurso {
	private Integer id;
	private Cursada curso;
	private Alumno alumno;
	private Universidad unlam;
	private ArrayList<Nota> notas;
	private ArrayList<Materia> materiasCorrelaAprobadas;

	public AsignacionAlumnoACurso(Integer id, Cursada curso, Alumno alumno, Universidad universidad) {
		super();
		this.id = id;
		this.curso = curso;
		this.alumno = alumno;
		this.unlam = universidad;
		this.materiasCorrelaAprobadas = new ArrayList<Materia>();
		this.notas = new ArrayList<Nota>();

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
				&& !curso.getAlumnos().contains(alumnoAsignar) && aproboCorrelativas()
				&& unlam.estaIngresadoALaUniversidadAlumno(alumnoAsignar)) {
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

	public Boolean promocionaMateria() {
		if (apruebaSegundoParcial() && apruebaPrimerParcial() && aproboCorrelativas()) {
			alumno.setMateriasAprobadas(curso.getMateria());
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

}